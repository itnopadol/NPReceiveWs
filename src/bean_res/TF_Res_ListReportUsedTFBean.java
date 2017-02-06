package bean_res;

public class TF_Res_ListReportUsedTFBean {
	private String itemCode;
	private String barCode;
	private String itemName;
	private String fromWH;
	private String fromShelf;
	private String toWH;
	private String ToShelf;
	private double qty;
	private String unitCode;
	
	
	public TF_Res_ListReportUsedTFBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TF_Res_ListReportUsedTFBean(String itemCode, String barCode,
			String itemName, String fromWH, String fromShelf, String toWH,
			String toShelf, double qty, String unitCode) {
		super();
		this.itemCode = itemCode;
		this.barCode = barCode;
		this.itemName = itemName;
		this.fromWH = fromWH;
		this.fromShelf = fromShelf;
		this.toWH = toWH;
		ToShelf = toShelf;
		this.qty = qty;
		this.unitCode = unitCode;
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
		return ToShelf;
	}


	public void setToShelf(String toShelf) {
		ToShelf = toShelf;
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


	
}
