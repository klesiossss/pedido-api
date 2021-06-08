package br.com.bluesoft.desafio.model.dto;

public class Preco {
	private Double preco;
	private Long quantidade_minima;
	

	public Preco(Double preco, Long quantidade_minima) {
		this.preco = preco;
		this.quantidade_minima = quantidade_minima;
	}
	
	public Preco() {	
	}
	
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Long getQuantidade_minima() {
		return quantidade_minima;
	}
	public void setQuantidade_minima(Long quantidade_minima) {
		this.quantidade_minima = quantidade_minima;
	}
	


}
