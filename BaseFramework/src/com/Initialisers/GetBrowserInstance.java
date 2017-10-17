/*  
 * @Author: Ishan
 * This is a superclass which will use to initialize
 *  the WebDriver and Vansah objects. This class will also initiate the
 *  browser instance based on what is mentioned in the constants file.
 *  All the test cases should extend this class for driver and Vansah API usage.
 *  
 * */

package com.Initialisers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

//import testpoint.StreamTest;

public class GetBrowserInstance 
{

	private WebDriver driver;
	//protected StreamTest vansah = new StreamTest();
	public String browserName = Constants.browser;



	/*This function will Initiate the type of browser defined in constants file
	 * and will create the browser instance accordingly
	 * */
	public  WebDriver getDriver()
	{
		if(browserName.equalsIgnoreCase("chrome")){
			driver = initChromeDriver();
			//driver = initChromeDriverIncognito();
		}else if(browserName.equalsIgnoreCase("Edge")){
			driver = initEdgeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")){
			driver = initFirefoxDriver();
		}else if(browserName.equalsIgnoreCase("IE")){
			driver = initIEDriver();
		}

		return driver;
	}


	/*
	 * This function will create the Chrome browser instance 
	 * In Incognito mode  and return the driver
	 * */
	public WebDriver initChromeDriverIncognito()
	{	
		System.setProperty("webdriver.chrome.driver", "Lib\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		options.addArguments("disable-extensions");
		options.addArguments("--start-maximized");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		// Issue in using this with incognito window  
		//driver.manage().window().maximize();  	
		return driver;

	}

	/*
	 * This function will create the Chrome browser instance 
	 * and return the driver
	 * */
	public WebDriver initChromeDriver()
	{
		System.setProperty("webdriver.chrome.driver", "Lib\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-extensions");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver initIEDriver()
	{
		System.setProperty("webdriver.ie.driver", "Lib\\IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
		driver = new InternetExplorerDriver(capabilities);
		//driver.manage().window().maximize();
		return driver;
	}
	

	/*
	 * This function will create the Edge browser instance 
	 * and return the driver.
	 * Please Note: This will oncly work with windows10 Environment.
	 * */
	public WebDriver initEdgeDriver(){


		//System.setProperty("webdriver.edge.driver", "Lib\\MicrosoftWebDriver.exe");
		System.setProperty("webdriver.edge.driver", "Lib\\MicrosoftWebDriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.edge();
		driver = new EdgeDriver(capabilities);
		//driver = new EdgeDriver();
		return driver;
	}

	/*
	 * This function will create the firefox browser instance 
	 * and return the driver.
	 * */

	public WebDriver initFirefoxDriver(){
		System.setProperty("webdriver.gecko.driver", "Lib\\geckodriver.exe");
		//FirefoxProfile profile=new FirefoxProfile();
		//profile.setAcceptUntrustedCertificates(true);
		//DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		//capabilities.setCapability("acceptInsecureCerts",true);
		driver = new FirefoxDriver();
		return driver;
	}



	/*
	 * Close and quite the browser once everythings is done
	 * */
	@AfterClass
	public void tearDown()
	{
		if(driver!=null)
		{	
			//driver.close();
			driver.quit();
			//driver = null;
		}
	}
}
