package NeoStoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {

	public static  String getDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{
		File myfile=new File("C:\\\\Users\\\\ajink\\\\OneDrive\\\\Documents\\\\ajinkya1.xlsx");
		
		Sheet mySheet = WorkbookFactory.create(myfile).getSheet("Sheet1");
		
		String value = mySheet.getRow(row).getCell(cell).getStringCellValue();
		
		Reporter.log("getting data from Excel file",true);
		return value;
	}
	
	public static  String getDataFromPropertyFile(String key) throws IOException
	{
		Properties prop=new Properties();
		
		FileInputStream file=new FileInputStream("C:\\Users\\ajink\\eclipse-workspace\\NeoStoxMavenProject\\congfigure.properties");
		
		prop.load(file);
		
		String value=prop.getProperty(key);
		Reporter.log("getting data from property file",true);
		return value;
	}
	
	public static void takeScreenshot(WebDriver driver,String fileName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\Users\\ajink\\eclipse-workspace\\NeoStoxMavenProject\\srcShot\\"+fileName+".png");
		
		FileHandler.copy(src, dest);
		Reporter.log("takeing screenshot",true);
	}
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		Reporter.log("Scrolling to element",true);
	}
	
	public static void Wait(WebDriver driver,int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		Reporter.log("waiting time is "+waitTime,true);
	}
}
