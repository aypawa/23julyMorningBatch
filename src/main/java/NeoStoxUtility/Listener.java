package NeoStoxUtility;

import java.io.IOException;


import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import NeoStoxBase.Base;

public class Listener extends Base implements ITestListener{
	
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("TC "+result.getName()+"is completed successfully",true);
	}
	public void onTestFailure(ITestResult result)
	{
		try {
			Utility.takeScreenshot(driver,result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.log("TC "+result.getName()+"is failed",true);
		
	}
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("TC "+result.getName()+"is skipped",true);
	}
	
	
	
	
	
}