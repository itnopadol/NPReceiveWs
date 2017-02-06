package bean_req;

public class CT_Req_SearchCenterBean {
	private String accessToken;
	private String search;
	
	
	public CT_Req_SearchCenterBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CT_Req_SearchCenterBean(String accessToken, String search) {
		super();
		this.accessToken = accessToken;
		this.search = search;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
