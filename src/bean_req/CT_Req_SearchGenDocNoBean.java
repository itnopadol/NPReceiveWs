package bean_req;

public class CT_Req_SearchGenDocNoBean {
		private String accessToken;
		private String module;
		private String tableName;
		private int type;
		private String header;
		
		
		public CT_Req_SearchGenDocNoBean() {
			super();
			// TODO Auto-generated constructor stub
		}


		public CT_Req_SearchGenDocNoBean(String accessToken, String module,
				String tableName, int type, String header) {
			super();
			this.accessToken = accessToken;
			this.module = module;
			this.tableName = tableName;
			this.type = type;
			this.header = header;
		}


		public String getAccessToken() {
			return accessToken;
		}


		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}


		public String getModule() {
			return module;
		}


		public void setModule(String module) {
			this.module = module;
		}


		public String getTableName() {
			return tableName;
		}


		public void setTableName(String tableName) {
			this.tableName = tableName;
		}


		public int getType() {
			return type;
		}


		public void setType(int type) {
			this.type = type;
		}


		public String getHeader() {
			return header;
		}


		public void setHeader(String header) {
			this.header = header;
		}
		
		
}
