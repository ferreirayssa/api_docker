
# 📦 API REST com Spring Boot + Docker

Esta é uma API REST desenvolvida com Spring Boot e empacotada em uma imagem Docker para facilitar o deploy em qualquer ambiente.

---

> **⚠️ Pré-requisito Importante:** Antes de prosseguir, certifique-se de que o **Docker** esteja instalado e devidamente configurado em seu ambiente. A execução desta aplicação depende diretamente do Docker.

---

## 🚀 Como executar com Docker

Siga os passos abaixo para executar a aplicação utilizando Docker:

### 1. Clone o repositório

Navegue até o diretório onde deseja clonar o projeto e execute o comando:

```bash
git clone https://github.com/ferreirayssa/api_docker
cd api_docker
```

### 2. Build da imagem Docker

Dentro do diretório do projeto (`api_docker`), construa a imagem Docker:

```bash
docker build -t api_docker .
```

### 3. Execute o container

Após o build da imagem ser concluído com sucesso, execute o container:

```bash
docker run -p 8080:8080 api_docker
```

A API estará acessível em `http://localhost:8080`.

---

## 🔍 Swagger (Documentação da API)

A documentação da API via Swagger está habilitada (utilizando Springdoc), você pode acessá-la através do seguinte endereço no seu navegador:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 📋 Simular as requisições na plataforma Postman

-   `Instale o Postman`: Instale o Postman Desktop na sua máquina.
-   `Criar Conta`: Crie uma conta, ou se já houver, entre com sua conta.
-   `Acesse a Collection pública para começar a simular`: [https://www.postman.com/descent-module-operator-65804179/docker/collection/vc2slnk/aplicao-api-docker](https://www.postman.com/descent-module-operator-65804179/docker/collection/vc2slnk/aplicao-api-docker)

---

## 🧱 Estrutura do Projeto

A estrutura principal do projeto é organizada da seguinte forma:

-   `Dockerfile`: Contém as instruções para a construção da imagem Docker da aplicação.
-   `Docker Compose`: Roda a aplicação automaticamente ao ser iniciado.
-   `pom.xml`: Arquivo de configuração do Maven, listando as dependências e plugins do projeto.
-   `src/`: Diretório contendo todo o código-fonte da API REST.

---

## 🛠️ Tecnologias Utilizadas

Este projeto foi desenvolvido utilizando as seguintes tecnologias:

-   Java 17
-   Spring Boot
-   Maven
-   Docker

---

## 👤 Autor

-   **[@ferreirayssa](https://github.com/ferreirayssa)**

---
