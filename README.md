# API de Gestão de Usuários

Esta API permite a criação, atualização e consulta de usuários, com funcionalidades para garantir a integridade e a consistência dos dados.

## Funcionalidades

- **Criar um Usuário**
- **Atualizar um Usuário**
- **Consultar um Usuário por ID**

## Endpoints

### 1. **Criar um Novo Usuário**

#### **POST /v1/users**

Cria um novo usuário com base nos dados fornecidos.

**Request Body:**
```json
{
  "name": "João Silva da Costa",
  "email": "joao.silva@example.com",
  "password": "SenhaForte123!"
}
```
**Response (Sucesso - 201):**
```json
{
  "id": 1,
  "name": "João Silva da Costa",
  "email": "joao.silva@example.com"
}
```
### 2. **Atualizar Usuário**

#### **PUT /v1/users/{id}**

Atualiza um usuário existente com o id fornecido.

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
  "email": "joao.silva@example.com"
}
```

