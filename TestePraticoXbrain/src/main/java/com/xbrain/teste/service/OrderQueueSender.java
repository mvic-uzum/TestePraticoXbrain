package com.xbrain.teste.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xbrain.teste.model.Pedido;

//Conecta ao RabbitMQ e envia mensagens à fila de Entrega
@Component
public class OrderQueueSender{
	
	@Autowired //Envia mensagens ao RabbitMQ de forma síncrona
    private RabbitTemplate rabbitTemplate;
 
    @Autowired
    private Queue filaEntrega;
 
    //Método que envia as mensagens
    public void send(Pedido pedido) {
        rabbitTemplate.convertAndSend(this.filaEntrega.getName(), pedido);
    }
    
}
