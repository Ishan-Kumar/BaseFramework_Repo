package com.Utills;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Utility 
{

	// Return date of 4 Days ahaead of current date
	public String getFutureDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		String future_Date = dtf.format(localDate.plusDays(4));
		System.out.println("Future Date used in TestCase" + dtf.format(localDate.plusDays(2)));
		return future_Date;
	}

	//Return date of 4 Days behind of current date
	public String getPastDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		String future_Date = dtf.format(localDate.minusDays(4));
		System.out.println("Past Date used in TestCase" + dtf.format(localDate.plusDays(2)));
		return future_Date;
	}

	//Return Cuurent Time in HHMM format
	public String getCurrentTime(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
		String crntTme =  sdf.format(cal.getTime());
		System.out.println("Current Test Time-->" + crntTme);
		return crntTme;
	}

	//Return Current system Date
	public String getCurrentDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		String current_Date = dtf.format(localDate);
		//System.out.println("Current Date used in TestCase" + dtf.format(localDate));
		return current_Date;
	}



}
