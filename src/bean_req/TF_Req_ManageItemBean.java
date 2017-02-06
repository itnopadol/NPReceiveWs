package bean_req;

public class TF_Req_ManageItemBean {
	private String accessToken;
	private String docNo;
	private String barCode;
	private String itemCode;
	private String docDate;
	private String fromWHCode;
	private String fromShelfCode;
	private String toWHCode;
	private String toShelfCode;
	private double qty;
	private String refNo;
	private int isCancel;
	private String pickCode;
	
	
	public TF_Req_ManageItemBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TF_Req_ManageItemBean(String accessToken, String docNo,
			String barCode, String itemCode, String docDate, String fromWHCode,
			String fromShelfCode, String toWHCode, String toShelfCode,
			double qty, String refNo, int isCancel, String pickCode) {
		super();
		this.accessToken = accessToken;
		this.docNo = docNo;
		this.barCode = barCode;
		this.itemCode = itemCode;
		this.docDate = docDate;
		this.fromWHCode = fromWHCode;
		this.fromShelfCode = fromShelfCode;
		this.toWHCode = toWHCode;
		this.toShelfCode = toShelfCode;
		this.qty = qty;
		this.refNo = refNo;
		this.isCancel = isCancel;
		this.pickCode = pickCode;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public String getDocNo() {
		return docNo;
	}


	public void setDocNo(String docNo) {
		this.docNo = docNo;
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


	public String getDocDate() {
		return docDate;
	}


	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}


	public String getFromWHCode() {
		return fromWHCode;
	}


	public void setFromWHCode(String fromWHCode) {
		this.fromWHCode = fromWHCode;
	}


	public String getFromShelfCode() {
		return fromShelfCode;
	}


	public void setFromShelfCode(String fromShelfCode) {
		this.fromShelfCode = fromShelfCode;
	}


	public String getToWHCode() {
		return toWHCode;
	}


	public void setToWHCode(String toWHCode) {
		this.toWHCode = toWHCode;
	}


	public String getToShelfCode() {
		return toShelfCode;
	}


	public void setToShelfCode(String toShelfCode) {
		this.toShelfCode = toShelfCode;
	}


	public double getQty() {
		return qty;
	}


	public void setQty(double qty) {
		this.qty = qty;
	}


	public String getRefNo() {
		return refNo;
	}


	public void setRefNo(String refNo) {
		this.refNo = refNo;
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


	

}
