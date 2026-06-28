🏦 Virtual Bank - Motor PIX API

Uma API RESTful desenvolvida em Java com Spring Boot para simular as operações essenciais de um banco digital, com foco no processamento de transferências instantâneas (PIX).

🚀 Sobre o Projeto

Este projeto foi construído para aplicar conceitos de Engenharia de Software e arquitetura de back-end na prática. A API vai além de um simples CRUD (cadastro de dados), atuando como um motor financeiro real que garante a integridade e consistência de transações bancárias.

O sistema é responsável por:

Gerenciar Contas: Relacionamento direto entre usuários e seus saldos.

Processar Transações: Transferência de valores (PIX) entre contas em tempo real.

Aplicar Regras de Negócio: Bloqueio automático de operações inválidas (como saldo insuficiente ou CPF inexistente).

Garantir Segurança de Dados: Uso de transações atômicas (@Transactional) para impedir perda de dinheiro em caso de falhas no servidor.

🛠️ Stack Tecnológica

Java 17+

Spring Boot 3 (Web, Data JPA)

H2 Database (Banco em memória) / PostgreSQL

Maven
