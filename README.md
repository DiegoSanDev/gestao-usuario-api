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
| PostgreSQL     | 3.2.4   | https://www.postgresql.org/                |
| JUnit          | 5.10.2  | https://junit.org/junit5/                  |

## **Executar o projeto**

- <b>docker-compose up --build</b> ou <b>docker-compose up</b> 
- <b>mvn spring-boot:run</b>


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