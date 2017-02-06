package bean_res;

import java.util.ArrayList;
import java.util.List;

public class CT_Res_ItemDataBean {
	CT_Res_ResultResponseBean response;
	List<CT_Res_ListItemBean> data = new ArrayList<CT_Res_ListItemBean>();
	
	
	public CT_Res_ItemDataBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CT_Res_ItemDataBean(CT_Res_ResultResponseBean response,
			List<CT_Res_ListItemBean> data) {
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


	public List<CT_Res_ListItemBean> getData() {
		return data;
	}


	public void setData(List<CT_Res_ListItemBean> data) {
		this.data = data;
	}
	
	
	
}
