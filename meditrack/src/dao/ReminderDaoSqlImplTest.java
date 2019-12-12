package dao;

import java.util.ArrayList;

import model.Reminder;

public class ReminderDaoSqlImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReminderDao r=new ReminderDaoSqlImpl();
		ArrayList<Reminder> list=r.getMonth(12, 2019, 9);
		System.out.println(list.get(0).getEvent());
	}

	
}
