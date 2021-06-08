package br.com.bluesoft.desafio.model;

import io.swagger.annotations.ApiModelProperty;

public class Request {
	
	@ApiModelProperty(value = "Produto")
	private Produto produto;
	@ApiModelProperty(value = "Quantidade desse produto")
	private Long quant;
	
	
	public Request(Produto produto, Long quant) {
		this.produto = produto;
		this.quant = quant;
	}
	
	public Request() { }
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Long getQuant() {
		return quant;
	}
	public void setQuant(Long quant) {
		this.quant = quant;
	}
	
	

}
