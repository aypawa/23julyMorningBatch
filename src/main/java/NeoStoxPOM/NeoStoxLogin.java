package NeoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NeoStoxUtility.Utility;

public class NeoStoxLogin {

	@FindBy(xpath="//*[@id='MainContent_signinsignup_txt_mobilenumber']")private WebElement MobileNoField;
	
	@FindBy(xpath="//*[@id='lnk_signup1']") private WebElement SignUpButton;
	
	public NeoStoxLogin(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void sendMobileNo(WebDriver driver,String Num)
	{
		MobileNoField.sendKeys(Num);
	}
	public void clickOnSignUp(WebDriver driver)
	{
		SignUpButton.click();
		Utility.Wait(driver,2000);
	}
}
