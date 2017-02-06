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

import bean_req.CT_Req_SearchCenterBean;
import bean_req.CT_Req_SearchGenDocNoBean;
import bean_req.CT_Req_SearchTypeBean;
import bean_req.CT_Req_ServerDataBaseBean;
import bean_req.RC_Req_InsertDataReceiveBean;
import bean_req.RC_Req_InsertReceiveSubBean;
import bean_req.RC_Req_InsertUpdateReceiveBean;
import bean_req.RC_Req_ItemReceiveSubBean;
import bean_req.RC_Req_SearchItemReceive;
import bean_req.RC_Req_SearchReceiveDetailsBean;
import bean_req.RC_Req_TestAPI;
import bean_res.CT_Res_DataResultBean;
import bean_res.CT_Res_GenAccessTokenBean;
import bean_res.CT_Res_ItemDataBean;
import bean_res.CT_Res_ListItemDataBean;
import bean_res.CT_Res_ResultResponseBean;
import bean_res.PO_Res_ListVendorNotReceiptBean;
import bean_res.PO_Res_ListVendorPOBean;
import bean_res.PO_Res_PODetailsBean;
import bean_res.PO_Res_VendorNotReceiptBean;
import bean_res.PO_Res_VendorPOBean;
import bean_res.RC_Res_InsertDataResponseBean;
import bean_res.RC_Res_InsertReceiveItemBean;
import bean_res.RC_Res_ListRecieveItemBean;
import bean_res.RC_Res_ListSearchItemBean;
import bean_res.RC_Res_ListSearchRecieveBean;
import bean_res.RC_Res_ReceiveDataBean;
import bean_res.RC_Res_SearchItemDetailsBean;
import bean_res.RC_Res_SearchRecieveBean;
import bean_res.RC_Res_TestAPI;
import connect.SQLConn;

public class ReceiveController {
	SQLConn ds = SQLConn.INSTANCE ;
	CT_Req_ServerDataBaseBean sv = new CT_Req_ServerDataBaseBean();
	CT_Res_ResultResponseBean resp = new CT_Res_ResultResponseBean();
	PO_Res_VendorNotReceiptBean ap = new PO_Res_VendorNotReceiptBean();
	List<PO_Res_ListVendorNotReceiptBean> apList = new ArrayList<PO_Res_ListVendorNotReceiptBean>();
	PO_Res_PODetailsBean poDetails = new PO_Res_PODetailsBean();
	List<CT_Res_ListItemDataBean> poItem = new ArrayList<CT_Res_ListItemDataBean>();
	PO_Res_VendorPOBean PO = new PO_Res_VendorPOBean();
	List<PO_Res_ListVendorPOBean> listPO = new ArrayList<PO_Res_ListVendorPOBean>();
	RC_Res_InsertDataResponseBean rcResp = new RC_Res_InsertDataResponseBean();
	SQLExecuteController exec = new SQLExecuteController();
	RC_Res_InsertReceiveItemBean rcRespSub = new RC_Res_InsertReceiveItemBean();
	List<RC_Res_ListRecieveItemBean> listRC = new ArrayList<RC_Res_ListRecieveItemBean>();
	RC_Res_ReceiveDataBean RC = new RC_Res_ReceiveDataBean();
	List<RC_Res_ListSearchItemBean> listItem = new ArrayList<RC_Res_ListSearchItemBean>();
	RC_Res_SearchItemDetailsBean itm = new RC_Res_SearchItemDetailsBean();
	SearchDataCenterBean data = new SearchDataCenterBean();
	DocNoController genDoc = new DocNoController();
	
	RC_Res_SearchRecieveBean receive = new RC_Res_SearchRecieveBean();
	List<RC_Res_ListSearchRecieveBean> listDoc = new ArrayList<RC_Res_ListSearchRecieveBean>();
	
	
	RC_Res_TestAPI test = new RC_Res_TestAPI();
	
	
	public PO_Res_VendorNotReceiptBean searchVendorNotReceipt(CT_Req_ServerDataBaseBean dbName,CT_Req_SearchCenterBean search){	
		String vQuery;

		dbName.setDatabaseName(dbName.getDatabaseName());
		dbName.setServerName(dbName.getServerName());
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_PO_SearchVenderNotReceipt_API '"+search.getSearch()+"'";
			
			ResultSet rs = st.executeQuery(vQuery);
			
			PO_Res_ListVendorNotReceiptBean evt;
			apList.clear();
			while(rs.next()){
				
				evt = new PO_Res_ListVendorNotReceiptBean();
				evt.setCode(rs.getString("apcode"));
				evt.setName(rs.getString("apname"));
				System.out.println(vQuery);
				System.out.println(rs.getString("apname"));
				
				apList.add(evt);
				
				resp.setIsSuccess(1);
				resp.setProcessName("Search vendor not receipt item");
				resp.setProcessDesc("Search Successful");
	
			}
			ap.setApList(apList);
			st.close();
			rs.close();
					
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search vendor not receipt item");
			resp.setProcessDesc(e.getMessage());
		}finally{
			ds.close();
		}
		
		ap.setResp(resp);
		
