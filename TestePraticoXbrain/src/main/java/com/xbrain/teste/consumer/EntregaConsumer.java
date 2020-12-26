package com.xbrain.teste.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xbrain.teste.config.MessagingConfig;
import com.xbrain.teste.model.Entrega;
import com.xbrain.teste.repository.EntregaRepository;

@Component
public class EntregaConsumer{

	 @Autowired //Instancia a implementação fornecida em tempo de execução pelo Spring Data JPA
	 private EntregaRepository entregaRepository;
	
	 @RabbitListener(queues = MessagingConfig.QUEUE)
	 public void consumeMessageFromQueue(Entrega entrega){
		 System.out.println("Solicitação de entrega recebida!"); 
		 //Salva no banco de dados
		 entregaRepository.save(entrega);
	 }
	 
}
