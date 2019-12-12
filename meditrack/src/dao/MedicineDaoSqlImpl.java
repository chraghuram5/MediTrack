package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionHandler;

public class MedicineDaoSqlImpl implements MedicineDao {

	@Override
	public ArrayList<String> getMedicine() {
		try {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from medicine");
			ResultSet rs = ps.executeQuery();
			ArrayList<String> list = new ArrayList<String>();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
