package bean_res;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RC_Res_ReceiveDataBean {
	CT_Res_ResultResponseBean resp;
	private String docNo;
	private Date docDate;
	private String apCode;
	private double sumOfItemAmount;
	List<RC_Res_ListRecieveItemBean> listItem = new ArrayList<RC_Res_ListRecieveItemBean>();
	
	public RC_Res_ReceiveDataBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RC_Res_ReceiveDataBean(CT_Res_ResultResponseBean resp, String docNo,
			Date docDate, String apCode, double sumOfItemAmount,
			List<RC_Res_ListRecieveItemBean> listItem) {
		super();
		this.resp = resp;
		this.docNo = docNo;
		this.docDate = docDate;
		this.apCode = apCode;
		this.sumOfItemAmount = sumOfItemAmount;
		this.listItem = listItem;
	}

	public CT_Res_ResultResponseBean getResp() {
		return resp;
	}

	public void setResp(CT_Res_ResultResponseBean resp) {
		this.resp = resp;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public Date getDocDate() {
		return docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public String getApCode() {
		return apCode;
	}

	public void setApCode(String apCode) {
		this.apCode = apCode;
	}

	public double getSumOfItemAmount() {
		return sumOfItemAmount;
	}

	public void setSumOfItemAmount(double sumOfItemAmount) {
		this.sumOfItemAmount = sumOfItemAmount;
	}

	public List<RC_Res_ListRecieveItemBean> getListItem() {
		return listItem;
	}

	public void setListItem(List<RC_Res_ListRecieveItemBean> listItem) {
		this.listItem = listItem;
	}

	
}
