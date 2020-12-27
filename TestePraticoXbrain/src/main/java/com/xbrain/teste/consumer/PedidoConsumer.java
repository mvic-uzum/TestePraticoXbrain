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
		 System.out.println("Solicitação de entrega do pedido "+pedido.getIdPedido()+" recebida!"); 
		 //Salva no banco de dados
		 Entrega entrega = new Entrega();
		 entrega.setIdPedido(pedido.getIdPedido());
		 entrega.setEndereco(pedido.getEndereco());
		 entregaRepository.save(entrega);
	 }
	 
}
