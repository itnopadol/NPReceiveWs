package bean_res;

public class CT_Res_ListWareHouseBean {
	private String code;
	private String name;
	private String location;
	
	
	public CT_Res_ListWareHouseBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CT_Res_ListWareHouseBean(String code, String name, String location) {
		super();
		this.code = code;
		this.name = name;
		this.location = location;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
