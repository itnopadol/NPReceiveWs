package bean_res;

import java.util.Date;
import java.util.List;

public class PR_Res_SearchStockRequestBean {
	private String docNo;
	private Date wantDate;
	private int status;
	private int diffDate;
	private Date docDate;
	private String personCode;
	List<PR_Res_ListStockRequestBean> listData;
	
	public PR_Res_SearchStockRequestBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PR_Res_SearchStockRequestBean(String docNo, Date wantDate,
			int status, int diffDate, Date docDate, String personCode,
			List<PR_Res_ListStockRequestBean> listData) {
		super();
		this.docNo = docNo;
		this.wantDate = wantDate;
		this.status = status;
		this.diffDate = diffDate;
		this.docDate = docDate;
		this.personCode = personCode;
		this.listData = listData;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public Date getWantDate() {
		return wantDate;
	}

	public void setWantDate(Date wantDate) {
		this.wantDate = wantDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDiffDate() {
		return diffDate;
	}

	public void setDiffDate(int diffDate) {
		this.diffDate = diffDate;
	}

	public Date getDocDate() {
		return docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public List<PR_Res_ListStockRequestBean> getListData() {
		return listData;
	}

	public void setListData(List<PR_Res_ListStockRequestBean> listData) {
		this.listData = listData;
	}
	
	

}
