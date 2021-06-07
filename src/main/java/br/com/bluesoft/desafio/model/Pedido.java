package br.com.bluesoft.desafio.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
	private List<Item> itens = new ArrayList<Item>();
	
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
	 
	
}
