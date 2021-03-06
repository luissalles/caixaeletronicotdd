package br.gov.serpro.caixaeletronico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	
	@Test(expected=FalhaDeHardwareException.class)
	public void hardwareFalhaAoPegarNumeroCartao() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardwareFalha(),  new MockServicoRemoto(contaCorrente));
		caixaEletronico.logar();
	}
	
	@Test
	public void consultarSaldoDe100Reais() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardwareLoginComSucesso(),  new MockServicoRemoto(contaCorrente));
		assertEquals("O saldo é R$100", caixaEletronico.saldo());
	}

	@Test
	public void saqueComSucesso() {
		MockHardwareLoginComSucesso mockHardware = new MockHardwareLoginComSucesso();
		CaixaEletronico caixaEletronico = new CaixaEletronico(mockHardware,  new MockServicoRemoto(contaCorrente));
		assertEquals("Retire seu dinheiro", caixaEletronico.sacar(50));
		assertEquals("O saldo é R$50", caixaEletronico.saldo());
		assertTrue(mockHardware.passouPeloHardware);
	}

	@Test(expected=FalhaDeHardwareException.class)
	public void saqueComFalhaNaEntregaDoDinheiro() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardwareFalha(),  new MockServicoRemoto(contaCorrente));
		caixaEletronico.sacar(10);
	}

	@Test
	public void saqueComSaldoInsuficente() {
		MockHardwareLoginComSucesso mockHardware = new MockHardwareLoginComSucesso();
		CaixaEletronico caixaEletronico = new CaixaEletronico(mockHardware,  new MockServicoRemoto(contaCorrente));
		assertEquals("Saldo Insuficiente", caixaEletronico.sacar(120));
		assertFalse(mockHardware.passouPeloHardware);
	}

	@Test
	public void depositoComSucesso() {
		MockHardwareLoginComSucesso mockHardware = new MockHardwareLoginComSucesso();
		CaixaEletronico caixaEletronico = new CaixaEletronico(mockHardware,  new MockServicoRemoto(contaCorrente));
		assertEquals("Depósito recebido com sucesso", caixaEletronico.depositar(50));
		assertEquals("O saldo é R$150", caixaEletronico.saldo());
		assertTrue(mockHardware.passouPeloHardware);
	}

	@Test(expected=FalhaDeHardwareException.class)
	public void depositoComFalhaNoHardware() {
		CaixaEletronico caixaEletronico = new CaixaEletronico(new MockHardwareFalha(),  new MockServicoRemoto(contaCorrente));
		caixaEletronico.depositar(50);
	}
}
