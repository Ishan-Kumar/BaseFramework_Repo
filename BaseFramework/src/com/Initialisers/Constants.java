//this class holds all the application constants
package com.Initialisers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Constants {
	
	//Browser
	//public static final String browser = "Chrome";
	//public static final String browser = "Edge";
	public static final String browser = "IE";
	
	//Application Url
	public static final String application_URL1 = "https://testpoint.vansah.net/";
	//public static final String application_URL = "http://toolsqa.com/automation-practice-form/";
	
	public static final String application_URL2 = "http://www.way2automation.com/demo.html";
	String userName = "test";
	String Password = "test";
	
	// BUILD GENERATOR
	static Calendar c = Calendar.getInstance();
	static SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy.HHmmss");
	static String build = sdf.format(c.getTime());
	public static final String BUILD = build;





}
