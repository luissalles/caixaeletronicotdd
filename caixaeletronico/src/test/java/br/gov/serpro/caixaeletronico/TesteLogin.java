package br.gov.serpro.caixaeletronico;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteLogin {

	@Test
	public void realizarLoginComSucesso() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardwareLoginComSucesso());
		assertEquals("Usuário Autenticado", caixaEletronico.logar());
	}

	@Test(expected=ContaNaoEncontradaException.class)
	public void loginInválido() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardwareLoginInvalido());
		caixaEletronico.logar();
	}
}
