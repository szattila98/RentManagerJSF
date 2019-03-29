package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RentDao {

	private Connection connection = null;
	private String sql;
	private Statement s;
	private PreparedStatement ps;
	private ResultSet rs;

	public boolean connect() {
		try {
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/rentmanager?user=root&password=");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean setTenant(int flatId, String tenantName) {
		try {
			ps = connection.prepareStatement("UPDATE tenants SET name=? WHERE flatnum=?" );
			ps.setString(1, tenantName);
			ps.setInt(2, flatId);
			ps.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
//	public String query() {
//
//		try {
//			s = connection.createStatement();
//			rs = s.executeQuery("Select name from tenants where id=1");
//			while (rs.next()) {
//	            return rs.getString(1);
//	        }
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "heh";
//
//	}

//	public boolean addDummyData() {
//		try {
//
//			for (int j = 1; j < 13; j++) {
//				PreparedStatement ps = connection
//						.prepareStatement("INSERT INTO tenants(name, balance, flatnum) VALUES (?,?,?)");
//				ps.setString(1, "empty");
//				ps.setInt(2, 0);
//				ps.setInt(3, j);
//				ps.execute();
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}

}
