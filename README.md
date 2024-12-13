# API de Controle de Tarefas e Produtividade

## Descrição

Este projeto consiste em uma RESTful API construída com Java e o framework Spring Boot. A API tem como objetivo gerenciar tarefas e melhorar a produtividade dos usuários, permitindo:

- Adicionar, remover, atualizar e buscar tarefas pelo ID.

- Categorizar tarefas para organização eficiente.

- Personalizar tarefas conforme necessidade do usuário.

- Cadastrar e editar o perfil de usuários.


## Baixando o Repositório

Para obter o código do projeto em sua máquina, siga as instruções:

1. Faça o clone do repositório usando o comando:

git clone https://github.com/JsViniciusA/TasksApi.git


2. Alternativamente, baixe o arquivo .zip do projeto diretamente do GitHub e extraia o conteúdo.


3. Abra o projeto em uma IDE de sua preferência, como IntelliJ IDEA ou Eclipse.




## Pré-requisitos

### Programas necessários:
PostgreSQL (instalado e configurado)

- Java 17 (ou superior)

- Spring Boot

- Swagger (Postman ou ferramenta similar para testar a API)

- Git (para controle de versão)




### Configurando o Banco de Dados PostgreSQL

1. Instale o PostgreSQL

Baixe e instale o PostgreSQL na página oficial.



2. Crie o banco de dados Acesse o terminal do PostgreSQL (ou um gerenciador como pgAdmin) e crie um banco de dados para o projeto:

CREATE DATABASE tasksapi;


3. Configuração do usuário e permissões Verifique se você possui um usuário configurado para o banco e dê as permissões necessárias. Por exemplo:

CREATE USER api_user WITH PASSWORD 'sua_senha';
GRANT ALL PRIVILEGES ON DATABASE tasksapi TO api_user;




### Configurando o Projeto

1. Crie o arquivo .env Na raiz do projeto, crie um arquivo .env com as configurações de conexão com o PostgreSQL:

DB_NAME=tasksapi
DB_USER=api_user
DB_PASSWORD=sua_senha
DB_HOST=localhost
DB_PORT=5432


2. Configuração no application.properties O projeto utiliza o Spring Boot, e as configurações de banco estão no arquivo src/main/resources/application.properties. Certifique-se de que ele contém:

spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect




#### Executando o Projeto

1. Compile e rode o projeto Use sua IDE para executar o projeto ou utilize o terminal:

./mvnw spring-boot:run


2. Teste a API Abra o Postman ou outra ferramenta de requisição HTTP e teste os endpoints disponíveis. Por exemplo:

- GET: http://localhost:8080/tasks

- POST: http://localhost:8080/tasks/add



### Estrutura do Projeto

#### Principais Tecnologias e Frameworks Utilizados:

- Java 17

- Spring Boot

- PostgreSQL (banco de dados)

- Spring Data JPA (para manipulação do banco de dados)

- Lombok (para reduzir código boilerplate)




## Contribuindo com o Projeto

Para contribuir, siga as etapas:

1. Faça um fork do repositório.


2. Crie uma nova branch para sua alteração:

git checkout -b minha-feature


3. Após realizar as alterações desejadas, envie suas mudanças:

git add .
git commit -m "Minha contribuição"
git push origin minha-feature


4. Abra um Pull Request no GitHub para revisão.



Mais informações sobre como contribuir estão no arquivo CONTRIBUTING.md.



### Tutorial de Trabalho com Git

Para comandos Git e boas práticas de colaboração, consulte o arquivo Tutorial_git.pdf.



## Autores

- Iann Vitor Souza de Lima

- José Vinícius Alves Teixeira

- Luciano Tomé Ferreira Correia Chaves

- Mário Antônio Carvalho Fragoso Filho

- Marcus Antônio Teti Cavalcanti Gomes

- Yuki Peterson William S. Araujo



## Licença

Creative Commons Legal Code - CC0 1.0 Universal

CREATIVE COMMONS CORPORATION IS NOT A LAW FIRM AND DOES NOT PROVIDE
LEGAL SERVICES. DISTRIBUTION OF THIS DOCUMENT DOES NOT CREATE AN
ATTORNEY-CLIENT RELATIONSHIP. CREATIVE COMMONS PROVIDES THIS
INFORMATION ON AN "AS-IS" BASIS. CREATIVE COMMONS MAKES NO WARRANTIES
REGARDING THE USE OF THIS DOCUMENT OR THE INFORMATION OR WORKS
PROVIDED HEREUNDER, AND DISCLAIMS LIABILITY FOR DAMAGES RESULTING FROM
THE USE OF THIS DOCUMENT OR THE INFORMATION OR WORKS PROVIDED
HEREUNDER.
