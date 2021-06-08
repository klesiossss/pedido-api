package br.com.bluesoft.desafio.model.dto;


	import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Produto;


	public class ItemDTO {
		
		private Long id;
	
		private Produto produto;
		private Long quantidade;
		private Double total;
		private Double preco;
		private Fornecedor fornecedor;
		
		
		public ItemDTO(Long id, Produto produto, Long quantidade, Double total, Double preco, Fornecedor fornecedor) {
			this.id = id;
			this.produto = produto;
			this.quantidade = quantidade;
			this.total = total;
			this.preco = preco;
			this.fornecedor = fornecedor;
		}
		
		public ItemDTO() {
		}

		public ItemDTO(Produto produto, Long quantidade, Double total, Double preco, Fornecedor fornecedor) {
			this.produto = produto;
			this.quantidade = quantidade;
			this.total = total;
			this.preco = preco;
			this.fornecedor = fornecedor;
	
		}
		
		public ItemDTO(Produto produto, Long quantidade, Double total, Double preco) {
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

		public Fornecedor getFornecedor() {
			return fornecedor;
		}

		public void setFornecedor(Fornecedor fornecedor) {
			this.fornecedor = fornecedor;
		}
		
		

}
