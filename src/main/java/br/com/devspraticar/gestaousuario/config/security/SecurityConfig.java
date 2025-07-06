package br.com.devspraticar.gestaousuario.config.security;

import br.com.devspraticar.gestaousuario.security.JwtAuthenticationFilter;
import br.com.devspraticar.gestaousuario.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static br.com.devspraticar.gestaousuario.enums.RoleType.ROLE_USER;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final SecurityProperties securityProperties;

    @SneakyThrows
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
         httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .httpBasic(AbstractHttpConfigurer::disable)
            .formLogin(AbstractHttpConfigurer::disable)
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(securityProperties.getPublicEndpoints().toArray(new String[0])).permitAll()
                .requestMatchers(POST, "/v1/users").permitAll()
                .requestMatchers(POST, "/auth/login").permitAll()
                .requestMatchers(GET, "/v1/users/**").hasAuthority(ROLE_USER.name())
                .requestMatchers(PUT, "/v1/users/**").hasAuthority(ROLE_USER.name())
                .anyRequest().authenticated()
            ).addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

         if(securityProperties.isDisableSecurityHeaders()) {
             httpSecurity.headers(AbstractHttpConfigurer::disable);
         }

         return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}