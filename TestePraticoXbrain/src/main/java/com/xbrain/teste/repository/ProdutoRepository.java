package com.xbrain.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xbrain.teste.model.Produto;

@Repository //Responsável pela interação com o Banco de Dados
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	//Automaticamente implementado pelo Spring Data JPA
}
