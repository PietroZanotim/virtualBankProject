# Virtual Bank API 🏦

Uma API RESTful focada na simulação de transações financeiras, construída para demonstrar a resolução de problemas reais de engenharia de software, como concorrência de dados e design resiliente de APIs.

## 🚀 Destaques da Arquitetura (Por debaixo dos panos)

* **Controle de Concorrência (Pessimistic Locking):** O maior desafio de um sistema financeiro é a condição de corrida (*double-spending*). A API utiliza `@Lock(LockModeType.PESSIMISTIC_WRITE)` na camada de repositório para travar o registro da conta durante transferências simultâneas, garantindo a integridade absoluta dos saldos.
* **Isolamento de Domínio (Padrão DTO):** As entidades de banco de dados (`User`, `Account`, `Transaction`) são estritamente isoladas da camada web. Todo o tráfego de entrada e saída passa por Data Transfer Objects, evitando exposição acidental de dados sensíveis e quebra de encapsulamento.
* **Tratamento Global de Erros:** A aplicação nunca devolve *stack traces* nativos do Java para o cliente. Exceções de regras de negócio (como *Saldo Insuficiente* ou *Recurso Não Encontrado*) são capturadas via `@ControllerAdvice` e convertidas em respostas JSON padronizadas e limpas.
* **Documentação Viva (OpenAPI):** Em vez de coleções estáticas do Postman, a API integra o Swagger UI, gerando uma interface web interativa onde os endpoints podem ser testados em tempo real diretamente pelo navegador.

## 🛠️ Stack Tecnológica

* **Core:** Java 21, Spring Boot 3.3.4
* **Persistência:** Spring Data JPA, H2 Database (configurado em memória para facilitar a execução local instantânea por recrutadores)
* **API Docs:** Springdoc OpenAPI

## ⚙️ Como testar em 1 minuto

1. Clone este repositório.
2. Execute o projeto via Maven ou rodando a classe `VirtualBankApplication.java` na sua IDE.
3. Acesse `http://localhost:8080/swagger-ui.html` para explorar as rotas e realizar transações simuladas.
