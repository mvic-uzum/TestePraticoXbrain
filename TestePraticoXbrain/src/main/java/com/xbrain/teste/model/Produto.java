package com.xbrain.teste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data //Gera Getters, Settets, hashCode() e equals() automaticamente para essa classe
@Entity //Para que haja uma tabela Produto no banco de dados
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //ID deve ser incrementado pelo banco de dados
	private Long id_produto;
	@Column(nullable = false)
	private float valor;
	
}
