package br.gov.serpro.caixaeletronico;

public class MockHardwareLoginInvalido implements Hardware {

	@Override
	public String pegarNumeroDaContaCartao() {
		throw new ContaNaoEncontradaException("999", "Não foi possível autenticar o usuário");
	}

}
