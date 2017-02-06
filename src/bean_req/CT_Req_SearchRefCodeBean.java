package bean_req;

public class CT_Req_SearchRefCodeBean {
	private String accessToken;
	private String refCode;
	private String search;
	
	
	public CT_Req_SearchRefCodeBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CT_Req_SearchRefCodeBean(String accessToken, String refCode,
			String search) {
		super();
		this.accessToken = accessToken;
		this.refCode = refCode;
		this.search = search;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public String getRefCode() {
		return refCode;
	}


	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}


	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
