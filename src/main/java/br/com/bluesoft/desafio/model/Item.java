package br.com.bluesoft.desafio.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.bluesoft.desafio.model.dto.ItemDTO;
import io.swagger.annotations.ApiModelProperty;


@Entity
public class Item {
	
	public Item(Long id, Produto produto, Long quantidade, Double total, Double preco, Pedido pedido) {
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.total = total;
		this.preco = preco;
		this.pedido = pedido;
	}
	
	public Item() {
	}

    @ApiModelProperty(value = "Código do Item")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ApiModelProperty(value = "Produto")
	@ManyToOne
	private Produto produto;
    @ApiModelProperty(value = "Quantidade de itens")
	private Long quantidade;
    @ApiModelProperty(value = "Valor total por item")
	private Double total;
    @ApiModelProperty(value = "Preco unitario do produto")
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

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

	

}
