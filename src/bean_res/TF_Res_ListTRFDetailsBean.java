package bean_res;

public class TF_Res_ListTRFDetailsBean {
	private String itemCode;
	private String itemName;
	private String fromWH;
	private String fromShelf;
	private String toWH;
	private String toShelf;
	private double qty;
	private String unitCode;
	private String barCode;
	private String refNo;
	private double amount;
	private double price;
	private double sumOfCost;
	private int lineNumber;
	private int isCancel;
	private String pickCode;
	private String pickName;
	
	
	public TF_Res_ListTRFDetailsBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TF_Res_ListTRFDetailsBean(String itemCode, String itemName,
			String fromWH, String fromShelf, String toWH, String toShelf,
			double qty, String unitCode, String barCode, String refNo,
			double amount, double price, double sumOfCost, int lineNumber,
			int isCancel, String pickCode, String pickName) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.fromWH = fromWH;
		this.fromShelf = fromShelf;
		this.toWH = toWH;
		this.toShelf = toShelf;
		this.qty = qty;
		this.unitCode = unitCode;
		this.barCode = barCode;
		this.refNo = refNo;
		this.amount = amount;
		this.price = price;
		this.sumOfCost = sumOfCost;
		this.lineNumber = lineNumber;
		this.isCancel = isCancel;
		this.pickCode = pickCode;
		this.pickName = pickName;
	}


	public String getItemCode() {
		return itemCode;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getFromWH() {
		return fromWH;
	}


	public void setFromWH(String fromWH) {
		this.fromWH = fromWH;
	}


	public String getFromShelf() {
		return fromShelf;
	}


	public void setFromShelf(String fromShelf) {
		this.fromShelf = fromShelf;
	}


	public String getToWH() {
		return toWH;
	}


	public void setToWH(String toWH) {
		this.toWH = toWH;
	}


	public String getToShelf() {
		return toShelf;
	}


	public void setToShelf(String toShelf) {
		this.toShelf = toShelf;
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


	public String getBarCode() {
		return barCode;
	}


	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}


	public String getRefNo() {
		return refNo;
	}


	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getSumOfCost() {
		return sumOfCost;
	}


	public void setSumOfCost(double sumOfCost) {
		this.sumOfCost = sumOfCost;
	}


	public int getLineNumber() {
		return lineNumber;
	}


	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}


	public int getIsCancel() {
		return isCancel;
	}


	public void setIsCancel(int isCancel) {
		this.isCancel = isCancel;
	}


	public String getPickCode() {
		return pickCode;
	}


	public void setPickCode(String pickCode) {
		this.pickCode = pickCode;
	}


	public String getPickName() {
		return pickName;
	}


	public void setPickName(String pickName) {
		this.pickName = pickName;
	}


}
