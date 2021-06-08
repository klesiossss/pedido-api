package br.com.bluesoft.desafio.model.dto;

import java.util.List;


public class FornecedorResponse {
	private String nome;
	private String cnpj;
	private List<Preco> precos;
	
	public FornecedorResponse(String nome, String cnpj, List<Preco> precos) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.precos = precos;
	}
	
	public FornecedorResponse() { }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public List<Preco> getPrecos() {
		return precos;
	}
	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}
	
	
	
	
	
}
