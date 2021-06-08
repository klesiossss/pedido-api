package br.com.bluesoft.desafio.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Produto {
	
	public Produto(String gtin, String nome) {
		this.gtin = gtin;
		this.nome = nome;
	}
	
	public Produto() {}
	
	@ApiModelProperty(value = "Codigo de barra do produto")
	@Id
    private String gtin;

	@ApiModelProperty(value = "Nome do produto")
    private String nome;

    public String getGtin() {
		return gtin;
	}

	public void setGtin(String gtin) {
		this.gtin = gtin;
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
		result = prime * result + ((gtin == null) ? 0 : gtin.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Produto other = (Produto) obj;
		if (gtin == null) {
			if (other.gtin != null)
				return false;
		} else if (!gtin.equals(other.gtin))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	

	
	  
    
}
