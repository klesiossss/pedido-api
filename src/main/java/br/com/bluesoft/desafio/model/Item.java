package br.com.bluesoft.desafio.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.bluesoft.desafio.model.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Produto produto;
	private Long quantidade;
	private Double total;
	private Double preco;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Pedido pedido;
	
	public Item (ItemDTO item) {
		this.produto = item.getProduto();
		this.quantidade = item.getQuantidade();
		this.total = item.getTotal();
		this.preco = item.getPreco();
		
	}
	
	public Item(Produto produto, Long quantidade, Double total, Double preco) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.total = total;
		this.preco = preco;

		
	}


}
