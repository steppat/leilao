package br.com.alura.leilao.system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NovoLeilaoPage {

    private WebDriver driver;

    public NovoLeilaoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preencheForm(String nome, double valor, String data) {

        WebElement txtNome = driver.findElement(By.name("nome"));
        WebElement txtValor = driver.findElement(By.name("valorInicial"));
        WebElement txtData = driver.findElement(By.name("dataAbertura"));

        txtNome.sendKeys(nome);
        txtValor.sendKeys(String.valueOf(valor));
        txtData.sendKeys(data);

        txtNome.submit();
    }

}