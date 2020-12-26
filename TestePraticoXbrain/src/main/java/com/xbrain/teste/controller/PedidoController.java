package com.xbrain.teste.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xbrain.teste.config.MessagingConfig;
import com.xbrain.teste.model.Pedido;
import com.xbrain.teste.model.Produto;
import com.xbrain.teste.repository.PedidoRepository;
import com.xbrain.teste.repository.ProdutoRepository;
import com.xbrain.teste.service.CalculationService;

@RestController
@RequestMapping("/pedidos") //Mapeia os endpoints desenvolvidos para receber requisições iniciadas por "/pedidos"
public class PedidoController{
	
	@Autowired //Instancia a implementação fornecida em tempo de execução pelo Spring Data JPA
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
    @Autowired
    private RabbitTemplate template;
	
	@GetMapping
	public List<Pedido> listarPedidos(){
		return pedidoRepository.findAll();
	}
	
	@GetMapping("/{idPedido}")
	public Pedido findByIdPedido(@PathVariable Long idPedido) {
		return pedidoRepository.findByIdPedido(idPedido);
	}
	
	//Para cadastrar novos pedidos
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String realizarPedido(@RequestBody Pedido pedido){
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
