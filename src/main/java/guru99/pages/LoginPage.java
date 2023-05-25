package guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	WebDriver driver;
	By userInput = By.name("uid");
	By passwordInput = By.name("password");
	By loginButton = By.xpath("//input[@value='LOGIN']");

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public ManagerHomePage logIn(String baseURL,String userName,String password)
	{
		navigateToURL(baseURL);
		writeText(userInput,userName);
		writeText(passwordInput,password);
		clickOnButton(loginButton);
		return new ManagerHomePage(driver);
	}
}
