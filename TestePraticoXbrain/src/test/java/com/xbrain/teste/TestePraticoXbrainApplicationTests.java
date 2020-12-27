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
	
	@Test 
	public void listarPedidosTest(){
		Cliente cliente = new Cliente(1L,"Maria");
		Produto produto1 = new Produto(1L,"Camisa",30.50);
		Produto produto2 = new Produto(2L,"Tênis",180);
		Produto produto3 = new Produto(3L,"Jaqueta",320.87);
		List<Produto> lista1 = new ArrayList<>();
		lista1.add(produto1);
		lista1.add(produto2);
		List<Produto> lista2 = new ArrayList<>();
		lista2.add(produto2);
		lista2.add(produto3);
		when(pedidoRepository.findAll()).thenReturn(Stream.of(new Pedido(1L,cliente,lista1,210.5,"Rua XV"),new Pedido(2L,cliente,lista2,500.87,"Rua Amazonas")).collect(Collectors.toList()));
		assertEquals(2,pedidoService.listarPedidos().size());
	}
	
	@Test
	public void findByIdPedidoTest(){	
	}
	
	//Conferir teste de registro da Entrega
	@Test
	public void realizarPedidoTest(){
		Cliente cliente = new Cliente(1L,"Maria");
		Produto produto1 = new Produto(1L,"Camisa",30.50);
		List<Produto> lista = new ArrayList<>();
		lista.add(produto1);
		Pedido pedido = new Pedido(1L,cliente,lista,30.50,"Rua dos Bosques");
		when(pedidoRepository.save(pedido)).thenReturn(pedido);
		assertEquals(pedido,pedidoService.realizarPedido(pedido));
	}
	
	//Teste do cálculo do valor total do pedido
	@Test
	public void somaTotalTest(){
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
	}
		
}