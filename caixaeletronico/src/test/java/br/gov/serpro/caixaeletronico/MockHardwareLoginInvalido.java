package br.gov.serpro.caixaeletronico;

public class MockHardwareLoginInvalido implements Hardware {
	boolean passouPeloHardware = false;

	@Override
	public String pegarNumeroDaContaCartao() {
		throw new ContaNaoEncontradaException("999", "Não foi possível autenticar o usuário");
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
