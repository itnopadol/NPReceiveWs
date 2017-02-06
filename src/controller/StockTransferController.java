package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.mysql.fabric.xmlrpc.base.Array;

import bean_req.CT_Req_SearchCenterBean;
import bean_req.CT_Req_SearchGenDocNoBean;
import bean_req.CT_Req_SearchRefCodeBean;
import bean_req.CT_Req_SearchStockWareHouseBean;
import bean_req.CT_Req_SearchTypeBean;
import bean_req.CT_Req_ServerDataBaseBean;
import bean_req.RC_Req_InsertReceiveSubBean;
import bean_req.TF_Req_InsertStockTransferBean;
import bean_req.TF_Req_ManageItemBean;
import bean_req.TF_Req_ReportUsedTFBean;
import bean_req.TF_Req_SearchStkTransferBean;
import bean_res.CT_Res_DataMasterBean;
import bean_res.CT_Res_DataResultBean;
import bean_res.CT_Res_GenAccessTokenBean;
import bean_res.CT_Res_ItemDataBean;
import bean_res.CT_Res_ListMasterDataBean;
import bean_res.CT_Res_ResultResponseBean;
import bean_res.CT_Res_WareHouseBean;
import bean_res.RC_Res_InsertDataResponseBean;
import bean_res.RC_Res_InsertReceiveItemBean;
import bean_res.TF_Res_ListReportUsedTFBean;
import bean_res.TF_Res_ListStkTransferBean;
import bean_res.TF_Res_ListTRFDetailsBean;
import bean_res.TF_Res_ReportUsedTFBean;
import bean_res.TF_Res_SearchStkTransferBean;
import bean_res.TF_Res_StkTransferDetailsBean;
import connect.SQLConn;

public class StockTransferController {
	SQLConn conn = SQLConn.INSTANCE;
	SQLExecuteController exec = new SQLExecuteController();
	
	RC_Res_InsertDataResponseBean stk = new RC_Res_InsertDataResponseBean();
	RC_Res_InsertReceiveItemBean stkSub = new RC_Res_InsertReceiveItemBean();
	DocNoController genDoc = new DocNoController();
	CT_Res_ResultResponseBean resp = new CT_Res_ResultResponseBean();
	SearchDataCenterBean data = new SearchDataCenterBean();
	
	TF_Res_SearchStkTransferBean tf = new TF_Res_SearchStkTransferBean();
	List<TF_Res_ListStkTransferBean> listTF = new ArrayList<TF_Res_ListStkTransferBean>();
	
	TF_Res_StkTransferDetailsBean tfDetails = new TF_Res_StkTransferDetailsBean();
	List<TF_Res_ListTRFDetailsBean> listTFItem = new ArrayList<TF_Res_ListTRFDetailsBean>();
	
	CT_Res_DataMasterBean sale = new CT_Res_DataMasterBean();
	List<CT_Res_ListMasterDataBean> listSale = new ArrayList<CT_Res_ListMasterDataBean>();
	
