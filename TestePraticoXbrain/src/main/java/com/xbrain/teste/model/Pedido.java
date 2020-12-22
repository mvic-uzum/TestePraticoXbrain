package com.xbrain.teste.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity //Para que haja uma tabela Pedido no banco de dados
@Table(name = "Pedido")
public class Pedido {
	
	@Id
	@Column(name = "pedidoId")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //ID deve ser incrementado pelo banco de dados
	private Long id_pedido;
	@OneToOne //Relacionamento com a entidade "Cliente"
	@Column(name = "clienteId",nullable = false) //não permite que sejam deixados como nulo
	private Long id_cliente;
	@OneToMany //Relacionamento com a entidade "Produto"
	@Column(name = "produtosId",nullable = false)
	private List<Produto> id_produtos;
	@Column(name = "valorTotal",nullable = false)
	private float valor_total;
	@Column(name = "endereco",nullable = false)
	private String endereco;

	//Getters e Setters
	public Long getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}
	public Long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public List<Produto> getId_produtos() {
		return id_produtos;
	}
	public void setId_produtos(List<Produto> id_produtos) {
		this.id_produtos = id_produtos;
	}
	public float getValor_total() {
		return valor_total;
	}
	public void setValor_total(float valor_total) {
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
