package NeoStoxTestClasses;

import org.testng.annotations.Test;

import NeoStoxBase.Base;
import NeoStoxPOM.NeoStoxHomePage;
import NeoStoxPOM.NeoStoxLogin;
import NeoStoxPOM.NeoStoxPassword;
import NeoStoxUtility.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

@Listeners(NeoStoxUtility.Listener.class)
public class ValidateNeoStoxBalance extends Base{
	
	NeoStoxLogin login;
	NeoStoxPassword password;
	NeoStoxHomePage home;
	@BeforeClass
	  public void launchBrowser() throws IOException 
	  {
		launchNeoStox();
		 login=new NeoStoxLogin(driver);
		 password=new NeoStoxPassword(driver);
		 home=new NeoStoxHomePage(driver);
		
	  }
	 @BeforeMethod
	  public void loginToNeoStox() throws IOException, InterruptedException 
	  {
		 login.sendMobileNo(driver, Utility.getDataFromPropertyFile("MobileNo"));
		 login.clickOnSignUp(driver);
		 password.sendPassword(driver, Utility.getDataFromPropertyFile("password"));
		 password.clickOnSubmitButton(driver);
		 Thread.sleep(3000);
		 home.popupHandle(driver);
		 Utility.Wait(driver, 2000);
		 
	  }
  @Test
  public void validateBalance() throws IOException 
  {
	  Assert.assertEquals(home.getBalance(),Utility.getDataFromPropertyFile("Balance"),"TC failed actual and expected are not matching");
	  Utility.Wait(driver, 3000);
  }
 

  @AfterMethod
  public void logOutFromApplication() 
  {
	  home.clickOnLogOutButton(driver);
  }

  

  @AfterClass
  public void closingBrowser() 
  {
	  driver.close();
  }

}
