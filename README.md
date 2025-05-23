# 📦 API REST com Spring Boot + Docker

Esta é uma API REST desenvolvida com Spring Boot e empacotada em uma imagem Docker para facilitar o deploy em qualquer ambiente.

---

## 🚀 Como executar com Docker

### 1. Clone o repositório

```bash
git clone https://github.com/SEU-USUARIO/minha-api-spring.git
cd minha-api-spring
```

### 2. Build da imagem Docker
docker build -t minha-api-spring .

### 3. Execute o container
docker run -p 8080:8080 minha-api-spring

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
