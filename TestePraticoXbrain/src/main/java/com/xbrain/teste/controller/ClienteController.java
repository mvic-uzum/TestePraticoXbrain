package com.xbrain.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xbrain.teste.model.Cliente;
import com.xbrain.teste.service.ClienteService;

@RestController
@RequestMapping("/clientes") //Mapeia os endpoints desenvolvidos para receber requisições iniciadas por "/clientes"
public class ClienteController{

	@Autowired //Instancia a implementação fornecida em tempo de execução pelo Spring Data JPA
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listarClientes(){
		return clienteService.listarClientes();
	}
	
	@GetMapping("/{idCliente}")
	public Cliente findByIdCliente(@PathVariable Long idCliente) {
		return clienteService.findByIdCliente(idCliente);
	}
	
	//Para cadastrar novos clientes
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastrarCliente(@RequestBody Cliente cliente){
		return clienteService.cadastrarCliente(cliente);
	}
	
}
