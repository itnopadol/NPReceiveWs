package bean_res;

public class CT_Res_ListItemDataBean {
	private String itemCode;
	private String barCode;
	private String itemName;
	private String whCode;
	private String shelfCode;
	private double qty;
	private double remainQty;
	private double price;
	private String discountWord;
	private double discountAmount;
	private double amount;
	private String unitCode;
	private double rcQty;
	private int status;
	private int isListCancel;
	private String myDescription;
	
	public CT_Res_ListItemDataBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CT_Res_ListItemDataBean(String itemCode, String barCode,
			String itemName, String whCode, String shelfCode, double qty,
			double remainQty, double price, String discountWord,
			double discountAmount, double amount, String unitCode,
			double rcQty, int status, int isListCancel, String myDescription) {
		super();
		this.itemCode = itemCode;
		this.barCode = barCode;
		this.itemName = itemName;
		this.whCode = whCode;
		this.shelfCode = shelfCode;
		this.qty = qty;
		this.remainQty = remainQty;
		this.price = price;
		this.discountWord = discountWord;
		this.discountAmount = discountAmount;
		this.amount = amount;
		this.unitCode = unitCode;
		this.rcQty = rcQty;
		this.status = status;
		this.isListCancel = isListCancel;
		this.myDescription = myDescription;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public double getRemainQty() {
		return remainQty;
	}

	public void setRemainQty(double remainQty) {
		this.remainQty = remainQty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDiscountWord() {
		return discountWord;
	}

	public void setDiscountWord(String discountWord) {
		this.discountWord = discountWord;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public double getRcQty() {
		return rcQty;
	}

	public void setRcQty(double rcQty) {
		this.rcQty = rcQty;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsListCancel() {
		return isListCancel;
	}

	public void setIsListCancel(int isListCancel) {
		this.isListCancel = isListCancel;
	}

	public String getMyDescription() {
		return myDescription;
	}

	public void setMyDescription(String myDescription) {
		this.myDescription = myDescription;
	}

	
}
