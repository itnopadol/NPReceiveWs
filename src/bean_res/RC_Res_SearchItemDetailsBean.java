package bean_res;

import java.util.List;

public class RC_Res_SearchItemDetailsBean {
	CT_Res_ResultResponseBean resp;
	List<RC_Res_ListSearchItemBean> item;
	
	
	public RC_Res_SearchItemDetailsBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RC_Res_SearchItemDetailsBean(CT_Res_ResultResponseBean resp,
			List<RC_Res_ListSearchItemBean> item) {
		super();
		this.resp = resp;
		this.item = item;
	}


	public CT_Res_ResultResponseBean getResp() {
		return resp;
	}


	public void setResp(CT_Res_ResultResponseBean resp) {
		this.resp = resp;
	}


	public List<RC_Res_ListSearchItemBean> getItem() {
		return item;
	}


	public void setItem(List<RC_Res_ListSearchItemBean> item) {
		this.item = item;
	}


	
}
