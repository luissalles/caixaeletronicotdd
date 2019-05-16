package br.gov.serpro.caixaeletronico;

public class MockHardwareFalha implements Hardware {

	@Override
	public String pegarNumeroDaContaCartao() {
		throw new FalhaDeHardwareException();
	}

	@Override
	public void entregarDinheiro() {
		throw new FalhaDeHardwareException();
	}

	@Override
	public void lerEnvelope() {
		throw new FalhaDeHardwareException();
	}

}
