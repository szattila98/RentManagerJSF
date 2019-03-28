package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RentDao {

	private Connection connection = null;
	private Statement s;

	public boolean connect() {
		try {
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/rentmanager?user=root&password=");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean addDummyFlat() {
		try {
			Statement s = connection.createStatement();
			String sql = "INSERT INTO flats VALUES (1,1,1,100,100)";
			s.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
