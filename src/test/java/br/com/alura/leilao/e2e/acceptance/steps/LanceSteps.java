package br.com.alura.leilao.e2e.acceptance.steps;

import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LanceSteps {

	private WebAppUtil webApp;
	private LoginPage loginPage;
	private LeiloesPage leilaoPage; 
	
	@Before
	public void setup() {
		this.webApp = new WebAppUtil();
		this.webApp.seed();
	}
	
	@After
	public void tearDown() {
		webApp.cleanUp();
	}
	
	
	
	@Dado("o usuario {string} logado")
	public void o_usuario_e_um_do_usuario(String nomeUsuario) {
		this.loginPage = this.webApp.getLoginPage();
		leilaoPage = this.loginPage.realizaLoginCom(nomeUsuario, "pass");
	}

	@Quando("quando ele dar um lance valido no leileo do {string}")
	public void quando_dar_um_lance_valido(String donoDoLeilao) {
		this.leilaoPage.visitaPaginaParaDarLanceNoLeilaoDo(donoDoLeilao);
	}

	@Entao("o lance é aceito")
	public void o_lance_é_aceito_pelo_leilao() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Dado("o usuario {string} que criou um {string}")
	public void o_usuario_que_criou_um(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Quando("navega para pagina de leiloes")
	public void navega_para_pagina_de_leiloes() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Entao("ele não dar um lance no {string}")
	public void ele_não_dar_um_lance_no(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
