package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.FileReader;
import java.util.Properties;

public class ConnectionHandler {
	public static Connection getConnection() {
		try {
			Properties p = new Properties();
			// Always Change Path of FileReader
			FileReader r = new FileReader("C:\\Users\\806929\\git\\meditrack\\src\\connection.properties");
			p.load(r);
			String url, user, pass, driver;
			driver = p.getProperty("driver");
			url = p.getProperty("connection-url");
			user = p.getProperty("user");
			pass = p.getProperty("password");

			Class.forName(driver);
			// System.out.println(user+ pass+ driver);
			Connection con = DriverManager.getConnection(url, user, pass);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return null;
	}

}