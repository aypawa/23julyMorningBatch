package NeoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import NeoStoxUtility.Utility;

public class NeoStoxHomePage {

	@FindBy(xpath="(//*[text()='OK'])[2]")private WebElement okButton;
	
	@FindBy(xpath="(//a[text()='Close'])[5]")private WebElement closeButton;

	@FindBy(xpath="//span[@id='lbl_username']")private WebElement UserName;
	
	@FindBy(xpath="//span[@id='lbl_curbalancetop']")private WebElement Balance;
	
	@FindBy(xpath="//*[text()='Logout']")private WebElement logOutButton;
	
public NeoStoxHomePage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
} 
public void popupHandle(WebDriver driver) throws InterruptedException
{
	if(okButton.isDisplayed())
	{
		Thread.sleep(3000);
		okButton.click();
		Thread.sleep(3000);
		Utility.scrollIntoView(driver,closeButton);
		Thread.sleep(2000);
		closeButton.click();
		Thread.sleep(2000);
	}
	else
	{
		Reporter.log("There is no popup",true);
	}
}

   public String getActualUserName()
   {
	String actualUserId = UserName.getText();
	Reporter.log("Actual user id is "+actualUserId,true);
	return actualUserId;
   }
   
   public String getBalance()
   {
	   String actualBalance = Balance.getText();
	   Reporter.log("Actual balance is "+actualBalance,true);
	   return actualBalance;
   }
   
   public void clickOnLogOutButton(WebDriver driver) 
   {
	   UserName.click();
	   Utility.Wait(driver, 2000);
	   logOutButton.click();
	   
   }
}
