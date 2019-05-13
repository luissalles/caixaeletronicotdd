package br.gov.serpro.caixaeletronico;


public class ContaNaoEncontradaException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String erro;
	
	ContaNaoEncontradaException(String erro, String message){
		super(message);
		this.erro = erro;
	}
	
}
