package com.xbrain.teste;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.xbrain.teste.model.Cliente;
import com.xbrain.teste.model.Entrega;
import com.xbrain.teste.model.Pedido;
import com.xbrain.teste.model.Produto;
import com.xbrain.teste.repository.ClienteRepository;
import com.xbrain.teste.repository.EntregaRepository;
import com.xbrain.teste.repository.PedidoRepository;
import com.xbrain.teste.repository.ProdutoRepository;
import com.xbrain.teste.service.CalculationService;
import com.xbrain.teste.service.ClienteService;
import com.xbrain.teste.service.EntregaService;
import com.xbrain.teste.service.PedidoService;
import com.xbrain.teste.service.ProdutoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestePraticoXbrainApplicationTests{

	//Testes - Cliente	
	@Autowired
	private ClienteService clienteService;

	@MockBean 
	private ClienteRepository clienteRepository;
	
	@Test
	public void listarClientesTest(){ 
		when(clienteRepository.findAll()).thenReturn(Stream.of(new Cliente(1L,"Maria"),new Cliente(2L,"Ana"),new Cliente(3L,"Júlia")).collect(Collectors.toList()));
		assertEquals(3,clienteService.listarClientes().size());	
	}
	
	@Test
	public void findByIdClienteTest(){
		Cliente cliente = new Cliente(1L,"Maria");
		when(clienteRepository.findByIdCliente(1L)).thenReturn(cliente);
		Cliente clienteRetornado = clienteService.findByIdCliente(1L);
		verify(clienteRepository, times(1)).findByIdCliente(1L);
		verifyNoMoreInteractions(clienteRepository);
		assertEquals(clienteRetornado,cliente);
	}
	
	@Test
	public void cadastrarClienteTest(){
		Cliente cliente = new Cliente(1L,"Maria");
		when(clienteRepository.save(cliente)).thenReturn(cliente);
		assertEquals(cliente,clienteService.cadastrarCliente(cliente));
	}
	
	//Testes - Produto
	@Autowired
	private ProdutoService produtoService;
	
	@MockBean 
	private ProdutoRepository produtoRepository;
	
	@Test
	public void listarProdutosTest(){
		when(produtoRepository.findAll()).thenReturn(Stream.of(new Produto(1L,"Camisa",30.50),new Produto(2L,"Tênis",180),new Produto(3L,"Jaqueta",320.87)).collect(Collectors.toList()));
		assertEquals(3,produtoService.listarProdutos().size());
	}
	
	@Test
	public void findByIdProdutoTest(){	
		Produto produto = new Produto(1L,"Camisa",30.50);
		when(produtoRepository.findByIdProduto(1L)).thenReturn(produto);
		Produto produtoRetornado = produtoService.findByIdProduto(1L);
		verify(produtoRepository, times(1)).findByIdProduto(1L);
		verifyNoMoreInteractions(produtoRepository);
		assertEquals(produtoRetornado,produto);
	}
	
	@Test
	public void cadastrarProdutoTest(){
		Produto produto = new Produto(1L,"Camisa",30.50);
		when(produtoRepository.save(produto)).thenReturn(produto);
		assertEquals(produto,produtoService.cadastrarProduto(produto));
	}
	
	//Testes - Pedido
	@Autowired
	private PedidoService pedidoService;
	
	@MockBean 
	private PedidoRepository pedidoRepository;
	
	@MockBean
	private CalculationService calculationService;
	
	@Test 
	public void listarPedidosTest(){
		Cliente cliente = new Cliente(1L,"Maria");
		Produto produto1 = new Produto(1L,"Camisa",30.50);
		Produto produto2 = new Produto(2L,"Tênis",180);
		Produto produto3 = new Produto(3L,"Jaqueta",320.87);
		List<Produto> lista1 = new ArrayList<Produto>();
		lista1.add(produto1);
		lista1.add(produto2);
		List<Produto> lista2 = new ArrayList<Produto>();
		lista2.add(produto2);
		lista2.add(produto3);
		when(pedidoRepository.findAll()).thenReturn(Stream.of(new Pedido(1L,cliente,lista1,210.5,"Rua XV"),new Pedido(2L,cliente,lista2,500.87,"Rua Amazonas")).collect(Collectors.toList()));
		assertEquals(2,pedidoService.listarPedidos().size());
	}
	
	@Test
	public void findByIdPedidoTest(){	
		Cliente cliente = new Cliente(1L,"Maria");
		Produto produto = new Produto(1L,"Camisa",30.50);
		List<Produto> listaProdutos = new ArrayList<Produto>();
		listaProdutos.add(produto);
		Pedido pedido = new Pedido(1L,cliente,listaProdutos,30.50,"Rua dos Bosques");
		when(pedidoRepository.findByIdPedido(1L)).thenReturn(pedido);
		Pedido pedidoRetornado = pedidoService.findByIdPedido(1L);
		verify(pedidoRepository, times(1)).findByIdPedido(1L);
		verifyNoMoreInteractions(pedidoRepository);
		assertEquals(pedidoRetornado,pedido);
	}
	
	@Test
	public void realizarPedidoTest(){
		Cliente cliente = new Cliente(1L,"Maria");
		Produto produto = new Produto(1L,"Camisa",30.50);
		List<Produto> lista = new ArrayList<Produto>();
		lista.add(produto);
		Pedido pedido = new Pedido(1L,cliente,lista,30.50,"Rua dos Bosques");
	}
	
	//Teste do cálculo do valor total do pedido
	@Test
	public void somaTotalTest(){
		Produto produto1 = new Produto(1L,"Camisa",30.50);
		Produto produto2 = new Produto(2L,"Tênis",180);
		List<Produto> lista = new ArrayList<Produto>();
		lista.add(produto1);
		lista.add(produto2);
		//Passando os valores do produto para uma nova lista
		List<Produto> produtosVendidos = lista.stream().map(produto -> produtoService.findByIdProduto(produto.getIdProduto())).collect(Collectors.toList());
		double valorTotal = 0;
		double soma = produto1.getValor() + produto2.getValor();
		when(calculationService.somaTotal(produtosVendidos)).thenReturn(valorTotal);
		assertEquals(soma,valorTotal,0); //Range para cálculos de precisão numérica
	}
	
	//Testes - Entrega
	@Autowired
	private EntregaService entregaService;
	
	@MockBean 
	private EntregaRepository entregaRepository;
	
	@Test
	public void listarEntregasTest(){
		when(entregaRepository.findAll()).thenReturn(Stream.of(new Entrega(1L,1L,"Rua XV"),new Entrega(2L,2L,"Rua dos Bosques")).collect(Collectors.toList()));
		assertEquals(2,entregaService.listarEntregas().size());
	}
	
	@Test
	public void findByIdEntregaTest(){
		Entrega entrega = new Entrega(1L,1L,"Rua XV");
		when(entregaRepository.findByIdEntrega(1L)).thenReturn(entrega);
		Entrega entregaRetornada = entregaService.findByIdEntrega(1L);
		verify(entregaRepository, times(1)).findByIdEntrega(1L);
		verifyNoMoreInteractions(entregaRepository);
		assertEquals(entregaRetornada,entrega);
	}
		
}