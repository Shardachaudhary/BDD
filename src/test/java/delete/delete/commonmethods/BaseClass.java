package delete.delete.commonmethods;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import dataProvider.ConfigFileReader;
import delete.delete.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver; 
	
	public WebDriver initdriver() throws IOException
	{
		
		//System.setProperty("webdriver.chrome.driver","D:\\Downloads\\chromedriver_win32\\chromedriver.exe");
		String str;
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		 	
		//Login process
		//driver.get("https://www.amazon.com/");
		
		str = ConfigFileReader.fetchConfigData("URL");
		System.out.println(str);
		driver.get(str);		
		return driver;
	}
	@BeforeMethod
	public void launchApplication() throws IOException
	{
		driver = initdriver();
		//LoginPage lp = new LoginPage();
		//lp.loginMethod(driver,ConfigFileReader.fetchConfigData("username"), ConfigFileReader.fetchConfigData("password"));
	}
	
	//@AfterMethod
	public void quitdriver()
	{
		driver.quit();
	}
}
