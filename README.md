# Projeto Spring Library
## Consiste em um sistema backend de biblioteca, que gerencia livros e autores e expõe recursos através de uma API RESTful
## Tecnologias utilizadas:
### * Java
### * Spring Boot
### * Docker
### * PostgreSQL

---

## Endpoints

### Salvar novo livro
OBS: O id será gerado automaticamente no servidor e atribuído ao novo registro

Necessário para enviar a requisição:\
*Enviar, em formato json, o objeto que deseja persistir no banco de dados
* **URL: `/livros`**
* **Método: `POST`**
* **Resposta: (201 CREATED)**

```json
{

}
```

---
### Obter registros de livros
* **URL:** `/livros`
* **Método:** `GET`
* **Resposta: (200 OK)**

```json
[
  {
    
  }
]
```

---
### Obter livro informando o id
Necessário para enviar a requisição:\
*Enviar o id como parâmetro de url
* **URL:** `/livros/{id}`
* **Método:** `GET`
* **Resposta: (200 OK)**

```json
{
    
}
```

---
### Atualizar livro
Necessário para enviar a requisição:\
*Enviar o id como parâmetro de url\
*Enviar o objeto com os dados atualizados em formato json no corpo (body) da requisição
* **URL: `/livros/{id}`**
* **Método: `PUT`**
* **Resposta: (204 NO CONTENT)**
```json
{

}
```

---
### Deletar livro
Necessário para enviar a requisição:\
*Enviar o id como parâmetro de url
* **URL: `/livros/{id}`**
* **Método: `DELETE`**
* **Resposta: (204 NO CONTENT)**

---
### Salvar novo autor
OBS: O id será gerado automaticamente no servidor e atribuído ao novo registro

Necessário para enviar a requisição:\
*Enviar, em formato json, o objeto que deseja persistir no banco de dados
* **URL: `/autores`**
* **Método: `POST`**
* **Resposta: (201 CREATED)**

```json 
{

}
```

---
### Obter registros de autores
* **URL: `/autores`**
* **Método: `GET`**
* **Resposta: (200 OK)**

```json
[
  {
    
  }
]
```

---
### Obter autor informando o id
Necessário para enviar a requisição:\
*Enviar o id como parâmetro de url
* **URL:** `/autores/{id}`
* **Método:** `GET`
* **Resposta: (200 OK)**

```json
{
    
}
```

---
### Atualizar autor
Necessário para enviar a requisição:\
*Enviar o id como parâmetro de url\
*Enviar o objeto com os dados atualizados em formato json no corpo (body) da requisição
* **URL: `/autores/{id}`**
* **Método: `PUT`**
* **Resposta: (204 NO CONTENT)**
```json
{
    
}
```

---
### Deletar autor
Necessário para enviar a requisição:\
*Enviar o id como parâmetro de url
* **URL: `/autores/{id}`**
* **Método: `DELETE`**
* **Resposta: (204 NO CONTENT)**
---