package br.com.bluesoft.desafio.exception;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = -6030733006897912418L;
	
	public BusinessException() {
		super("Nenhum fornecedor encontrado para a quantidade solicitada");
	}
	
	public BusinessException(String message) {
		super(message);
	}
}