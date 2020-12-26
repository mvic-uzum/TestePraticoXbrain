package com.xbrain.teste.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xbrain.teste.config.MessagingConfig;
import com.xbrain.teste.model.Entrega;
import com.xbrain.teste.model.Pedido;
import com.xbrain.teste.repository.EntregaRepository;

@Component
public class PedidoConsumer{

	 @Autowired //Instancia a implementação fornecida em tempo de execução pelo Spring Data JPA
	 private EntregaRepository entregaRepository;
	
	 @RabbitListener(queues = MessagingConfig.QUEUE)
	 public void consumeMessageFromQueue(Pedido pedido){
		 System.out.println("Solicitação de entrega do pedido "+pedido.getId_pedido()+" recebida!"); 
		 //Salva no banco de dados
		 Entrega entrega = new Entrega();
		 entrega.setId_pedido(pedido.getId_pedido());
		 entrega.setEndereco(pedido.getEndereco());
		 entregaRepository.save(entrega);
	 }
	 
}
