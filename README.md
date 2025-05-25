# 📦 API REST com Spring Boot + Docker

Esta é uma API REST desenvolvida com Spring Boot e empacotada em uma imagem Docker para facilitar o deploy em qualquer ambiente.

---

## 🚀 Como executar com Docker

### 1. Clone o repositório

```bash
git clone https://github.com/ferreirayssa/api_docker.git
cd api_docker
```

### 2. Build da imagem Docker
docker build -t api_docker .

### 3. Execute o container
docker run -p 8080:8080 api_docker

### 4. Acesse no navegador:
http://localhost:8080

## 🔍 Swagger (Documentação da API)
Se estiver configurado com SpringFox ou Springdoc, acesse:

/swagger-ui.html

ou /swagger-ui/index.html

## 🧱 Estrutura do projeto
Dockerfile – Instruções para build da imagem

.dockerignore – Arquivos ignorados no build

pom.xml – Dependências do projeto

src/ – Código-fonte da API

🛠️ Tecnologias
Java 17

Spring Boot

Maven

Docker

👤 Autor
Ferreirayssa
