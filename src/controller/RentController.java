package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import dao.RentDao;
import model.Billing;

@ManagedBean
@ApplicationScoped
public class RentController {

	private RentDao rentDao;
	private String nameForDelete;
	private String nameForCashIn;
	private int sum;
	private String desc;

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

	public List<Billing> commonCharge(int sum, String desc) {
		setSum(sum);
		setDesc(desc);
		return rentDao.recordCommonCharge(sum, desc);
	}

	public boolean finlizeCommonCharge() {
		return rentDao.commitRecordedCommonCharge(rentDao.recordCommonCharge(this.sum, this.desc));
	}

	public List<Billing> totalCost(int sum, String desc) {
		setSum(sum);
		setDesc(desc);
		return rentDao.recordTotalCost(sum, desc);
	}

	public boolean finalizeTotalCost() {
		return rentDao.commitRecordedTotalCost(rentDao.recordTotalCost(this.sum, this.desc));
	}

// =============================================================================================	

	public List<String> fillTenantList() {
		return rentDao.fillTenantDropdown();
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

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
