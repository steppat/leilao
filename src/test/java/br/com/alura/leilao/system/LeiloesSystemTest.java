package br.com.alura.leilao.system;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.system.pages.AlterarLeilaoPage;
import br.com.alura.leilao.system.pages.LeiloesPage;
import br.com.alura.leilao.system.pages.LoginPage;
import br.com.alura.leilao.system.pages.NovoLeilaoPage;

public class LeiloesSystemTest extends SystemTestBase{
	
	
	
	private LeiloesPage leiloesPage;


	@BeforeEach
	void setup() {
		LoginPage loginPage = new LoginPage(getDriver());
		leiloesPage = loginPage.realizaLogin();		
	}

	@Test
	public void deveCadastrarUmLeilao() {
		
		NovoLeilaoPage novoLeilaoPage = leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
		
		String nome = "Comodore Amiga";
		double valor = 899.9;
		String data = "04/08/2020";
		
		novoLeilaoPage.preencheForm(nome, valor, data);

		assertTrue(leiloesPage.existe(nome, valor, data));
	}
	
	
	@Test
	public void deveEditarUmLeilao() {
		
		AlterarLeilaoPage novoLeilaoPage = leiloesPage.visitaPaginaParaAltearLeilao();
		String nome = "Comodore Amiga";
		double valor = 899.9;
		String data = "04/08/2020";
		
		novoLeilaoPage.preencheForm(nome, valor, data);

		assertTrue(leiloesPage.existe(nome, valor, data));
	}
	
}
