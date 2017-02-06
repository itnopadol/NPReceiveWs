package bean_res;

public class TF_Res_ListStkTransferBean {
	private String docNo;
	private int isConfirm;
	private String docDate;
	private String myDescription;
	private double SumOfQty;
	private int isCancel;
	private int isCompleteSave;
	private double sumOfAmount;
	private String refDocNo;
	private int docType;
	
	
	public TF_Res_ListStkTransferBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TF_Res_ListStkTransferBean(String docNo, int isConfirm,
			String docDate, String myDescription, double sumOfQty,
			int isCancel, int isCompleteSave, double sumOfAmount,
			String refDocNo, int docType) {
		super();
		this.docNo = docNo;
		this.isConfirm = isConfirm;
		this.docDate = docDate;
		this.myDescription = myDescription;
		SumOfQty = sumOfQty;
		this.isCancel = isCancel;
		this.isCompleteSave = isCompleteSave;
		this.sumOfAmount = sumOfAmount;
		this.refDocNo = refDocNo;
		this.docType = docType;
	}


	public String getDocNo() {
		return docNo;
	}


	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}


	public int getIsConfirm() {
		return isConfirm;
	}


	public void setIsConfirm(int isConfirm) {
		this.isConfirm = isConfirm;
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


	public double getSumOfQty() {
		return SumOfQty;
	}


	public void setSumOfQty(double sumOfQty) {
		SumOfQty = sumOfQty;
	}


	public int getIsCancel() {
		return isCancel;
	}


	public void setIsCancel(int isCancel) {
		this.isCancel = isCancel;
	}


	public int getIsCompleteSave() {
		return isCompleteSave;
	}


	public void setIsCompleteSave(int isCompleteSave) {
		this.isCompleteSave = isCompleteSave;
	}


	public double getSumOfAmount() {
		return sumOfAmount;
	}


	public void setSumOfAmount(double sumOfAmount) {
		this.sumOfAmount = sumOfAmount;
	}


	public String getRefDocNo() {
		return refDocNo;
	}


	public void setRefDocNo(String refDocNo) {
		this.refDocNo = refDocNo;
	}


	public int getDocType() {
		return docType;
	}


	public void setDocType(int docType) {
		this.docType = docType;
	}


}
