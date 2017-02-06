package bean_res;

import java.util.List;

public class TF_Res_SearchStkTransferBean {
	CT_Res_ResultResponseBean response;
	List<TF_Res_ListStkTransferBean> data;
	
	
	public TF_Res_SearchStkTransferBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TF_Res_SearchStkTransferBean(CT_Res_ResultResponseBean response,
			List<TF_Res_ListStkTransferBean> data) {
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


	public List<TF_Res_ListStkTransferBean> getData() {
		return data;
	}


	public void setData(List<TF_Res_ListStkTransferBean> data) {
		this.data = data;
	}
	
	
}
