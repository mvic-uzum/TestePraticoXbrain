package com.xbrain.teste.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xbrain.teste.config.MessagingConfig;
import com.xbrain.teste.model.Pedido;
import com.xbrain.teste.repository.PedidoRepository;

@Component
public class EntregaConsumer{

	 @Autowired //Instancia a implementação fornecida em tempo de execução pelo Spring Data JPA
	 private PedidoRepository pedidoRepository;
	
	 @RabbitListener(queues = MessagingConfig.QUEUE)
	 public void consumeMessageFromQueue(Pedido pedido){ //trocar pra entrega
		 System.out.println("Solicitação de entrega recebida!"); //trocar para entrega
		 //Salva no banco de dados
		 pedidoRepository.save(pedido);
	 }
	 
}
