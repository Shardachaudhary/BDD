package delete.delete;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import dataProvider.ConfigFileReader;
import delete.delete.commonmethods.BaseClass;
import delete.delete.commonmethods.CommonMethods;

public class Search extends BaseClass{
	public String productName = "Samsung 253";
	@Test
	public void searchitem() throws IOException, InterruptedException 
	{	
		String filePath = ConfigFileReader.fetchConfigData("excelFilePath");
	
		String str = CommonMethods.fetchExcelCellValue(filePath, "data2" , "SearchItems");
			
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(str,Keys.RETURN);		
		addItem(CommonMethods.fetchExcelCellValue(filePath, "data2" , "ItemsToBeAdded"));
		
	}


public void addItem(String itemname) throws InterruptedException {	
//Thread.sleep(5000);	

By products = By.xpath("//*[@class = 'a-size-medium a-color-base a-text-normal']");

CommonMethods.waitForElementToAppear(driver, products);


List<WebElement> prod = driver.findElements(products);

for(int i= 0 ; i<prod.size();i++)
{
	String searchedString; 
	searchedString = prod.get(i).getText();
	if(searchedString.contains(itemname))
	{
		prod.get(i).click();		
	}
	
}

String currentHandle= driver.getWindowHandle();
Set<String> handles=driver.getWindowHandles();
for(String actual: handles) {
if(!actual.equalsIgnoreCase(currentHandle)) {
//Switch to the opened tab
driver.switchTo().window(actual); 
//opening the URL saved.
//driver.get(urlToClick);

By cart = By.id("add-to-cart-button");
CommonMethods.waitForElementToAppear(driver, cart);
driver.findElement(cart).click();

driver.close();

driver.switchTo().window(currentHandle);
System.out.println(currentHandle);
driver.navigate().refresh();


//  //*[@id="p_n_format_browse-bin/13462099031"]/span/a/div/label/i

driver.findElement(By.xpath("//*[@id='p_n_format_browse-bin/13462099031']/span/a/div/label/i")).click();

}}

	}	
	



	

	
	
	public void readFilefromconfig() throws IOException
	{
		System.out.println(ConfigFileReader.fetchConfigData("username"));
		System.out.println(ConfigFileReader.fetchConfigData("password"));
	}

}
