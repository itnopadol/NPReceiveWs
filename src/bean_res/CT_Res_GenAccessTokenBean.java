package bean_res;

public class CT_Res_GenAccessTokenBean {
	CT_Res_ResultResponseBean resp;
	private String userID;
	private String saleCode;
	private String accessToken;
	private String accessDatetime;
	private String dataBaseName;
	private String serverName;
	
	
	public CT_Res_GenAccessTokenBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CT_Res_GenAccessTokenBean(CT_Res_ResultResponseBean resp,
			String userID, String saleCode, String accessToken,
			String accessDatetime, String dataBaseName, String serverName) {
		super();
		this.resp = resp;
		this.userID = userID;
		this.saleCode = saleCode;
		this.accessToken = accessToken;
		this.accessDatetime = accessDatetime;
		this.dataBaseName = dataBaseName;
		this.serverName = serverName;
	}


	public CT_Res_ResultResponseBean getResp() {
		return resp;
	}


	public void setResp(CT_Res_ResultResponseBean resp) {
		this.resp = resp;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getSaleCode() {
		return saleCode;
	}


	public void setSaleCode(String saleCode) {
		this.saleCode = saleCode;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public String getAccessDatetime() {
		return accessDatetime;
	}


	public void setAccessDatetime(String accessDatetime) {
		this.accessDatetime = accessDatetime;
	}


	public String getDataBaseName() {
		return dataBaseName;
	}


	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}


	public String getServerName() {
		return serverName;
	}


	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	
	
	
}
