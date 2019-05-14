package br.gov.serpro.caixaeletronico;

public class MockServicoRemoto implements ServicoRemoto {
	ContaCorrente contaCorrente;
	
	MockServicoRemoto(ContaCorrente contaCorrente){
		this.contaCorrente = contaCorrente;
	}
	
	@Override
	public int recuperarConta() {
		return contaCorrente.numero;
	}

	@Override
	public int recuperarSaldo() {
		return contaCorrente.saldo;
	}

	@Override
	public int persistirConta(String operacao, int valor) {
		if(operacao.equals("SAQUE")) {
			contaCorrente.saldo -= valor;
		}
		return this.recuperarSaldo();
	}

}
