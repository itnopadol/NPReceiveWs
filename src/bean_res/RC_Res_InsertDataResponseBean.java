package bean_res;

public class RC_Res_InsertDataResponseBean {
	CT_Res_ResultResponseBean resp;
	private String docNo;
	
	
	public RC_Res_InsertDataResponseBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RC_Res_InsertDataResponseBean(CT_Res_ResultResponseBean resp,
			String docNo) {
		super();
		this.resp = resp;
		this.docNo = docNo;
	}


	public CT_Res_ResultResponseBean getResp() {
		return resp;
	}


	public void setResp(CT_Res_ResultResponseBean resp) {
		this.resp = resp;
	}


	public String getDocNo() {
		return docNo;
	}


	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}



}
