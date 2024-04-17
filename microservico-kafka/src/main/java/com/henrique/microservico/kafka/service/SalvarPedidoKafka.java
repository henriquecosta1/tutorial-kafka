package com.henrique.microservico.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henrique.microservico.kafka.data.PedidoData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SalvarPedidoKafka {

	@KafkaListener(topics = "SalvarPedido", groupId = "MicroServicoSalvaPedido")
	private void executar(ConsumerRecord<String, String> record) {
		
		log.info("Chave = {}", record.key());
		log.info("Cabeçalho = {}", record.headers());
		log.info("Partição = {}", record.partition());
		
		String dados = record.value();
		ObjectMapper mapper = new ObjectMapper();
		PedidoData pedido;
		
		try {
			pedido = mapper.readValue(dados, PedidoData.class);
		} catch (JsonProcessingException e) {
			log.error("Falha ao converter evento [dado={}]", dados, e);
			return;
		}
		
		log.info("Evento Recebido = {}", pedido);
		
		
	}
}
