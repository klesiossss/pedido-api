package br.com.bluesoft.desafio.model.dto;


	import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


	@Data
	@AllArgsConstructor
	@NoArgsConstructor	
	public class ItemDTO {
		
		private Long id;
	
		private Produto produto;
		private Long quantidade;
		private Double total;
		private Double preco;
		private Fornecedor fornecedor;
		
		
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

}
