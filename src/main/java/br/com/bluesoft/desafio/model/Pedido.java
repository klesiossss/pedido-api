package br.com.bluesoft.desafio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Pedido {
	
	public Pedido(Long id, List<Item> itens, Fornecedor fornecedor) {
		this.id = id;
		this.itens = itens;
		this.fornecedor = fornecedor;
	}
	
	public Pedido() {
	}
		
	@ApiModelProperty(value = "Codigo do pedido")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(value = "Lista de itens")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
	private List<Item> itens = new ArrayList<Item>();
	
	@ApiModelProperty(value = "Fornecedor do pedido")
	@ManyToOne
	private Fornecedor fornecedor;
	
	
	public Pedido(List<Item> itens,Fornecedor f) {
		this.itens = itens;
		this.fornecedor = f;
	}
	
	 public void addItem(Item item) {
		 itens.add(item);
		 item.setPedido(this);  
	    }
	
	 
	 public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public List<Item> getItens() {
			return itens;
		}

		public void setItens(List<Item> itens) {
			this.itens = itens;
		}

		public Fornecedor getFornecedor() {
			return fornecedor;
		}

		public void setFornecedor(Fornecedor fornecedor) {
			this.fornecedor = fornecedor;
		}
	 
	
}
