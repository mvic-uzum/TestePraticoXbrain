package com.xbrain.teste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xbrain.teste.model.Produto;
import com.xbrain.teste.repository.ProdutoRepository;

@Service
public class ProdutoService{
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> listarProdutos(){
		return produtoRepository.findAll();
	}
	
	public Produto findByIdProduto(Long idProduto){
		return produtoRepository.findByIdProduto(idProduto);
	}
	
	public Produto cadastrarProduto(Produto produto){
		return produtoRepository.save(produto);
	}
	
}
