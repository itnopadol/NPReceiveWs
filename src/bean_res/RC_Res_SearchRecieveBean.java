package bean_res;

import java.util.List;

public class RC_Res_SearchRecieveBean {
	CT_Res_ResultResponseBean resp;
	List<RC_Res_ListSearchRecieveBean> details;
	
	
	public RC_Res_SearchRecieveBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RC_Res_SearchRecieveBean(CT_Res_ResultResponseBean resp,
			List<RC_Res_ListSearchRecieveBean> details) {
		super();
		this.resp = resp;
		this.details = details;
	}


	public CT_Res_ResultResponseBean getResp() {
		return resp;
	}


	public void setResp(CT_Res_ResultResponseBean resp) {
		this.resp = resp;
	}


	public List<RC_Res_ListSearchRecieveBean> getDetails() {
		return details;
	}


	public void setDetails(List<RC_Res_ListSearchRecieveBean> details) {
		this.details = details;
	}
	
	
}
