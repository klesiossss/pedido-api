package br.com.bluesoft.desafio.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Item;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Produto;
import br.com.bluesoft.desafio.model.Request;
import br.com.bluesoft.desafio.model.dto.ItemDTO;
import br.com.bluesoft.desafio.repository.FornecedorRepository;
import br.com.bluesoft.desafio.repository.PedidoRepository;
import br.com.bluesoft.desafio.repository.ProdutoRepository;


@SpringBootTest
@DisplayName("deve salvar um pedido")
public class ServiceFornecedorTest {
	
	@Mock
	private PedidoRepository pedidoRepository;
	@Mock
	private FornecedorRepository fornRepo;
	@Mock
	private ProdutoRepository prodRepo;
	
	@InjectMocks
	private PedidoService pedidoService;
	
	private static Pedido pedido;
	private static Fornecedor fornecedor;
	private static Item item;
	private static ItemDTO itemDTO;
	private static Request request;
	private static Produto produto;
	
	@BeforeAll
	static void beforeAll() {
		pedido = new Pedido();
		fornecedor = new Fornecedor();
		item = new Item();
		itemDTO = new ItemDTO();
		produto = new Produto();
		request = new Request();
		
		
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

	}
	
	
	@Test
	@DisplayName("Deve retornar menor valor da api ")
	public  void TesteRetornandoItemMaisBarato() {
		when(pedidoRepository.save(pedido)).thenReturn(pedido);
		
		
		Pedido newPedido = new Pedido();

		fornRepo.save(fornecedor);
		newPedido.setFornecedor(fornecedor);
		newPedido.addItem(item);
			
		
		ItemDTO item = pedidoService.obterMenorPreco(produto,10L);
		System.out.println(item);
		assertAll(() -> {
	
			assertEquals(item.getFornecedor().getNome(),"Fornecedor 1");
			assertEquals(item.getFornecedor().getCnpj(),"56.918.868/0001-20");
			assertEquals(item.getPreco(), 5.89);
			assertEquals(item.getProduto().getNome(), "REFRIGERANTE COCA-COLA 2LT");
			assertEquals(item.getProduto().getGtin(), "7894900011517");
			
		});
	}
	
		
	@Test
	@DisplayName("Deve retornar pedidos da api ")
	public  void TesteRetornandoOsPedidos() {
		when(pedidoRepository.save(pedido)).thenReturn(pedido);
		
		fornRepo.save(fornecedor);
		pedido.setFornecedor(fornecedor);
		pedido.addItem(item);
		
		request.setProduto(produto);
		request.setQuant(10L);
		List<Request> req = new ArrayList<>();
		req.add(request);
		
		List<Pedido> pedidos;
	
		pedidos = pedidoService.obterPedidos(req);

		assertAll(() -> {
			 Assertions.assertThat(pedidos).isNotNull();
		});
	}
	
}