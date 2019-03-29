package controller;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import dao.RentDao;

@ManagedBean
@ApplicationScoped
public class RentController {
	
	private boolean connected = false;
	private RentDao rentDao = new RentDao();
	
	public void connectToDb() {
		connected = rentDao.connect();
	}
	
	public boolean moveTenant(int flatId, String tenantName) {
		return rentDao.setTenant(flatId, tenantName);
	}
	
	public boolean depositSum(String tenantName, int sum) {
		return rentDao.deposit(tenantName, sum);
	}
	
// =============================================================================================	

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	
}