		return ap;
	}
	
	public PO_Res_VendorNotReceiptBean searchVendorNotReceipt_V2(CT_Req_SearchCenterBean search){	
		String vQuery;
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(search.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_PO_SearchVenderNotReceipt_API '"+search.getSearch()+"'";
			
			ResultSet rs = st.executeQuery(vQuery);
			
			PO_Res_ListVendorNotReceiptBean evt;
			apList.clear();
			while(rs.next()){
				
				evt = new PO_Res_ListVendorNotReceiptBean();
				evt.setCode(rs.getString("apcode"));
				evt.setName(rs.getString("apname"));
				System.out.println(vQuery);
				System.out.println(rs.getString("apname"));
				
				apList.add(evt);
				
				resp.setIsSuccess(1);
				resp.setProcessName("Search vendor not receipt item");
				resp.setProcessDesc("Search Successful");
	
			}
			ap.setApList(apList);
			st.close();
			rs.close();
					
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search vendor not receipt item");
			resp.setProcessDesc(e.getMessage());
		}finally{
			ds.close();
		}
		
		ap.setResp(resp);
		
		return ap;
	}
	
	public PO_Res_PODetailsBean searchPODetails(CT_Req_ServerDataBaseBean dbName,CT_Req_SearchCenterBean search){
		String vQuery;
		
		System.out.println(dbName.getServerName());
		System.out.println(dbName.getDatabaseName());
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_PO_SearchPONotReceiptDetails_API '"+search.getSearch()+"'";
			
			ResultSet rs = st.executeQuery(vQuery);
			
			CT_Res_ListItemDataBean evt;
			poItem.clear();
			while(rs.next()){
				
				poDetails.setDocNo(rs.getString("docno"));
				poDetails.setDocDate(rs.getDate("docdate"));
				poDetails.setApCode(rs.getString("apcode"));
				poDetails.setApName(rs.getString("apname"));
				poDetails.setDueDate(rs.getDate("duedate"));
				poDetails.setLeadDate(rs.getDate("leaddate"));
				poDetails.setMyDescription(rs.getString("mydescription"));
				poDetails.setSumOfItemAmount(rs.getDouble("SumOfItemAmount"));
				poDetails.setDiscountAmount(rs.getDouble("discountAmount"));
				poDetails.setAfterDiscount(rs.getDouble("afterDiscount"));
				poDetails.setBeforeTaxAmount(rs.getDouble("beforeTaxAmount"));
				poDetails.setTaxAmount(rs.getDouble("taxAmount"));
				poDetails.setTotalAmount(rs.getDouble("totalAmount"));


				evt = new CT_Res_ListItemDataBean();
				evt.setItemCode(rs.getString("itemcode"));
				evt.setBarCode(rs.getString("barcode"));
				evt.setItemName(rs.getString("itemname"));
				evt.setWhCode(rs.getString("whcode"));
				evt.setShelfCode(rs.getString("shelfcode"));
				evt.setQty(rs.getDouble("qty"));
				evt.setRemainQty(rs.getDouble("remainQty"));
				evt.setPrice(rs.getDouble("price"));
				evt.setDiscountWord(rs.getString("discountWord"));
				evt.setDiscountAmount(rs.getDouble("DiscountAmountSub"));
				evt.setAmount(rs.getDouble("amount"));
				evt.setUnitCode(rs.getString("unitCode"));
				
				poItem.add(evt);
				
				resp.setIsSuccess(1);
				resp.setProcessName("Search PO Details");
				resp.setProcessDesc("Search Successful");
	
			}
			poDetails.setResp(resp);
			poDetails.setListItem(poItem);
			st.close();
			rs.close();
					
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search PO Details");
			resp.setProcessDesc(e.getMessage());
		}finally{
			ds.close();
		}
		return poDetails;
	}
	
	public PO_Res_PODetailsBean searchPODetails_V2(CT_Req_SearchCenterBean search){
		String vQuery;
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(search.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_NP_SearchPODetails_API '"+search.getSearch()+"'";
			
			ResultSet rs = st.executeQuery(vQuery);
			
			CT_Res_ListItemDataBean evt;
			poItem.clear();
			while(rs.next()){
				
				poDetails.setDocNo(rs.getString("docno"));
				poDetails.setDocDate(rs.getDate("docdate"));
				poDetails.setApCode(rs.getString("apcode"));
				poDetails.setApName(rs.getString("apname"));
				poDetails.setDueDate(rs.getDate("duedate"));
				poDetails.setLeadDate(rs.getDate("leaddate"));
				poDetails.setMyDescription(rs.getString("mydescription"));
				poDetails.setSumOfItemAmount(rs.getDouble("SumOfItemAmount"));
				poDetails.setDiscountAmount(rs.getDouble("discountAmount"));
				poDetails.setAfterDiscount(rs.getDouble("afterDiscount"));
				poDetails.setBeforeTaxAmount(rs.getDouble("beforeTaxAmount"));
				poDetails.setTaxAmount(rs.getDouble("taxAmount"));
				poDetails.setTotalAmount(rs.getDouble("totalAmount"));
				poDetails.setTaxType(rs.getInt("taxtype"));

				evt = new CT_Res_ListItemDataBean();
				evt.setItemCode(rs.getString("itemcode"));
				
				System.out.println(rs.getString("barcode"));
				
				evt.setBarCode(rs.getString("barcode"));
				evt.setItemName(rs.getString("itemname"));
				evt.setWhCode(rs.getString("whcode"));
				evt.setShelfCode(rs.getString("shelfcode"));
				evt.setQty(rs.getDouble("qty"));
				evt.setRemainQty(rs.getDouble("remainQty"));
				evt.setPrice(rs.getDouble("price"));
				evt.setDiscountWord(rs.getString("discountWord"));
				evt.setDiscountAmount(rs.getDouble("DiscountAmountSub"));
				evt.setAmount(rs.getDouble("amount"));
				evt.setUnitCode(rs.getString("unitCode"));
				

				
				poItem.add(evt);
				
				resp.setIsSuccess(1);
				resp.setProcessName("Search PO Details");
				resp.setProcessDesc("Search Successful");
	
			}
			poDetails.setResp(resp);
			poDetails.setListItem(poItem);
			st.close();
			rs.close();
					
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search PO Details");
			resp.setProcessDesc(e.getMessage());
		}finally{
			ds.close();
		}
		
		return poDetails;
	}
	
	public PO_Res_VendorPOBean searchVendorPO(CT_Req_ServerDataBaseBean dbName,CT_Req_SearchCenterBean search){
		String vQuery;
		
		System.out.println(dbName.getDatabaseName());
		System.out.println(dbName.getServerName());
		
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_PO_SearchVendorPONOtReceipt_API '"+search.getSearch()+"'";
			
			ResultSet rs = st.executeQuery(vQuery);
			
			PO_Res_ListVendorPOBean evt;
			listPO.clear();
			while(rs.next()){
				evt = new PO_Res_ListVendorPOBean();
				evt.setDocNo(rs.getString("docno"));
				evt.setDocDate(rs.getDate("docdate"));
				evt.setApCode(rs.getString("apcode"));
				evt.setApName(rs.getString("apname"));
				evt.setDueDate(rs.getDate("duedate"));
				evt.setLeadDate(rs.getDate("leaddate"));
				evt.setMyDescription(rs.getString("mydescription"));
				evt.setSumOfItemAmount(rs.getDouble("SumOfItemAmount"));
				evt.setDiscountAmount(rs.getDouble("discountAmount"));
				evt.setAfterDiscount(rs.getDouble("afterDiscount"));
				evt.setBeforeTaxAmount(rs.getDouble("beforeTaxAmount"));
				evt.setTaxAmount(rs.getDouble("taxAmount"));
				evt.setTotalAmount(rs.getDouble("totalAmount"));
				
				listPO.add(evt);
				
				resp.setIsSuccess(1);
				resp.setProcessName("Search PO Details");
				resp.setProcessDesc("Search Successful");
	
			}
			PO.setResp(resp);
			PO.setListPO(listPO);
			st.close();
			rs.close();
					
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search PO Details");
			resp.setProcessDesc("error :"+e.getMessage());
		}finally{
			ds.close();
		}
		return PO;
	}
	
	public PO_Res_VendorPOBean searchVendorPO_V2(CT_Req_SearchCenterBean search){
		String vQuery;
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(search.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_PO_SearchVendorPONOtReceipt_API '"+search.getSearch()+"'";
			
			ResultSet rs = st.executeQuery(vQuery);
			
			PO_Res_ListVendorPOBean evt;
			listPO.clear();
			while(rs.next()){
				evt = new PO_Res_ListVendorPOBean();
				evt.setDocNo(rs.getString("docno"));
				evt.setDocDate(rs.getDate("docdate"));
				evt.setApCode(rs.getString("apcode"));
				evt.setApName(rs.getString("apname"));
				evt.setDueDate(rs.getDate("duedate"));
				evt.setLeadDate(rs.getDate("leaddate"));
				evt.setMyDescription(rs.getString("mydescription"));
				evt.setSumOfItemAmount(rs.getDouble("SumOfItemAmount"));
				evt.setDiscountAmount(rs.getDouble("discountAmount"));
				evt.setAfterDiscount(rs.getDouble("afterDiscount"));
				evt.setBeforeTaxAmount(rs.getDouble("beforeTaxAmount"));
				evt.setTaxAmount(rs.getDouble("taxAmount"));
				evt.setTotalAmount(rs.getDouble("totalAmount"));
				
				listPO.add(evt);
				
				resp.setIsSuccess(1);
				resp.setProcessName("Search PO Details");
				resp.setProcessDesc("Search Successful");
	
			}
			PO.setResp(resp);
			PO.setListPO(listPO);
			st.close();
			rs.close();
					
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search PO Details");
			resp.setProcessDesc("error :"+e.getMessage());
		}finally{
			ds.close();
		}
		return PO;
	}
	
	public RC_Res_InsertDataResponseBean insertReceive(CT_Req_ServerDataBaseBean dbName,RC_Req_InsertUpdateReceiveBean req){
		String vQuery;
		Integer isSuccess;
		String docNo;
		
		System.out.println(dbName.getDatabaseName());
		System.out.println(dbName.getServerName());
		
		
		if (req.getIsCompleteSave()==0){
			docNo = genDoc.genDocNo(dbName,0);
		}else{
			docNo = req.getDocNo();
		}
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_RC_InsertApinvoice_API '"+docNo+"','"+req.getDocDate()+"','"+req.getPoRefNo()+"',"+req.getIsCompleteSave()+",'"+req.getUserID()+"'";
			isSuccess = exec.executeSql(dbName, vQuery);
			
			resp.setIsSuccess(isSuccess);
			resp.setProcessName("Save Receive");
			resp.setProcessDesc("Successful");
			
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Save Receive Header");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		rcResp.setResp(resp);
		rcResp.setDocNo(docNo);
		
		return rcResp;
	}
	
	public RC_Res_InsertDataResponseBean insertReceive_V2(RC_Req_InsertUpdateReceiveBean req){
		String vQuery;
		Integer isSuccess;
		String docNo;
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(req.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		CT_Req_SearchGenDocNoBean genDocno = new CT_Req_SearchGenDocNoBean();
		
		genDocno.setAccessToken(req.getAccessToken());
		genDocno.setHeader("RH");
		genDocno.setModule("Inventory");
		genDocno.setType(0);
		genDocno.setTableName("BCAPINVOICE");
		
		if (req.getIsCompleteSave()==0){
			docNo = genDoc.genNewDocno_V2(genDocno);
		}else{
			docNo = req.getDocNo();
		}
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_RC_InsertApinvoice_API '"+docNo+"','"+req.getDocDate()+"','"+req.getPoRefNo()+"',"+req.getIsCompleteSave()+",'"+req.getUserID()+"'";
			isSuccess = exec.executeSql(dbName, vQuery);
			
			resp.setIsSuccess(isSuccess);
			resp.setProcessName("Save Receive");
			resp.setProcessDesc("Successful");
			
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Save Receive Header");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		rcResp.setResp(resp);
		rcResp.setDocNo(docNo);
		
		return rcResp;
	}
	
	public RC_Res_InsertDataResponseBean insertUpdateDataReceive_V2(RC_Req_InsertDataReceiveBean req){
		String vQuery;
		String vQuerySub;
		Integer isSuccess;
		String docNo;
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(req.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_NP_InsertApInvoice_API '"+req.getDocNo()+"','"+req.getDocDate()+"','"+req.getPoRefNo()+"','"+req.getRefDocNo()+"',"+req.getSumOfItemAmount()+","+req.getIsCancel()+",'"+req.getUserID()+"'";
			isSuccess = exec.executeSql(dbName, vQuery);
			
			//if(req.getIsCancel()==0){
				for(int i=0;i<req.getListItem().size();i++){
					vQuerySub = "exec dbo.USP_NP_InsertApInvoiceSub_API '"+req.getDocNo()+"','"+req.getDocDate()+"','"+req.getPoRefNo()+"','"+req.getListItem().get(i).getBarCode()+"',"+req.getListItem().get(i).getQty()+",'"+req.getListItem().get(i).getWhCode()+"','"+req.getListItem().get(i).getShelfCode()+"',"+req.getListItem().get(i).getIsCancel()+","+req.getListItem().get(i).getStatusRec()+",'"+req.getListItem().get(i).getMyDescription()+"','"+req.getUserID()+"'";
					System.out.println("Insert Sub ="+vQuerySub);
					isSuccess = exec.executeSql(dbName, vQuerySub);
				}
			//}
			
			resp.setIsSuccess(isSuccess);
			resp.setProcessName("Save Receive");
			resp.setProcessDesc("Successful");
			
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Save Receive Header");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		rcResp.setResp(resp);
		rcResp.setDocNo(req.getDocNo());
		
		return rcResp;
	}
	
	public RC_Res_InsertReceiveItemBean manageItem(CT_Req_ServerDataBaseBean dbName,RC_Req_InsertReceiveSubBean req){
		String vQuery;
		Integer isSuccess;
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_RC_InsertApinvoiceSub_API '"+req.getDocNo()+"','"+req.getDocDate()+"','"+req.getPoRefNo()+"','"+req.getBarCode()+"',"+req.getQty()+","+req.getIsCancel()+",'"+req.getUserID()+"'";
			isSuccess = exec.executeSql(dbName, vQuery);
			
			resp.setIsSuccess(isSuccess);
			resp.setProcessName("Save Receive");
			resp.setProcessDesc("Successful");
			
		} catch (Exception e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Save Receive Header");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		rcRespSub.setItemCount(0);
		rcRespSub.setResp(resp);
		
		return rcRespSub;
	}
	
	public RC_Res_InsertReceiveItemBean manageItem_V2(RC_Req_InsertReceiveSubBean req){
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
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_RC_InsertApinvoiceSub_API '"+req.getDocNo()+"','"+req.getDocDate()+"','"+req.getPoRefNo()+"','"+req.getBarCode()+"',"+req.getQty()+","+req.getIsCancel()+",'"+req.getUserID()+"'";
			isSuccess = exec.executeSql(dbName, vQuery);
			
			resp.setIsSuccess(isSuccess);
			resp.setProcessName("Save Receive");
			resp.setProcessDesc("Successful");
			
		} catch (Exception e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Save Receive Header");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		rcRespSub.setItemCount(0);
		rcRespSub.setResp(resp);
		
		return rcRespSub;
	}

	public RC_Res_InsertReceiveItemBean manageListItemSub_V2(RC_Req_ItemReceiveSubBean req){
		String vQuery;
		Integer isSuccess=0;
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(req.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			
			for(int i=0;i<req.getListItem().size();i++){
				vQuery = "exec dbo.USP_RC_InsertApinvoiceItemSub_API '"+req.getDocNo()+"','"+req.getDocDate()+"','"+req.getPoRefNo()+"','"+req.getListItem().get(i).getBarCode()+"',"+req.getListItem().get(i).getQty()+","+req.getListItem().get(i).getIsCancel()+","+req.getListItem().get(i).getStatusRec()+",'"+req.getListItem().get(i).getMyDescription()+"','"+req.getUserID()+"'";
				System.out.println("Insert Sub ="+vQuery);
				isSuccess = exec.executeSql(dbName, vQuery);
			}

			resp.setIsSuccess(isSuccess);
			resp.setProcessName("Save Receive");
			resp.setProcessDesc("Successful");
			
		} catch (Exception e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Save Receive Header");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		rcRespSub.setItemCount(0);
		rcRespSub.setResp(resp);
		
		return rcRespSub;
	}
	
	public PO_Res_PODetailsBean searchReceiveDetails(CT_Req_ServerDataBaseBean dbName,RC_Req_SearchReceiveDetailsBean search){
		String vQuery;
		
		System.out.println(dbName.getServerName());
		System.out.println(dbName.getDatabaseName());
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_PO_SearchPOReceiptDetails_API '"+search.getDocNo()+"','"+search.getRecNo()+"'";
			System.out.println(vQuery);
			ResultSet rs = st.executeQuery(vQuery);
			
			CT_Res_ListItemDataBean evt;
			poItem.clear();
			while(rs.next()){
				
				poDetails.setDocNo(rs.getString("docno"));
				poDetails.setDocDate(rs.getDate("docdate"));
				poDetails.setApCode(rs.getString("apcode"));
				poDetails.setApName(rs.getString("apname"));
				poDetails.setDueDate(rs.getDate("duedate"));
				poDetails.setLeadDate(rs.getDate("leaddate"));
				poDetails.setMyDescription(rs.getString("mydescription"));
				poDetails.setSumOfItemAmount(rs.getDouble("SumOfItemAmount"));
				poDetails.setDiscountAmount(rs.getDouble("discountAmount"));
				poDetails.setAfterDiscount(rs.getDouble("afterDiscount"));
				poDetails.setBeforeTaxAmount(rs.getDouble("beforeTaxAmount"));
				poDetails.setTaxAmount(rs.getDouble("taxAmount"));
				poDetails.setTotalAmount(rs.getDouble("totalAmount"));
				poDetails.setIsDocCancel(rs.getInt("DocisCancel"));
				poDetails.setIsConfirm(rs.getInt("isconfirm"));


				evt = new CT_Res_ListItemDataBean();
				evt.setItemCode(rs.getString("itemcode"));
				evt.setItemName(rs.getString("itemname"));
				evt.setBarCode(rs.getString("barcode"));
				evt.setWhCode(rs.getString("whcode"));
				evt.setShelfCode(rs.getString("shelfcode"));
				evt.setQty(rs.getDouble("qty"));
				evt.setRemainQty(rs.getDouble("remainQty"));
				evt.setPrice(rs.getDouble("price"));
				evt.setDiscountWord(rs.getString("discountWord"));
				evt.setDiscountAmount(rs.getDouble("DiscountAmountSub"));
				evt.setAmount(rs.getDouble("amount"));
				evt.setUnitCode(rs.getString("unitCode"));
				evt.setRcQty(rs.getDouble("recQty"));
				evt.setStatus(rs.getInt("rcstatus"));
				evt.setIsListCancel(rs.getInt("iscancel"));
				
				poItem.add(evt);
				
				resp.setIsSuccess(1);
				resp.setProcessName("Search PO Details");
				resp.setProcessDesc("Search Successful");
	
			}
			poDetails.setResp(resp);
			poDetails.setListItem(poItem);
			st.close();
			rs.close();
					
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search PO Details");
			resp.setProcessDesc(e.getMessage());
		}finally{
			ds.close();
		}
		return poDetails;
	}
	
	public PO_Res_PODetailsBean searchReceiveDetails_V2(RC_Req_SearchReceiveDetailsBean search){
		String vQuery;
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(search.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_PO_SearchPOReceiptDetails_API '"+search.getDocNo()+"','"+search.getRecNo()+"'";
			System.out.println(vQuery);
			ResultSet rs = st.executeQuery(vQuery);
			
			CT_Res_ListItemDataBean evt;
			poItem.clear();
			while(rs.next()){
				
				poDetails.setDocNo(rs.getString("docno"));
				poDetails.setDocDate(rs.getDate("docdate"));
				poDetails.setApCode(rs.getString("apcode"));
				poDetails.setApName(rs.getString("apname"));
				poDetails.setDueDate(rs.getDate("duedate"));
				poDetails.setLeadDate(rs.getDate("leaddate"));
				poDetails.setMyDescription(rs.getString("mydescription"));
				poDetails.setSumOfItemAmount(rs.getDouble("SumOfItemAmount"));
				poDetails.setDiscountAmount(rs.getDouble("discountAmount"));
				poDetails.setAfterDiscount(rs.getDouble("afterDiscount"));
				poDetails.setBeforeTaxAmount(rs.getDouble("beforeTaxAmount"));
				poDetails.setTaxAmount(rs.getDouble("taxAmount"));
				poDetails.setTotalAmount(rs.getDouble("totalAmount"));
				poDetails.setIsDocCancel(rs.getInt("DocisCancel"));
				poDetails.setIsConfirm(rs.getInt("isconfirm"));


				evt = new CT_Res_ListItemDataBean();
				evt.setItemCode(rs.getString("itemcode"));
				evt.setItemName(rs.getString("itemname"));
				evt.setBarCode(rs.getString("barcode"));
				evt.setWhCode(rs.getString("whcode"));
				evt.setShelfCode(rs.getString("shelfcode"));
				evt.setQty(rs.getDouble("qty"));
				evt.setRemainQty(rs.getDouble("remainQty"));
				evt.setPrice(rs.getDouble("price"));
				evt.setDiscountWord(rs.getString("discountWord"));
				evt.setDiscountAmount(rs.getDouble("DiscountAmountSub"));
				evt.setAmount(rs.getDouble("amount"));
				evt.setUnitCode(rs.getString("unitCode"));
				evt.setRcQty(rs.getDouble("recQty"));
				evt.setStatus(rs.getInt("rcstatus"));
				evt.setIsListCancel(rs.getInt("iscancel"));
				
				poItem.add(evt);
				
				resp.setIsSuccess(1);
				resp.setProcessName("Search PO Details");
				resp.setProcessDesc("Search Successful");
	
			}
			poDetails.setResp(resp);
			poDetails.setListItem(poItem);
			st.close();
			rs.close();
					
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search PO Details");
			resp.setProcessDesc(e.getMessage());
		}finally{
			ds.close();
		}
		return poDetails;
	}
	
	
	public PO_Res_PODetailsBean searchRecDetails_V2(CT_Req_SearchCenterBean search){
		String vQuery;
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(search.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_PO_SearchReceiptDetails_API '"+search.getSearch()+"'";
			System.out.println(vQuery);
			ResultSet rs = st.executeQuery(vQuery);
			
			CT_Res_ListItemDataBean evt;
			poItem.clear();
			while(rs.next()){
				
				poDetails.setDocNo(rs.getString("docno"));
				poDetails.setDocDate(rs.getDate("docdate"));
				poDetails.setApCode(rs.getString("apcode"));
				poDetails.setApName(rs.getString("apname"));
				poDetails.setDueDate(rs.getDate("duedate"));
				poDetails.setLeadDate(rs.getDate("leaddate"));
				poDetails.setMyDescription(rs.getString("mydescription"));
				poDetails.setSumOfItemAmount(rs.getDouble("SumOfItemAmount"));
				poDetails.setDiscountAmount(rs.getDouble("discountAmount"));
				poDetails.setAfterDiscount(rs.getDouble("afterDiscount"));
				poDetails.setBeforeTaxAmount(rs.getDouble("beforeTaxAmount"));
				poDetails.setTaxAmount(rs.getDouble("taxAmount"));
				poDetails.setTotalAmount(rs.getDouble("totalAmount"));
				poDetails.setIsDocCancel(rs.getInt("DocisCancel"));
				poDetails.setIsConfirm(rs.getInt("isconfirm"));
				poDetails.setRefDocno(rs.getString("refdocno"));


				evt = new CT_Res_ListItemDataBean();
				evt.setItemCode(rs.getString("itemcode"));
				evt.setItemName(rs.getString("itemname"));
				evt.setBarCode(rs.getString("barcode"));
				evt.setWhCode(rs.getString("whcode"));
				evt.setShelfCode(rs.getString("shelfcode"));
				evt.setQty(rs.getDouble("qty"));
				evt.setRemainQty(rs.getDouble("remainQty"));
				evt.setPrice(rs.getDouble("price"));
				evt.setDiscountWord(rs.getString("discountWord"));
				evt.setDiscountAmount(rs.getDouble("DiscountAmountSub"));
				evt.setAmount(rs.getDouble("amount"));
				evt.setUnitCode(rs.getString("unitCode"));
				evt.setRcQty(rs.getDouble("recQty"));
				evt.setStatus(rs.getInt("rcstatus"));
				evt.setIsListCancel(rs.getInt("iscancel"));
				evt.setMyDescription(rs.getString("mydescriptionsub"));
				
				poItem.add(evt);
				
				resp.setIsSuccess(1);
				resp.setProcessName("Search PO Details");
				resp.setProcessDesc("Search Successful");
	
			}
			poDetails.setResp(resp);
			poDetails.setListItem(poItem);
			st.close();
			rs.close();
					
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search PO Details");
			resp.setProcessDesc(e.getMessage());
		}finally{
			ds.close();
		}
		return poDetails;
	}
	
	public RC_Res_SearchRecieveBean searchReceive(CT_Req_ServerDataBaseBean dbName,CT_Req_SearchCenterBean search){
		String vQuery;
		
		SearchDataCenterBean post = new SearchDataCenterBean();
		CT_Req_SearchCenterBean req1 = new CT_Req_SearchCenterBean();
		
		System.out.println("searchReceive");
		System.out.println(dbName.getDatabaseName());
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_RC_SearchApinvoice_API '"+search.getSearch()+"'";
			System.out.println(vQuery);
			ResultSet rs = st.executeQuery(vQuery);
			
			RC_Res_ListSearchRecieveBean evt;
			listDoc.clear();
			while(rs.next()){
				
				System.out.println(rs.getString("DocNo"));
				
				evt = new RC_Res_ListSearchRecieveBean();
				evt.setRecNo(rs.getString("DocNo"));
				evt.setDocDate(rs.getDate("docdate"));
				evt.setApCode(rs.getString("apcode"));
				evt.setApName(rs.getString("apname"));
				evt.setSumOfItemAmount(rs.getDouble("sumofitemamount"));
				evt.setPoRefNo(rs.getString("pORefNo"));
				evt.setMyDescription(rs.getString("mydescription"));
				evt.setIsCancel(rs.getInt("iscancel"));
				evt.setIsConfirm(rs.getInt("isconfirm"));
				
				listDoc.add(evt);
				
				resp.setIsSuccess(1);
				resp.setProcessName("Search Receive List");
				resp.setProcessDesc("Search Successful");
	
			}
			receive.setResp(resp);
			receive.setDetails(listDoc);
			st.close();
			rs.close();
					
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search Receive List");
			resp.setProcessDesc("error :"+e.getMessage());
		}finally{
			ds.close();
		}
		return receive;
	}
	
	public RC_Res_SearchRecieveBean searchReceive_V2(CT_Req_SearchCenterBean search){
		String vQuery;
		
//		SearchDataCenterBean post = new SearchDataCenterBean();
//		CT_Req_SearchCenterBean req1 = new CT_Req_SearchCenterBean();
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(search.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_RC_SearchApinvoice_API '"+search.getSearch()+"'";
			System.out.println(vQuery);
			ResultSet rs = st.executeQuery(vQuery);
			
			RC_Res_ListSearchRecieveBean evt;
			listDoc.clear();
			while(rs.next()){
				
				System.out.println(rs.getString("DocNo"));
				
				evt = new RC_Res_ListSearchRecieveBean();
				evt.setRecNo(rs.getString("DocNo"));
				evt.setDocDate(rs.getDate("docdate"));
				evt.setApCode(rs.getString("apcode"));
				evt.setApName(rs.getString("apname"));
				evt.setSumOfItemAmount(rs.getDouble("sumofitemamount"));
				evt.setPoRefNo(rs.getString("pORefNo"));
				evt.setMyDescription(rs.getString("mydescription"));
				evt.setIsCancel(rs.getInt("iscancel"));
				evt.setIsConfirm(rs.getInt("isconfirm"));
				
				listDoc.add(evt);
				
				resp.setIsSuccess(1);
				resp.setProcessName("Search Receive List");
				resp.setProcessDesc("Search Successful");
	
			}
			receive.setResp(resp);
			receive.setDetails(listDoc);
			st.close();
			rs.close();
					
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search Receive List");
			resp.setProcessDesc("error :"+e.getMessage());
		}finally{
			ds.close();
		}
		return receive;
	}
	
	public CT_Res_ResultResponseBean cancelReceive(CT_Req_ServerDataBaseBean dbName,RC_Req_SearchReceiveDetailsBean search){
		String vQuery;
		int isSuccess;

		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_RC_CancelReceive_API '"+search.getRecNo()+"','"+search.getDocNo()+"'";
			isSuccess = exec.executeSql(dbName, vQuery);
			
			resp.setIsSuccess(isSuccess);
			resp.setProcessName("Cancel Receive");
			resp.setProcessDesc("Successful");
			
		} catch (Exception e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Cancel Receive Header");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		return resp;
	}
	
	public CT_Res_ResultResponseBean cancelReceive_V2(RC_Req_SearchReceiveDetailsBean search){
		String vQuery;
		int isSuccess;

		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(search.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_RC_CancelReceive_API '"+search.getRecNo()+"','"+search.getDocNo()+"'";
			isSuccess = exec.executeSql(dbName, vQuery);
			
			resp.setIsSuccess(isSuccess);
			resp.setProcessName("Cancel Receive");
			resp.setProcessDesc("Successful");
			
		} catch (Exception e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Cancel Receive Header");
			resp.setProcessDesc("Error :"+e.getMessage());
		}
		return resp;
	}
	
	public RC_Res_SearchItemDetailsBean searchItem(CT_Req_ServerDataBaseBean dbName,RC_Req_SearchItemReceive search){
		String vQuery;
		
		System.out.println(dbName.getServerName());
		System.out.println(dbName.getDatabaseName());
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_NP_SearchItem_API "+search.getType()+",'"+search.getBarCode()+"'";
			
			ResultSet rs = st.executeQuery(vQuery);
			
			listItem.clear();
			RC_Res_ListSearchItemBean evt;
			while(rs.next()){
				
				evt = new RC_Res_ListSearchItemBean();
				evt.setBarCode(rs.getString("barCode"));
				evt.setItemCode(rs.getString("itemCode"));
				evt.setItemName(rs.getString("itemName"));
				evt.setQtyRC(data.checkItemQtyReceive(dbName, search.getDocNo(), rs.getString("itemCode")));
				evt.setUnitCode(rs.getString("unitCode"));
				evt.setPrice(rs.getDouble("price"));
				
				listItem.add(evt);
				
				resp.setIsSuccess(1);
				resp.setProcessName("Search Item Details");
				resp.setProcessDesc("Search Successful");
			}
			itm.setResp(resp);
			itm.setItem(listItem);
			st.close();
			rs.close();
					
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search Item Details");
			resp.setProcessDesc("error :"+e.getMessage());
		}finally{
			ds.close();
		}
		return itm;
	}
	
	public RC_Res_SearchItemDetailsBean searchItem_V2(RC_Req_SearchItemReceive search){
		String vQuery;
		
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		CT_Res_GenAccessTokenBean token;
		token = exec.dataConnect(search.getAccessToken());
		
		System.out.println(token.getDataBaseName());
		System.out.println(token.getServerName());
		
		dbName.setDatabaseName(token.getDataBaseName());
		dbName.setServerName(token.getServerName());
		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_NP_SearchItem_API "+search.getType()+",'"+search.getBarCode()+"'";
			
			ResultSet rs = st.executeQuery(vQuery);
			
			listItem.clear();
			RC_Res_ListSearchItemBean evt;
			while(rs.next()){
				
				evt = new RC_Res_ListSearchItemBean();
				evt.setBarCode(rs.getString("barCode"));
				evt.setItemCode(rs.getString("itemCode"));
				evt.setItemName(rs.getString("itemName"));
				evt.setQtyRC(data.checkItemQtyReceive(dbName, search.getDocNo(), rs.getString("itemCode")));
				evt.setUnitCode(rs.getString("unitCode"));
				evt.setPrice(rs.getDouble("price"));
				
				listItem.add(evt);
				
				resp.setIsSuccess(1);
				resp.setProcessName("Search Item Details");
				resp.setProcessDesc("Search Successful");
			}
			itm.setResp(resp);
			itm.setItem(listItem);
			st.close();
			rs.close();
					
		} catch (SQLException e) {
			// TODO: handle exception
			resp.setIsSuccess(0);
			resp.setProcessName("Search Item Details");
			resp.setProcessDesc("error :"+e.getMessage());
		}finally{
			ds.close();
		}
		return itm;
	}
	
	public RC_Res_TestAPI callApi(){
		
		test.setDocNo("RE590730-0001");
		test.setApCode("somrod lakthan");
		
		return test;
	}
	
	public CT_Res_ItemDataBean itemList(CT_Req_SearchTypeBean req){
		CT_Res_ItemDataBean itemdata = new CT_Res_ItemDataBean();
		
		itemdata = data.searchItem(req);
		
		return itemdata;
	}
	
	public CT_Res_ItemDataBean itemnava(CT_Req_SearchCenterBean req){
		String newDocNo="";
		String docNo="";
		
		//CT_Res_DataResultBean staff;
		
		try {

			URL url = new URL("http://qserver.nopadol.com:8080/NPDataCenterWs/center/searchitem");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			//String input = "{\"req\":\"iPad 4\"}";
			//String input = req.toString();
			//System.out.println("input="+input);
			String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"search\":\""+req.getSearch()+"\"}";
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
		
		//StringEntity str = null;
		
    	Gson gson = new Gson();
    	String json = gson.toJson(docNo); 
    	CT_Res_ItemDataBean itemData = gson.fromJson(docNo, CT_Res_ItemDataBean.class);
    	System.out.println("Docno :"+itemData.getData());
    	
    	//str = new StringEntity(jsonString, HTTP.UTF_8);
    	
        //StringEntity params =new StringEntity(json,HTTP.UTF_8);
    	
    	System.out.println(json.charAt(0));

		
    	newDocNo = itemData.getData().get(0).getItemName();
    	
    	System.out.println("newDocNo:"+newDocNo);
    	
		return itemData;
	}
	
	public CT_Res_DataResultBean genReceiveNo(CT_Req_SearchGenDocNoBean req){
		String newDocNo="";
		String docNo="";
		
		//CT_Res_DataResultBean staff;
		
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
}
