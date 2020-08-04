package br.com.alura.leilao.system.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

	public boolean existe(String nomeProduto, double valor, String usuario) {
		return driver.getCurrentUrl().endsWith("/leiloes") && driver.getPageSource().contains(nomeProduto) && 
				driver.getPageSource().contains(String.valueOf(valor));
	}

	public NovoLeilaoPage visitaPaginaParaCriarUmNovoLeilao() {
		driver.findElement(By.linkText("Novo Leilão")).click();
		return new NovoLeilaoPage(driver);
	}

	public DetalhesDoLeilaoPage visitaLeilaoPaginaParaDarLance() {
		driver.findElement(By.linkText("dar lance")).click();
		return new DetalhesDoLeilaoPage(driver);
	}

	public AlterarLeilaoPage visitaPaginaParaAltearLeilao() {
		driver.findElement(By.linkText("editar")).click();
		return new AlterarLeilaoPage(driver);
	}
}
