# **API para Gerenciamento de Usuários**

<p>
API para gerenciamento de cadastro de usuários.
Esta API possibilita a criação, busca e atualização de informações dos usuários.
</p>

## **Tecnologias**

| Tecnologia        | Versão  | Documentação                                                      |
|-------------------|---------|-------------------------------------------------------------------|
| Java              | 17.0.10 | https://docs.oracle.com/en/java/javase/17/                        |
| Spring Boot       | 3.2.4   | https://spring.io/projects/spring-boot                            |
| Maven             | 3.9.0   | https://maven.apache.org/                                         |
| Docker            | 25.0.3  | https://docs.docker.com/                                          |
| Docker Compose    | 3.2.4   | https://docs.docker.com/compose/                                  |
| PostgreSQL        | 42.7.3  | https://www.postgresql.org/                                       |
| JUnit             | 5.10.2  | https://junit.org/junit5/                                         |
| springdoc-openapi | v2.5.0  | https://springdoc.org/#google_vignette                            |
| Spring Data JDBC  | 3.2.4   | https://docs.spring.io/spring-data/relational/reference/jdbc.html |

## **Executar o Projeto**

- <b>docker-compose up --build</b> ou <b>docker-compose up</b>
- <b>mvn spring-boot:run</b>

## Diagramae de Arquitetura

### **Arquitetura lógica**
<p>
A <b>arquiteture lógica</b> é a organização em larga escala das classes de software em pacotes, subsitemas e camadas.
</p>

[![alt text] (https://github.com/DiegoSanDev/gestao-usuario-api/issues/5#issue-2304649958)

### **Camada de Apresentação (presentation)**
<p>
Esta camada lida com a interação do usuário com a aplicação. Ela contém os controladores RESTful, que recebem as solicitações HTTP e enviam as respostas de volta ao cliente. 
Também inclui classes DTO para transferir dados entre a camada de apresentação e outras camadas, exceções específicas do controlador para lidar com erros e validações para validar os dados de entrada.
</p>

### **Camada de Modelo (model)**
<p>
Esta camada contém os modelos de dados e a lógica de negócios da aplicação. Os enums representam constantes ou estados específicos do domínio. 
A classe de serviço contém a lógica de negócios principal da aplicação. Ela inclui os mapeadores para converter entre objetos DTO e entidades de domínio
</p>

### **Camada de Infraestrutura (infrastructure)**
<p>
Esta camada lida com o acesso a dados e a integração com sistemas externos, bem como os repositórios para interagir com o banco de dados.
</p>

## Estrutura de Pastas do Projeto
- **config/**: Contém classes de configuração do Spring Boot. Essas classes são usadas para configurar beans, segurança, e outras funcionalidades específicas da aplicação
- **model/**: Agrupa as classes que representam a lógica de negócios e o modelo de domínio da aplicação.
  - `enums/`: Contém enums usados na aplicação para representar conjuntos fixos de constantes.
  - `entities`: Contém as classes que representam as entidades do modelo de domínio, geralmente mapeadas para tabelas no banco de dados.
  - `service`: Contém as classes de serviço que implementam a lógica de negócios e interagem com os repositórios.
  - `mapper`: Contém classes de mapeamento para converter entre entidades e DTOs (Data Transfer Objects).
- **exception/**: Contém classes para gerenciamento de exceções personalizadas da aplicação. 
- **presentation/**:  Agrupa as classes responsáveis pela camada de apresentação da aplicação.
  - `controller/`: Contém os controladores RESTful que lidam com as requisições HTTP.
  - `dto/`: Contém os Data Transfer Objects (DTOs) usados para transferência de dados entre cliente e servidor.
  - `exception/`: Contém classes para tratamento de exceções na camada de apresentação.
  - `validation/`: Contém classes e anotações personalizadas para validação de dados.
- **Infrastructure/**: Contém classes que implementam a camada de infraestrutura, incluindo repositórios para acesso ao banco de dados.
  - `repository/`: Contém interfaces que estendem JpaRepository ou CrudRepository para acessar o banco de dados. 
- **resources/**: Contém recursos estáticos e arquivos de configuração da aplicação.
  - `application.properties`: Arquivo de configuração principal do Spring Boot.

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
