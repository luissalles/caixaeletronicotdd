package br.gov.serpro.caixaeletronico;

public class CaixaEletronico {
	Hardware hardware;
	ServicoRemoto servicoRemoto;

	public CaixaEletronico(Hardware hardware, ServicoRemoto servicoRemoto) {
		this.hardware = hardware;
		this.servicoRemoto = servicoRemoto;	
	}

	public String logar() {
		if(hardware.pegarNumeroDaContaCartao() != null) {
			return "Usuário Autenticado";
		}else {
			return "Não foi possível autenticar usuário";
		}
	}

	public String saldo() {
		ContaCorrente contaCorrente = servicoRemoto.recuperarConta();
		return "O saldo é R$" + contaCorrente.retornaSaldo();
	}

	public String sacar(int valor) {
		ContaCorrente contaCorrente = servicoRemoto.recuperarConta();
		if((contaCorrente.retornaSaldo() - valor) < 0) {
			return "Saldo Insuficiente";
		}else {
			servicoRemoto.persistirConta("SAQUE", 50);
			hardware.entregarDinheiro();
			return "Retire seu dinheiro";
		}
	}

	public String depositar(int valor) {
		servicoRemoto.persistirConta("DEPOSITO", 50);
		hardware.lerEnvelope();
		return "Depósito recebido com sucesso";
	}
}
