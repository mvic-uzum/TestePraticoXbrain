package com.xbrain.teste;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.xbrain.teste.model.Cliente;
import com.xbrain.teste.repository.ClienteRepository;
import com.xbrain.teste.repository.ProdutoRepository;
import com.xbrain.teste.service.ClienteService;
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
	
	/*@Test
	public void findByIdClienteTest(){
		Long idCliente = 2L;
		Cliente cliente = clienteRepository.findByIdCliente(idCliente);
		when(clienteRepository.findByIdCliente(idCliente)).thenReturn((Cliente) Stream.of(new Cliente(2L,"Ana")).collect(Collectors.toList()));
		assertEquals(cliente,clienteService.findByIdCliente(idCliente));
	}*/
	
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

}