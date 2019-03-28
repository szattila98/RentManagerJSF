package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	public boolean addDummyData() {
		try {

			for (int j = 1; j < 13; j++) {
				PreparedStatement ps = connection
						.prepareStatement("INSERT INTO tenants(name, balance, flatnum) VALUES (?,?,?)");
				ps.setString(1, "empty");
				ps.setInt(2, 0);
				ps.setInt(3, j);
				ps.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
