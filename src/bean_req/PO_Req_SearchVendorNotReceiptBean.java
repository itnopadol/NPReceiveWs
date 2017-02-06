package bean_req;

public class PO_Req_SearchVendorNotReceiptBean {
	private String accessToken;
	private String search;
	
	
	public PO_Req_SearchVendorNotReceiptBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PO_Req_SearchVendorNotReceiptBean(String accessToken, String search) {
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
