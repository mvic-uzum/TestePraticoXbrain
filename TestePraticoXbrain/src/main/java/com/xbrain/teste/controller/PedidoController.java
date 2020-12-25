package com.xbrain.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xbrain.teste.model.Pedido;
import com.xbrain.teste.repository.PedidoRepository;
import com.xbrain.teste.service.OrderQueueSender;

@RestController
@RequestMapping("/pedidos") //Mapeia os endpoints desenvolvidos para receber requisições iniciadas por "/pedidos"
public class PedidoController{
	
	@Autowired //Instancia a implementação fornecida em tempo de execução pelo Spring Data JPA
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public List<Pedido> listarPedidos(){
		return pedidoRepository.findAll();
	}
	
	//Para cadastrar novos pedidos
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void realizarPedido(@RequestBody Pedido pedido){
		OrderQueueSender filaEntrega = new OrderQueueSender();
		//Salva o pedido no banco de dados
		pedidoRepository.save(pedido);
		//Envia o pedido para a fila de entregas
		filaEntrega.send(pedido);	
	}
	
}
