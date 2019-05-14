package br.gov.serpro.caixaeletronico;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TesteCaixaEletronico {
	ContaCorrente contaCorrente;
	
	@Before
	public void inicializarConta() {
		contaCorrente = new ContaCorrente(11,100);
	}
	
	@Test
	public void realizarLoginComSucesso() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardwareLoginComSucesso(), new MockServicoRemoto(contaCorrente));
		assertEquals("Usuário Autenticado", caixaEletronico.logar());
	}

	@Test(expected=ContaNaoEncontradaException.class)
	public void loginInválido() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardwareLoginInvalido(),  new MockServicoRemoto(contaCorrente));
		caixaEletronico.logar();
	}
	
	@Test
	public void consultarSaldoDe100Reais() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardwareLoginComSucesso(),  new MockServicoRemoto(contaCorrente));
		assertEquals("O saldo é R$100", caixaEletronico.saldo());
	}

	@Test
	public void saqueComSucesso() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardwareLoginComSucesso(),  new MockServicoRemoto(contaCorrente));
		assertEquals("Retire seu dinheiro", caixaEletronico.sacar());
	}
}
