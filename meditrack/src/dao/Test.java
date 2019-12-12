package dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test {
		Timer timer;
		String year;
		String month;
		String day;
		String hours;
		String minutes;
		String seconds;
		String date;
		public Test(int year, int month, int day, int hours, int minutes, int seconds) {
			super();
			this.timer = new Timer();
			this.year = Integer.toString(year);
			this.month = Integer.toString(month);
			this.day =Integer.toString(day);
			this.hours =Integer.toString(hours);
			this.minutes = Integer.toString(minutes);
			this.seconds = Integer.toString(seconds);
			
		}


	static class PrintTask extends TimerTask {
		public void run() {
			System.out.println("Task executed");
		}
	}
	public static void main(String[] args) throws ParseException {
		Timer timer1 = new Timer();
		DateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String year1 = Integer.toString(2019);
		String month1 = Integer.toString(11);
		String day1 = Integer.toString(27);
		String hours1 = Integer.toString(18);
		String minutes1 = Integer.toString(41);
		String seconds1 = Integer.toString(0);
		String original = year1 + "-" + month1 + "-" + day1 + " " + hours1 + ":" + minutes1 + ":" + seconds1;
		Date date = d.parse(original);
		timer1.schedule(new PrintTask(), date);

	}
}