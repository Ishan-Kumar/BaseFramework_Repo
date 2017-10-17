package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Initialisers.Constants;
import com.Utills.Keywords;

public class SamplePageObjects 
{
	Keywords key = new Keywords();

	//This is test Xpaths
	public By name = By.xpath("");
	
	
	//This is to perform Login
	public void navigateAndLogin(WebDriver driver){
		key.gotToUrl(driver, Constants.application_URL2);
		
	
	}
	
	
	
}
