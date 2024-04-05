# Estágio 1: Construir o aplicativo Java com Maven
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

# Estágio 2: Criar a imagem final com o JAR construído
FROM adoptopenjdk/openjdk17:jre-17.0.2_8-alpine
WORKDIR /app
COPY --from=build /app/target/minha-aplicacao.jar .
EXPOSE 8080
CMD ["java", "-jar", "minha-aplicacao.jar"]
