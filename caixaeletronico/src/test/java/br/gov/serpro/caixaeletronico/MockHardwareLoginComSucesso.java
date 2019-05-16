package br.gov.serpro.caixaeletronico;

public class MockHardwareLoginComSucesso implements Hardware {

	@Override
	public String pegarNumeroDaContaCartao() {
		return "000011";
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
