package bean_req;

public class RC_Req_SearchReceiveDetailsBean {
	private String accessToken;
	private String docNo;
	private String recNo;
	
	
	public RC_Req_SearchReceiveDetailsBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RC_Req_SearchReceiveDetailsBean(String accessToken, String docNo,
			String recNo) {
		super();
		this.accessToken = accessToken;
		this.docNo = docNo;
		this.recNo = recNo;
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


	public String getRecNo() {
		return recNo;
	}


	public void setRecNo(String recNo) {
		this.recNo = recNo;
	}


	
	
}
