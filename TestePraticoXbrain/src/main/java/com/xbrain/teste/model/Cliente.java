package com.xbrain.teste.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //Para que haja uma tabela Cliente no banco de dados
@Table(name = "Cliente")
public class Cliente {

	@Id
	@Column(name = "clienteId")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //ID deve ser incrementado pelo banco de dados
	private Long id_cliente;
	@Column(name = "nome",nullable = false)
	private String nome;
	@OneToMany //Relacionamento com a entidade "Pedido"
	@JoinColumn(name = "pedidosId",nullable = true) //FK
	private List<Pedido> id_pedidos;
	
	//Getters e Setters
	public Long getId_cliente() {
		return id_cliente;
	}

	public List<Pedido> getId_pedidos() {
		return id_pedidos;
	}

	public void setId_pedidos(List<Pedido> id_pedidos) {
		this.id_pedidos = id_pedidos;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_cliente == null) ? 0 : id_cliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (id_cliente == null) {
			if (other.id_cliente != null)
				return false;
		} else if (!id_cliente.equals(other.id_cliente))
			return false;
		return true;
	}	
	
}
