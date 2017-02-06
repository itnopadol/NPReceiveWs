package bean_req;

import java.util.Date;

public class PR_Req_InsertStockRequestBean {
	private String docNo;
	private Date docDate;
	private String personCode;
	
	
	public PR_Req_InsertStockRequestBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PR_Req_InsertStockRequestBean(String docNo, Date docDate,
			String personCode) {
		super();
		this.docNo = docNo;
		this.docDate = docDate;
		this.personCode = personCode;
	}


	public String getDocNo() {
		return docNo;
	}


	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}


	public Date getDocDate() {
		return docDate;
	}


	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}
	
	public String getPersonCode(){
		return personCode;
	}
	
	public void setPersonCode(String personCode){
		this.personCode = personCode;
	}
}
