package bean_res;

import java.util.ArrayList;
import java.util.List;

public class PO_Res_VendorPOBean {
	private CT_Res_ResultResponseBean resp;
	List<PO_Res_ListVendorPOBean> listPO = new ArrayList<PO_Res_ListVendorPOBean>();
	
	
	public PO_Res_VendorPOBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PO_Res_VendorPOBean(CT_Res_ResultResponseBean resp,
			List<PO_Res_ListVendorPOBean> listPO) {
		super();
		this.resp = resp;
		this.listPO = listPO;
	}


	public CT_Res_ResultResponseBean getResp() {
		return resp;
	}


	public void setResp(CT_Res_ResultResponseBean resp) {
		this.resp = resp;
	}


	public List<PO_Res_ListVendorPOBean> getListPO() {
		return listPO;
	}


	public void setListPO(List<PO_Res_ListVendorPOBean> listPO) {
		this.listPO = listPO;
	}


}
