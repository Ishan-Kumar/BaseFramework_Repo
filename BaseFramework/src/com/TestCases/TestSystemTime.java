package com.TestCases;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
public class TestSystemTime {
	
	public static void main(String args[]){
		
	
		        Calendar cal = Calendar.getInstance();
		        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
		        System.out.println("Time-->" + sdf.format(cal.getTime()));
		        //System.out.println("Date-->" + sdf.format(cal.));
		        
		        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        LocalDate localDate = LocalDate.now();
		        System.out.println("Date-->" + dtf.format(localDate)); //2016/11/16
		        
		        long epoch = System.currentTimeMillis();

		        System.out.println("Epoch : " + (epoch / 1000));
		       }

}
