# Workshop Spring Boot JPA

API REST desenvolvida em Java com Spring Boot durante meus estudos de desenvolvimento backend.

O projeto simula um sistema de pedidos, permitindo trabalhar com usuários, produtos, categorias, pedidos, itens de pedido e pagamentos.

O objetivo principal foi praticar a construção de uma API REST utilizando Spring Boot, persistência de dados com JPA/Hibernate, PostgreSQL, Docker e deploy no Render.

## Tecnologias utilizadas

- Java 25
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Docker
- Render
- Postman

## Estrutura do projeto

O projeto utiliza uma arquitetura em camadas:

```text
Resource
   ↓
Service
   ↓
Repository
   ↓
JPA / Hibernate
   ↓
PostgreSQL
```

### Resource

Responsável pelos endpoints REST e pelo recebimento das requisições HTTP.

### Service

Contém a lógica da aplicação e faz a comunicação entre a camada Resource e a camada Repository.

### Repository

Responsável pelo acesso ao banco de dados utilizando Spring Data JPA.

### Entities

Representam as entidades que serão persistidas no banco de dados.

## Entidades

O projeto possui entidades como:

- User
- Order
- Product
- Category
- OrderItem
- Payment

Também são utilizados relacionamentos JPA como:

- `@OneToMany`
- `@ManyToOne`
- `@ManyToMany`
- `@OneToOne`

## Banco de dados

O ambiente de produção utiliza PostgreSQL hospedado no Render.

A conexão com o banco é configurada através de variáveis de ambiente:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Dessa forma, as credenciais do banco de dados não ficam armazenadas diretamente no código ou no repositório.

O Hibernate é responsável pela criação e atualização das tabelas:

```properties
spring.jpa.hibernate.ddl-auto=update
```

Entre as tabelas geradas estão:

```text
tb_user
tb_order
tb_order_item
tb_payment
tb_product
tb_category
tb_product_category
```

## Perfil de produção

O projeto utiliza um perfil específico para produção.

No arquivo `application.properties`:

```properties
spring.application.name=course
spring.profiles.active=prod
spring.jpa.open-in-view=true
```

No arquivo `application-prod.properties`:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## Tratamento de exceções

A API possui tratamento personalizado de exceções.

Entre os casos tratados estão:

- recurso não encontrado;
- busca por ID inexistente;
- tentativa de atualização de recurso inexistente;
- erros de integridade do banco de dados.

Exemplo:

```http
GET /users/999
```

Caso o usuário não exista, a API retorna uma resposta HTTP adequada informando que o recurso não foi encontrado.

## Operações CRUD

A API implementa operações de criação, consulta, atualização e exclusão.

### Listar usuários

```http
GET /users
```

### Buscar usuário por ID

```http
GET /users/{id}
```

Exemplo:

```http
GET /users/1
```

### Criar usuário

```http
POST /users
```

Exemplo de JSON:

```json
{
  "name": "Bob Brown",
  "email": "bob@gmail.com",
  "phone": "977557755"
}
```

### Atualizar usuário

```http
PUT /users/{id}
```

Exemplo:

```http
PUT /users/1
```

### Excluir usuário

```http
DELETE /users/{id}
```

Exemplo:

```http
DELETE /users/1
```

## Deploy

A aplicação foi publicada no Render.

O fluxo da aplicação em produção funciona da seguinte forma:

```text
Cliente / Postman
       ↓
Render
       ↓
Spring Boot
       ↓
Spring Data JPA
       ↓
Hibernate
       ↓
PostgreSQL
```

A aplicação e o banco PostgreSQL estão hospedados no Render.

## Docker

O projeto utiliza Docker para criar o ambiente responsável pela execução da aplicação no deploy.

O `Dockerfile` utilizado é:

```dockerfile
FROM eclipse-temurin:25-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["sh", "-c", "java -jar target/*.jar"]
```

## Variáveis de ambiente

Para executar a aplicação com PostgreSQL, são necessárias as seguintes variáveis:

```text
DB_URL
DB_USERNAME
DB_PASSWORD
```

Exemplo:

```text
DB_URL=jdbc:postgresql://host:5432/database
DB_USERNAME=usuario
DB_PASSWORD=senha
```

As credenciais reais não devem ser adicionadas ao GitHub.

## Executando o projeto

Clone o repositório:

```bash
git clone https://github.com/daviaarrudaofc/workshop-springboot-jpa.git
```

Entre na pasta do projeto:

```bash
cd workshop-springboot-jpa
```

Execute a aplicação:

```bash
./mvnw spring-boot:run
```

No Windows também é possível utilizar:

```bash
mvnw.cmd spring-boot:run
```

## Testando a API

A API pode ser testada utilizando o Postman.

Localmente:

```http
GET http://localhost:8080/users
```

Exemplo de busca por ID:

```http
GET http://localhost:8080/users/1
```

Também é possível utilizar a URL pública da aplicação hospedada no Render.

## Conceitos praticados

Durante o desenvolvimento deste projeto foram trabalhados conceitos como:

- desenvolvimento de API REST;
- arquitetura em camadas;
- injeção de dependência;
- Spring Boot;
- Spring Data JPA;
- Hibernate;
- ORM;
- relacionamentos entre entidades;
- operações CRUD;
- tratamento de exceções;
- PostgreSQL;
- configuração de perfis;
- variáveis de ambiente;
- Docker;
- deploy de aplicações Java;
- conexão com banco de dados em produção.

## Objetivo do projeto

Este projeto foi desenvolvido com foco no aprendizado e prática de desenvolvimento backend utilizando Java e Spring Boot.

Além do desenvolvimento da API, o projeto também permitiu praticar a configuração de um ambiente de produção utilizando Docker, Render e PostgreSQL.

## Autor

**Davi Arruda**

GitHub: [daviaarrudaofc](https://github.com/daviaarrudaofc)
