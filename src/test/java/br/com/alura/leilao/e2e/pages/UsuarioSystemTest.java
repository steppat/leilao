package br.com.alura.leilao.e2e.pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuarioSystemTest {

	private WebDriver driver;
    private UsuariosPage usuarioPage;
	private LoginPage loginPage;

    @BeforeEach
    public void inicializa() {
        this.driver = new FirefoxDriver();
        this.loginPage = new LoginPage(driver);
        this.usuarioPage = new UsuariosPage(driver);
    }

    @Test
    public void deveAdicionarUmUsuario() {

        usuarioPage.visita();
        usuarioPage.novo()
        .cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");

        assertTrue(usuarioPage.existeNaListagem(
                "Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));

    }

    @AfterEach
    public void encerra() {
        driver.close();
    }
}
