package bean_res;

import java.util.List;

public class TF_Res_ReportUsedTFBean {
	private CT_Res_ResultResponseBean resp;
	private String docNo;
	private String docDate;
	private String myDescription;
	private int isCancel;
	private String recurName;
	private String refNo;
	private String confirmCode;
	private String confirmName;
	private List<TF_Res_ListReportUsedTFBean> listItem;
	
	
	public TF_Res_ReportUsedTFBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TF_Res_ReportUsedTFBean(CT_Res_ResultResponseBean resp,
			String docNo, String docDate, String myDescription, int isCancel,
			String recurName, String refNo, String confirmCode,
			String confirmName, List<TF_Res_ListReportUsedTFBean> listItem) {
		super();
		this.resp = resp;
		this.docNo = docNo;
		this.docDate = docDate;
		this.myDescription = myDescription;
		this.isCancel = isCancel;
		this.recurName = recurName;
		this.refNo = refNo;
		this.confirmCode = confirmCode;
		this.confirmName = confirmName;
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


	public String getDocDate() {
		return docDate;
	}


	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}


	public String getMyDescription() {
		return myDescription;
	}


	public void setMyDescription(String myDescription) {
		this.myDescription = myDescription;
	}


	public int getIsCancel() {
		return isCancel;
	}


	public void setIsCancel(int isCancel) {
		this.isCancel = isCancel;
	}


	public String getRecurName() {
		return recurName;
	}


	public void setRecurName(String recurName) {
		this.recurName = recurName;
	}


	public String getRefNo() {
		return refNo;
	}


	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}


	public String getConfirmCode() {
		return confirmCode;
	}


	public void setConfirmCode(String confirmCode) {
		this.confirmCode = confirmCode;
	}


	public String getConfirmName() {
		return confirmName;
	}


	public void setConfirmName(String confirmName) {
		this.confirmName = confirmName;
	}


	public List<TF_Res_ListReportUsedTFBean> getListItem() {
		return listItem;
	}


	public void setListItem(List<TF_Res_ListReportUsedTFBean> listItem) {
		this.listItem = listItem;
	}


}
