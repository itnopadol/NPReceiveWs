package bean_res;

public class CT_Res_DataResultBean {
	CT_Res_ResultResponseBean response;
	private String data;
	
	
	public CT_Res_DataResultBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CT_Res_DataResultBean(CT_Res_ResultResponseBean response, String data) {
		super();
		this.response = response;
		this.data = data;
	}


	public CT_Res_ResultResponseBean getResponse() {
		return response;
	}


	public void setResponse(CT_Res_ResultResponseBean response) {
		this.response = response;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}
	
	
}
