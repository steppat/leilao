package br.com.alura.leilao.e2e.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage {

	private WebDriver driver;

	private static String PAGE_URL = "http://localhost:8080/leiloes";
	
	public LeiloesPage(WebDriver driver) {
		this.driver = driver;
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void visita() {
		driver.get(PAGE_URL);
	}

	public NovoLeilaoPage novo() {
		// clica no link de novo leilao
		driver.findElement(By.linkText("Novo Leilão")).click();
		// retorna a classe que representa a nova pagina
		return new NovoLeilaoPage(driver);
	}

	public boolean existe(String produto, double valor, String usuario,
			boolean usado) {

		return driver.getPageSource().contains(produto) && 
				driver.getPageSource().contains(String.valueOf(valor)) &&
				driver.getPageSource().contains(usado ? "Sim" : "Não");

	}
	
	public DetalhesDoLeilaoPage detalhes(int posicao) {
		List<WebElement> elementos = driver.findElements(By.linkText("Exibir"));
		elementos.get(posicao - 1).click();

		return new DetalhesDoLeilaoPage(driver);
	}

}
