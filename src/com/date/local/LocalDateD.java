package com.date.local;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateD {

	public static void main(String[] args) throws ParseException {

		String tradeDate = "2017-06-25";
		String time = "12:11:33";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        SimpleDateFormat sdateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        LocalDate date = LocalDate.parse(tradeDate, formatter);
        LocalDate currentDate = LocalDate.now();
         
        System.out.println("currentDate:"+currentDate);
        
        System.out.println("tdate:"+date);
        
        if(currentDate.isBefore(date)) {
        	String currentDateS = date.format(formatter);
        	String dateTimeS = currentDateS + " "+ time;
        	String res = sdateFormat.format(sdateFormat.parse(dateTimeS));
        	System.out.println("result:"+res);
        } else {
        	System.out.println("curret and tdate are same");
        }
				
	}

}
