package bean_res;

import java.util.List;

public class PO_Res_VendorNotReceiptBean {
	private CT_Res_ResultResponseBean resp;
	List<PO_Res_ListVendorNotReceiptBean> apList;
	
	public PO_Res_VendorNotReceiptBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PO_Res_VendorNotReceiptBean(CT_Res_ResultResponseBean resp,
			List<PO_Res_ListVendorNotReceiptBean> apList) {
		super();
		this.resp = resp;
		this.apList = apList;
	}

	public CT_Res_ResultResponseBean getResp() {
		return resp;
	}

	public void setResp(CT_Res_ResultResponseBean resp) {
		this.resp = resp;
	}

	public List<PO_Res_ListVendorNotReceiptBean> getApList() {
		return apList;
	}

	public void setApList(List<PO_Res_ListVendorNotReceiptBean> apList) {
		this.apList = apList;
	}


}
