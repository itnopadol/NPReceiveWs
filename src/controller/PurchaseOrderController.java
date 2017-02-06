package controller;

import connect.SQLConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean_req.CT_Req_SearchCenterBean;
import bean_req.CT_Req_ServerDataBaseBean;
import bean_req.PO_Req_SearchVendorNotReceiptBean;
import bean_res.CT_Res_ListItemDataBean;
import bean_res.CT_Res_ResultResponseBean;
import bean_res.PO_Res_ListVendorNotReceiptBean;
import bean_res.PO_Res_ListVendorPOBean;
import bean_res.PO_Res_PODetailsBean;
import bean_res.PO_Res_VendorNotReceiptBean;
import bean_res.PO_Res_VendorPOBean;
import bean_res.PR_Res_ListStockRequestBean;

public class PurchaseOrderController {
	SQLConn ds = SQLConn.INSTANCE ;
	CT_Req_ServerDataBaseBean sv = new CT_Req_ServerDataBaseBean();
	CT_Res_ResultResponseBean resp = new CT_Res_ResultResponseBean();
	PO_Res_VendorNotReceiptBean ap = new PO_Res_VendorNotReceiptBean();
	List<PO_Res_ListVendorNotReceiptBean> apList = new ArrayList<PO_Res_ListVendorNotReceiptBean>();
	PO_Res_PODetailsBean poDetails = new PO_Res_PODetailsBean();
	List<CT_Res_ListItemDataBean> poItem = new ArrayList<CT_Res_ListItemDataBean>();
	PO_Res_VendorPOBean PO = new PO_Res_VendorPOBean();
	List<PO_Res_ListVendorPOBean> listPO = new ArrayList<PO_Res_ListVendorPOBean>();
	
	public PO_Res_VendorNotReceiptBean searchVendorNotReceipt(CT_Req_ServerDataBaseBean dbName,CT_Req_SearchCenterBean search){	
		String vQuery;

		System.out.println(dbName.getServerName());
		System.out.println(dbName.getDatabaseName());
		
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
		
		System.out.println(dbName.getServerName());
		System.out.println(dbName.getDatabaseName());
		
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
			resp.setProcessDesc(e.getMessage());
		}finally{
			ds.close();
		}
		return PO;
	}
}
