package bean_req;

public class CT_Req_SearchStockWareHouseBean {
	private String accessToken;
	private int type;
	private String whCode;
	private String shelf;
	private String search;
	
	
	public CT_Req_SearchStockWareHouseBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CT_Req_SearchStockWareHouseBean(String accessToken,int type, String whCode,
			String shelf, String search) {
		super();
		this.accessToken = accessToken;
		this.type = type;
		this.whCode = whCode;
		this.shelf = shelf;
		this.search = search;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public String getWhCode() {
		return whCode;
	}


	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}


	public String getShelf() {
		return shelf;
	}


	public void setShelf(String shelf) {
		this.shelf = shelf;
	}


	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
