package bean_req;

public class RC_Req_InsertReceiveSubBean {
	private String accessToken;
	private String docNo;
	private String docDate;
	private String poRefNo;
	private String barCode;
	private double Qty;
	private int isCancel;
	private String userID;
	
	
	public RC_Req_InsertReceiveSubBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RC_Req_InsertReceiveSubBean(String accessToken, String docNo,
			String docDate, String poRefNo, String barCode, double qty,
			int isCancel, String userID) {
		super();
		this.accessToken = accessToken;
		this.docNo = docNo;
		this.docDate = docDate;
		this.poRefNo = poRefNo;
		this.barCode = barCode;
		Qty = qty;
		this.isCancel = isCancel;
		this.userID = userID;
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


	public String getDocDate() {
		return docDate;
	}


	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}


	public String getPoRefNo() {
		return poRefNo;
	}


	public void setPoRefNo(String poRefNo) {
		this.poRefNo = poRefNo;
	}


	public String getBarCode() {
		return barCode;
	}


	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}


	public double getQty() {
		return Qty;
	}


	public void setQty(double qty) {
		Qty = qty;
	}


	public int getIsCancel() {
		return isCancel;
	}


	public void setIsCancel(int isCancel) {
		this.isCancel = isCancel;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}



}
