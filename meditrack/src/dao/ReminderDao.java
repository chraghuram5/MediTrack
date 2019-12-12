package dao;

import java.util.ArrayList;

import model.Medication;
import model.Reminder;

public interface ReminderDao {
	public void addReminder(Reminder reminder);
	public ArrayList<Reminder> getMonth(int month, int year, int userId);
	public int count(Reminder reminder);
	public void editReminder(Reminder reminder);
	public void deleteReminder(int Id);
	public Reminder getReminder(int Id);	
}
