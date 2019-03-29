package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.CommonCharge;

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
			ps = connection.prepareStatement("UPDATE tenants SET name=? WHERE flatnum=?");
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

	public boolean recordDeposit(String tenantName, int sum) {
		int tenant = 0;
		try {
			ps = connection.prepareStatement("SELECT flatnum FROM tenants WHERE name=?");
			ps.setString(1, tenantName);
			rs = ps.executeQuery();
			while (rs.next())
				tenant = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		try {
			ps = connection.prepareStatement("INSERT INTO deposits(sum, tenant) VALUES (?,?)" );
			ps.setInt(1, sum);
			ps.setInt(2, tenant);
			ps.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		try {
			ps = connection.prepareStatement("UPDATE tenants SET balance=balance+? WHERE id=?" );
			ps.setInt(1, sum);
			ps.setInt(2, tenant);
			ps.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean recordCommonCharge(int sum, String desc) {
		ArrayList<CommonCharge> cch = new ArrayList<>();
		try {
			ps = connection.prepareStatement("SELECT tenants.id, flats.floorSpace FROM tenants INNER JOIN flats ON tenants.flatnum=flats.id");
			rs = ps.executeQuery();
			while (rs.next()) {
				cch.add(new CommonCharge(rs.getInt(1), rs.getInt(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		try {
			for (CommonCharge i : cch) {
				ps = connection.prepareStatement("INSERT INTO charges(sum, description, tenant) VALUES (?,?,?)" );
				ps.setInt(1, sum * i.getFloorSpace());
				ps.setString(2, desc);
				ps.setInt(3, i.getTenant());
				ps.executeUpdate();
				ps = connection.prepareStatement("UPDATE tenants SET balance=balance+? WHERE id=?" );
				ps.setInt(1, -sum * i.getFloorSpace());
				ps.setInt(2, i.getTenant());
				ps.executeUpdate();
			}
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
