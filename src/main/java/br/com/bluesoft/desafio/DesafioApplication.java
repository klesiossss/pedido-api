package br.com.bluesoft.desafio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bluesoft.desafio.model.Item;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Produto;
import br.com.bluesoft.desafio.model.Request;
import br.com.bluesoft.desafio.service.PedidoService;

/**
 * Apos subir a aplicacao acesse:
 * 
 * http://localhost:8080/swagger-ui.html 
 * 
 * Para acesar o Banco de dados H2, acesse:
 * 
 * http://localhost:8080/h2-console
 * 
 * insira no campo JDBC URL:
 * 
 * jdbc:h2:mem:testdb
 * 
 * user name: sa
 * senha:			//em branco
 * 
 * */
@SpringBootApplication
public class DesafioApplication implements CommandLineRunner{

   
	public static void main(String[] args) {
        SpringApplication.run(DesafioApplication.class, args);
    }

	@Autowired
	private PedidoService ps;

		@Override
		public void run(String... args) throws Exception {
		
			Produto prod1 = new Produto("7894900011517","REFRIGERANTE COCA-COLA 2LT");
			Produto prod2 = new Produto("7891910000197","AÇÚCAR REFINADO UNIÃO 1KG");
			Produto prod3 = new Produto("7891991010856","CERVEJA BUDWEISER");
			Produto prod4 = new Produto("7891000100103","LEITE CONDENSADO MOÇA"); 
			Produto prod5 = new Produto("7891910007110","AÇÚCAR DE CONFEITEIRO UNIÃO GLAÇÚCAR");
		
				
			Request r1 = new Request(prod1,2L);
			Request r2 = new Request(prod2,3L);
			Request r3 = new Request(prod3,1L);
			Request r4 = new Request(prod4,10L);
			Request r5 = new Request(prod5,10L);
			
			List<Request> request = new ArrayList<Request>();
			
			request.add(r1);
			request.add(r2);
			request.add(r3);
			request.add(r4);
			request.add(r5);
			
		
			List<Pedido> pedido = ps.obterPedidos(request);
			
			for(Pedido i : pedido) {
				
				System.out.println("\n Pedido "+i.getId()); 
				System.out.println(i.getFornecedor().getNome());
				System.out.println("Cnpj: "+i.getFornecedor().getCnpj());
				for(Item item : i.getItens()) {
					System.out.println(item.getProduto().getNome());
					System.out.println("Codigo de Barra: "+item.getProduto().getGtin());
					System.out.println("Preco: "+item.getPreco());
					System.out.println("Quantidade: "+item.getQuantidade());
					System.out.println("Total " +item.getTotal());
				}
				System.out.println("\n");
		
			}
			 
		}
}
		
		
		
		
	
	

