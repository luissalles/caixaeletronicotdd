package br.gov.serpro.caixaeletronico;

public class MockHardwareLoginComSucesso implements Hardware {

	@Override
	public String pegarNumeroDaContaCartao() {
		return "000011";
	}

}
