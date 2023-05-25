package guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerHomePage extends BasePage {

	WebDriver driver;
	By managerId = By.xpath("//tr[@align='center']/td");
	
	public ManagerHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String getManagerId() {
		return getText(managerId);
	}

}
