package br.com.alura.leilao.e2e;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.alura.leilao.e2e.pages.DetalhesDoLeilaoPage;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.UsuariosPage;

public class LanceSystemTest {
	
	private WebDriver driver;
    private LeiloesPage leiloes;

    @BeforeEach
    public void inicializa() {
        
    	this.driver = new FirefoxDriver();
        leiloes = new LeiloesPage(driver);
        
        driver.get("http://localhost:8080/apenas-teste/limpa");
        
        UsuariosPage usuarios = new UsuariosPage(driver);
        usuarios.visita();
//        usuarios.novo().cadastra("nome", "email");
//        usuarios.novo().cadastra("nome2", "email2");
        
        LeiloesPage leiloes = new LeiloesPage(driver);
        leiloes.novo().preenche("obj", 0, "nome", false);
    }

    @Test
    public void deveFazerUmLance() {

        DetalhesDoLeilaoPage lances = leiloes.detalhes(1);

        lances.lance("José Alberto", 150);

        assertTrue(lances.existeLance("José Alberto", 150));
    }
}
