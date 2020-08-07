package br.com.alura.leilao.e2e.acceptance.steps;

import org.junit.Assert;

import br.com.alura.leilao.e2e.pages.DetalhesDoLeilaoPage;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.NovoLeilaoPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LanceSteps {

	private Browser webApp;
	private LoginPage loginPage;
	private LeiloesPage leiloesPage;
	private DetalhesDoLeilaoPage detalhesPage; 
	
//	@Before
	public void setup() {
		this.webApp = new Browser();
		this.webApp.seed();
	}
	
//	@After
	public void tearDown() {
		webApp.clean();
	}
	
	@Dado("o usuario {string} logado")
	public void o_usuario_e_um_do_usuario(String nomeUsuario) throws Exception {
		this.setup();
		this.loginPage = this.webApp.getLoginPage();
		leiloesPage = this.loginPage.realizaLoginComo(nomeUsuario, "pass");
		Thread.sleep(2000);
	}

	@Quando("ele dá um lance valido no leilao do {string}")
	public void quando_dar_um_lance_valido(String donoDoLeilao) throws Exception {
		this.detalhesPage = this.leiloesPage.visitaPaginaDoLeilaoDo(donoDoLeilao);
		this.detalhesPage.darLance("150");
	}

	@Entao("o lance é aceito")
	public void o_lance_é_aceito_pelo_leilao() {
		Assert.assertTrue(this.detalhesPage.existeLance("150"));
		this.tearDown();
	}
	
	//------------------------------------------
	
	@Dado("o usuario {string} que criou um {string}")
	public void o_usuario_que_criou_um(String dono, String nomeLeilao) {
		this.setup();
		this.leiloesPage = this.webApp.getLoginPage().realizaLoginComo(dono, "pass");
		NovoLeilaoPage novoLeilaoPage = this.leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
		this.leiloesPage = novoLeilaoPage.preencheForm(nomeLeilao, "100", "01/12/2019");
	}

	@Quando("ele navega para pagina de leiloes")
	public void navega_para_pagina_de_leiloes() {
	}

	@Entao("o {string} não pode dar um lance no leilao criado")
	public void ele_não_dar_um_lance_no(String dono) {
		Assert.assertTrue(this.leiloesPage.naoPodeDarLanceNoLeilaoCriado(dono));
		this.tearDown();
	}

}
