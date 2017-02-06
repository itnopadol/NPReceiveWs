package bean_res;

public class RC_Res_InsertReceiveItemBean {
	CT_Res_ResultResponseBean resp;
	private int itemCount;
	
	
	public RC_Res_InsertReceiveItemBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RC_Res_InsertReceiveItemBean(CT_Res_ResultResponseBean resp,
			int itemCount) {
		super();
		this.resp = resp;
		this.itemCount = itemCount;
	}


	public CT_Res_ResultResponseBean getResp() {
		return resp;
	}


	public void setResp(CT_Res_ResultResponseBean resp) {
		this.resp = resp;
	}


	public int getItemCount() {
		return itemCount;
	}


	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}


}
