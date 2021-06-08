package br.com.bluesoft.desafio.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluesoft.desafio.api.FornecedorAPI;
import br.com.bluesoft.desafio.exception.BusinessException;
import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Item;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Produto;
import br.com.bluesoft.desafio.model.Request;
import br.com.bluesoft.desafio.model.dto.FornecedorResponse;
import br.com.bluesoft.desafio.model.dto.ItemDTO;
import br.com.bluesoft.desafio.repository.FornecedorRepository;
import br.com.bluesoft.desafio.repository.PedidoRepository;
import br.com.bluesoft.desafio.repository.ProdutoRepository;

@Service
public class PedidoService {
	@Autowired
	private FornecedorRepository fornRepo;
	@Autowired
	private PedidoRepository pedidoRepo;
	@Autowired
	private ProdutoRepository prodRepo;
	
	
	
	public ItemDTO obterMenorPreco (Produto produto, Long quant) {
		FornecedorAPI forn = new FornecedorAPI();
		List<FornecedorResponse> response= forn.getApi(produto.getGtin());
		 
		Double menorPreco = 0.0;
		int indiceJ = 0;	
		FornecedorResponse resAux = new FornecedorResponse();
		menorPreco = response.get(0).getPrecos().get(0).getPreco();
		
		for(int i = 0; i< response.size(); i++){
			for(int j = 0; j < response.get(i).getPrecos().size(); j++) {
				if(response.get(i).getPrecos().get(j).getQuantidade_minima() <= quant && response.get(i).getPrecos().get(j).getPreco() <= menorPreco) {
					menorPreco = response.get(i).getPrecos().get(j).getPreco();
					resAux = response.get(i);
					indiceJ = j;  
				}
			}
		}
		
		if (resAux.getNome() == null) throw new BusinessException("Nenhum fornecedor encontrado para a quantidade solicitada de "+produto.getNome());
					
		return new ItemDTO(produto, quant, resAux.getPrecos().get(indiceJ).getPreco()*quant,
					resAux.getPrecos().get(indiceJ).getPreco(),new Fornecedor(resAux.getNome(), resAux.getCnpj()));		
	}
	
	
		 
	public List<Pedido> obterPedidos(List<Request> request) {
		
		List<ItemDTO> itens  = new ArrayList<ItemDTO>();
		List<Request> req = request.stream().filter(r->r.getQuant()!=0 ).collect(Collectors.toList());
		
		for(Request r : req ) {
			itens.add(obterMenorPreco(r.getProduto(), r.getQuant()));
		}
		
		Set<String> nomeForn = new HashSet<String>();
		for(ItemDTO it: itens) {
			nomeForn.add(it.getFornecedor().getNome());		
		}
		List<String> nf = nomeForn.stream().collect(Collectors.toList());
		List<Pedido> pedidos= new ArrayList<Pedido>();
			   
		for(String x : nf) {  	  
			Fornecedor f = new Fornecedor(); 
			String st = x;
		 
			List<ItemDTO> itns = itens.stream().filter(c->c.getFornecedor().getNome().equals(st)).collect(Collectors.toList());   	
			if(fornRepo.findByNome(itns.get(0).getFornecedor().getNome())==null)
				fornRepo.save(new Fornecedor(itns.get(0).getFornecedor().getNome(),itns.get(0).getFornecedor().getCnpj()));
		 
			f = fornRepo.findByNome(itns.get(0).getFornecedor().getNome());
			List<Item> itm = itns.stream().map(Item::new).collect(Collectors.toList());
			Pedido p = new Pedido();
			p.setFornecedor(f);    
			for(Item it: itm) {
		      p.addItem(it);
		   }
			Pedido pe = pedidoRepo.save(p); 
			pedidos.add(pe);
		  }
		      	
		return pedidos;	 
	}
	
	
	
	public List<Pedido>  obterTodosPedidos() {
		return pedidoRepo.findAll();
	}
	
	public Pedido salva(Pedido pedido) {
		return pedidoRepo.save(pedido);
	}

}
