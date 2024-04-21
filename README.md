# **API para Gerenciamento de Usuários**

API para gerenciamento de cadastro de usuários.
Esta API possibilita a criação, busca e atualização de informações dos usuários.

## **Tecnologias**

| Tecnologia    | Versão  |
| Java          | 17.0.10 |
|Spring Boot    | 3.2.4   |
|Maven          | 3.9.0   |
|Docker         | 25.0.3  |
|Docker Compose | 3.2.4   |
|PostgreSQL     | 3.2.4   |

## **Executar o projeto**

- docker-compose up --build ou docker-compose up 
- mvn spring-boot:run


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
        <b>docker-compose --build</b>
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