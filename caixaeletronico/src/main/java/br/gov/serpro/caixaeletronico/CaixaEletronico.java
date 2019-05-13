package br.gov.serpro.caixaeletronico;

public class CaixaEletronico {
	Hardware hardware;

	public CaixaEletronico(Hardware hardware, ServicoRemoto servicoRemoto) {
		this.hardware = hardware;
	}

	public String logar() {
		if(hardware.pegarNumeroDaContaCartao() != null) {
			return "Usuário Autenticado";
		}else {
			return "Não foi possível autenticar usuário";
		}
	}

	public String saldo() {
		ContaCorrente contaCorrente = new ContaCorrente(11, 100);
		return "O saldo é R$" + contaCorrente.retornaSaldo();
	}

}
