package view;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import controller.PurchaseOrderController;
import controller.ReceiveController;
import controller.StockTransferController;

import bean_req.CT_Req_SearchCenterBean;
import bean_req.CT_Req_SearchGenDocNoBean;
import bean_req.CT_Req_ServerDataBaseBean;
import bean_req.PO_Req_SearchVendorNotReceiptBean;
import bean_req.RC_Req_InsertDataReceiveBean;
import bean_req.RC_Req_InsertReceiveSubBean;
import bean_req.RC_Req_InsertUpdateReceiveBean;
import bean_req.RC_Req_ItemReceiveSubBean;
import bean_req.RC_Req_SearchItemReceive;
import bean_req.RC_Req_SearchReceiveDetailsBean;
import bean_req.RC_Req_TestAPI;
import bean_res.CT_Res_DataResultBean;
import bean_res.CT_Res_ItemDataBean;
import bean_res.CT_Res_ResultResponseBean;
import bean_res.PO_Res_PODetailsBean;
import bean_res.PO_Res_VendorNotReceiptBean;
import bean_res.PO_Res_VendorPOBean;
import bean_res.RC_Res_InsertDataResponseBean;
import bean_res.RC_Res_InsertReceiveItemBean;
import bean_res.RC_Res_ReceiveDataBean;
import bean_res.RC_Res_SearchItemDetailsBean;
import bean_res.RC_Res_SearchRecieveBean;
import bean_res.RC_Res_TestAPI;

@Path(value="/rc")
public class Receive {
	@POST 
	@Path("/vendor")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public PO_Res_VendorNotReceiptBean searchVendorNotReceipt(CT_Req_SearchCenterBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		PO_Res_VendorNotReceiptBean vendor = new PO_Res_VendorNotReceiptBean();
		ReceiveController ctl = new ReceiveController();
		db.setServerName("192.168.0.7");
		db.setDatabaseName("nava");
		
		vendor = ctl.searchVendorNotReceipt(db,search);
		return vendor;
	}
	
	@POST 
	@Path("/v2/vendor")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public PO_Res_VendorNotReceiptBean searchVendorNotReceipt_V2(CT_Req_SearchCenterBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		PO_Res_VendorNotReceiptBean vendor = new PO_Res_VendorNotReceiptBean();
		ReceiveController ctl = new ReceiveController();
//		db.setServerName("192.168.0.7");
//		db.setDatabaseName("nava");
		
		vendor = ctl.searchVendorNotReceipt_V2(search);
		return vendor;
	}
	
	@POST 
	@Path("/vendorpo")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public PO_Res_VendorPOBean searchVendorPO(CT_Req_SearchCenterBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		PO_Res_VendorPOBean vendorPO = new PO_Res_VendorPOBean();
		ReceiveController ctl = new ReceiveController();
		db.setServerName("192.168.0.7");
		db.setDatabaseName("nava");
		
		vendorPO = ctl.searchVendorPO(db, search);
		return vendorPO;
	}
	
	@POST 
	@Path("/v2/vendorpo")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public PO_Res_VendorPOBean searchVendorPO_V2(CT_Req_SearchCenterBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		PO_Res_VendorPOBean vendorPO = new PO_Res_VendorPOBean();
		ReceiveController ctl = new ReceiveController();
//		db.setServerName("192.168.0.7");
//		db.setDatabaseName("nava");
		
		vendorPO = ctl.searchVendorPO_V2(search);
		return vendorPO;
	}

	@POST 
	@Path("/podetails")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public PO_Res_PODetailsBean searchPODetails(CT_Req_SearchCenterBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		PO_Res_PODetailsBean podetails = new PO_Res_PODetailsBean();
		ReceiveController ctl = new ReceiveController();
		db.setServerName("192.168.0.7");
		db.setDatabaseName("nava");
		
		podetails = ctl.searchPODetails(db, search);
		return podetails;
	}
	
	@POST 
	@Path("/v2/podetails")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public PO_Res_PODetailsBean searchPODetails_V2(CT_Req_SearchCenterBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		PO_Res_PODetailsBean podetails = new PO_Res_PODetailsBean();
		ReceiveController ctl = new ReceiveController();
//		db.setServerName("192.168.0.7");
//		db.setDatabaseName("nava");
		
		podetails = ctl.searchPODetails_V2(search);
		return podetails;
	}
	
