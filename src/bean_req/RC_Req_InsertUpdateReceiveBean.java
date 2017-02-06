package bean_req;

import java.util.List;

public class RC_Req_InsertUpdateReceiveBean {
	private String accessToken;
	private String docNo;
	private String docDate;
	private String poRefNo;
	private String refDocNo;
	private int isCompleteSave;
	private String userID;
	
	
	public RC_Req_InsertUpdateReceiveBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RC_Req_InsertUpdateReceiveBean(String accessToken, String docNo,
			String docDate, String poRefNo, String refDocNo,
			int isCompleteSave, String userID) {
		super();
		this.accessToken = accessToken;
		this.docNo = docNo;
		this.docDate = docDate;
		this.poRefNo = poRefNo;
		this.refDocNo = refDocNo;
		this.isCompleteSave = isCompleteSave;
		this.userID = userID;
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


	public int getIsCompleteSave() {
		return isCompleteSave;
	}


	public void setIsCompleteSave(int isCompleteSave) {
		this.isCompleteSave = isCompleteSave;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	
}
