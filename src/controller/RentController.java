package controller;

import javax.faces.bean.ManagedBean;

import dao.RentDao;

@ManagedBean
public class RentController {
	
	private boolean connected = false;
	private RentDao rentDao = new RentDao();
	
	public void connectToDb() {
		connected = rentDao.connect();
	}
	
	
	
// =============================================================================================	

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	
}
