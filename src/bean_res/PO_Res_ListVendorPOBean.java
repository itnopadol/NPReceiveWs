package bean_res;

import java.util.Date;

public class PO_Res_ListVendorPOBean {
	private String docNo;
	private Date docDate;
	private String apCode;
	private String apName;
	private Date dueDate;
	private Date leadDate;
	private String myDescription;
	private double sumOfItemAmount;
	private double discountAmount;
	private double afterDiscount;
	private double beforeTaxAmount;
	private double taxAmount;
	private double totalAmount;
	
	
	public PO_Res_ListVendorPOBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PO_Res_ListVendorPOBean(String docNo, Date docDate, String apCode,
			String apName, Date dueDate, Date leadDate, String myDescription,
			double sumOfItemAmount, double discountAmount,
			double afterDiscount, double beforeTaxAmount, double taxAmount,
			double totalAmount) {
		super();
		this.docNo = docNo;
		this.docDate = docDate;
		this.apCode = apCode;
		this.apName = apName;
		this.dueDate = dueDate;
		this.leadDate = leadDate;
		this.myDescription = myDescription;
		this.sumOfItemAmount = sumOfItemAmount;
		this.discountAmount = discountAmount;
		this.afterDiscount = afterDiscount;
		this.beforeTaxAmount = beforeTaxAmount;
		this.taxAmount = taxAmount;
		this.totalAmount = totalAmount;
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


	public String getApName() {
		return apName;
	}


	public void setApName(String apName) {
		this.apName = apName;
	}


	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public Date getLeadDate() {
		return leadDate;
	}


	public void setLeadDate(Date leadDate) {
		this.leadDate = leadDate;
	}


	public String getMyDescription() {
		return myDescription;
	}


	public void setMyDescription(String myDescription) {
		this.myDescription = myDescription;
	}


	public double getSumOfItemAmount() {
		return sumOfItemAmount;
	}


	public void setSumOfItemAmount(double sumOfItemAmount) {
		this.sumOfItemAmount = sumOfItemAmount;
	}


	public double getDiscountAmount() {
		return discountAmount;
	}


	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}


	public double getAfterDiscount() {
		return afterDiscount;
	}


	public void setAfterDiscount(double afterDiscount) {
		this.afterDiscount = afterDiscount;
	}


	public double getBeforeTaxAmount() {
		return beforeTaxAmount;
	}


	public void setBeforeTaxAmount(double beforeTaxAmount) {
		this.beforeTaxAmount = beforeTaxAmount;
	}


	public double getTaxAmount() {
		return taxAmount;
	}


	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