	@POST 
	@Path("/insert")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public RC_Res_InsertDataResponseBean insertReceive(RC_Req_InsertUpdateReceiveBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		RC_Res_InsertDataResponseBean rc = new RC_Res_InsertDataResponseBean();
		ReceiveController ctl = new ReceiveController();
		db.setServerName("192.168.0.7");
		db.setDatabaseName("nava");
		
		rc = ctl.insertReceive(db, req);
		return rc;
	}
		
	@POST 
	@Path("/v2/insert")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public RC_Res_InsertDataResponseBean insertReceive_V2(RC_Req_InsertUpdateReceiveBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		RC_Res_InsertDataResponseBean rc = new RC_Res_InsertDataResponseBean();
		ReceiveController ctl = new ReceiveController();
//		db.setServerName("192.168.0.7");
//		db.setDatabaseName("nava");
		
		rc = ctl.insertReceive_V2(req);
		return rc;
	}
	
	
	@POST 
	@Path("/v2/insertapinvoice")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public RC_Res_InsertDataResponseBean insertApinvoice_V2(RC_Req_InsertDataReceiveBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		RC_Res_InsertDataResponseBean rc = new RC_Res_InsertDataResponseBean();
		ReceiveController ctl = new ReceiveController();
//		db.setServerName("192.168.0.7");
//		db.setDatabaseName("nava");
		
		rc = ctl.insertUpdateDataReceive_V2(req);
		return rc;
	}
	
	@POST 
	@Path("/manageitem")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public RC_Res_InsertReceiveItemBean insertReceiveSub(RC_Req_InsertReceiveSubBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		RC_Res_InsertReceiveItemBean sub = new RC_Res_InsertReceiveItemBean();
		ReceiveController ctl = new ReceiveController();
		db.setServerName("192.168.0.7");
		db.setDatabaseName("nava");
		
		sub = ctl.manageItem(db, req);
		return sub;
	}
	
	@POST 
	@Path("/v2/manageitem")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public RC_Res_InsertReceiveItemBean insertReceiveSub_V2(RC_Req_InsertReceiveSubBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		RC_Res_InsertReceiveItemBean sub = new RC_Res_InsertReceiveItemBean();
		ReceiveController ctl = new ReceiveController();
//		db.setServerName("192.168.0.7");
//		db.setDatabaseName("nava");
		
		sub = ctl.manageItem_V2(req);
		return sub;
	}
	
	@POST 
	@Path("/v2/managelistitem")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public RC_Res_InsertReceiveItemBean insertListReceiveSub_V2(RC_Req_ItemReceiveSubBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		RC_Res_InsertReceiveItemBean sub = new RC_Res_InsertReceiveItemBean();
		ReceiveController ctl = new ReceiveController();
//		db.setServerName("192.168.0.7");
//		db.setDatabaseName("nava");
		
		sub = ctl.manageListItemSub_V2(req);
		return sub;
	}
	
	@POST 
	@Path("/search")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public PO_Res_PODetailsBean searchReceive(RC_Req_SearchReceiveDetailsBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		PO_Res_PODetailsBean data = new PO_Res_PODetailsBean();
		ReceiveController ctl = new ReceiveController();
		db.setServerName("192.168.0.7");
		db.setDatabaseName("nava");
		
		data = ctl.searchReceiveDetails(db, search);
		return data;
	}
	
	@POST 
	@Path("/v2/search")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public PO_Res_PODetailsBean searchReceive_V2(RC_Req_SearchReceiveDetailsBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		PO_Res_PODetailsBean data = new PO_Res_PODetailsBean();
		ReceiveController ctl = new ReceiveController();
//		db.setServerName("192.168.0.7");
//		db.setDatabaseName("nava");
		
		data = ctl.searchReceiveDetails_V2(search);
		return data;
	}
	
	
	@POST 
	@Path("/v2/searchrec")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public PO_Res_PODetailsBean searchRecDetails_V2(CT_Req_SearchCenterBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		PO_Res_PODetailsBean data = new PO_Res_PODetailsBean();
		ReceiveController ctl = new ReceiveController();
//		db.setServerName("192.168.0.7");
//		db.setDatabaseName("nava");
		
		data = ctl.searchRecDetails_V2(search);
		return data;
	}
	
