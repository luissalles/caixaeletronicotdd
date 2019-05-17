package br.gov.serpro.caixaeletronico;

public class MockServicoRemoto implements ServicoRemoto {
	ContaCorrente contaCorrente;
	
	MockServicoRemoto(ContaCorrente contaCorrente){
		this.contaCorrente = contaCorrente;
	}
	
	@Override
	public ContaCorrente recuperarConta() {
		return contaCorrente;
	}

	@Override
	public int persistirConta(String operacao, int valor) {
		if(operacao.equals("SAQUE")) {
			contaCorrente.saldo -= valor;
		}else {
			contaCorrente.saldo += valor;
		}
		return contaCorrente.saldo;
	}

}
