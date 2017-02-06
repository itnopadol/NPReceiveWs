package bean_req;

public class PR_Req_SearchStockRequestBean {
	private int type;
	private String search;
	
	
	public PR_Req_SearchStockRequestBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PR_Req_SearchStockRequestBean(int type, String search) {
		super();
		this.type = type;
		this.search = search;
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
