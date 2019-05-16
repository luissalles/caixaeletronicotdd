package br.gov.serpro.caixaeletronico;

public interface Hardware {
	String pegarNumeroDaContaCartao();
	void entregarDinheiro();
	void lerEnvelope();
}
