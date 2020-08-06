package br.com.alura.leilao.e2e.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SystemTestBase {

	private static WebDriver driver;

//  Documentação
//	http://chromedriver.storage.googleapis.com/index.html?path=84.0.4147.30/
//	https://github.com/mozilla/geckodriver/releases
	
	protected WebDriver getDriver() {
		return driver;
	}

	@BeforeAll
	public static void setUpAll() {
		driver = initChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@BeforeEach
	public void setUp() {
        driver.get("http://localhost:8080/banco/seed");
	}

	private static WebDriver initChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/nico/Documents/dev/workspaces/bdd/leilao/drivers/chromedriver");
		return new ChromeDriver();
	}
	
	@SuppressWarnings("unused")
	private static WebDriver initFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "/Users/nico/Documents/dev/workspaces/bdd/leilao/drivers/geckodriver");
		return new FirefoxDriver();
	}

	@AfterEach
	public void cleanUp() {
        driver.get("http://localhost:8080/banco/limpa");
		driver.manage().deleteAllCookies();
	}

	@AfterAll
	public static void tearDown() {
		driver.close();
	}

}
