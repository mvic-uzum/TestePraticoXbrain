package com.xbrain.teste.service;

import java.util.List;

import com.xbrain.teste.model.Produto;

//Calcula o valor total do pedido
public class CalculationService{
	
	private float valor_total;
	
	public float somaTotal(List<Produto> produto){
		for(int i=0; i<produto.size(); i++){
			Produto produtosPedido = produto.get(i);
			valor_total += produtosPedido.getValor();
		}
		return valor_total;
	}
		
}
