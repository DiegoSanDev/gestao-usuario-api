# API RESTful de Gestão de Usuários com Spring Boot

Projeto de demonstração de uma API RESTful para gestão de usuários, construída com Java 21 e Spring Boot 3.3.5. Inclui operações CRUD, validação de dados e testes unitários.

## Índice

- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Como executar](#como-executar)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Endpoints](#endpoints)
    - [Criar Usuário](#1-criar-usuário)
    - [Atualizar Usuário](#2-atualizar-usuário)
    - [Buscar Usuário por ID](#3-buscar-usuário-por-id)
    - [Login (Autenticação)](#endpoint-de-login)
- [Autenticação e Geração de Token JWT](#-autenticação-e-geraçãø-de-token-jwt)
    - [Fluxo de Login](#como-funciona-o-fluxo-de-login)
    - [Endpoint de Login](#endpoint-de-login)
    - [Como usar o token JWT](#como-usar-o-token-jwt)

## Tecnologias Utilizadas

Este projeto utiliza as seguintes tecnologias e bibliotecas:

| **Tecnologia**                     | **Descrição**                                                            | **Versão** | **Link**                                                                                                                           |
|------------------------------------|--------------------------------------------------------------------------|------------|------------------------------------------------------------------------------------------------------------------------------------|
| **Java**                           | Linguagem principal utilizada no projeto.                                | 21         | [OpenJDK](https://openjdk.org/projects/jdk/21/)                                                                                    |
| **Spring Boot**                    | Framework para aplicações Java modernas com configurações mínimas.       | 3.3.5      | [Spring Boot](https://spring.io/projects/spring-boot)                                                                              |
| **Spring Boot Starter Web**        | Facilita a criação de APIs RESTful com Spring MVC.                       | 3.3.5      | [spring-boot-starter-web](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#web)                               |
| **Spring Boot Starter Validation** | Validação de dados com Bean Validation.                                  | 3.3.5      | [spring-boot-starter-validation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#io.validation)              |
| **Spring Boot Starter Data JPA**   | Integração com JPA e abstração de acesso a dados com Spring Data.        | 3.3.5      | [spring-boot-starter-data-jpa](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#data.sql.jpa-and-spring-data) |
| **H2 Database**                    | Banco de dados em memória para desenvolvimento e testes.                 | 2.x        | [H2 Database](https://www.h2database.com/)                                                                                         |
| **Lombok**                         | Redução de código boilerplate (getters, setters, etc).                   | 1.18.34    | [Lombok](https://projectlombok.org/)                                                                                               |
| **Spring Boot Starter Test**       | Ferramentas para testes unitários e de integração (JUnit, Mockito, etc). | 3.3.5      | [spring-boot-starter-test](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.testing)                 |
| **Spring Security**                | Segurança da aplicação.                                                  | 6.x        | [spring-security](https://spring.io/projects/spring-security)                                                                      |

## Pré-requisitos

- Java 21
- Maven 3.9+
- IDE de sua preferência (IntelliJ, Eclipse, VSCode)

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/api-gestao-usuarios.git
   cd api-gestao-usuarios
2. Compile e execute a aplicação:
   ```bash
   mvn spring-boot:run
3. Acesse a aplicação:
   ```bash
   http://localhost:8080
4. Para acessar a documentação da API via Swagger: 
   ```bash
   http://localhost:8080/swagger-ui.html
   
## Estrutura do Projeto
- src/main/java – Código fonte da aplicação
- src/test/java – Testes unitários e de integração
- application.yaml – Configurações da aplicação

## Estrutura de Pacotes

| Pacote                    | Responsabilidade                                                                                                      |
| ------------------------- |-----------------------------------------------------------------------------------------------------------------------|
| `config`                  | Configurações técnicas e de infraestrutura da aplicação.                                                              |
| `config.security`         | Configuração do Spring Security (SecurityFilterChain, AuthenticationManager, filtros JWT, propriedades de segurança). |
| `controller`              | Camada de entrada da aplicação. Responsável por expor os endpoints REST e orquestrar as requisições HTTP.             |
| `controller.api`          | Interfaces que definem o contrato dos endpoints (base para controllers, Swagger/OpenAPI e testes).                    |
| `controller.dto.request`  | DTOs de entrada da API (dados recebidos via HTTP).                                                                    |
| `controller.dto.response` | DTOs de saída da API (dados retornados via HTTP).                                                                     |
| `controller.validator`    | Validações específicas de entrada HTTP (formato, campos obrigatórios, validações sintáticas).                         |
| `model`                   | Camada de domínio da aplicação. Contém regras de negócio e o estado central do sistema.                               |
| `model.entity`            | Entidades do domínio (JPA). Representam o estado persistido da aplicação.                                             |
| `model.service`           | Serviços de domínio. Implementam regras de negócio e casos de uso centrais.                                           |
| `model.enums`             | Enumerações do domínio.                                                                                               |
| `repository`              | Camada de persistência. Interfaces JPA para acesso a dados.                                                           |
| `security`                | Componentes relacionados à segurança da aplicação, isolados do MVC.                                                   |
| `security.auth`           | Casos de uso de autenticação (login, geração/refresh de token).                                                       |
| `security.jwt`            | Lógica de geração, validação e manipulação de tokens JWT.                                                             |
| `security.userdetails`    | Adapters do Spring Security (`UserDetailsService`).                                                                   |
| `security.model`          | Modelos de segurança                                                                                                  |
| `mapper`                  | Conversão de dados entre camadas (DTO ↔ Entity).                                                                      |
| `exception`               | Exceções da aplicação e tratamento global de erros (`@ControllerAdvice`).                                             |



## Funcionalidades
- Criar um Usuário
- Atualizar um Usuário
- Consultar um Usuário por ID

## Endpoints
1. Criar um Novo Usuário
   - POST /v1/users 
   - Este endpoint permite a criação de um novo usuário na aplicação.
   - Requisição:
      - Headers 
        - Content-Type: application/json
      - Request Body:
        ``` json
        {
          "name": "João Silva da Costa",
          "email": "joao.silva@example.com",
          "password": "SenhaForte123!"
        }
          
   - Resposta (Status HTTP: 201 Created)
     ``` json 
     {
       "id": 1,
       "name": "João Silva da Costa",
       "email": "joao.silva@example.com",
       "createdAt": "2025-05-01T12:00:00Z"
     }
   - Erro - 400 Bad Request
       ````json
       {
          "message": "Campo(s) obrigatório(s)",
          "violations": [
            {
               "field": "password",
               "message": "O campo 'password' deve ter entre 6 e 8 caracteres."
            }
          ]
       }
   - Exemplo de requisição com cURL
       ```
        curl --location 'http://localhost:8080/v1/users' \
        --header 'Content-Type: application/json' \
        --data-raw '{
        "name": "Fulano de Tals",
        "email": "fulano.tals2@example.com",
        "password": "123456"
        }'
       ```
2. Atualizar Usuário
   - PUT /v1/users/{id}
   - Atualiza um usuário existente com o id fornecido.
   - Requisição
       - Headers
           - Content-Type: application/json
       - Request Body:
         ``` json
         {
           "name": "João Silva da Costa",
           "email": "joao.silva@example.com",
           "password": "SenhaForte123!"
         }

   - Resposta (Status HTTP: 200 OK)
     ``` json 
     {
       "id": 1,
       "name": "João Silva da Costa",
       "email": "joao.silva@example.com",
       "createdAt": "2025-05-01T12:00:00Z",
       "updateAt": "2025-05-01T12:00:00Z",
     }
   - Erro - 400 Bad Request
       ````json
       {
          "message": "Campo(s) obrigatório(s)",
          "violations": [
            {
               "field": "password",
               "message": "O campo 'password' deve ter entre 6 e 8 caracteres."
            }
          ]
       }
   - Exemplo de requisição com cURL
       ```
        curl --location --request PUT 'http://localhost:8080/v1/users/1' \
         --header 'Content-Type: application/json' \
           --data-raw '{
           "name": "Fulano de Talssss",
           "email": "fulano.tals1@example.com",
           "password": "123456"
          }'
       ```
3.  Buscar Usuário por ID
    - GET /v1/users/{id}
    - Busca um usuário existente com o id fornecido.
    - Resposta (Status HTTP: 200 OK)
         ``` json 
          {
           "id": 1,
           "name": "João Silva da Costa",
           "email": "joao.silva@example.com",
           "createdAt": "2025-05-01T12:00:00Z",
           "updateAt": "2025-05-01T12:00:00Z",
         }
      
    - Erro - 404 Not Found
         ````json
         {"message": "Usuário não encontrado."}

    - Exemplo de requisição com cURL
         ```
           curl --location 'http://localhost:8080/v1/users/1'
         ```
## Autenticação e Geração de Token JWT

### Como funciona o fluxo de login?
    1. O usuário envia e-mail e senha via endpoint /auth/login.
    2. As credenciais são validadas pelo sistema.
    3. É gerado um token JWT com informações de autenticação.
    4. O cliente usa o token nas requisições futuras via header Authorization.

### Endpoint de Login
1. Login 
   - POST /auth/login 
   - Request Body:
     - Headers
         - Content-Type: application/json
     - Request Body:
       ``` json
       {
         "email": "usuario@dominio.com",
         "password": "SenhaForte123!"
       }

     - Resposta (Status HTTP: 200 OK)
       ``` json 
       {
         "accessToken": "eyJhbGciOiJIUzUxMiJ9...",
         "tokenType": "Bearer",
         "expiresIn": 900
       }
     - Exemplo de requisição com cURL 
       ```
       curl --location 'http://localhost:8080/auth/login' \
        --header 'Content-Type: application/json' \
        --data-raw '{
        "email": "usuario@dominio.com",
        "password": "SenhaForte123!"
        }'
       ```
### Como usar o token JWT
Após obter o token, envie-o no header:

1. Authorization: Bearer <accessToken>

