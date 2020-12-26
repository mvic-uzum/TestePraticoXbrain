package com.xbrain.teste.service;

import java.util.List;
import java.util.stream.Collectors;

import com.xbrain.teste.model.Produto;

//Calcula o valor total do pedido
public class CalculationService{
	
	public double somaTotal(List<Produto> produtos){
		return produtos.stream().map(Produto::getValor).collect(Collectors.summingDouble(Double::doubleValue));
	}
		
}
