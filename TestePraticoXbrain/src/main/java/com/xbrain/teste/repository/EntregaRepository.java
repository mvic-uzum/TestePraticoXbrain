package com.xbrain.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xbrain.teste.model.Entrega;

@Repository //Responsável pela interação com o Banco de Dados
public interface EntregaRepository extends JpaRepository<Entrega, Long>{
	//Automaticamente implementado pelo Spring Data JPA
}
