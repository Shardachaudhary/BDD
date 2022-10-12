package delete.delete;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import delete.delete.commonmethods.BaseClass;
import delete.delete.commonmethods.CommonMethods;

public class LoginPage {
	
By signin = By.id("nav-link-accountList-nav-line-1");
By userEmail = By.id("ap_email");
By contnue = By.id("continue");
By pswd = By.id("ap_password");
By submit = By.id("signInSubmit");

public void loginMethod(WebDriver driver,String user, String pwd) {
	
	String loginText;
	driver.findElement(signin).click();
	CommonMethods.waitForElementToAppear(driver,userEmail);
	driver.findElement(userEmail).sendKeys(user);
	
	CommonMethods.waitForElementToAppear(driver,contnue);
	driver.findElement(contnue).click();
	
	CommonMethods.waitForElementToAppear(driver,pswd);
	driver.findElement(pswd).sendKeys(pwd);
	
	driver.findElement(submit).click();
	
	loginText= driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
	
	if(loginText.contains("naresh")) {
		System.out.println("passed");
	}
		else {
			System.out.println("failed");
		}
	
	
			
	
}
}

