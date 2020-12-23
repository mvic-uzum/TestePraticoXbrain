package com.xbrain.teste.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity //Para que haja uma tabela Pedido no banco de dados
@Table(name = "Pedido")
public class Pedido {
	
	@Id
	@Column(name = "pedidoId")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //ID deve ser incrementado pelo banco de dados
	private Long id_pedido;
	@ManyToOne //Relacionamento com a entidade "Cliente"
	@JoinColumn(name = "clienteId",nullable = false) //não permite que sejam deixados como nulo
	private Cliente id_cliente;
	@ManyToMany //Relacionamento com a entidade "Produto"
	@JoinColumn(name = "produtosId",nullable = false) //FK
	private List<Produto> id_produtos;
	@Column(name = "valorTotal",nullable = false)
	private float valor_total;
	@Column(name = "endereco",nullable = false)
	private String endereco;
	
	//Calcula o valor total do pedido
	public float somaTotal(){
		for(int i=0; i<id_produtos.size(); i++){
			Produto produto = id_produtos.get(i);
			valor_total += produto.getValor();
		}
		return valor_total;
	}

	//Getters e Setters
	public Long getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}
	public Cliente getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Cliente id_cliente) {
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
