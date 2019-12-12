package model;

public class Reminder {
	private int userId;
	private String event;
	private int day;
	private int month;
	private int year;
	private int hours;
	private int minutes;
	private String reminder;
	private String repeat;
	private String type;
	private int id;
	public Reminder(int userId, int day, int month, int year, int hours, int minutes, String reminder) {
		super();
		this.userId = userId;
		this.day = day;
		this.month = month;
		this.year = year;
		this.hours = hours;
		this.minutes = minutes;
		this.reminder = reminder;
		
	}
	
	public Reminder(int userId, String event, int day, int month, int year, int hours, int minutes, String reminder,
			String repeat, String type, int id) {
		super();
		this.userId = userId;
		this.event = event;
		this.day = day;
		this.month = month;
		this.year = year;
		this.hours = hours;
		this.minutes = minutes;
		this.reminder = reminder;
		this.repeat = repeat;
		this.type = type;
		this.id = id;
	}

	public Reminder(int day, int month, int year, int hours, int minutes, String reminder) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.hours = hours;
		this.minutes = minutes;
		this.reminder = reminder;
	}
	
	public Reminder(String event, int day, int month, int year, int hours, int minutes, String reminder, String repeat,
			String type) {
		super();
		this.event = event;
		this.day = day;
		this.month = month;
		this.year = year;
		this.hours = hours;
		this.minutes = minutes;
		this.reminder = reminder;
		this.repeat = repeat;
		this.type = type;
	}
	public Reminder(int userId, String event, int day, int month, int year, int hours, int minutes, String reminder,
			String repeat, String type) {
		super();
		this.userId = userId;
		this.event = event;
		this.day = day;
		this.month = month;
		this.year = year;
		this.hours = hours;
		this.minutes = minutes;
		this.reminder = reminder;
		this.repeat = repeat;
		this.type = type;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getRepeat() {
		return repeat;
	}
	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
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
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public String getReminder() {
		return reminder;
	}
	public void setReminder(String reminder) {
		this.reminder = reminder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
