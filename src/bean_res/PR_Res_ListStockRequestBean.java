package bean_res;


public class PR_Res_ListStockRequestBean {
	private String itemCode;
	private String itemName;
	private int qty;
	
	public PR_Res_ListStockRequestBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PR_Res_ListStockRequestBean(String itemCode, String itemName, int qty) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.qty = qty;
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	
}
