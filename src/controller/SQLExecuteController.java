package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean_req.CT_Req_SearchCenterBean;
import bean_req.CT_Req_ServerDataBaseBean;
import bean_res.CT_Res_GenAccessTokenBean;

import connect.SQLConn;


public class SQLExecuteController {
private SQLConn ds = SQLConn.INSTANCE;
CT_Res_GenAccessTokenBean dataConn = new CT_Res_GenAccessTokenBean();
CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
	
	private Integer isSuccess;
	public Integer isSuccess() {
		return isSuccess;
	}
	public void setSuccess(Integer isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public Integer executeSql(CT_Req_ServerDataBaseBean dbName,String sql) {
		
		try {
			Statement stmt = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
	
			stmt.execute(sql);
			if (stmt != null) {
				stmt.close();
			}
			isSuccess=1;
			
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			isSuccess=0;
		} finally {
			
			ds.close();
			
		}
		
		return isSuccess;
	}
	
	
	public CT_Res_GenAccessTokenBean dataConnect(String accessToken){
		String vQuery;

		dbName.setDatabaseName("bcnp");
		dbName.setServerName("192.168.0.7");
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_NP_SearchTokenData '"+accessToken+"'";
			ResultSet rs = st.executeQuery(vQuery);
			while(rs.next()){
				dataConn.setDataBaseName(rs.getString("databasename"));
				dataConn.setServerName(rs.getString("servername"));
				dataConn.setUserID(rs.getString("userid"));
				dataConn.setSaleCode(rs.getString("salecode"));
			}
			
			rs.close();
			st.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			ds.close();
		}
		
		return dataConn;
	}
}
