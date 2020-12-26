package com.xbrain.teste.service;

import java.util.List;

import com.xbrain.teste.model.Produto;

//Calcula o valor total do pedido
public class CalculationService{
	
	public double somaTotal(List<Produto> produto){
		double valor_total = 0;
		for(int i=0;i<produto.size();i++){
			valor_total += produto.get(i).getValor();
		}
		return valor_total;
	}
		
}
