package br.gov.serpro.caixaeletronico;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteCaixaEletronico {

	@Test
	public void realizarLoginComSucesso() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardwareLoginComSucesso(), new MockServicoRemoto());
		assertEquals("Usuário Autenticado", caixaEletronico.logar());
	}

	@Test(expected=ContaNaoEncontradaException.class)
	public void loginInválido() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardwareLoginInvalido(),  new MockServicoRemoto());
		caixaEletronico.logar();
	}
	
	@Test
	public void consultarSaldoDe100Reais() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardwareLoginComSucesso(),  new MockServicoRemoto());
		assertEquals("O saldo é R$100", caixaEletronico.saldo());
	}
}
