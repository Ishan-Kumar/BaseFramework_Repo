/*This is to test and generate new functions
 * for the framework. Use the URL on constants file to generate new functions
 * */
package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Initialisers.Constants;
import com.Initialisers.GetBrowserInstance;
import com.Utills.Keywords;

public class TestSiteWayToAutomation extends GetBrowserInstance 
{
	WebDriver driver;
	Keywords act = new Keywords();

	//Initialize Driver
	@Test(priority=1)
	public void getBrowser(){
		this.driver = getDriver();
	}


	@Test(priority =2)
	public void testfunctions2(){

		try 
		{

			act.gotToUrl(driver, Constants.application_URL2);
			//act.click(driver, "xpath", "//button[@id='alert']");

			//Thread.sleep(2000);
			//act.clickAlertOK(driver);
			Thread.sleep(7000);

		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
