package br.com.bluesoft.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Produto;
import br.com.bluesoft.desafio.model.Request;
import br.com.bluesoft.desafio.repository.ProdutoRepository;
import br.com.bluesoft.desafio.service.PedidoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/produtos")
public class PedidoController {

	
    private ProdutoRepository produtoRepository;
    private PedidoService pedidoService;
    
    @Autowired
    public PedidoController(ProdutoRepository produtoRepository, PedidoService pedidoService) {
        this.produtoRepository = produtoRepository;
        this.pedidoService = pedidoService;
    }

    @ApiOperation(value = "Retorna todos os produtos")
    @GetMapping
    public Iterable<Produto> findAll() {
        return produtoRepository.findAll();
    }
    
    @ApiOperation(value = "Retorna produto pelo id")
    @GetMapping("id/{id}")
    public ResponseEntity<Produto> findById (@PathVariable String id) {
    	Produto produto =  produtoRepository.findByGtin(id);
    	return ResponseEntity.ok(produto);
    }
    
    
    @ApiOperation(value = "Dado uma lista de produtos e quantidades, Retorna os produtos mais baratos "
    		+ "em uma lista de Pedidos por fornecedores")
    @PostMapping("pedidos")
    public ResponseEntity<List<Pedido>> obtenPedidos(@RequestBody List<Request> request){
    	List<Pedido> pedidos =  pedidoService.obterPedidos(request);
    	return ResponseEntity.ok(pedidos);
    }
    
    @ApiOperation(value = "Retorna todos os pedidos")
    @GetMapping("todosPedidos")
    public ResponseEntity<List<Pedido>> obterTodosPedidos(){
    	List<Pedido> pedidos =  pedidoService.obterTodosPedidos();
    	return ResponseEntity.ok(pedidos);
    }
   
}
