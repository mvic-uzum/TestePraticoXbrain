package com.xbrain.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class TestePraticoXbrainApplication {
	
	//Configurando o RabbitMQ
	@Value("${queue.order.name}")
    private String FilaDeEntrega;

	public static void main(String[] args) {
		SpringApplication.run(TestePraticoXbrainApplication.class, args);
	}
	
	@Bean
    public Queue queue() {
        return new Queue(FilaDeEntrega, true);
    }
	
}