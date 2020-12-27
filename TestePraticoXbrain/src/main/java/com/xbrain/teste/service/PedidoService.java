package com.xbrain.teste.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xbrain.teste.config.MessagingConfig;
import com.xbrain.teste.model.Pedido;
import com.xbrain.teste.model.Produto;
import com.xbrain.teste.repository.PedidoRepository;
import com.xbrain.teste.repository.ProdutoRepository;

@Service
public class PedidoService{

	@Autowired 
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
    @Autowired
    private RabbitTemplate template;
    
    public List<Pedido> listarPedidos(){ 
		return pedidoRepository.findAll();
	}
	
	public Pedido findByIdPedido(Long idPedido){
		return pedidoRepository.findByIdPedido(idPedido);
	}
	
	public String realizarPedido(Pedido pedido){
		//Criando a lista de produtos inclusos no pedido
		List<Produto> produtosVendidos = pedido.getProduto().stream().map(produto -> produtoRepository.findByIdProduto(produto.getIdProduto())).collect(Collectors.toList());
		//Cálculo do valor total do pedido
		CalculationService calculationService = new CalculationService();
		double valorTotal = calculationService.somaTotal(produtosVendidos);
		pedido.setValor_total(valorTotal); 
		//Salvando o pedido no banco de dados
		pedidoRepository.save(pedido);
		//Enviando para a fila de entrega - Publisher
		template.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,pedido);
		System.out.println("Pedido enviado com sucesso à fila de entrega!");
		return "Pedido realizado com sucesso!";
	}
    
}
