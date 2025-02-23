# transacao-API

## Descrição

A Transacao API é um serviço desenvolvido em Java utilizando o framework Spring Boot. Ele permite a adição, remoção e consulta de transações financeiras, além de fornecer estatísticas sobre essas transações.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.3
- Gradle
- Lombok
- Springdoc OpenAPI

## Estrutura do Projeto

- `src/main/java/pedroleonez/transacaoapi`
  - `business/services`: Contém as classes de serviço que implementam a lógica de negócios.
  - `controller`: Contém os controladores REST que expõem os endpoints da API.
  - `controller/dtos`: Contém os Data Transfer Objects (DTOs) utilizados para transferir dados entre as camadas.

## Endpoints

### Transação

- **Adicionar Transação**
  - **URL:** `/transacao`
  - **Método:** `POST`
  - **Descrição:** Adiciona uma nova transação.
  - **Request Body:**
    ```json
    {
      "valor": 100.0,
      "timestamp": "2023-10-01T12:00:00Z"
    }
    ```
  - **Responses:**
    - `201`: Transação adicionada com sucesso.
    - `400`: Requisição inválida.
    - `422`: Entidade não processável.
    - `500`: Erro interno do servidor.

- **Deletar Transações**
  - **URL:** `/transacao`
  - **Método:** `DELETE`
  - **Descrição:** Deleta todas as transações.
  - **Responses:**
    - `200`: Transações deletadas com sucesso.
    - `400`: Requisição inválida.
    - `500`: Erro interno do servidor.

### Estatísticas

- **Buscar Estatísticas**
  - **URL:** `/estatistica`
  - **Método:** `GET`
  - **Descrição:** Busca estatísticas das transações no intervalo de tempo especificado.
  - **Query Params:**
    - `intervaloBusca` (opcional, padrão: 60): Intervalo de tempo em segundos para buscar as transações.
  - **Responses:**
    - `200`: Estatísticas retornadas com sucesso.
    - `400`: Erro na busca de estatísticas de transações.
    - `500`: Erro interno do servidor.

## Como Executar o Projeto

1. **Clone o repositório:**
   ```sh
   git clone https://github.com/pedroleonez/transacao-api.git
   cd transacao-api
