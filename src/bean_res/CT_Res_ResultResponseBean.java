package bean_res;

public class CT_Res_ResultResponseBean {
	private int isSuccess;
	private String processName;
	private String processDesc;
	
	
	public CT_Res_ResultResponseBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CT_Res_ResultResponseBean(int isSuccess, String processName,
			String processDesc) {
		super();
		this.isSuccess = isSuccess;
		this.processName = processName;
		this.processDesc = processDesc;
	}


	public int getIsSuccess() {
		return isSuccess;
	}


	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}


	public String getProcessName() {
		return processName;
	}


	public void setProcessName(String processName) {
		this.processName = processName;
	}


	public String getProcessDesc() {
		return processDesc;
	}


	public void setProcessDesc(String processDesc) {
		this.processDesc = processDesc;
	}
	
	
}
