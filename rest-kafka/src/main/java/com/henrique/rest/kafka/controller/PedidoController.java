package com.henrique.rest.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.henrique.rest.kafka.data.PedidoData;
import com.henrique.rest.kafka.service.RegistraEventoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PedidoController {
	
	private final RegistraEventoService eventoService;
	
	@PostMapping(path = "/api/salvar-pedido")
	public ResponseEntity<String> salvarPedido(@RequestBody PedidoData pedido) {
		eventoService.adicionarEvento("SalvarPedido", pedido);
		return ResponseEntity.ok("Sucesso");
	}
}
