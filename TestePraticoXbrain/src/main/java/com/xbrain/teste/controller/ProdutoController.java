package com.xbrain.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xbrain.teste.model.Produto;
import com.xbrain.teste.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos") //Mapeia os endpoints desenvolvidos para receber requisições iniciadas por "/produtos"
public class ProdutoController {
	
	@Autowired //Instancia a implementação fornecida em tempo de execução pelo Spring Data JPA
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> listarProdutos(){
		return produtoRepository.findAll();
	}
	
}
