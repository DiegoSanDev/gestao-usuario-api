package br.com.devspraticar.gestaousuario.security.jwt;

import br.com.devspraticar.gestaousuario.model.entity.Role;
import br.com.devspraticar.gestaousuario.security.model.UserSecurity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private static final String CLAIM_ROLES = "roles";
    private static final String CLAIM_USER_ID = "user_id";

    @Value("${security.jwt.secret}")
    private String jwtSecret;

    @Getter
    @Value("${security.jwt.expirationMS}")
    private long jwtExpirationMs;

    private SecretKey secretKey;

    @PostConstruct
    public void init() {
        this.secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generateToken(Authentication authentication) {
        UserSecurity userPrincipal = (UserSecurity) authentication.getPrincipal();
        List<String> roles = userPrincipal.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .toList();

        Date now = new Date();
        Date expiry = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
            .setSubject(userPrincipal.getUsername())
            .setIssuer("gestao-usuario-api")
            .claim(CLAIM_ROLES, roles)
            .claim(CLAIM_USER_ID, userPrincipal.getUser().getId())
            .setIssuedAt(now)
            .setExpiration(expiry)
            .signWith(secretKey, SignatureAlgorithm.HS512)
            .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            log.warn("Token expirado", e);
        } catch (UnsupportedJwtException e) {
            log.warn("Token não suportado", e);
        } catch (MalformedJwtException e) {
            log.warn("Token inválido", e);
        } catch (SignatureException e) {
            log.warn("Assinatura inválida", e);
        } catch (IllegalArgumentException e) {
            log.warn("Token vazio ou nulo", e);
        }
        return false;
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        String username = claims.getSubject();
        List<String> roles = claims.get(CLAIM_ROLES, List.class);

        List<SimpleGrantedAuthority> authorities = roles.stream()
                .map(SimpleGrantedAuthority::new)
                .toList();

        UserDetails userDetails = new User(username, "", authorities);
        return new UsernamePasswordAuthenticationToken(userDetails, token, authorities);
    }

    public String generateTokenFromUser(br.com.devspraticar.gestaousuario.model.entity.User user) {

        Date now = new Date();
        Date expiry = new Date(now.getTime() + jwtExpirationMs);

        List<String> roles = user.getRoles().stream()
                .map(Role::getName)
                .toList();

        return Jwts.builder()
            .setSubject(user.getEmail())
            .setIssuer("gestao-usuario-api")
            .claim(CLAIM_ROLES, roles)
            .claim(CLAIM_USER_ID, user.getId())
            .setIssuedAt(now)
            .setExpiration(expiry)
            .signWith(secretKey, SignatureAlgorithm.HS512)
            .compact();
    }


}
