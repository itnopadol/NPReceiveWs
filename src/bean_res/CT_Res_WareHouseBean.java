package bean_res;

import java.util.ArrayList;
import java.util.List;

public class CT_Res_WareHouseBean {
	CT_Res_ResultResponseBean response;
	List<CT_Res_ListWareHouseBean> data = new ArrayList<CT_Res_ListWareHouseBean>();
	
	
	public CT_Res_WareHouseBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CT_Res_WareHouseBean(CT_Res_ResultResponseBean response,
			List<CT_Res_ListWareHouseBean> data) {
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


	public List<CT_Res_ListWareHouseBean> getData() {
		return data;
	}


	public void setData(List<CT_Res_ListWareHouseBean> data) {
		this.data = data;
	}
	
	
	
}
