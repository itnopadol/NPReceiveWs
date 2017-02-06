package bean_req;

public class TF_Req_InsertStockTransferBean {
	private String accessToken;
	private String docNo;
	private String docDate;
	private int IsCompleteSave;
	private String creatorCode;
	private String refNo;
	private int docType;
	private String myDescription;
	private String confirmCode;
	
	
	public TF_Req_InsertStockTransferBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TF_Req_InsertStockTransferBean(String accessToken, String docNo,
			String docDate, int isCompleteSave, String creatorCode,
			String refNo, int docType, String myDescription, String confirmCode) {
		super();
		this.accessToken = accessToken;
		this.docNo = docNo;
		this.docDate = docDate;
		IsCompleteSave = isCompleteSave;
		this.creatorCode = creatorCode;
		this.refNo = refNo;
		this.docType = docType;
		this.myDescription = myDescription;
		this.confirmCode = confirmCode;
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


	public int getIsCompleteSave() {
		return IsCompleteSave;
	}


	public void setIsCompleteSave(int isCompleteSave) {
		IsCompleteSave = isCompleteSave;
	}


	public String getCreatorCode() {
		return creatorCode;
	}


	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	}


	public String getRefNo() {
		return refNo;
	}


	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}


	public int getDocType() {
		return docType;
	}


	public void setDocType(int docType) {
		this.docType = docType;
	}


	public String getMyDescription() {
		return myDescription;
	}


	public void setMyDescription(String myDescription) {
		this.myDescription = myDescription;
	}


	public String getConfirmCode() {
		return confirmCode;
	}


	public void setConfirmCode(String confirmCode) {
		this.confirmCode = confirmCode;
	}


}
