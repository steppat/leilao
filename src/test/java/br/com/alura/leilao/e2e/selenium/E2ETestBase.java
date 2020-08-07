package br.com.alura.leilao.e2e.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.alura.leilao.e2e.pages.WebDriverFactory;

public class E2ETestBase {

	private static WebDriver driver;

//  Documentação
//	http://chromedriver.storage.googleapis.com/index.html
//	https://github.com/mozilla/geckodriver/releases
	
	protected WebDriver getDriver() {
		return driver;
	}

	@BeforeAll
	public static void setUpAll() {
		driver = new WebDriverFactory().createWebDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@BeforeEach
	public void setUp() {
        driver.get("http://localhost:8080/banco/seed");
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
