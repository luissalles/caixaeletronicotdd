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
	public void persistirConta() {
		// TODO Auto-generated method stub
		
	}

}
