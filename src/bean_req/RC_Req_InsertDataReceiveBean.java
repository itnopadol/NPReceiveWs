package bean_req;

import java.util.List;

public class RC_Req_InsertDataReceiveBean {
	private String accessToken;
	private String docNo;
	private String docDate;
	private String poRefNo;
	private String refDocNo;
	private double sumOfItemAmount;
	private int isCancel;
	private String userID;
	List<RC_Req_ListItemReceiveSubBean> listItem;
	
	
	public RC_Req_InsertDataReceiveBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RC_Req_InsertDataReceiveBean(String accessToken, String docNo,
			String docDate, String poRefNo, String refDocNo,
			double sumOfItemAmount, int isCancel, String userID,
			List<RC_Req_ListItemReceiveSubBean> listItem) {
		super();
		this.accessToken = accessToken;
		this.docNo = docNo;
		this.docDate = docDate;
		this.poRefNo = poRefNo;
		this.refDocNo = refDocNo;
		this.sumOfItemAmount = sumOfItemAmount;
		this.isCancel = isCancel;
		this.userID = userID;
		this.listItem = listItem;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
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


	public String getPoRefNo() {
		return poRefNo;
	}


	public void setPoRefNo(String poRefNo) {
		this.poRefNo = poRefNo;
	}


	public String getRefDocNo() {
		return refDocNo;
	}


	public void setRefDocNo(String refDocNo) {
		this.refDocNo = refDocNo;
	}


	public double getSumOfItemAmount() {
		return sumOfItemAmount;
	}


	public void setSumOfItemAmount(double sumOfItemAmount) {
		this.sumOfItemAmount = sumOfItemAmount;
	}


	public int getIsCancel() {
		return isCancel;
	}


	public void setIsCancel(int isCancel) {
		this.isCancel = isCancel;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public List<RC_Req_ListItemReceiveSubBean> getListItem() {
		return listItem;
	}


	public void setListItem(List<RC_Req_ListItemReceiveSubBean> listItem) {
		this.listItem = listItem;
	}

	
}
