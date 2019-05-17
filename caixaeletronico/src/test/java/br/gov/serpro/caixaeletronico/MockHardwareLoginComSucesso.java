package br.gov.serpro.caixaeletronico;

public class MockHardwareLoginComSucesso implements Hardware {
	boolean passouPeloHardware = false;
	
	@Override
	public String pegarNumeroDaContaCartao() {
		return "000011";
	}

	@Override
	public void entregarDinheiro() {
		passouPeloHardware = true;
	}

	@Override
	public void lerEnvelope() {
		passouPeloHardware = true;
	}

}
