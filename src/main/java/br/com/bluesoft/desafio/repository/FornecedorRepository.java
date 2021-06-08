package br.com.bluesoft.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bluesoft.desafio.model.Fornecedor;
@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
	Fornecedor findByNome(String nome);
}
