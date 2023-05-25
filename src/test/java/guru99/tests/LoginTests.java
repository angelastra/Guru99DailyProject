package guru99.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import guru99.pages.LoginPage;
import guru99.pages.ManagerHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTests {

	static WebDriver driver;
	static String baseURL;
	static String userName;
	static String password;
	public static void main(String [] args) throws IOException
	{
		
		driver = initializeDriver();
		LoginPage lp = new LoginPage(driver);
		ManagerHomePage mhp = lp.logIn(baseURL,userName,password);
		String managerId = mhp.getManagerId();
		org.junit.Assert.assertTrue(managerId.contains(userName));

	}
	
	public static WebDriver initializeDriver() throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/guru99/resources/global.properties");
		prop.load(fis);
		userName = prop.getProperty("userName");
		password = prop.getProperty("password");
		baseURL = prop.getProperty("baseURL");
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
