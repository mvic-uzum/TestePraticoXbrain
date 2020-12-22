package com.xbrain.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	//Para cadastrar novos produtos
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto cadastrarProduto(@RequestBody Produto produto){
		return (produtoRepository.save(produto));
	}
	
}
