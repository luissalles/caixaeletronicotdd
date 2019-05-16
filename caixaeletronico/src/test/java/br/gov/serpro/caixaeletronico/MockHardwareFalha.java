package br.gov.serpro.caixaeletronico;

public class MockHardwareFalha implements Hardware {

	@Override
	public String pegarNumeroDaContaCartao() {
		throw new FalhaHardwareException();
	}

	@Override
	public void entregarDinheiro() {
		// TODO Auto-generated method stub

	}

	@Override
	public void lerEnvelope() {
		// TODO Auto-generated method stub

	}

}
