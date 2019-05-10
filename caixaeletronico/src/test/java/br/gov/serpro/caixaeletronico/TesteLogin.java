package br.gov.serpro.caixaeletronico;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteLogin {

	@Test
	public void realizarLoginComSucesso() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardware());
		assertEquals("Usuário Autenticado", caixaEletronico.logar());
	}
}
