package com.example.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class GregorianCalendarTest {
	@Test
	public void test(){
		GregorianCalendar gregorian = new GregorianCalendar();
		gregorian.setTime(new Date());
		int numberOfDays = 16 * 7 -3;
	    gregorian.add(Calendar.DAY_OF_YEAR, numberOfDays);
	    System.out.println(gregorian.getTime());
	}
}
