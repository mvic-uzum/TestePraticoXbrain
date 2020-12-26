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
	private Long idEntrega;
	@Column(name = "idPedido",nullable = false)
	private Long idPedido; 
	@Column(name = "endereco",nullable = false)
	private String endereco; 
	
	public Entrega(){
	}
	
	public Entrega(Long idEntrega,Long idPedido,String endereco){
		super();
		this.idEntrega = idEntrega;
		this.idPedido = idPedido;
		this.endereco = endereco;
	}
	
	//Getters and Setters
	public Long getIdEntrega() {
		return idEntrega;
	}

	public void setIdEntrega(Long idEntrega) {
		this.idEntrega = idEntrega;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
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
		result = prime * result + ((idEntrega == null) ? 0 : idEntrega.hashCode());
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
		if (idEntrega == null) {
			if (other.idEntrega != null)
				return false;
		} else if (!idEntrega.equals(other.idEntrega))
			return false;
		return true;
	}
	
}
