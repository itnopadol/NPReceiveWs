package bean_req;

public class RC_Req_ListItemReceiveSubBean {
	private String barCode;
	private double qty;
	private String unitCode;
	private String whCode;
	private String shelfCode;
	private int isCancel;
	private int statusRec;
	private String myDescription;

	public RC_Req_ListItemReceiveSubBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RC_Req_ListItemReceiveSubBean(String barCode, double qty,
			String unitCode, String whCode, String shelfCode, int isCancel,
			int statusRec, String myDescription) {
		super();
		this.barCode = barCode;
		this.qty = qty;
		this.unitCode = unitCode;
		this.whCode = whCode;
		this.shelfCode = shelfCode;
		this.isCancel = isCancel;
		this.statusRec = statusRec;
		this.myDescription = myDescription;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}

	public String getShelfCode() {
		return shelfCode;
	}

	public void setShelfCode(String shelfCode) {
		this.shelfCode = shelfCode;
	}

	public int getIsCancel() {
		return isCancel;
	}

	public void setIsCancel(int isCancel) {
		this.isCancel = isCancel;
	}

	public int getStatusRec() {
		return statusRec;
	}

	public void setStatusRec(int statusRec) {
		this.statusRec = statusRec;
	}

	public String getMyDescription() {
		return myDescription;
	}

	public void setMyDescription(String myDescription) {
		this.myDescription = myDescription;
	}

	
}
