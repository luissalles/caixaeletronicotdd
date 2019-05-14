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
		return "O saldo é R$" + servicoRemoto.recuperarSaldo();
	}

	public String sacar() {
		return "Retire seu dinheiro";
	}

}
