package br.com.alura.leilao.e2e.acceptance.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.alura.leilao.e2e.pages.LoginPage;

public class WebAppUtil {

	private WebDriver driver;

	public WebAppUtil() {
//		http://chromedriver.storage.googleapis.com/index.html?path=84.0.4147.30/
		System.setProperty("webdriver.chrome.driver", "/Users/nico/Documents/dev/workspaces/bdd/leilao/drivers/chromedriver");
		this.driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
//		https://github.com/mozilla/geckodriver/releases
//		System.setProperty("webdriver.gecko.driver", "/Users/nico/Documents/dev/workspaces/bdd/leilao/drivers/geckodriver");
//		this.driver = new FirefoxDriver();
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
		driver.close();
	}

}
