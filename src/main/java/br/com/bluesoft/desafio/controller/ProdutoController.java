package br.com.bluesoft.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Produto;
import br.com.bluesoft.desafio.model.Request;
import br.com.bluesoft.desafio.repository.ProdutoRepository;
import br.com.bluesoft.desafio.service.PedidoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	
    private ProdutoRepository produtoRepository;
    private PedidoService pedidoService;
    
    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository, PedidoService pedidoService) {
        this.produtoRepository = produtoRepository;
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public Iterable<Produto> findAll() {
        return produtoRepository.findAll();
    }
    
    @GetMapping("id/{id}")
    public Produto findById (@PathVariable String id) {
    	return produtoRepository.findByGtin(id);
    }
    
    @GetMapping("pedidos")
    public ResponseEntity<List<Pedido>> obtenPedidos(@RequestBody List<Request> request){
    	List<Pedido> pedidos =  pedidoService.obterPedidos(request);
    	return ResponseEntity.ok(pedidos);
    }
    
    @GetMapping("todosPedidos")
    public ResponseEntity<List<Pedido>> obterTodosPedidos(){
    	List<Pedido> pedidos =  pedidoService.obterTodosPedidos();
    	return ResponseEntity.ok(pedidos);
    }
   
}
