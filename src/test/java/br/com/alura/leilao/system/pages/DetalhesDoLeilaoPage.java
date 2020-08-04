package br.com.alura.leilao.system.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DetalhesDoLeilaoPage {

	private WebDriver driver;

	public DetalhesDoLeilaoPage(WebDriver driver) {
		this.driver = driver;
	}

	public void darLance(String valor) {
		WebElement txtValor = driver.findElement(By.name("valor"));
		txtValor.sendKeys(valor);
		driver.findElement(By.id("btnDarLance")).click();
	}

	public boolean existeLance(String valor) {
		return new WebDriverWait(driver, 5)
				.until(ExpectedConditions
						.textToBePresentInElementLocated(By.id("lancesDados"), valor ));
	}
	
	public boolean temApenasUmLance() {
		List<WebElement> trs = driver.findElements(By.tagName("tr"));
		return trs.size() == 2;

	}


}