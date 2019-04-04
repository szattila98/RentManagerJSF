package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Billing;

public class RentDao {

	private Connection connection = connect();
	private PreparedStatement ps;
	private ResultSet rs;

	private Connection connect() {
		try {
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/rentmanager?user=root&password=");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return connection;
	}

	public List<String> fillTenantDropdown() {
		List<String> names = new ArrayList<String>();
		try {
			ps = connection.prepareStatement("SELECT name FROM tenants WHERE name IS NOT NULL");
			rs = ps.executeQuery();
			while (rs.next()) {
				names.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return names;
	}

	public boolean setTenant(int floor, int door, String tenantName) {
		int flatId = 0;
		try {
			ps = connection.prepareStatement(
					"SELECT flats.id FROM tenants INNER JOIN flats ON tenants.flatnum=flats.id WHERE flats.floor=? AND flats.door=?");
			ps.setInt(1, floor);
			ps.setInt(2, door);
			rs = ps.executeQuery();
			while (rs.next()) {
				flatId = rs.getInt(1);
			}
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

	public boolean deleteTenant(String name) {
		try {
			ps = connection.prepareStatement("UPDATE tenants SET name=NULL WHERE name=?");
			ps.setString(1, name);
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
		int balance = 0;
		try {
			ps = connection.prepareStatement("SELECT id, balance FROM tenants WHERE name=?");
			ps.setString(1, tenantName);
			rs = ps.executeQuery();
			while (rs.next()) {
				tenant = rs.getInt(1);
				balance = rs.getInt(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		try {
			ps = connection.prepareStatement("INSERT INTO deposits(sum, balance, tenant) VALUES (?,?,?)");
			ps.setInt(1, sum);
			ps.setInt(2, balance + sum);
			ps.setInt(3, tenant);
			ps.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		try {
			ps = connection.prepareStatement("UPDATE tenants SET balance=balance+? WHERE id=?");
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

	public ArrayList<Billing> recordCommonCharge(int sum, String desc) {
		ArrayList<Billing> billings = new ArrayList<>();
		try {
			ps = connection.prepareStatement(
					"SELECT tenants.id, flats.floorSpace, tenants.name FROM tenants INNER JOIN flats ON tenants.flatnum=flats.id WHERE tenants.name IS NOT NULL");
			rs = ps.executeQuery();
			while (rs.next()) {
				billings.add(new Billing(rs.getInt(1), rs.getInt(2), desc, rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Billing i : billings) {
			i.setCost(-sum * i.getFloorSpace());
		}
		return billings;
	}

	public boolean commitRecordedCommonCharge(List<Billing> billings) {
		try {
			for (Billing i : billings) {
				ps = connection.prepareStatement("INSERT INTO charges(sum, description, tenant) VALUES (?,?,?)");
				ps.setInt(1, (int) i.getCost());
				ps.setString(2, i.getDesc());
				ps.setInt(3, i.getFlatnum());
				ps.executeUpdate();
				ps = connection
						.prepareStatement("UPDATE tenants SET balance=balance+? WHERE id=? AND name IS NOT NULL");
				ps.setInt(1, (int) i.getCost());
				ps.setInt(2, i.getFlatnum());
				ps.executeUpdate();
			}
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ArrayList<Billing> recordTotalCost(int sum, String desc) {
		ArrayList<Billing> billing = new ArrayList<>();
		try {
			ps = connection.prepareStatement(
					"SELECT tenants.id, flats.floorSpace, tenants.name FROM tenants INNER JOIN flats ON tenants.flatnum=flats.id WHERE tenants.name IS NOT NULL");
			rs = ps.executeQuery();
			while (rs.next()) {
				billing.add(new Billing(rs.getInt(1), rs.getInt(2), desc, rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int maxFloorspace = 0;
		for (Billing i : billing) {
			maxFloorspace += i.getFloorSpace();
		}
		for (Billing i : billing) {
			i.setCost(-((sum / maxFloorspace) * i.getFloorSpace()));
		}
		return billing;
	}

	public boolean commitRecordedTotalCost(List<Billing> billing) {
		try {
			for (Billing i : billing) {
				ps = connection.prepareStatement("INSERT INTO charges(sum, description, tenant) VALUES (?,?,?)");
				ps.setInt(1, (int) i.getCost());
				ps.setString(2, i.getDesc());
				ps.setInt(3, i.getFlatnum());
				ps.executeUpdate();
				ps = connection
						.prepareStatement("UPDATE tenants SET balance=balance+? WHERE id=? AND name IS NOT NULL");
				ps.setInt(1, (int) i.getCost());
				ps.setInt(2, i.getFlatnum());
				ps.executeUpdate();
			}
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
