package delete.delete.commonmethods;
import java.io.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CommonMethods extends BaseClass{
	
	static Map map ;
	static FileInputStream fs;
	
	public static void waitForElementToAppear( WebDriver driver, By findBy)
	{
		
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));	
	}
		
	public static void waitForElementToDisappear(WebDriver driver ,WebElement ele)
	{		
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(ele));	
	}
	
	public  static Map fetchExcelData(String filePath, String inputstr, String strKey) throws IOException 
	{	
		    map= new HashMap<String,String>();	
			fs = new FileInputStream(filePath);
			
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet wsh= wb.getSheetAt(0);					
		    int totalRows = wsh.getLastRowNum();
		    
		    for(int i=1; i<=totalRows; i++)
		    {
		    	Row row = wsh.getRow(i);	    	
		    	Row HeaderRow = wsh.getRow(0);
			    int totalCells = row.getLastCellNum();
				    if(row.getCell(0).getStringCellValue().equalsIgnoreCase(inputstr))
				    {				    	
				    	for (int j = 0; j<totalCells; j++) 
					    {		    			
			    				Cell cell = row.getCell(j);
							    map.put(HeaderRow.getCell(j).getStringCellValue(), cell.getStringCellValue());
					    }
				    	break;
				    }		    
		    }
		    return map;
	}
	
	public static String fetchExcelCellValue(String filePath, String inputStr, String keyValue) throws IOException
	{
		String excelCellValue = null;
		Map<String , String> m = new HashMap<String, String>();
		m = CommonMethods.fetchExcelData(filePath, inputStr , keyValue);		 
		for (Map.Entry me : m.entrySet()) {		
			if(me.getKey().toString().equals(keyValue))
			{			
				excelCellValue =  me.getValue().toString();			
			}         
       }
		return excelCellValue;
	}
	
}


