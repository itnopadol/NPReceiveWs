package bean_req;

public class CT_Req_SearchTypeBean {
	private String accessToken;
	private int type;
	private String search;
	
	
	public CT_Req_SearchTypeBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CT_Req_SearchTypeBean(String accessToken, int type, String search) {
		super();
		this.accessToken = accessToken;
		this.type = type;
		this.search = search;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
