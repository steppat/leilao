package features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.alura.leilao.system.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class PageFactory {

	private WebDriver driver;

//	http://chromedriver.storage.googleapis.com/index.html?path=84.0.4147.30/
//	https://github.com/mozilla/geckodriver/releases
	public PageFactory() {
		System.setProperty("webdriver.chrome.driver", "/Users/nico/Documents/dev/workspaces/bdd/leilao/drivers/chromedriver");
		this.driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
//		System.setProperty("webdriver.gecko.driver", "/Users/nico/Documents/dev/workspaces/bdd/leilao/drivers/geckodriver");
//		this.driver = new FirefoxDriver();
	}

	
	protected WebDriver getDriver() {
		return driver;
	}
	
	public LoginPage setup() {
        driver.get("http://localhost:8080/banco/seed");
        return new LoginPage(driver);
	}

	
	public void cleanUp() {
        driver.get("http://localhost:8080/banco/limpa");
		driver.manage().deleteAllCookies();
		driver.close();
	}

}
