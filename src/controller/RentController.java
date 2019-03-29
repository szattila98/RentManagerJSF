package controller;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import dao.RentDao;

@ManagedBean
@ApplicationScoped
public class RentController {

	private boolean connected = false;
	private boolean evict = false;
	private RentDao rentDao = new RentDao();

	public void connectToDb() {
		connected = rentDao.connect();
	}

	public boolean moveInTenant(int floor, int door, String tenantName) {
		return rentDao.setTenant(floor, door, tenantName);
	}

	public boolean moveOutTenant(int floor, int door) {
		return rentDao.deleteTenant(floor, door);
	}

	public boolean depositSum(String tenantName, int sum) {
		return rentDao.recordDeposit(tenantName, sum);
	}

	public boolean commonCharge(int sum, String desc) {
		return rentDao.recordCommonCharge(sum, desc);
	}

// =============================================================================================	

	public void evictMode() {
	    if (evict) {
			evict = false;
		}else evict = true;
	}
	
	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public boolean isEvict() {
		return evict;
	}

	public void setEvict(boolean evict) {
		this.evict = evict;
	}

	public RentDao getRentDao() {
		return rentDao;
	}

	public void setRentDao(RentDao rentDao) {
		this.rentDao = rentDao;
	}

}
