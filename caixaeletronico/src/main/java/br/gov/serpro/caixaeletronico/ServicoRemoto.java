package br.gov.serpro.caixaeletronico;

public interface ServicoRemoto {
	ContaCorrente recuperarConta();
	int persistirConta(String operacao, int valor);
}
