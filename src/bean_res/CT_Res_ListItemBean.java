package bean_res;

public class CT_Res_ListItemBean {
	private String barCode;
	private String itemCode;
	private String itemName;
	private String unitCode;
	private double salePrice1;
	private double stkRemain;
	
	
	public CT_Res_ListItemBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CT_Res_ListItemBean(String barCode, String itemCode,
			String itemName, String unitCode, double salePrice1,
			double stkRemain) {
		super();
		this.barCode = barCode;
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unitCode = unitCode;
		this.salePrice1 = salePrice1;
		this.stkRemain = stkRemain;
	}


	public String getBarCode() {
		return barCode;
	}


	public void setBarCode(String barCode) {
		this.barCode = barCode;
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


	public String getUnitCode() {
		return unitCode;
	}


	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}


	public double getSalePrice1() {
		return salePrice1;
	}


	public void setSalePrice1(double salePrice1) {
		this.salePrice1 = salePrice1;
	}


	public double getStkRemain() {
		return stkRemain;
	}


	public void setStkRemain(double stkRemain) {
		this.stkRemain = stkRemain;
	}
	
	
}
