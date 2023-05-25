package guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateToURL(String URL) {
		driver.get(URL);
	}
	
	public void writeText(By locator, String text) {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		driver.findElement(locator).sendKeys(text);
	}
	
	public String getText(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,5);
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator))).getText();
	
	}
	
	public void clickOnButton(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable((locator))).click();
		
	}
	
	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToAppear(WebElement findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisappear(WebElement element) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
}
