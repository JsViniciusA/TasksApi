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
- PostgreSQL (instalado e configurado)

  ![image](https://github.com/user-attachments/assets/7deec811-9df9-4436-b570-26e64b23ca7e)



- Java 17 (ou superior)

  ![image](https://github.com/user-attachments/assets/7bf49ae8-a433-402d-a70f-f90f01e0e0b0)



- Spring Boot

  ![image](https://github.com/user-attachments/assets/28de0544-99fa-49cc-8445-bbd73b3f1764)



- Swagger (Postman ou ferramenta similar para testar a API)

  ![image](https://github.com/user-attachments/assets/a67ad5d2-bb8e-4aeb-a4f2-26547678ed5b)



- Git (para controle de versão)

  ![image](https://github.com/user-attachments/assets/255c51fe-171e-4a18-8d4e-025a989c6d4e)






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




### Ferramentas e materiais utilizados
Para mais informações sobre as ferramentas, bibliotecas e frameworks usados no projeto, visualizar o arquivo ferramentas_materiais.pdf(./tasksdocs/ferramentas_materiais.pdf)
   
   

# Contribuição do repositório:

## Contribuição dos membros do grupo:
Após clonarem o repositório utilizando git clone, os membros do grupo podem e devem, criar suas respectivas branchs a partir da branch develop. Quando finalizadas as alterações desejadas, deve ser realizado um merge para a dev(git merge), respeitando conflitos e alterações antigas.Por fim, o código pronto será colocado na branch main através de um merge da develop. (Na main, "git merge develop")

## Contribuição de terceiros: 
Usuários que se interessarem em colaborar com o código do projeto, poderão fazer um fork do repositório(git fork), e realizarem as implementações desejadas. Após finalizadas as implementações,comitadas(git commit -m "mensagem da alteracao") e enviadas(git push -u origin develop), os usuários devem abrir um pull request no qual os colaboradores do repositório podem ou não aceitar a mesclagem.

### Tutorial de trabalho

Para mais informações de comandos git que podem e devem ser usados durante a colaboração, visualizar o arquivo tutorial_git.pdf(./tasksdocs/Tutorial_git.pdf)

