package com.xbrain.teste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name = "Entrega")
@ToString
public class Entrega{
	
	@Id
	@Column(name = "entregaId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_entrega;
	@Column(name = "idPedido",nullable = false)
	private Long id_pedido; 
	@Column(name = "endereco",nullable = false)
	private String endereco; 
	
	public Entrega(){
	}
	
	public Entrega(Long id_entrega,Long id_pedido,String endereco){
		super();
		this.id_entrega = id_entrega;
		this.id_pedido = id_pedido;
		this.endereco = endereco;
	}
	
	//Getters and Setters
	public Long getId_entrega() {
		return id_entrega;
	}

	public void setId_entrega(Long id_entrega) {
		this.id_entrega = id_entrega;
	}

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
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
		result = prime * result + ((id_entrega == null) ? 0 : id_entrega.hashCode());
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
		Entrega other = (Entrega) obj;
		if (id_entrega == null) {
			if (other.id_entrega != null)
				return false;
		} else if (!id_entrega.equals(other.id_entrega))
			return false;
		return true;
	}
	
}
