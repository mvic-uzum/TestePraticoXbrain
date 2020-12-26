package com.xbrain.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xbrain.teste.model.Cliente;

@Repository //Responsável pela interação com o Banco de Dados
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
