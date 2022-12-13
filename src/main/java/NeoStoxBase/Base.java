package NeoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import NeoStoxUtility.Utility;

public class Base {
  public static WebDriver driver;
	public void launchNeoStox() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ajink\\OneDrive\\Desktop\\Automation velocity\\Driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get(Utility.getDataFromPropertyFile("Url"));
		driver.manage().window().maximize();
		Utility.Wait(driver, 3000);
	}
	public static void closeBrowser() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
	}
}
