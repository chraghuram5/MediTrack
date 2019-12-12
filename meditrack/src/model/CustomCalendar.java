package model;

public class CustomCalendar {
	private int month;
	private int year;
	
	public CustomCalendar(int month, int year) {
		super();
		this.month = month;
		this.year = year;
	}
	
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public static String[] months = { "", // leave empty so that months[1] = "January"
			"January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
			"November", "December" };

	public static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int day(int month, int day, int year) {
		if (month == 2 && isLeapYear(year))
			days[month] = 29;
		int y = year - (14 - month) / 12;
		int x = y + y / 4 - y / 100 + y / 400;
		int m = month + 12 * ((14 - month) / 12) - 2;
		int d = (day + x + (31 * m) / 12) % 7;
		return d;
	}

	// return true if the given year is a leap year
	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0) && (year % 100 != 0))
			return true;
		if (year % 400 == 0)
			return true;
		return false;
	}
	
	public static void printCalendar(int month, int year) {

				// print calendar header
				System.out.println("   " + months[month] + " " + year);
				System.out.println(" S  M Tu  W Th  F  S");

				// starting day
				int d = day(month, 1, year);
				System.out.println(d);
				// print the calendar
				for (int i = 0; i < d; i++)
					System.out.print("   ");
				for (int i = 1; i <= days[month]; i++) {
					System.out.printf("%2d ", i);
					if (((i + d) % 7 == 0) || (i == days[month]))
						System.out.println();
				}
	}
	public static void main(String args[]) {
		CustomCalendar.printCalendar(11,2019);
	}

}