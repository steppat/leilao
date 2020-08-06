package br.com.alura.leilao.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;
	
	private static String URL_LOGIN_PAGE = "http://localhost:8080/login";


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LeiloesPage realizaLoginCom(String nome, String senha) {
    	driver.get(URL_LOGIN_PAGE);

        WebElement txtNome = driver.findElement(By.name("username"));
        WebElement txtEmail = driver.findElement(By.name("password"));

        txtNome.sendKeys(nome);
        txtEmail.sendKeys(senha);

        txtNome.submit();
                
        return new LeiloesPage(driver);
    }
    
    public LeiloesPage realizaLogin() {
    	return realizaLoginCom("fulano", "pass");
    }

	public boolean estaNaPaginaDeLeiloes() {
		return this.driver.getCurrentUrl().endsWith("/leiloes");
	}

	public boolean estaNaPaginaDeLoginComErro() {
		return this.driver.getCurrentUrl().endsWith("/login?error");
	}
}
