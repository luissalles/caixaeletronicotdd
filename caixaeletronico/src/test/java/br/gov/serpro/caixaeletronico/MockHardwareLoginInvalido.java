package br.gov.serpro.caixaeletronico;

public class MockHardwareLoginInvalido implements Hardware {

	@Override
	public String pegarNumeroDaContaCartao() {
		return null;
	}

}
