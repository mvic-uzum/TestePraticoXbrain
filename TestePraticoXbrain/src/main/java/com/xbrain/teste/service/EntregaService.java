package com.xbrain.teste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xbrain.teste.model.Entrega;
import com.xbrain.teste.repository.EntregaRepository;

@Service
public class EntregaService{
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	public List<Entrega> listarEntregas(){
		return entregaRepository.findAll();
	}
	
	public Entrega findByIdEntrega(Long idEntrega){
		return entregaRepository.findByIdEntrega(idEntrega);
	}

}
