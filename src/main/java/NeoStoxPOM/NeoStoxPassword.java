package NeoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NeoStoxPassword {

	@FindBy(xpath="//*[@id='txt_accesspin']")private WebElement password;
	
	@FindBy(xpath="//*[@id='lnk_submitaccesspin']")private WebElement submitButton;
	
	public NeoStoxPassword(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void sendPassword(WebDriver driver,String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnSubmitButton(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		submitButton.click();
	}
	
}
