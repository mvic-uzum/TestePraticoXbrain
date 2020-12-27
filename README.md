# TestePraticoXbrain

Para o teste prático da empresa X-Brain, foi desenvolvida uma API back-end utilizando Spring Boot e um banco de dados em memória (H2).

Requisitos:
- Desenvolver uma API REST que seja capaz de gerar um pedido (código do cliente, código dos produtos, valor total e endereço de entrega);
- A api deve gravar o pedido no banco e enviar o pedido para a uma fila de mensagem de entregas, usando RabbitMQ;
- Criar um serviço para ler as entregas da fila e salvar na tabela Entrega (endereço de entrega e id do pedido);
- Realizar testes automatizados.

Neste projeto, todos os itens requisitados foram cumpridos dentro do prazo estipulado de 7 dias.
