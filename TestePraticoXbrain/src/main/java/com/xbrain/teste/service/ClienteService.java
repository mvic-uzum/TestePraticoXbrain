package com.xbrain.teste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xbrain.teste.model.Cliente;
import com.xbrain.teste.repository.ClienteRepository;

@Service
public class ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarClientes(){ 
		return clienteRepository.findAll();
	}
	
	public Cliente findByIdCliente(Long idCliente){
		return clienteRepository.findByIdCliente(idCliente);
	}
	
	public Cliente cadastrarCliente(Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
}
