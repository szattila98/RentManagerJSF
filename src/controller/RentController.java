package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import dao.RentDao;

@ManagedBean
@ApplicationScoped
public class RentController {

	private RentDao rentDao = new RentDao();
	private String name;
	private List<String> names;

	@PostConstruct
	public void init() {
		names = fillTenantList();
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

// =============================================================================================	

	public List<String> fillTenantList() {
		return rentDao.fillTenantDropdown();
	}

	public RentDao getRentDao() {
		return rentDao;
	}

	public void setRentDao(RentDao rentDao) {
		this.rentDao = rentDao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

}
