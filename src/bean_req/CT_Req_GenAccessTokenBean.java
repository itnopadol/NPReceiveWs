package bean_req;

public class CT_Req_GenAccessTokenBean {
	private String companyCode;
	private String saleCode;
	private String password;
	
	
	public CT_Req_GenAccessTokenBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CT_Req_GenAccessTokenBean(String companyCode, String saleCode,
			String password) {
		super();
		this.companyCode = companyCode;
		this.saleCode = saleCode;
		this.password = password;
	}


	public String getCompanyCode() {
		return companyCode;
	}


	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}


	public String getSaleCode() {
		return saleCode;
	}


	public void setSaleCode(String saleCode) {
		this.saleCode = saleCode;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
