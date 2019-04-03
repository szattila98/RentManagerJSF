package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import dao.RentDao;

@ManagedBean
@ApplicationScoped
public class RentController {

	private RentDao rentDao;
	private String nameForDelete;
	private String nameForCashIn;
	
	@PostConstruct
	public void init() {
		rentDao = new RentDao();
	}

	public boolean moveInTenant(int floor, int door, String tenantName) {
		return rentDao.setTenant(floor, door, tenantName);
	}

	public boolean moveOutTenant(String name) {
		return rentDao.deleteTenant(name);
	}

	public boolean depositSum(String tenantName, int sum) {
		return rentDao.recordDeposit(tenantName, sum);
	}

	public boolean commonCharge(int sum, String desc) {
		return rentDao.recordCommonCharge(sum, desc);
	}
	
	public boolean totalCost(int sum, String desc) {
		return rentDao.recordTotalCost(sum, desc);
	}

// =============================================================================================	

	public List<String> fillTenantList() {
		return rentDao.fillTenantDropdown();
	}
	
	public void clear() {
		
	}

	public String getNameForDelete() {
		return nameForDelete;
	}

	public void setNameForDelete(String nameForDelete) {
		this.nameForDelete = nameForDelete;
	}

	public String getNameForCashIn() {
		return nameForCashIn;
	}

	public void setNameForCashIn(String nameForCashIn) {
		this.nameForCashIn = nameForCashIn;
	}

}
