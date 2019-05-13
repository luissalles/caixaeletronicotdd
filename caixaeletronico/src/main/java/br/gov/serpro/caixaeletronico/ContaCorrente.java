package br.gov.serpro.caixaeletronico;

public class ContaCorrente {
	int numero;
	int saldo;
	
	ContaCorrente(int numero, int saldo){
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public int retornaSaldo() {
		return saldo;
	}
}
