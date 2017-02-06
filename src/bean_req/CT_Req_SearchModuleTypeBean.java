package bean_req;

public class CT_Req_SearchModuleTypeBean {
	private String accessToken;
	private String module;
	private int type;
	private String search;
	
	
	public CT_Req_SearchModuleTypeBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CT_Req_SearchModuleTypeBean(String accessToken, String module,
			int type, String search) {
		super();
		this.accessToken = accessToken;
		this.module = module;
		this.type = type;
		this.search = search;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public String getModule() {
		return module;
	}


	public void setModule(String module) {
		this.module = module;
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
