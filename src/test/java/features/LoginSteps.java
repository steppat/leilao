package features;

import org.junit.Assert;

import br.com.alura.leilao.system.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {
	
	private PageFactory paginas;
	private LoginPage login;
	
	
	@Before
	public void setup() {
		paginas = new PageFactory();
	}
	
	@Dado("o usuario valido")
	public void o_usuario_valido() {
		login = paginas.setup();
	}

	@Quando("realiza login")
	public void realiza_login() {
		this.login.realizaLogin();

	    
	}
	@Entao("eh redirecionado a pagina de login")
	public void eh_redirecionado_a_pagina_de_login() {
		Assert.assertTrue(this.login.estaNaPaginaDeLeiloes());
	}
	
	@After
	public void tearDown() {
		paginas.cleanUp();
	}
}
