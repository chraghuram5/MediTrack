package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.ConnectionHandler;

public class UserDaoSqlImpl implements UserDao {

	
	@Override
	public int addUser(User user) {
		try {
			Connection con = ConnectionHandler.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into user(fname, lname, email, gender, uname, mobile, password, role) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getFname());
			ps.setString(2, user.getLname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getUname());
			ps.setString(6, user.getMobile());
			ps.setString(7, user.getPassword());
			ps.setString(8, user.getRole());
			int n = ps.executeUpdate();
			return n;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		// TODO Auto-generated method stub
	}

	@Override
	public int authenticate(String uname, String password) {
		// TODO Auto-generated method stub
		try {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement ps = connection.prepareStatement("select id from user where uname=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			int userId = 0;
			while (rs.next()) {
				userId = rs.getInt(1);
			}
			return userId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		try {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from user where id=?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			User user = null;
			while (rs.next()) {
				user = new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9),rs.getInt(10));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addId(int assId, int id) {
		// TODO Auto-generated method stub
		try {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE `meditrack`.`user` SET `assId` = ? WHERE (`id` = ?);");
			ps.setInt(1, assId);
			ps.setInt(2, id);	
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
