package bean_req;

public class TF_Req_ReportUsedTFBean {
	private String accessToken;
	private int type;
	private String begDate;
	private String endDate;
	private String whCode;
	private String confirmCode;
	private String search;
	
	
	public TF_Req_ReportUsedTFBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TF_Req_ReportUsedTFBean(String accessToken, int type,
			String begDate, String endDate, String whCode, String confirmCode,
			String search) {
		super();
		this.accessToken = accessToken;
		this.type = type;
		this.begDate = begDate;
		this.endDate = endDate;
		this.whCode = whCode;
		this.confirmCode = confirmCode;
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


	public String getBegDate() {
		return begDate;
	}


	public void setBegDate(String begDate) {
		this.begDate = begDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getWhCode() {
		return whCode;
	}


	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}


	public String getConfirmCode() {
		return confirmCode;
	}


	public void setConfirmCode(String confirmCode) {
		this.confirmCode = confirmCode;
	}


	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
