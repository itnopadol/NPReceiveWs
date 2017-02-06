package bean_res;

public class RC_Res_ListRecieveItemBean {
	private String BarCode;
	private String ItemCode;
	private String ItemName;
	private double Qty;
	private String UnitCode;
	private String PORefNo;
	private int LineNumber;
	private int status;
	private int isCancel;
	
	
	public RC_Res_ListRecieveItemBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RC_Res_ListRecieveItemBean(String barCode, String itemCode,
			String itemName, double qty, String unitCode, String pORefNo,
			int lineNumber, int status, int isCancel) {
		super();
		BarCode = barCode;
		ItemCode = itemCode;
		ItemName = itemName;
		Qty = qty;
		UnitCode = unitCode;
		PORefNo = pORefNo;
		LineNumber = lineNumber;
		this.status = status;
		this.isCancel = isCancel;
	}


	public String getBarCode() {
		return BarCode;
	}


	public void setBarCode(String barCode) {
		BarCode = barCode;
	}


	public String getItemCode() {
		return ItemCode;
	}


	public void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}


	public String getItemName() {
		return ItemName;
	}


	public void setItemName(String itemName) {
		ItemName = itemName;
	}


	public double getQty() {
		return Qty;
	}


	public void setQty(double qty) {
		Qty = qty;
	}


	public String getUnitCode() {
		return UnitCode;
	}


	public void setUnitCode(String unitCode) {
		UnitCode = unitCode;
	}


	public String getPORefNo() {
		return PORefNo;
	}


	public void setPORefNo(String pORefNo) {
		PORefNo = pORefNo;
	}


	public int getLineNumber() {
		return LineNumber;
	}


	public void setLineNumber(int lineNumber) {
		LineNumber = lineNumber;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getIsCancel() {
		return isCancel;
	}


	public void setIsCancel(int isCancel) {
		this.isCancel = isCancel;
	}


}
