﻿# Tutorial Kafka

Projeto de Arquitetura Orientada a eventos

<b>Tecnologias utilizadas</b>
- Java
- SpringBoot
- Kafka
- Docker

Tutorial:
Subir imagens da raiz do diretório docker: 
- docker-compose up -d
- Iniciar as duas aplicações SpringBoot utilizando Eclipse ou IntelliJ
- Envio de dados para o microserviço utilizando requisição POST para a url:
   
   - http://localhost:8080/api/salvar-pedido

- Modelo JSON:

```json
{
	"codigo": "1",
	"nomeProduto": "Pasta de dente",
	"valor": 5.00
}
```
