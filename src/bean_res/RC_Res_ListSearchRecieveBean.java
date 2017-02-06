package bean_res;

import java.util.Date;

public class RC_Res_ListSearchRecieveBean {
	private String recNo;
	private Date docDate;
	private String apCode;
	private String apName;
	private double sumOfItemAmount;
	private String poRefNo;
	private String myDescription;
	private int isCancel;
	public int isConfirm;
	
	
	public RC_Res_ListSearchRecieveBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RC_Res_ListSearchRecieveBean(String recNo, Date docDate,
			String apCode, String apName, double sumOfItemAmount,
			String poRefNo, String myDescription, int isCancel, int isConfirm) {
		super();
		this.recNo = recNo;
		this.docDate = docDate;
		this.apCode = apCode;
		this.apName = apName;
		this.sumOfItemAmount = sumOfItemAmount;
		this.poRefNo = poRefNo;
		this.myDescription = myDescription;
		this.isCancel = isCancel;
		this.isConfirm = isConfirm;
	}


	public String getRecNo() {
		return recNo;
	}


	public void setRecNo(String recNo) {
		this.recNo = recNo;
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


	public String getApName() {
		return apName;
	}


	public void setApName(String apName) {
		this.apName = apName;
	}


	public double getSumOfItemAmount() {
		return sumOfItemAmount;
	}


	public void setSumOfItemAmount(double sumOfItemAmount) {
		this.sumOfItemAmount = sumOfItemAmount;
	}


	public String getPoRefNo() {
		return poRefNo;
	}


	public void setPoRefNo(String poRefNo) {
		this.poRefNo = poRefNo;
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


	public int getIsConfirm() {
		return isConfirm;
	}


	public void setIsConfirm(int isConfirm) {
		this.isConfirm = isConfirm;
	}


}
