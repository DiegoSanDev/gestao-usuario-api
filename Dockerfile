FROM openjdk:17-alpine

WORKDIR /app
COPY target/gestao-usuario-api-0.0.1-SNAPSHOT.jar /app/gestao-usuario.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar", "/app/gestao-usuario.jar"]