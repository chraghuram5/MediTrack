package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Reminder;
import util.ConnectionHandler;

public class ReminderDaoSqlImpl implements ReminderDao {

	@Override
	public void addReminder(Reminder reminder) {
		// TODO Auto-generated method stub
		try {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO `meditrack`.`data` (`reminderId`, `event`, `day`, `month`, `year`, `hours`, `minutes`, `reminder`, `repeat`, `type`) VALUES (?,?,?,?,?,?,?,?,?,?);");
			ps.setInt(1, reminder.getUserId());
			ps.setString(2, reminder.getEvent());
			ps.setInt(3, reminder.getDay());
			ps.setInt(4, reminder.getMonth());
			ps.setInt(5, reminder.getYear());
			ps.setInt(6, reminder.getHours());
			ps.setInt(7, reminder.getMinutes());
			ps.setString(8, reminder.getReminder());
			ps.setString(9, reminder.getRepeat());
			ps.setString(10, reminder.getType());
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Reminder> getMonth(int month, int year, int userId) {
		// TODO Auto-generated method stub
		try {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("select * from data where month=? and year=? and reminderId=?");
			ps.setInt(1, month);
			ps.setInt(2, year);
			ps.setInt(3, userId);
			ArrayList<Reminder> list = new ArrayList<Reminder>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reminder reminder = new Reminder(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
						rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11));
				list.add(reminder);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int count(Reminder reminder) {
		try {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement ps = connection.prepareStatement(
					"select count(reminderId)\r\n" + "FROM data\r\n" + "WHERE day=? and month=? and year=?");
			ps.setInt(1, reminder.getDay());
			ps.setInt(2, reminder.getMonth());
			ps.setInt(3, reminder.getYear());
			ResultSet rs = ps.executeQuery();
			int n;
			while (rs.next()) {
				n = rs.getInt(1);
				return n;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void editReminder(Reminder reminder) {
		try {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE `meditrack`.`data` SET `event` = ?, `day` = ?, `month` = ?, `year` = ?, `hours` = ?, `minutes` = ?, `reminder` = ?, `repeat` = ?, `type` = ? WHERE (`Id` = ?);");
			ps.setString(1, reminder.getEvent());
			ps.setInt(2, reminder.getDay());
			ps.setInt(3, reminder.getMonth());
			ps.setInt(4, reminder.getYear());
			ps.setInt(5, reminder.getHours());
			ps.setInt(6, reminder.getMinutes());
			ps.setString(7, reminder.getReminder());
			ps.setString(8, reminder.getRepeat());
			ps.setString(9, reminder.getType());
			ps.setInt(10, reminder.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteReminder(int Id) {
		// TODO Auto-generated method stub
		try {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement ps = connection.prepareStatement("delete from data where Id=?");
			ps.setInt(1, Id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Reminder getReminder(int Id) {
		try {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("select * from data where Id=?");
			ps.setInt(1, Id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reminder reminder = new Reminder(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
						rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11));
				return reminder;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
