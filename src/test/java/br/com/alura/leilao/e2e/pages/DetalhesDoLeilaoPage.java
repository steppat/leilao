package br.com.alura.leilao.e2e.pages;

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
		
		driver.getPageSource();
		
		WebElement txtValor = driver.findElement(By.id("valor"));
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(txtValor));
		
		txtValor.clear();
		txtValor.sendKeys(valor);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btnDarLance")));
		
		driver.findElement(By.id("btnDarLance")).click();
	}

	public boolean existeLance(String valor) {
		By locator = By.xpath("//table[@id='lancesDados']//td[contains(.,'" + valor + "')]");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
		WebElement td = driver.findElement(locator);
		String result = td.getText();
		return result != null;
	}
	
	public boolean temApenasUmLance() {
		List<WebElement> trs = driver.findElements(By.tagName("tr"));
		return trs.size() == 2;

	}


}