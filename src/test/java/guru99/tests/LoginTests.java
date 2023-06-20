package guru99.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import guru99.pages.LoginPage;
import guru99.pages.ManagerHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTests {

	static WebDriver driver;
	static String baseURL;
	static String userName;
	static String password;
	static String driverInstancePath;
	public static void main(String [] args) throws IOException
	{
		
		driver = initializeDriver();
		LoginPage lp = new LoginPage(driver);
		ManagerHomePage mhp = lp.logIn(baseURL,userName,password);
		String managerId = mhp.getManagerId();
		org.junit.Assert.assertTrue(managerId.contains(userName));
		driver.quit();
	}
	
	public static WebDriver initializeDriver() throws IOException 
	{
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("guru99DailyProject");
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(myprofile);
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/guru99/resources/global.properties");
		prop.load(fis);
		userName = prop.getProperty("userName");
		password = prop.getProperty("password");
		baseURL = prop.getProperty("baseURL");
		driverInstancePath = prop.getProperty("firefoxLocation");
    	//System.setProperty("webdriver.gecko.driver",driverInstancePath);
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
