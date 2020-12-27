package com.xbrain.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xbrain.teste.model.Entrega;
import com.xbrain.teste.service.EntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController{

	@Autowired //Instancia a implementação fornecida em tempo de execução pelo Spring Data JPA
	private EntregaService entregaService;
	
	@GetMapping
	public List<Entrega> listarEntregas(){
		return entregaService.listarEntregas();
	}
	
	@GetMapping("/{idEntrega}")
	public Entrega findByIdEntrega(@PathVariable Long idEntrega) {
		return entregaService.findByIdEntrega(idEntrega);
	}
	
}
