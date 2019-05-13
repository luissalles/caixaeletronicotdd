package br.gov.serpro.caixaeletronico;

public class CaixaEletronico {
	Hardware hardware;

	public CaixaEletronico(Hardware hardware) {
		this.hardware = hardware;
	}

	public String logar() {
		if(hardware != null) {
			return "Usuário Autenticado";
		}else {
			return "Não foi possível autenticar usuário";
		}
	}

}
