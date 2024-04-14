# pooSistematizacao

# Sistema de Gerenciamento de Entregas - Dianome

Este repositório contém o código-fonte do Sistema de Gerenciamento de Entregas desenvolvido para a empresa Dianome. A aplicação é construída com Spring Boot e PostgreSQL e permite gerenciar informações de entregadores, incluindo CPF, nome e capacidade do veículo.

## Pré-requisitos

Antes de iniciar, você precisa ter as seguintes ferramentas instaladas em seu sistema:
- Java JDK 11 ou superior
- Maven
- PostgreSQL

Além disso, é recomendado ter um editor de código, como o IntelliJ IDEA ou Eclipse, para visualizar e editar o código.

## Configuração do Ambiente

### Configurando o Banco de Dados

1. Instale o PostgreSQL e crie um banco de dados para a aplicação.
2. Modifique o arquivo `src/main/resources/application.properties` com as credenciais do seu banco de dados:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco_de_dados
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    ```

### Construindo a Aplicação

Para construir a aplicação, execute o seguinte comando no terminal:

```bash
mvn clean install

Executando a Aplicação
Após a construção, você pode executar a aplicação com:

java -jar target/nome-do-seu-arquivo.jar

Ou, se preferir, pode executar diretamente através do Maven:

mvn spring-boot:run

Utilizando a API
As seguintes URIs estão disponíveis:

POST /entrega: Cadastra um novo entregador.
GET /entrega: Lista todos os entregadores.
GET /entrega/{id}: Mostra detalhes de um entregador específico.
PUT /entrega/{id}: Atualiza os dados de um entregador.
DELETE /entrega/{id}: Remove um entregador do sistema.
Contribuições
Contribuições são sempre bem-vindas! Para contribuir, por favor, crie um fork do repositório, faça suas alterações e envie um Pull Request.

Agradecemos o interesse no Sistema de Gerenciamento de Entregas da Dianome!
