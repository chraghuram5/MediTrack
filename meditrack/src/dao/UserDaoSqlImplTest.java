package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import model.User;

public class UserDaoSqlImplTest {

	public static void main(String[] args) {
		int month=1;
		int day=1;
		int year=2019;
		int hours=00;
		int minutes=14;
		int seconds=0;
	     Date localTime = new Date(year-1900,month-1,day,hours,minutes,seconds); 
	     DateFormat converter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	    	   
	     converter.setTimeZone(TimeZone.getTimeZone("GMT"));    
	     System.out.println("local time : " + localTime);;
	     String s=converter.format(localTime);
	     System.out.println(s);

	}

	
}
