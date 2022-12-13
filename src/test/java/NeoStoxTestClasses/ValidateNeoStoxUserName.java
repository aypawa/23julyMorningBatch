package NeoStoxTestClasses;

import org.testng.annotations.Test;

import NeoStoxBase.Base;
import NeoStoxPOM.NeoStoxHomePage;
import NeoStoxPOM.NeoStoxLogin;
import NeoStoxPOM.NeoStoxPassword;
import NeoStoxUtility.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
//import java.net.PasswordAuthentication;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ValidateNeoStoxUserName extends Base {
	
	NeoStoxLogin login;
	NeoStoxPassword passsword;
	NeoStoxHomePage home;
	
	 @BeforeClass
	  public void launchBrowser() throws IOException
	  {
		  launchNeoStox();
		  login=new NeoStoxLogin (driver);
		  passsword=new NeoStoxPassword (driver);
		  home=new NeoStoxHomePage(driver);
	  }

	
	
	 @BeforeMethod
	  public void loginToNeoStox() throws IOException, InterruptedException 
	  {
		 
		
		login.sendMobileNo(driver,Utility.getDataFromPropertyFile("MobileNo"));
		login.clickOnSignUp(driver);
		passsword.sendPassword(driver,Utility.getDataFromPropertyFile("password"));
		passsword.clickOnSubmitButton(driver);
		Thread.sleep(3000);
		home.popupHandle(driver);
		Utility.Wait(driver, 2000);
		 
	  }

  @Test
  public void ValidateNeoStoxUserNameId() throws IOException
  {
	  Assert.assertEquals(home.getActualUserName(),Utility.getDataFromPropertyFile("UserName"),"TC failed actual and expected id are not matching");
	  Utility.Wait(driver, 2000);
  }
 

  @AfterMethod
  public void logoutFromApplication() 
  {
	  home.clickOnLogOutButton(driver);
  }
  @AfterClass
  public void closingBrowser() throws InterruptedException 
  {
	closeBrowser();
  }
 
  
}
