package br.com.alura.leilao.e2e;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.NovoLeilaoPage;

public class LeiloesTest extends E2ETest{

	private LeiloesPage leiloesPage;

	@BeforeEach
	public void inicializa() {
		LoginPage loginPage = new LoginPage(getDriver());
		this.leiloesPage = loginPage.realizaLogin();
	}
	
	@Test
	public void deveCadastrarUmLeilao() {

		NovoLeilaoPage novoLeilao = leiloesPage.novo();
		novoLeilao.preenche("Geladeira", 123, "Paulo Henrique", true);

		assertTrue(leiloesPage.existe("Geladeira", 123, "Paulo Henrique", true));

	}
	
}
