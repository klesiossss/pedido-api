package br.com.bluesoft.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bluesoft.desafio.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
