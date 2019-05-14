package br.gov.serpro.caixaeletronico;

public interface ServicoRemoto {
	int recuperarConta();
	int recuperarSaldo();
	int persistirConta(String operacao, int valor);
}
