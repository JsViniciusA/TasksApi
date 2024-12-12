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

- Java JDK 17 ou superior.

- Maven para gerenciar dependências (geralmente integrado à IDE).

- MySQL Workbench 8.0 (ou ferramenta similar para gerenciar o banco de dados).




### Ferramentas e Materiais Utilizados

As ferramentas, bibliotecas e frameworks utilizados estão detalhados no arquivo ferramentas_materiais.pdf.



### Configurando o Ambiente

Passos para Configuração

1. Clone o repositório para sua máquina:

git clone https://github.com/JsViniciusA/TasksApi.git
cd TasksApi


2. Configure o banco de dados:

Acesse o MySQL Workbench ou terminal e crie o banco de dados:

CREATE DATABASE nome_do_banco;



3. Configure o arquivo application.properties:

No diretório src/main/resources, edite o arquivo application.properties com as credenciais do banco de dados:

spring.datasource.url=jdbc:mysql://127.0.0.1:3306/nome_do_banco
spring.datasource.username=usuario
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true



4. Compile o projeto e baixe as dependências:

mvn clean install


5. Inicie o servidor:

mvn spring-boot:run


6. Teste a API no Swagger:

Acesse o Swagger UI no navegador:

http://localhost:8080/swagger-ui.html





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
