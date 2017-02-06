package bean_res;

public class RC_Res_ListSearchItemBean {
	private String itemCode;
	private String barCode;
	private String itemName;
	private String unitCode; 
	private double price;
	private double qtyRC;
	
	
	public RC_Res_ListSearchItemBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RC_Res_ListSearchItemBean(String itemCode, String barCode,
			String itemName, String unitCode, double price, double qtyRC) {
		super();
		this.itemCode = itemCode;
		this.barCode = barCode;
		this.itemName = itemName;
		this.unitCode = unitCode;
		this.price = price;
		this.qtyRC = qtyRC;
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


	public String getUnitCode() {
		return unitCode;
	}


	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getQtyRC() {
		return qtyRC;
	}


	public void setQtyRC(double qtyRC) {
		this.qtyRC = qtyRC;
	}
	
	
}
