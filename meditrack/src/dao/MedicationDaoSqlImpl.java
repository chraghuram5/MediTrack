package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Medication;
import util.ConnectionHandler;

public class MedicationDaoSqlImpl implements MedicationDao {

	@Override
	public ArrayList<Medication> getMedicationList(int userId) {
		try {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from medicationdata where userId=?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			ArrayList<Medication> list = new ArrayList<Medication>();
			while (rs.next()) {
				Medication medication=new Medication(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));
				list.add(medication);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void addMedication(Medication medication) {
		try {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement ps = connection.prepareStatement("insert into medicationdata(medication,morning,afternoon,evening,night, userId) values(?,?,?,?,?,?)");
			ps.setString(1, medication.getMedicine());
			ps.setInt(2, medication.getMorning());
			ps.setInt(3, medication.getAfternoon());
			ps.setInt(4, medication.getEvening());
			ps.setInt(5, medication.getNight());
			ps.setInt(6, medication.getUserId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Medication getMedication(int medicationId) {	
		try {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from medicationdata where medicationId=?");
			ps.setInt(1, medicationId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Medication medication=new Medication(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));
				return medication;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void editMedication(Medication medication) {
		// TODO Auto-generated method stub
		try {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE medicationdata\r\n" + 
					"SET medication= ?, morning=?, afternoon=?, evening=?, night=? \r\n" + 
					"WHERE medicationId=?;");
			ps.setString(1, medication.getMedicine());
			ps.setInt(2, medication.getMorning());
			ps.setInt(3, medication.getAfternoon());
			ps.setInt(4, medication.getEvening());
			ps.setInt(5, medication.getNight());
			ps.setInt(6, medication.getMedicationId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMedication(int medicationId) {
		try {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement ps = connection.prepareStatement("delete from medicationdata where medicationId=?");
			ps.setInt(1, medicationId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
