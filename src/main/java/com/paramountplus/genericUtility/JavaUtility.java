package com.paramountplus.genericUtility;

import java.util.Date;
import java.util.Random;

/**
 * This class contains generic java methods like getRandomNumber, getSystemDateAndTime
 * @author rahulrajat.m
 */
public class JavaUtility {
	/**
	 * It's used to return random number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random random= new Random();
		int randomNumber= random.nextInt(10000);
		return randomNumber;
	}
	/**
	 * Used to get system date and time in IST format
	 * @return
	 */
	public String getSystemDateAndTime()
	{
		Date date= new Date();
		return date.toString();	
	}
	/**
	 * Used to get system date and time in YYYY-MM-DD format (ISO format)
	 * @return
	 */
	public String getSystemDateAndTimeInISOFormat()
	{
		Date date= new Date();
		String dateAndTime= date.toString();
		String YYYY= dateAndTime.split(" ")[5];
		String DD= dateAndTime.split(" ")[2];
		int MM= date.getMonth();
		String finalFormat= YYYY+"-"+MM+"-"+DD;
		return finalFormat;
	}
}
