package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import dao.RentDao;
import model.Billing;
import model.Charge;
import model.Debt;
import model.Deposit;

@ManagedBean
@ApplicationScoped
public class RentController {

	private RentDao rentDao;
	private String nameForDelete;
	private String nameForCashIn;
	private int sum;
	private String desc;
	private String nameForDebtList;
	private String nameForChargeAndDepositList;

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

	public ArrayList<Debt> DebtsByDateAndName(String from, String to, String name) {
		if (from.isEmpty() || to.isEmpty()) {
			return new ArrayList<Debt>();
		}
		return rentDao.listDebtsByTenant(parseDate(from), parseDate(to), name);
	}

	public ArrayList<Charge> ChargesByDateAndName(String from, String to, String name) {
		if (from.isEmpty() || to.isEmpty()) {
			return new ArrayList<Charge>();
		}
		return rentDao.listChargesByTenant(parseDate(from), parseDate(to), name);
	}

	public ArrayList<Deposit> DepositsByDateAndName(String from, String to, String name) {
		if (from.isEmpty() || to.isEmpty()) {
			return new ArrayList<Deposit>();
		}
		return rentDao.listDepositsByTenant(parseDate(from), parseDate(to), name);
	}

// =============================================================================================	

	public List<String> fillTenantList() {
		return rentDao.fillTenantDropdown();
	}

	public Date parseDate(String date) {
		try {
			return new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return new Date();
		}
	}

	public String getNameForChargeAndDepositList() {
		return nameForChargeAndDepositList;
	}

	public void setNameForChargeAndDepositList(String nameForChargeAndDepositList) {
		this.nameForChargeAndDepositList = nameForChargeAndDepositList;
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

	public RentDao getRentDao() {
		return rentDao;
	}

	public void setRentDao(RentDao rentDao) {
		this.rentDao = rentDao;
	}

	public String getNameForDebtList() {
		return nameForDebtList;
	}

	public void setNameForDebtList(String nameForDebtList) {
		this.nameForDebtList = nameForDebtList;
	}

}
