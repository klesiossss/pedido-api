package br.com.bluesoft.desafio.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorResponse {
	private String nome;
	private String cnpj;
	private List<Preco> precos;
}
