# API de Gerenciamento de Filmes e Usuários

Uma API RESTful para gerenciar os recursos de Filmes e Usuários, construída com Spring Boot.

---

## 📖 Acesso à Documentação

Enquanto a aplicação estiver rodando localmente, é possível acessar a documentação interativa da API e o JSON de especificação através das seguintes rotas:

* **Documentação (Swagger UI):**
    `http://localhost:8080/swagger-ui.html`

* **Documentação (Scalar):**
    `http://localhost:8080/docs`

* **Especificação OpenAPI (JSON):**
    `http://localhost:8080/v3/api-docs`

---

## 🚀 Endpoints da API

A API está organizada em torno de dois recursos principais:

### 🎬 Filmes (`movie-controller`)

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `GET` | `/movies` | Lista todos os filmes. |
| `POST` | `/movies` | Adiciona um novo filme. |
| `GET` | `/movies/{id}` | Busca um filme pelo seu ID. |
| `PATCH` | `/movies/{id}` | Atualiza um filme existente. |
| `DELETE` | `/movies/{id}` | Remove um filme. |

### 👤 Usuários (`user-controller`)

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `GET` | `/users` | Lista todos os usuários. |
| `POST` | `/users` | Adiciona um novo usuário. |
| `GET` | `/users/{id}` | Busca um usuário pelo seu ID. |
| `PATCH` | `/users/{id}` | Atualiza um usuário existente. |
| `DELETE` | `/users/{id}` | Remove um usuário. |

---

## 🛠️ Como Executar

1.  **Clone o repositório:**

2.  **Configure o Ambiente:**
3.  
    Ajuste as propriedades do arquivo `application.properties` na raiz do diretório `src/main/resources`.

    ```properties
    # Define a porta da aplicação
    server.port=8080

    # Configurações do Banco de Dados (Exemplo com PostgreSQL)
    spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_seu_banco
    spring.datasource.username=seu_usuario_db
    spring.datasource.password=sua_senha_db
    ```

    > **Nota sobre o Banco de Dados:**
    >
    > Este projeto foi configurado inicialmente com **MySQL**. A dependência do driver MySQL (`mysql-connector-j`) já está incluída no `pom.xml`.
    >
    > Se você optar por usar um banco de dados diferente, é necessário **adicionar a dependência do driver** correspondente ao seu `pom.xml` e remover a do MySQL.

4.  **Execução do projeto:**
    Este projeto utiliza **Flyway Migrations**. Ao executar a aplicação pela primeira vez, o Spring Boot irá ler os arquivos de migração e criar automaticamente todas as tabelas e estruturas necessárias no banco de dados que você configurou.

    Para executar (exemplo usando o Maven Wrapper):
    ```bash
    ./mvnw spring-boot:run
    ```

    Após a inicialização, a API estará disponível em `http://localhost:8080`.
