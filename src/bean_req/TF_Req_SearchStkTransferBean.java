package bean_req;

public class TF_Req_SearchStkTransferBean {
	private String accessToken;
	private String docNo;
	private String refNo;
	private String userID;
	
	
	public TF_Req_SearchStkTransferBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TF_Req_SearchStkTransferBean(String accessToken, String docNo,
			String refNo, String userID) {
		super();
		this.accessToken = accessToken;
		this.docNo = docNo;
		this.refNo = refNo;
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


	public String getRefNo() {
		return refNo;
	}


	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}

	
}