	@POST 
	@Path("/listdocno")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public RC_Res_SearchRecieveBean listReceive(CT_Req_SearchCenterBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		RC_Res_SearchRecieveBean data = new RC_Res_SearchRecieveBean();
		ReceiveController ctl = new ReceiveController();
		db.setServerName("192.168.0.7");
		db.setDatabaseName("nava");
		
		data = ctl.searchReceive(db, search);
		return data;
	}
	
	
	@POST 
	@Path("/v2/listdocno")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public RC_Res_SearchRecieveBean listReceive_V2(CT_Req_SearchCenterBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		RC_Res_SearchRecieveBean data = new RC_Res_SearchRecieveBean();
		ReceiveController ctl = new ReceiveController();
//		db.setServerName("192.168.0.7");
//		db.setDatabaseName("nava");
		
		data = ctl.searchReceive_V2(search);
		return data;
	}
		
	@POST 
	@Path("/cancel")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_ResultResponseBean cancelReceive(RC_Req_SearchReceiveDetailsBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_ResultResponseBean cancel = new CT_Res_ResultResponseBean();
		ReceiveController ctl = new ReceiveController();
		db.setServerName("192.168.0.7");
		db.setDatabaseName("nava");
		
		cancel = ctl.cancelReceive(db, search);
		return cancel;
	}
		
	@POST 
	@Path("/v2/cancel")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_ResultResponseBean cancelReceive_V2(RC_Req_SearchReceiveDetailsBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_ResultResponseBean cancel = new CT_Res_ResultResponseBean();
		ReceiveController ctl = new ReceiveController();
//		db.setServerName("192.168.0.7");
//		db.setDatabaseName("nava");
		
		cancel = ctl.cancelReceive_V2(search);
		return cancel;
	}

	@POST 
	@Path("/item")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public RC_Res_SearchItemDetailsBean searchItem(RC_Req_SearchItemReceive search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		RC_Res_SearchItemDetailsBean itm = new RC_Res_SearchItemDetailsBean();
		ReceiveController ctl = new ReceiveController();
		db.setServerName("192.168.0.7");
		db.setDatabaseName("nava");
		
		itm = ctl.searchItem(db, search);
		return itm;
	}
	
	@POST 
	@Path("/v2/item")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public RC_Res_SearchItemDetailsBean searchItem_V2(RC_Req_SearchItemReceive search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		RC_Res_SearchItemDetailsBean itm = new RC_Res_SearchItemDetailsBean();
		ReceiveController ctl = new ReceiveController();
//		db.setServerName("192.168.0.7");
//		db.setDatabaseName("nava");
		
		itm = ctl.searchItem_V2(search);
		return itm;
	}
	
	@POST 
	@Path("/searchitem")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_ItemDataBean searchItem(CT_Req_SearchCenterBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_ItemDataBean itm = new CT_Res_ItemDataBean();
		ReceiveController ctl = new ReceiveController();
		
		itm = ctl.itemnava(search);
		return itm;
	}
	
	@POST 
	@Path("/v2/searchitem")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_ItemDataBean searchItem_V2(CT_Req_SearchCenterBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_ItemDataBean itm = new CT_Res_ItemDataBean();
		ReceiveController ctl = new ReceiveController();
		
		itm = ctl.itemnava(search);
		return itm;
	}
	
	@GET 
	@Path("/api")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public RC_Res_TestAPI searchAPI(){
		RC_Res_TestAPI test = new RC_Res_TestAPI();
		ReceiveController ctl = new ReceiveController();
		
		test = ctl.callApi();
		return test;
	}
	
	@POST 
	@Path("/v2/gendocno")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_DataResultBean genTrnNo(CT_Req_SearchGenDocNoBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_DataResultBean docno = new CT_Res_DataResultBean();
		ReceiveController ctl = new ReceiveController();
		
		docno = ctl.genReceiveNo(req);
		return docno;
	}	
}
