package br.gov.serpro.caixaeletronico;

public interface ServicoRemoto {
	int recuperarConta();
	int recuperarSaldo();
	void persistirConta();
}
