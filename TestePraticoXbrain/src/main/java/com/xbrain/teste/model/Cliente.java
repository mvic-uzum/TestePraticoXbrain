package com.xbrain.teste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data //Gera Getters, Settets, hashCode() e equals() automaticamente para essa classe
@Entity //Para que haja uma tabela Cliente no banco de dados
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //ID deve ser incrementado pelo banco de dados
	private Long id_cliente;
	@Column(name = "nome")
	private String nome;
	
}
