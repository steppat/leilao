package br.com.alura.leilao.system;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.system.pages.DetalhesDoLeilaoPage;
import br.com.alura.leilao.system.pages.LeiloesPage;
import br.com.alura.leilao.system.pages.LoginPage;

public class LanceSystemTest extends SystemTestBase{
	
	private LeiloesPage leiloesPage;

	@BeforeEach
	void setup() {
		LoginPage loginPage = new LoginPage(getDriver());
		this.leiloesPage = loginPage.realizaLogin();
	}
	
    @Test
    public void deveAceitarUmLance() {
		LoginPage loginPage = new LoginPage(getDriver());
		this.leiloesPage = loginPage.realizaLogin();
		DetalhesDoLeilaoPage detalhesLeilaoPage = leiloesPage.visitaLeilaoPaginaParaDarLance();
		
		detalhesLeilaoPage.darLance("150");
		
        assertTrue(detalhesLeilaoPage.existeLance("150"));
    }
    
    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		DetalhesDoLeilaoPage detalhesLeilaoPage = leiloesPage.visitaLeilaoPaginaParaDarLance();
		detalhesLeilaoPage.darLance("150");
		detalhesLeilaoPage.darLance("160");

        assertTrue(detalhesLeilaoPage.temApenasUmLance());
    }
    
    @Test
    public void naoDeveAceitarDoisLancesComOMesmoValor() {
		DetalhesDoLeilaoPage detalhesLeilaoPage = leiloesPage.visitaLeilaoPaginaParaDarLance();
		detalhesLeilaoPage.darLance("150");
		detalhesLeilaoPage.darLance("150");

        assertTrue(detalhesLeilaoPage.temApenasUmLance());
    }
}
