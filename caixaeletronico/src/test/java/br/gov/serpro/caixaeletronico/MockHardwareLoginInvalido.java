package br.gov.serpro.caixaeletronico;

public class MockHardwareLoginInvalido implements Hardware {

	@Override
	public String pegarNumeroDaContaCartao() {
		throw new ContaNaoEncontradaException("999", "Não foi possível autenticar o usuário");
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
