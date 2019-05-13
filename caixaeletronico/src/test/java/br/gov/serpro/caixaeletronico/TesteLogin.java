package br.gov.serpro.caixaeletronico;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteLogin {

	@Test
	public void realizarLoginComSucesso() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardwareLoginComSucesso());
		assertEquals("Usuário Autenticado", caixaEletronico.logar());
	}

	@Test
	public void loginInválido() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardwareLoginComSucesso());
		assertEquals("Não foi possível autenticar usuário", caixaEletronico.logar());
	}
}