	CT_Res_DataResultBean docno = new CT_Res_DataResultBean();
	
	
	public RC_Res_InsertDataResponseBean insertStkTransfer(CT_Req_ServerDataBaseBean dbName,TF_Req_InsertStockTransferBean req){
		String vQuery;
		Integer isSuccess;
		String docNo;
		CT_Req_SearchGenDocNoBean genDocno = new CT_Req_SearchGenDocNoBean();
		
		genDocno.setAccessToken(req.getAccessToken());
		genDocno.setHeader("TH");
		genDocno.setModule("Inventory");
		genDocno.setType(0);
		genDocno.setTableName("BCSTKTRANSFER");
		
		if (req.getIsCompleteSave()==0){
			
			docNo = genDoc.genNewDocno(genDocno);
		}else{
			docNo = req.getDocNo();
		}
		
		System.out.println("newDocNo ="+docNo);
		
		try {
			Statement st = conn.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_API_InsertSTKTransfer '"+docNo+"','"+req.getDocDate()+"','"+req.getRefNo()+"',"+req.getIsCompleteSave()+",'"+req.getCreatorCode()+"',"+req.getDocType()+",'"+req.getMyDescription()+"','"+req.getConfirmCode()+"'";
			isSuccess = exec.executeSql(dbName, vQuery);
			
			resp.setIsSuccess(isSuccess);
			resp.setProcessName("Save StockTransfer Header");
			resp.setProcessDesc("Successful");
			
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Save StockTransfer Header");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		stk.setResp(resp);
		stk.setDocNo(docNo);
		return stk;
	}
	
	public RC_Res_InsertDataResponseBean insertStkTransfer_V2(TF_Req_InsertStockTransferBean req){
		String vQuery;
		Integer isSuccess;
		String docNo;
		CT_Req_SearchGenDocNoBean genDocno = new CT_Req_SearchGenDocNoBean();
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(req.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
//		
//		genDocno.setAccessToken(req.getAccessToken());
//		genDocno.setHeader("TH");
//		genDocno.setModule("Inventory");
//		genDocno.setType(0);
//		genDocno.setTableName("BCSTKTRANSFER");
//		
//		if (req.getIsCompleteSave()==0){
//			
//			docNo = genDoc.genNewDocno_V2(genDocno);
//		}else{
//			docNo = req.getDocNo();
//		}
		
		try {
			Statement st = conn.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_API_InsertSTKTransfer '"+req.getDocNo()+"','"+req.getDocDate()+"','"+req.getRefNo()+"',"+req.getIsCompleteSave()+",'"+req.getCreatorCode()+"',"+req.getDocType()+",'"+req.getMyDescription()+"','"+req.getConfirmCode()+"'";
			isSuccess = exec.executeSql(dbName, vQuery);
			
			resp.setIsSuccess(isSuccess);
			resp.setProcessName("Save StockTransfer Header");
			resp.setProcessDesc("Successful");
			
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Save StockTransfer Header");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		stk.setResp(resp);
		stk.setDocNo(req.getDocNo());
		return stk;
	}
	
	public CT_Res_ResultResponseBean CancelStkTransfer(CT_Req_ServerDataBaseBean dbName,TF_Req_SearchStkTransferBean req){
		String vQuery;
		Integer isSuccess;
		//String docNo;
		//CT_Req_SearchGenDocNoBean genDocno = new CT_Req_SearchGenDocNoBean();
		
		try {
			Statement st = conn.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_RC_CancelStockTransfer_API '"+req.getDocNo()+"','"+req.getRefNo()+"','"+req.getUserID()+"'";
			isSuccess = exec.executeSql(dbName, vQuery);
			
			resp.setIsSuccess(isSuccess);
			resp.setProcessName("Cancel StockTransfer");
			resp.setProcessDesc("Successful");
			
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Cancel StockTransfer");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		return resp;
	}
	
	public CT_Res_ResultResponseBean CancelStkTransfer_V2(TF_Req_SearchStkTransferBean req){
		String vQuery;
		Integer isSuccess;
		//String docNo;
		//CT_Req_SearchGenDocNoBean genDocno = new CT_Req_SearchGenDocNoBean();
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(req.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = conn.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_RC_CancelStockTransfer_API '"+req.getDocNo()+"','"+req.getRefNo()+"','"+req.getUserID()+"'";
			isSuccess = exec.executeSql(dbName, vQuery);
			
			resp.setIsSuccess(isSuccess);
			resp.setProcessName("Cancel StockTransfer");
			resp.setProcessDesc("Successful");
			
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Cancel StockTransfer");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		return resp;
	}
	
	public TF_Res_SearchStkTransferBean searchStkTransfer(CT_Req_ServerDataBaseBean dbName,CT_Req_SearchTypeBean req){
		String vQuery;
		Integer isSuccess;
		
		try {
			Statement st = conn.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_API_SearchSTKTransfer "+req.getType()+",'"+req.getSearch()+"'";
			ResultSet rs = st.executeQuery(vQuery);
			
			System.out.println(vQuery);
			
			listTF.clear();
			TF_Res_ListStkTransferBean evt;
			while(rs.next()){
				
				evt = new TF_Res_ListStkTransferBean();
				evt.setDocDate(rs.getString("docdate"));
				evt.setDocNo(rs.getString("docno"));
				evt.setIsCancel(rs.getInt("iscancel"));
				evt.setIsCompleteSave(rs.getInt("iscompletesave"));
				evt.setIsConfirm(rs.getInt("isconfirm"));
				evt.setMyDescription(rs.getString("mydescription"));
				evt.setRefDocNo(rs.getString("refno"));
				evt.setSumOfAmount(rs.getDouble("SumOfAmount"));
				evt.setSumOfQty(rs.getDouble("SumOfQty"));
				evt.setDocType(rs.getInt("doctype"));
				
				listTF.add(evt);
			}

			resp.setIsSuccess(1);
			resp.setProcessName("Search StockTransfer");
			resp.setProcessDesc("Successful");
			
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search StockTransfer");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		tf.setResponse(resp);
		tf.setData(listTF);
		return tf;
	}
	
	public TF_Res_SearchStkTransferBean searchStkTransfer_V2(CT_Req_SearchTypeBean req){
		String vQuery;
		Integer isSuccess;
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(req.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = conn.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_API_SearchSTKTransfer "+req.getType()+",'"+req.getSearch()+"'";
			ResultSet rs = st.executeQuery(vQuery);
			
			System.out.println(vQuery);
			
			listTF.clear();
			TF_Res_ListStkTransferBean evt;
			while(rs.next()){
				
				evt = new TF_Res_ListStkTransferBean();
				evt.setDocDate(rs.getString("docdate"));
				evt.setDocNo(rs.getString("docno"));
				evt.setIsCancel(rs.getInt("iscancel"));
				evt.setIsCompleteSave(rs.getInt("iscompletesave"));
				evt.setIsConfirm(rs.getInt("isconfirm"));
				evt.setMyDescription(rs.getString("mydescription"));
				evt.setRefDocNo(rs.getString("refno"));
				evt.setSumOfAmount(rs.getDouble("SumOfAmount"));
				evt.setSumOfQty(rs.getDouble("SumOfQty"));
				evt.setDocType(rs.getInt("doctype"));
				
				listTF.add(evt);
			}

			resp.setIsSuccess(1);
			resp.setProcessName("Search StockTransfer");
			resp.setProcessDesc("Successful");
			
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search StockTransfer");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		tf.setResponse(resp);
		tf.setData(listTF);
		return tf;
	}
	
	public TF_Res_StkTransferDetailsBean searchStkTransferDetails(CT_Req_ServerDataBaseBean dbName,CT_Req_SearchTypeBean req){
		String vQuery;
		Integer isSuccess;
		
		try {
			Statement st = conn.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_API_SearchSTKTransferDetails "+req.getType()+",'"+req.getSearch()+"'";
			ResultSet rs = st.executeQuery(vQuery);
			
			tfDetails.setDocNo("Test");
			
			System.out.println(vQuery);
			System.out.println(tfDetails.getDocNo());

			listTFItem.clear();
			TF_Res_ListTRFDetailsBean evt;
			while(rs.next()){
				tfDetails.setDocDate(rs.getString("docdate"));
				tfDetails.setDocNo(rs.getString("docno"));
				tfDetails.setIsCancel(rs.getInt("iscancel"));
				tfDetails.setIsCompleteSave(rs.getInt("iscompletesave"));
				tfDetails.setIsConfirm(rs.getInt("isconfirm"));
				tfDetails.setMyDescription(rs.getString("mydescription"));
				tfDetails.setRefDocNo(rs.getString("recurname"));
				tfDetails.setSumOfAmount(rs.getDouble("SumOfAmount"));
				tfDetails.setSumOfQty(rs.getDouble("SumOfQty"));
				tfDetails.setDocType(rs.getInt("docType"));
				tfDetails.setConfirmCode(rs.getString("confirmcode"));
				tfDetails.setConfirmName(rs.getString("confirmname"));
				
				evt = new TF_Res_ListTRFDetailsBean();
				evt.setAmount(rs.getDouble("amount"));
				evt.setBarCode(rs.getString("barcode"));
				evt.setFromShelf(rs.getString("fromshelf"));
				evt.setFromWH(rs.getString("fromwh"));
				evt.setLineNumber(rs.getInt("linenumber"));
				evt.setItemCode(rs.getString("itemcode"));
				evt.setItemName(rs.getString("itemname"));
				evt.setPrice(rs.getDouble("price"));
				evt.setQty(rs.getDouble("qty"));
				evt.setRefNo(rs.getString("refno"));
				evt.setSumOfCost(rs.getDouble("sumofcost"));
				evt.setToShelf(rs.getString("toshelf"));
				evt.setToWH(rs.getString("towh"));
				evt.setUnitCode(rs.getString("unitcode"));	
				evt.setIsCancel(rs.getInt("iscancelsub"));
				evt.setPickCode(rs.getString("pickcode"));
				evt.setPickName(rs.getString("pickname"));
				
				listTFItem.add(evt);
			}

			resp.setIsSuccess(1);
			resp.setProcessName("Search StockTransferDetails");
			resp.setProcessDesc("Successful");
			
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search StockTransferDetails");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		tfDetails.setResponse(resp);
		tfDetails.setData(listTFItem);
		return tfDetails;
	}
	
	public TF_Res_StkTransferDetailsBean searchStkTransferDetails_V2(CT_Req_SearchTypeBean req){
		String vQuery;
		Integer isSuccess;
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(req.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = conn.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_API_SearchSTKTransferDetails "+req.getType()+",'"+req.getSearch()+"'";
			ResultSet rs = st.executeQuery(vQuery);
			
			tfDetails.setDocNo("Test");
			
			System.out.println(vQuery);
			System.out.println(tfDetails.getDocNo());

			listTFItem.clear();
			TF_Res_ListTRFDetailsBean evt;
			while(rs.next()){
				tfDetails.setDocDate(rs.getString("docdate"));
				tfDetails.setDocNo(rs.getString("docno"));
				tfDetails.setIsCancel(rs.getInt("iscancel"));
				tfDetails.setIsCompleteSave(rs.getInt("iscompletesave"));
				tfDetails.setIsConfirm(rs.getInt("isconfirm"));
				tfDetails.setMyDescription(rs.getString("mydescription"));
				tfDetails.setRefDocNo(rs.getString("recurname"));
				tfDetails.setSumOfAmount(rs.getDouble("SumOfAmount"));
				tfDetails.setSumOfQty(rs.getDouble("SumOfQty"));
				tfDetails.setDocType(rs.getInt("docType"));
				tfDetails.setConfirmCode(rs.getString("confirmcode"));
				tfDetails.setConfirmName(rs.getString("confirmname"));
				
				evt = new TF_Res_ListTRFDetailsBean();
				evt.setAmount(rs.getDouble("amount"));
				evt.setBarCode(rs.getString("barcode"));
				evt.setFromShelf(rs.getString("fromshelf"));
				evt.setFromWH(rs.getString("fromwh"));
				evt.setLineNumber(rs.getInt("linenumber"));
				evt.setItemCode(rs.getString("itemcode"));
				evt.setItemName(rs.getString("itemname"));
				evt.setPrice(rs.getDouble("price"));
				evt.setQty(rs.getDouble("qty"));
				evt.setRefNo(rs.getString("refno"));
				evt.setSumOfCost(rs.getDouble("sumofcost"));
				evt.setToShelf(rs.getString("toshelf"));
				evt.setToWH(rs.getString("towh"));
				evt.setUnitCode(rs.getString("unitcode"));	
				evt.setIsCancel(rs.getInt("iscancelsub"));
				evt.setPickCode(rs.getString("pickcode"));
				evt.setPickName(rs.getString("pickname"));
				
				listTFItem.add(evt);
			}

			resp.setIsSuccess(1);
			resp.setProcessName("Search StockTransferDetails");
			resp.setProcessDesc("Successful");
			
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search StockTransferDetails");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		tfDetails.setResponse(resp);
		tfDetails.setData(listTFItem);
		return tfDetails;
	}
	
	public RC_Res_InsertReceiveItemBean manageItem(CT_Req_ServerDataBaseBean dbName,TF_Req_ManageItemBean req){
		String vQuery;
		String vQuerySub12;
		String vQuerySub13;
		Integer isSuccess;
		
		try {
			Statement st = conn.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_API_InsertSTKTransferSub '"+req.getDocNo()+"','"+req.getBarCode()+"','"+req.getItemCode()+"','"+req.getDocDate()+"','"+req.getFromWHCode()+"','"+req.getFromShelfCode()+"','"+req.getToWHCode()+"','"+req.getToShelfCode()+"',"+req.getQty()+",'"+req.getRefNo()+"',"+req.getIsCancel()+",'"+req.getPickCode()+"'";
			isSuccess = exec.executeSql(dbName, vQuery);
			
			vQuerySub13 = "exec dbo.USP_API_InsertSTKTransferSub3 13,'"+req.getDocNo()+"','"+req.getBarCode()+"','"+req.getItemCode()+"','"+req.getDocDate()+"','"+req.getFromWHCode()+"','"+req.getFromShelfCode()+"','"+req.getToWHCode()+"','"+req.getToShelfCode()+"',"+req.getQty()+",'"+req.getRefNo()+"'";
			isSuccess = exec.executeSql(dbName, vQuerySub13);
			
			vQuerySub12 = "exec dbo.USP_API_InsertSTKTransferSub3 12,'"+req.getDocNo()+"','"+req.getBarCode()+"','"+req.getItemCode()+"','"+req.getDocDate()+"','"+req.getToWHCode()+"','"+req.getToShelfCode()+"','"+req.getFromWHCode()+"','"+req.getFromShelfCode()+"',"+req.getQty()+",'"+req.getRefNo()+"'";
			isSuccess = exec.executeSql(dbName, vQuerySub12);
			
			resp.setIsSuccess(isSuccess);
			resp.setProcessName("Save StockTransfer");
			resp.setProcessDesc("Successful");
			
		} catch (Exception e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Save StockTransfer");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		stkSub.setItemCount(0);
		stkSub.setResp(resp);
		
		return stkSub;
	}
	
	public RC_Res_InsertReceiveItemBean manageItem_V2(TF_Req_ManageItemBean req){
		String vQuery;
		String vQuerySub12;
		String vQuerySub13;
		Integer isSuccess;
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(req.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = conn.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_API_InsertSTKTransferSub '"+req.getDocNo()+"','"+req.getBarCode()+"','"+req.getItemCode()+"','"+req.getDocDate()+"','"+req.getFromWHCode()+"','"+req.getFromShelfCode()+"','"+req.getToWHCode()+"','"+req.getToShelfCode()+"',"+req.getQty()+",'"+req.getRefNo()+"',"+req.getIsCancel()+",'"+req.getPickCode()+"'";
			isSuccess = exec.executeSql(dbName, vQuery);
			
			//vQuerySub13 = "exec dbo.USP_API_InsertSTKTransferSub3 13,'"+req.getDocNo()+"','"+req.getBarCode()+"','"+req.getItemCode()+"','"+req.getDocDate()+"','"+req.getFromWHCode()+"','"+req.getFromShelfCode()+"','"+req.getToWHCode()+"','"+req.getToShelfCode()+"',"+req.getQty()+",'"+req.getRefNo()+"',"+req.getIsCancel()+"";
			//isSuccess = exec.executeSql(dbName, vQuerySub13);
			
			//vQuerySub12 = "exec dbo.USP_API_InsertSTKTransferSub3 12,'"+req.getDocNo()+"','"+req.getBarCode()+"','"+req.getItemCode()+"','"+req.getDocDate()+"','"+req.getToWHCode()+"','"+req.getToShelfCode()+"','"+req.getFromWHCode()+"','"+req.getFromShelfCode()+"',"+req.getQty()+",'"+req.getRefNo()+"',"+req.getIsCancel()+"";
			//isSuccess = exec.executeSql(dbName, vQuerySub12);
			
			resp.setIsSuccess(isSuccess);
			resp.setProcessName("Save StockTransfer");
			resp.setProcessDesc("Successful");
			
		} catch (Exception e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Save StockTransfer");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		stkSub.setItemCount(0);
		stkSub.setResp(resp);
		
		return stkSub;
	}
	
	public CT_Res_ItemDataBean itemList(CT_Req_SearchTypeBean req){
		CT_Res_ItemDataBean itemdata = new CT_Res_ItemDataBean();
		
		itemdata = data.searchItem(req);
		
		return itemdata;
	}
	
	public CT_Res_ItemDataBean searchitem(CT_Req_SearchTypeBean req){
		String docNo="";
		
		//CT_Res_DataResultBean staff;
		
		try {

			URL url = new URL("http://qserver.nopadol.com:8080/NPDataCenterWs/center/searchitem");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			//String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"search\":\""+req.getSearch()+"\"}";
			String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"type\":\""+req.getType()+"\",\"search\":\""+req.getSearch()+"\"}";
			System.out.println("input="+input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				docNo = output;
				System.out.println("json format :"+output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		
		//StringEntity str = null;
		
    	Gson gson = new Gson();
    	String json = gson.toJson(docNo); 
    	CT_Res_ItemDataBean itemData = gson.fromJson(docNo, CT_Res_ItemDataBean.class);
    	System.out.println("Docno :"+itemData.getData());
    	
    	
		return itemData;
	}
	
	public CT_Res_ItemDataBean searchitem_V2(CT_Req_SearchTypeBean req){
		String docNo="";
		
		//CT_Res_DataResultBean staff;
		
		try {

			URL url = new URL("http://qserver.nopadol.com:8080/NPDataCenterWs/center/v2/searchitem");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			//String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"search\":\""+req.getSearch()+"\"}";
			String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"type\":\""+req.getType()+"\",\"search\":\""+req.getSearch()+"\"}";
			System.out.println("input="+input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				docNo = output;
				System.out.println("json format :"+output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		
		//StringEntity str = null;
		
    	Gson gson = new Gson();
    	String json = gson.toJson(docNo); 
    	CT_Res_ItemDataBean itemData = gson.fromJson(docNo, CT_Res_ItemDataBean.class);
    	System.out.println("Docno :"+itemData.getData());
    	
    	
		return itemData;
	}
	
	public CT_Res_WareHouseBean searchwh(CT_Req_SearchTypeBean req){
		String warehouse="";
		
		//CT_Res_DataResultBean staff;
		
		try {

			URL url = new URL("http://qserver.nopadol.com:8080/NPDataCenterWs/center/searchwarehouse");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			//String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"search\":\""+req.getSearch()+"\"}";
			String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"type\":\""+req.getType()+"\",\"search\":\""+req.getSearch()+"\"}";
			System.out.println("input="+input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				warehouse = output;
				System.out.println("json format :"+output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		
		//StringEntity str = null;
		
    	Gson gson = new Gson();
    	String json = gson.toJson(warehouse); 
    	CT_Res_WareHouseBean whData = gson.fromJson(warehouse, CT_Res_WareHouseBean.class);
    	System.out.println("Docno :"+whData.getData());

    	
		return whData;
	}
	
	public CT_Res_WareHouseBean searchwh_V2(CT_Req_SearchTypeBean req){
		String warehouse="";
		
		//CT_Res_DataResultBean staff;
		
		try {

			URL url = new URL("http://qserver.nopadol.com:8080/NPDataCenterWs/center/v2/searchwarehouse");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			//String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"search\":\""+req.getSearch()+"\"}";
			String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"type\":\""+req.getType()+"\",\"search\":\""+req.getSearch()+"\"}";
			System.out.println("input="+input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				warehouse = output;
				System.out.println("json format :"+output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		
		//StringEntity str = null;
		
    	Gson gson = new Gson();
    	String json = gson.toJson(warehouse); 
    	CT_Res_WareHouseBean whData = gson.fromJson(warehouse, CT_Res_WareHouseBean.class);
    	System.out.println("Docno :"+whData.getData());

    	
		return whData;
	}
	
	public CT_Res_WareHouseBean searchShelf(CT_Req_SearchRefCodeBean req){
		String shelf="";
		
		//CT_Res_DataResultBean staff;
		//useUnicode=true;characterEncoding=utf-8
		
		System.out.println("Search Shelf");
		
		try {

			URL url = new URL("http://qserver.nopadol.com:8080/NPDataCenterWs/center/searchshelf");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			//conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("Content-Type", "application/json");
			//conn.setDoInput(true);
			//conn.setUseCaches(false);
			
			//String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"search\":\""+req.getSearch()+"\"}";
			String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"refCode\":\""+req.getRefCode()+"\",\"search\":\""+req.getSearch()+"\"}";
			System.out.println("input="+input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			
			System.out.println("os="+os.toString());

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				shelf = output;
				System.out.println("json format :"+output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		
		//StringEntity str = null;
		
    	Gson gson = new Gson();
    	String json = gson.toJson(shelf); 
    	CT_Res_WareHouseBean shData = gson.fromJson(shelf, CT_Res_WareHouseBean.class);
    	System.out.println("Docno :"+shData.getData());
    	
		return shData;
	}
	
	public CT_Res_WareHouseBean searchShelf_V2(CT_Req_SearchRefCodeBean req){
		String shelf="";
		
		//CT_Res_DataResultBean staff;
		
		try {

			URL url = new URL("http://qserver.nopadol.com:8080/NPDataCenterWs/center/v2/searchshelf");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			//String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"search\":\""+req.getSearch()+"\"}";
			String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"refCode\":\""+req.getRefCode()+"\",\"search\":\""+req.getSearch()+"\"}";
			System.out.println("input="+input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				shelf = output;
				System.out.println("json format :"+output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		
		//StringEntity str = null;
		
    	Gson gson = new Gson();
    	String json = gson.toJson(shelf); 
    	CT_Res_WareHouseBean shData = gson.fromJson(shelf, CT_Res_WareHouseBean.class);
    	System.out.println("Docno :"+shData.getData());
    	
		return shData;
	}
	
	public CT_Res_DataMasterBean searchSale(CT_Req_SearchTypeBean req){
		String sale="";
		
		//CT_Res_DataResultBean staff;
		
		try {

			URL url = new URL("http://qserver.nopadol.com:8080/NPDataCenterWs/center/searchsale");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			//String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"search\":\""+req.getSearch()+"\"}";
			String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"type\":\""+req.getType()+"\",\"search\":\""+req.getSearch()+"\"}";
			System.out.println("input="+input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				sale = output;
				System.out.println("json format :"+output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		
		//StringEntity str = null;
		
    	Gson gson = new Gson();
    	String json = gson.toJson(sale); 
    	CT_Res_DataMasterBean saleData = gson.fromJson(sale, CT_Res_DataMasterBean.class);
    	System.out.println("Docno :"+saleData.getResponse());
    	
		return saleData;
	}
	
	public CT_Res_DataMasterBean searchSale_V2(CT_Req_SearchTypeBean req){
		String sale="";
		
		//CT_Res_DataResultBean staff;
		
		try {

			URL url = new URL("http://qserver.nopadol.com:8080/NPDataCenterWs/center/v2/searchsale");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			//String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"search\":\""+req.getSearch()+"\"}";
			String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"type\":\""+req.getType()+"\",\"search\":\""+req.getSearch()+"\"}";
			System.out.println("input="+input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				sale = output;
				System.out.println("json format :"+output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		
		//StringEntity str = null;
		
    	Gson gson = new Gson();
    	String json = gson.toJson(sale); 
    	CT_Res_DataMasterBean saleData = gson.fromJson(sale, CT_Res_DataMasterBean.class);
    	System.out.println("Docno :"+saleData.getResponse());
    	
		return saleData;
	}
	
	public CT_Res_DataMasterBean searchSaleApprove_V2(CT_Req_SearchTypeBean req){
		String vQuery;
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(req.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = conn.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_NP_SearchSaleApprove "+req.getType()+",'"+req.getSearch()+"'";
			ResultSet rs = st.executeQuery(vQuery);
			System.out.println(vQuery);
			
			listSale.clear();
			CT_Res_ListMasterDataBean evt;
			while(rs.next()){
				evt = new CT_Res_ListMasterDataBean();
				evt.setCode(rs.getString("comment"));
				evt.setName(rs.getString("name"));
				
				listSale.add(evt);
			}
			
			resp.setIsSuccess(1);
			resp.setProcessName("Search Sale");
			resp.setProcessDesc("Successful");

			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search Sale");
			resp.setProcessDesc("Successful");
		}finally{
			conn.close();
		}
		
		sale.setListData(listSale);
		sale.setResponse(resp);
		return sale;
	}
	
	public CT_Res_ItemDataBean searchItemStock(CT_Req_SearchStockWareHouseBean req){
		String item="";
		
		//CT_Res_DataResultBean staff;
		
		try {

			URL url = new URL("http://qserver.nopadol.com:8080/NPDataCenterWs/center/searchitemstock");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			//String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"search\":\""+req.getSearch()+"\"}";
			String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"type\":\""+req.getType()+"\",\"whCode\":\""+req.getWhCode()+"\",\"shelf\":\""+req.getShelf()+"\",\"search\":\""+req.getSearch()+"\"}";
			System.out.println("input="+input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				item = output;
				System.out.println("json format :"+output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		
		//StringEntity str = null;
		
    	Gson gson = new Gson();
    	String json = gson.toJson(item); 
    	CT_Res_ItemDataBean itemData = gson.fromJson(item, CT_Res_ItemDataBean.class);
    	System.out.println("Docno :"+itemData.getData());
    	
		return itemData;
	}
	
	public CT_Res_ItemDataBean searchItemStock_V2(CT_Req_SearchStockWareHouseBean req){
		String item="";
		
		//CT_Res_DataResultBean staff;
		
		try {

			URL url = new URL("http://qserver.nopadol.com:8080/NPDataCenterWs/center/v2/searchitemstock");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			//String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"search\":\""+req.getSearch()+"\"}";
			String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"type\":\""+req.getType()+"\",\"whCode\":\""+req.getWhCode()+"\",\"shelf\":\""+req.getShelf()+"\",\"search\":\""+req.getSearch()+"\"}";
			System.out.println("input="+input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			//BufferedReader br = new BufferedReader(new InputStreamReader(
					//(conn.getInputStream())));
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				item = output;
				System.out.println("json format :"+output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		
		//StringEntity str = null;
		
    	Gson gson = new Gson();
    	String json = gson.toJson(item); 
    	CT_Res_ItemDataBean itemData = gson.fromJson(item, CT_Res_ItemDataBean.class);
    	System.out.println("Docno :"+itemData.getData());
    	
		return itemData;
	}
	
	public CT_Res_DataResultBean genTrnNo(CT_Req_SearchGenDocNoBean req){
		String newDocNo="";
		String docNo="";
		
		//CT_Res_DataResultBean staff;
		
		System.out.println("OKKKKKKKKKKKKKKKKKKKK");
		
		try {

			URL url = new URL("http://qserver.nopadol.com:8080/NPDataCenterWs/center/v2/gendocno");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			//String input = "{\"req\":\"iPad 4\"}";
			//String input = req.toString();
			//System.out.println("input="+input);
			String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"module\":\""+req.getModule()+"\",\"tableName\":\""+req.getTableName()+"\",\"type\":\""+req.getType()+"\",\"header\":\""+req.getHeader()+"\"}";
			System.out.println("input="+input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

//			BufferedReader br = new BufferedReader(new InputStreamReader(
//					(conn.getInputStream())));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				docNo = output;
				System.out.println("json format :"+output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    	Gson gson = new Gson();
    	String json = gson.toJson(docNo); 
    	CT_Res_DataResultBean docno = gson.fromJson(docNo, CT_Res_DataResultBean.class);
    	System.out.println("Docno :"+docno.getData());
		
    	newDocNo = docno.getData();
    	
    	docno.setData(newDocNo);
    	
		return docno;
	}
	
	
	List<TF_Res_ListReportUsedTFBean> listItem = new ArrayList<TF_Res_ListReportUsedTFBean>();
	TF_Res_ReportUsedTFBean report = new TF_Res_ReportUsedTFBean();
	public TF_Res_ReportUsedTFBean reportUseTransfer_V2(TF_Req_ReportUsedTFBean req){
		String vQuery;
		String vQuerySub12;
		String vQuerySub13;
		Integer isSuccess;
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(req.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = conn.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_API_ReportSTKTransfer "+req.getType()+",'"+req.getBegDate()+"','"+req.getEndDate()+"','"+req.getWhCode()+"','"+req.getConfirmCode()+"','"+req.getSearch()+"'";
			ResultSet rs = st.executeQuery(vQuery);
			
			TF_Res_ListReportUsedTFBean evt;
			if(rs.next() != false){
				report.setDocNo(rs.getString("docno"));
				while(rs.next()){
					
					evt = new TF_Res_ListReportUsedTFBean();
					evt.setBarCode(rs.getString("barcode"));
					evt.setItemCode(rs.getString("itemcode"));
					evt.setFromShelf(rs.getString("fromwh"));
					evt.setFromShelf(rs.getString("fromshelf"));
					evt.setToWH(rs.getString("towh"));
					evt.setToShelf(rs.getString("toshelf"));
					evt.setItemName(rs.getString("itemname"));
					evt.setQty(rs.getDouble("qty"));
					evt.setUnitCode(rs.getString("unitcode"));
					
					listItem.add(evt);
				}
			}
			st.close();
			rs.close();
			
			resp.setIsSuccess(1);
			resp.setProcessName("Report StockTransfer");
			resp.setProcessDesc("Successful");
			
			report.setListItem(listItem);
			
		} catch (Exception e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Report StockTransfer");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		conn.close();

		report.setResp(resp);
		
		return report;
	}
}
