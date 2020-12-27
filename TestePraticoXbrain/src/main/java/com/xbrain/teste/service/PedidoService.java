package com.xbrain.teste.service;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xbrain.teste.config.MessagingConfig;
import com.xbrain.teste.model.Pedido;
import com.xbrain.teste.repository.PedidoRepository;

@Service
public class PedidoService{

	@Autowired 
	private PedidoRepository pedidoRepository;
	
    @Autowired
    private RabbitTemplate template;
    
    public List<Pedido> listarPedidos(){ 
		return pedidoRepository.findAll();
	}
	
	public Pedido findByIdPedido(Long idPedido){
		return pedidoRepository.findByIdPedido(idPedido);
	}
	
	public String realizarPedido(Pedido pedido){ 
		//Salvando o pedido no banco de dados
		pedidoRepository.save(pedido);
		//Enviando para a fila de entrega - Publisher
		template.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,pedido);
		System.out.println("Pedido enviado com sucesso à fila de entrega!");
		return "Pedido realizado com sucesso!";
	}
    
}
