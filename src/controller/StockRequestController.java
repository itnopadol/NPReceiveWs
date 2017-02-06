package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean_req.PR_Req_SearchStockRequestBean;
import bean_res.PR_Res_ListStockRequestBean;
import bean_res.PR_Res_SearchStockRequestBean;
import connect.SQLConn;

public class StockRequestController {
	private final SQLConn ds = SQLConn.INSTANCE;
	private String Textstring;
	
	List<PR_Res_ListStockRequestBean> listData = new ArrayList<PR_Res_ListStockRequestBean>();
	PR_Res_SearchStockRequestBean reqData = new PR_Res_SearchStockRequestBean();

	public PR_Res_SearchStockRequestBean stkReqSearch(String dbName,PR_Req_SearchStockRequestBean reqItemSearch) {
		java.text.SimpleDateFormat dt= new java.text.SimpleDateFormat();
		dt.applyPattern("yyyy-MM-dd HH:mm:ss.S");
		@SuppressWarnings("unused")
		Date dateNow = new Date();
		

		System.out.println("Search STKRequest");
		
			try {
				
				// get connection
				Statement stmt = ds.getSqlStatement(dbName);
			    
				Textstring="exec dbo.USP_PR_SearchDocnoAPI "+reqItemSearch.getType()+",'"+reqItemSearch.getSearch()+"'";
				
			   	System.out.println(Textstring);
			    ResultSet rs = stmt.executeQuery(Textstring);
			    
			    listData.clear();
			    
			    PR_Res_ListStockRequestBean listItem;
			    
			   
			    
			   	while (rs.next()) {
			   		
			   		reqData.setDocNo(rs.getString("docno"));
			   		reqData.setDocDate(rs.getDate("docdate"));
			   		reqData.setWantDate(rs.getDate("wantDate"));
			   		reqData.setStatus(rs.getInt("status"));
			   		reqData.setDiffDate(rs.getInt("diffDate"));
			   		reqData.setPersonCode(rs.getString("personcode"));
			   	 
			   		listItem = new PR_Res_ListStockRequestBean();	
	
	        		
			   		listItem.setItemCode(rs.getString("itemcode"));
			   		listItem.setItemName(rs.getString("itemname"));
			   		listItem.setQty(rs.getInt("qty"));
			   		
			   		System.out.println("docno = "+rs.getString("docno"));
			   		System.out.println("wantDate = "+rs.getDate("wantDate"));
			   		System.out.println("docdate = "+rs.getDate("docdate"));
			   		System.out.println("status = "+rs.getInt("status"));
			   		System.out.println("diffDay = "+rs.getInt("diffDate"));
			   		System.out.println("itemcode = "+rs.getString("itemcode"));
			   		System.out.println("itemname = "+rs.getString("itemname"));
			   		System.out.println("qty = "+rs.getInt("qty"));
			   		listData.add(listItem);
	
				}
			   
			   	reqData.setListData(listData);
			    rs.close();
			    stmt.close();
			    
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			    ds.close();
			}
		
		
		return reqData;
		
	}
}
