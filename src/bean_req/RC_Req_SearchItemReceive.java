package bean_req;

public class RC_Req_SearchItemReceive {
	private String accessToken;
	private String docNo;
	private int type;
	private String barCode;
	
	
	public RC_Req_SearchItemReceive() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RC_Req_SearchItemReceive(String accessToken, String docNo, int type,
			String barCode) {
		super();
		this.accessToken = accessToken;
		this.docNo = docNo;
		this.type = type;
		this.barCode = barCode;
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


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getBarCode() {
		return barCode;
	}


	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}


}
