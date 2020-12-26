package com.xbrain.teste.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.ToString;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity 
@Table(name = "Pedido")
@ToString
public class Pedido{
	
	@Id
	@Column(name = "pedidoId")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_pedido;
	@ManyToOne 
	@JoinColumn(name = "cliId",nullable = false) //FK
	private Cliente cliente;
	@ManyToMany
	@JoinColumn(name = "prodId",nullable = false) //FK
	private List<Produto> produto;
	@Column(name = "valorTotal",nullable = false)
	private double valor_total;
	@Column(name = "endereco",nullable = false)
	private String endereco;
	
	public Pedido(){	
	}
	
	public Pedido(Long id_pedido,Cliente cliente,List<Produto> produto,double valor_total,String endereco) {
		super();
		this.id_pedido = id_pedido;
		this.cliente = cliente;
		this.produto = produto;
		this.valor_total = valor_total;
		this.endereco = endereco;
	}

	//Getters e Setters
	public Long getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Produto> getProduto() {
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_pedido == null) ? 0 : id_pedido.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id_pedido == null) {
			if (other.id_pedido != null)
				return false;
		} else if (!id_pedido.equals(other.id_pedido))
			return false;
		return true;
	}
	
}
