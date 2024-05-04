# **API para Gerenciamento de Usuários**

<p>
API para gerenciamento de cadastro de usuários.
Esta API possibilita a criação, busca e atualização de informações dos usuários.
</p>

## **Tecnologias**

| Tecnologia     | Versão  | Documentação                               |
|----------------|---------|--------------------------------------------|
| Java           | 17.0.10 | https://docs.oracle.com/en/java/javase/17/ |
| Spring Boot    | 3.2.4   | https://spring.io/projects/spring-boot     |
| Maven          | 3.9.0   | https://maven.apache.org/                  |
| Docker         | 25.0.3  | https://docs.docker.com/                   |
| Docker Compose | 3.2.4   | https://docs.docker.com/compose/           |
| PostgreSQL     | 42.7.3  | https://www.postgresql.org/                |
| JUnit          | 5.10.2  | https://junit.org/junit5/                  |

## **Executar o Projeto**

- <b>docker-compose up --build</b> ou <b>docker-compose up</b>
- <b>mvn spring-boot:run</b>
- 
## Diagrama de Arquitetura

```plaintext
+--------------------------------------------------------+
|                   Aplicação Spring Boot                |
|                                                        |
|   +-----------------------------------------------+    |
|   |               Camada de Apresentação          |    |
|   |                                               |    |
|   |   +---------------------------------------+   |    |
|   |   |           Controladores RESTful       |   |    |
|   |   |                                       |   |    |
|   |   |   +--------------------------+        |   |    |
|   |   |   |           DTO            |        |   |    |
|   |   |   +--------------------------+        |   |    |
|   |   |                                       |   |    |
|   |   |   +--------------------------+        |   |    |
|   |   |   |         Exceções         |        |   |    |
|   |   |   +--------------------------+        |   |    |
|   |   |                                       |   |    |
|   |   |   +--------------------------+        |   |    |
|   |   |   |       Validações         |        |   |    |
|   |   |   +--------------------------+        |   |    |
|   |   +---------------------------------------+   |    |
|   +-----------------------------------------------+    |
|                                                        |
|   +-----------------------------------------------+    |
|   |              Camada de Domínio                |    |
|   |                                               |    |
|   |   +--------------------------+                |    |
|   |   |          Enums           |                |    |
|   |   +--------------------------+                |    |
|   |                                               |    |
|   |   +--------------------------+                |    |
|   |   |          Model           |                |    |
|   |   +--------------------------+                |    |
|   |                                               |    |
|   |   +--------------------------+                |    |
|   |   |        Serviço           |                |    |
|   |   +--------------------------+                |    |
|   +-----------------------------------------------+    |
|                                                        |
|   +-----------------------------------------------+    |
|   |           Camada de Infraestrutura            |    |
|   |                                               |    |
|   |   +--------------------------+                |    |
|   |   |         Mapeadores       |                |    |
|   |   +--------------------------+                |    |
|   |                                               |    |
|   |   +--------------------------+                |    |
|   |   |       Repositórios       |                |    |
|   |   +--------------------------+                |    |
|   |                                               |    |
|   +-----------------------------------------------+    |
|                                                        |
+--------------------------------------------------------+

## **Camada de Apresentação**
<p>
Esta camada lida com a interação do usuário com a aplicação. Ela contém os controladores RESTful, que recebem as solicitações HTTP e enviam as respostas de volta ao cliente. 
Também inclui classes DTO para transferir dados entre a camada de apresentação e outras camadas, exceções específicas do controlador para lidar com erros e validações para validar os dados de entrada.
</p>

## **Camada de Domínio**
<p>
Esta camada contém os modelos de dados e a lógica de negócios da aplicação. Os enums representam constantes ou estados específicos do domínio. 
A classe de serviço contém a lógica de negócios principal da aplicação
</p>

## **Camada de Infraestrutura**
Esta camada lida com o acesso a dados e a integração com sistemas externos. Ela inclui os mapeadores para converter entre objetos DTO e entidades de domínio,
bem como os repositórios para interagir com o banco de dados.

## Estrutura de Pastas do Projeto
- **config/**: Contém classes de configuação da aplicação
- **domain/**: Contém entidades e lógica de domínio da aplicação.
  - `enums/`: Enums relacionados ao domínio da aplicação.
  - `model`: Entidades (modelos de dados) da aplicação.
  - `service`: Classes de serviço relacionadas à lógica de negócios.
- **exception/**: Contém classes de exceção personalizadas para tratamento de erros.
- **infrastructure/**: Contém classes de infraestrutura relacionadas ao acesso a dados.
  - `mapper/`: Classes de mapeamento para conversão entre objetos DTO e entidades de domínio.
  - `repository/`: Interfaces de repositório para operações de banco de dados.
- **presentation/**: Contém classes relacionadas à apresentação da aplicação.
  - `controller/`: Controladores RESTful da aplicação.
  - `dto/`: Classes de transferência de dados (DTOs).
  - `exception/`: Classes de exceção específicas do controlador.
  - `validation/`: Classes para validação de dados de entrada nos controladores.
- **resources/**: Contém recursos estáticos e arquivos de configuração.
  - `application.properties`: Configurações da aplicação Spring Boot.
  - `schema.sql`: Arquivo SQL para criação de tabelas no banco de dados.

## **Alguns comandos do Docker Compose**
<ol>
    <li>
        <b>docker-compose up</b>
        <ul>
            <li>
                Este comando inicia todos os contêineres definidos no arquivo <code>docker-compose.yaml</code> no modo de daemon (em segundo plano).
            </li>
        </ul>
    </li>
    <li>
        <b>docker-compose down</b>
        <ul>
            <li>
                Este comando para e remove todos os contêineres, redes e volumes definidos no arquivo <code>docker-compose.yaml</code>.
            </li>
        </ul>
    </li>
    <li>
        <b>docker-compose build</b>
        <ul>
            <li>
                Este comando constrói ou reconstrói as imagens dos serviços definidos no arquivo <code>docker-compose.yaml</code>.
            </li>
        </ul>
    </li>
    <li>
        <b>docker-compose start</b>
        <ul>
            <li>
                Este comando inicia os serviços definidos no arquivo <code>docker-compose.yaml</code> sem reconstruir as imagens.
            </li>
        </ul>
    </li>
    <li>
        <b>docker-compose stop</b>
        <ul>
            <li>
                Este comando para os serviços definidos no arquivo <code>docker-compose.yaml</code> sem removê-los.
            </li>
        </ul>
    </li>
    <li>
        <b>docker-compose restart</b>
        <ul>
            <li>
                Este comando reinicia os serviços definidos no arquivo <code>docker-compose.yaml</code>>.
            </li>
        </ul>
    </li>
    <li>
        <b>docker-compose ps</b>
        <ul>
            <li>
                Este comando exibe o status dos serviços definidos no arquivo <code>docker-compose.yaml</code>>, mostrando se estão em execução ou parados.
            </li>
        </ul>
    </li>
    <li>
        <b>docker-compose logs</b>
        <ul>
            <li>
                Este comando exibe os logs de todos os serviços definidos no arquivo <code>docker-compose.yaml</code>.
            </li>
        </ul>
    </li>
</ol>