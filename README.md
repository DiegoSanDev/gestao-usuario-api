# API de Gestão de Usuários

Este é um projeto de demonstração utilizando Spring Boot para a criação de uma API RESTful de gestão de usuários.

## Tecnologias Utilizadas

| **Tecnologia**                     | **Descrição**                                                            | **Versão** | **Link**                                                                                                                           |
|------------------------------------|--------------------------------------------------------------------------|------------|------------------------------------------------------------------------------------------------------------------------------------|
| **Java**                           | Linguagem principal utilizada no projeto.                                | 21         | [OpenJDK](https://openjdk.org/projects/jdk/21/)                                                                                    |
| **Spring Boot**                    | Framework para aplicações Java modernas com configurações mínimas.       | 3.3.5      | [Spring Boot](https://spring.io/projects/spring-boot)                                                                              |
| **Spring Boot Starter Web**        | Facilita a criação de APIs RESTful com Spring MVC.                       | 3.3.5      | [spring-boot-starter-web](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#web)                               |
| **Spring Boot Starter Validation** | Validação de dados com Bean Validation.                                  | 3.3.5      | [spring-boot-starter-validation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#io.validation)              |
| **Spring Boot Starter Data JPA**   | Integração com JPA e abstração de acesso a dados com Spring Data.        | 3.3.5      | [spring-boot-starter-data-jpa](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#data.sql.jpa-and-spring-data) |
| **H2 Database**                    | Banco de dados em memória para desenvolvimento e testes.                 | 2.x        | [H2 Database](https://www.h2database.com/)                                                                                         |
| **Lombok**                         | Redução de código boilerplate (getters, setters, etc).                   | 1.18.34    | [Lombok](https://projectlombok.org/)                                                                                               |
| **Apache Commons Lang**            | Utilitários complementares à API padrão do Java.                         | 3.17.0     | [Apache Commons Lang](https://commons.apache.org/proper/commons-lang/)                                                             |
| **Spring Boot Starter Test**       | Ferramentas para testes unitários e de integração (JUnit, Mockito, etc). | 3.3.5      | [spring-boot-starter-test](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.testing)                 |


## Funcionalidades

- **Criar um Usuário**
- **Atualizar um Usuário**
- **Consultar um Usuário por ID**

## Endpoints

### 1. **Criar um Novo Usuário**

#### **POST /v1/users**

Este endpoint permite a criação de um novo usuário na aplicação.

#### Requisição
**Headers**
- Content-Type: application/json

**Request Body:**
```json
{
  "name": "Fulano de Tals",
  "email": "fulano.tals@example.com",
  "password": "Senh@Forte321",
  "userType": "USUARIO"
}

```
**Response (Sucesso - 201):**
```json
{
  "id": 1,
  "name": "Fulano de Tals",
  "email": "fulano.tals@example.com",
  "password": "Senh@Forte321",
  "userType": "USUARIO",
  "createdAt": "2025-05-01T12:00:00Z"
}
```
**Erro - 400 Bad Request**
```json
{
  "message": "Campo(s) obrigátório(s)",
  "violations": [
    {
      "field": "password",
      "message": "O campo 'password' deve ter entre 6 e 8 caracteres."
    }
  ]
}
```
**curl de exemplo**
```
curl --location 'http://localhost:8080/v1/users' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "Fulano de Tals",
  "email": "fulano.tals2@example.com",
  "password": "123456",
  "userType": "USUARIO"
}'
```

### 2. **Atualizar Usuário**

#### **PUT /v1/users/{id}**

Atualiza um usuário existente com o id fornecido.

#### Requisição
**Headers**
- Content-Type: application/json

**Request Body:**
```json
{
  "name": "João Silva da Costa",
  "email": "joao.silva@example.com",
  "password": "SenhaForte123!"
}
```
**Response (Sucesso - 200):**
```json
{
  "id": 1,
  "name": "João Silva da Costa",
  "email": "joao.silva@example.com",
  "password": "SenhaForte123!"
}
```

**Erro - 400 Bad Request**
```json
{
  "message": "Campo(s) obrigátório(s)",
  "violations": [
    {
      "field": "name",
      "message": "O campo 'name' deve der informado"
    }
  ]
}
```
**curl de exemplo**
```
curl --location --request PUT 'http://localhost:8080/v1/users/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Fulano de Talssss",
    "email": "fulano.tals1@example.com",
    "password": "123456"
}'
```

### 3. **Buscar Usuário po id**

#### **Get /v1/users/{id}**

**Response (Sucesso - 200):**
```json
{
  "id": 1,
  "name": "João Silva da Costa",
  "email": "joao.silva@example.com",
  "password": "SenhaForte123!"
}
```

**Erro - 404 Not found**
```json
{
  "message": "Usuário não encontrado."
}
```

**curl de exemplo**
```
curl --location 'http://localhost:8080/v1/users/1'
```