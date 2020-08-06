package br.com.alura.leilao.e2e.acceptance.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.selenium.WebDriverFactory;

public class WebAppUtil {

	private WebDriver driver;

	public WebAppUtil() {
		this.driver = new WebDriverFactory().createWebDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	protected WebDriver getDriver() {
		return driver;
	}

	public LoginPage getLoginPage() {
		return new LoginPage(driver);
	}

	public void seed() {
		driver.get("http://localhost:8080/banco/seed");
	}

	public void cleanUp() {
		driver.get("http://localhost:8080/banco/limpa");
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
