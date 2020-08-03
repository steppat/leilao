package br.com.alura.leilao.e2e;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.alura.leilao.controller.BancoController;

@SpringBootTest
//@RunWith(SpringRunner.class) 
class LeilaoApplicationTests {
	
	@Test
	void contextLoads() {
	}	

	@Autowired
	BancoController controller;
	
	private WebDriver webDriver;

	
//	http://chromedriver.storage.googleapis.com/index.html?path=84.0.4147.30/
//	https://github.com/mozilla/geckodriver/releases
    @BeforeEach
    public void setup() {
    	System.out.println("running @Before");
    	System.setProperty("webdriver.chrome.driver", "/Users/nico/Documents/dev/workspaces-bdd/leilao/drivers/chromedriver");
    	System.setProperty("webdriver.gecko.driver", "/Users/nico/Documents/dev/workspaces-bdd/leilao/drivers/geckodriver");

//    	webDriver = new FirefoxDriver();
    	webDriver = new ChromeDriver();
    }
	
	
    @Test
    public void getSearchPage() {
    	this.webDriver.get("https://www.google.com");
        WebElement element = this.webDriver.findElement(By.name("q"));
        assertNotNull(element);
    }
    
    
    @AfterEach
    public void tearDown() {
    	this.webDriver.quit();
    }
    

}
