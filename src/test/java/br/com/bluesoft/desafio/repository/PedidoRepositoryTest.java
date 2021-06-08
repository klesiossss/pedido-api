package br.com.bluesoft.desafio.repository;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Item;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Produto;
import br.com.bluesoft.desafio.model.dto.ItemDTO;

/**
 * Para rodar esse teste corretamente eh necessario tirar, ou comentar apenas, 
 * as instancias dos metodos da service que se encontra na main em DesafioApplication.
 * 
 * 
 * */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PedidoRepositoryTest {
   
	@Autowired
    private PedidoRepository pedidoRepository;
	
	
	
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @DisplayName("Deve salvar um novo pedido")
    public void testeCriarPedido(){
        Fornecedor fornecedor = new Fornecedor();
       Pedido pedido = new Pedido();
       
		fornecedor = new Fornecedor();
		Item item = new Item();
		ItemDTO itemDTO = new ItemDTO();
		Produto produto = new Produto();
		
		produto.setGtin("7894900011517");
		produto.setNome("REFRIGERANTE COCA-COLA 2LT");
		
		
		fornecedor.setNome("Fornecedor 1");
		fornecedor.setCnpj("56.918.868/0001-20");
		
		item.setProduto(produto);
		item.setPreco(12.4);
		item.setQuantidade(10L);
		item.setTotal(15.3);
		item.setPedido(pedido);
		
		itemDTO.setFornecedor(fornecedor);
		itemDTO.setProduto(produto);
		itemDTO.setPreco(5.89);
		itemDTO.setQuantidade(10L);
		itemDTO.setTotal(58.9);
		
		pedido.setFornecedor(fornecedor);
		pedido.addItem(item);
		
		Pedido salvaPedido = pedidoRepository.save(pedido);
		
        Assertions.assertThat(salvaPedido.getFornecedor()).isNotNull();
        Assertions.assertThat(salvaPedido.getFornecedor().getNome()).isEqualTo("Fornecedor 1");
        Assertions.assertThat(salvaPedido.getFornecedor().getCnpj()).isEqualTo("56.918.868/0001-20");
    }
    
}