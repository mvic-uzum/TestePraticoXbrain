package com.xbrain.teste.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "Produto")
public class Produto {

	@Id
	@Column(name = "produtoId")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //ID deve ser incrementado pelo banco de dados
	private Long id_produto;
	@Column(name = "tipoItem",nullable = false)
	private String tipo_item;
	@Column(name = "valor",nullable = false)
	private float valor;
	/*@ManyToMany //Relacionamento com a entidade "Pedido"
	@JoinColumn(name = "pedidosInclusoId",nullable = false) //FK
	private List<Pedido> pedido;*/
	
	public Produto(){
	}
	
	public Produto(Long id_produto,String tipo_item,float valor,List<Pedido> pedido) {
		super();
		this.id_produto = id_produto;
		this.tipo_item = tipo_item;
		this.valor = valor;
		//this.pedido = pedido;
	}
	
	//Getters e Setters	
	public Long getId_produto() {
		return id_produto;
	}
	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}
	public String getTipo_item() {
		return tipo_item;
	}
	public void setTipo_item(String tipo_item) {
		this.tipo_item = tipo_item;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	/*public List<Pedido> getPedido() {
		return pedido;
	}
	public void setPedidos(List<Pedido> pedido) {
		this.pedido = pedido;
	}*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_produto == null) ? 0 : id_produto.hashCode());
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
		Produto other = (Produto) obj;
		if (id_produto == null) {
			if (other.id_produto != null)
				return false;
		} else if (!id_produto.equals(other.id_produto))
			return false;
		return true;
	}
	
}
