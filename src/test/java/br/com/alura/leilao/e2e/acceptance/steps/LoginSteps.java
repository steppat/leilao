package br.com.alura.leilao.e2e.acceptance.steps;

import org.junit.Assert;

import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {
	
	private Browser webApp;
	private LoginPage loginPage;
	
	
//	@Before
	public void setup() {
		this.webApp = new Browser();
		this.webApp.seed();
	}
	
//	@After
	public void tearDown() {
		webApp.clean();
	}
	
	//----------------------------------------
	
	@Dado("o usuario valido")
	public void o_usuario_valido() {
		this.setup();
		this.loginPage = webApp.getLoginPage();
	}

	@Quando("realiza login")
	public void realiza_login() {
		this.loginPage.realizaLoginComoFulano();
	}
	
	@Entao("é redirecionado para a pagina de leiloes")
	public void é_redirecionado_a_pagina_de_leiloes() {
		Assert.assertTrue(this.loginPage.estaNaPaginaDeLeiloes());
		this.tearDown();
	}

	
	//------------------------------
	
	@Dado("o usuario invalido")
	public void o_usuario_invalido() {
		this.setup();
		loginPage = webApp.getLoginPage();
	}

	@Quando("tenta se logar")
	public void tenta_se_logar() {
		this.loginPage.realizaLoginComo("usuario", "semsenha");
	}
	@Entao("continua na página de login")
	public void continua_na_página_de_login() {
	    Assert.assertTrue(this.loginPage.estaNaPaginaDeLoginComErro());
	    this.tearDown();
	}
	
}
