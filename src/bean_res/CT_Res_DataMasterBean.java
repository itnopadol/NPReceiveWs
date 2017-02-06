package bean_res;

import java.util.List;

public class CT_Res_DataMasterBean {
	CT_Res_ResultResponseBean response;
	List<CT_Res_ListMasterDataBean> listData;
	
	
	public CT_Res_DataMasterBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CT_Res_DataMasterBean(CT_Res_ResultResponseBean response,
			List<CT_Res_ListMasterDataBean> listData) {
		super();
		this.response = response;
		this.listData = listData;
	}


	public CT_Res_ResultResponseBean getResponse() {
		return response;
	}


	public void setResponse(CT_Res_ResultResponseBean response) {
		this.response = response;
	}


	public List<CT_Res_ListMasterDataBean> getListData() {
		return listData;
	}


	public void setListData(List<CT_Res_ListMasterDataBean> listData) {
		this.listData = listData;
	}
	
}
