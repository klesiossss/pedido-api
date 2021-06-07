package br.com.bluesoft.desafio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Produto;
import br.com.bluesoft.desafio.model.Request;
import br.com.bluesoft.desafio.service.PedidoService;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner{
	@Autowired
	private PedidoService ps;
   
	public static void main(String[] args) {
        SpringApplication.run(DesafioApplication.class, args);
    }



		@Override
		public void run(String... args) throws Exception {
		
			Produto prod1 = new Produto("7894900011517","Cafe");
			Produto prod2 = new Produto("7891910000197","Acucar");
			Produto prod3 = new Produto("7891991010856","Arroz");
			Produto prod4 = new Produto("7891000100103","Feijao"); 
			Produto prod5 = new Produto("7891910007110","Acucar");
		
				
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
			
				System.out.println("Pedido "+i.getId()); 
				System.out.println(i.getFornecedor().getNome());
				System.out.println(i.getFornecedor().getCnpj());
				i.getItens().forEach(System.out::println);
				System.out.println("\n");
		
			}
			 
		}
		
		
		
		
	
	
}
