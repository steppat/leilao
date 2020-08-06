package br.com.alura.leilao.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NovoLeilaoPage {

    private WebDriver driver;

    public NovoLeilaoPage(WebDriver driver) {
        this.driver = driver;
    }

    public LeiloesPage preencheForm(String nome, String valor, String data) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("dataAbertura")));

        WebElement txtNome = driver.findElement(By.name("nome"));
        WebElement txtValor = driver.findElement(By.name("valorInicial"));
        WebElement txtData = driver.findElement(By.name("dataAbertura"));

        txtNome.sendKeys(nome);
        txtValor.sendKeys(valor);
        txtData.sendKeys(data);

        txtNome.submit();
        
        return new LeiloesPage(driver);
    }

}