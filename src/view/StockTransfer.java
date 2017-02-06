package view;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bean_req.CT_Req_SearchCenterBean;
import bean_req.CT_Req_SearchGenDocNoBean;
import bean_req.CT_Req_SearchRefCodeBean;
import bean_req.CT_Req_SearchStockWareHouseBean;
import bean_req.CT_Req_SearchTypeBean;
import bean_req.CT_Req_ServerDataBaseBean;
import bean_req.TF_Req_InsertStockTransferBean;
import bean_req.TF_Req_ManageItemBean;
import bean_req.TF_Req_ReportUsedTFBean;
import bean_req.TF_Req_SearchStkTransferBean;
import bean_res.CT_Res_DataMasterBean;
import bean_res.CT_Res_DataResultBean;
import bean_res.CT_Res_ItemDataBean;
import bean_res.CT_Res_ResultResponseBean;
import bean_res.CT_Res_WareHouseBean;
import bean_res.RC_Res_InsertDataResponseBean;
import bean_res.RC_Res_InsertReceiveItemBean;
import bean_res.TF_Res_ReportUsedTFBean;
import bean_res.TF_Res_SearchStkTransferBean;
import bean_res.TF_Res_StkTransferDetailsBean;
import controller.ReceiveController;
import controller.StockTransferController;

@Path(value="/trn")
public class StockTransfer {
	@POST 
	@Path("/insert")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public RC_Res_InsertDataResponseBean insertTransfer(TF_Req_InsertStockTransferBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		RC_Res_InsertDataResponseBean trn = new RC_Res_InsertDataResponseBean();
		StockTransferController ctl = new StockTransferController();
		db.setServerName("192.168.0.6");
		db.setDatabaseName("navatest");
		
		trn = ctl.insertStkTransfer(db, req);
		return trn;
	}
	
	@POST 
	@Path("/v2/gendocno")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_DataResultBean genTrnNo(CT_Req_SearchGenDocNoBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_DataResultBean docno = new CT_Res_DataResultBean();
		StockTransferController ctl = new StockTransferController();
		
		docno = ctl.genTrnNo(req);
		return docno;
	}
	
	
	@POST 
	@Path("/v2/insert")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public RC_Res_InsertDataResponseBean insertTransfer_V2(TF_Req_InsertStockTransferBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		RC_Res_InsertDataResponseBean trn = new RC_Res_InsertDataResponseBean();
		StockTransferController ctl = new StockTransferController();
//		db.setServerName("192.168.0.6");
//		db.setDatabaseName("navatest");
		
		trn = ctl.insertStkTransfer_V2(req);
		return trn;
	}
	
	@POST 
	@Path("/manageitem")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public RC_Res_InsertReceiveItemBean insertStktransferSub(TF_Req_ManageItemBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		RC_Res_InsertReceiveItemBean sub = new RC_Res_InsertReceiveItemBean();
		StockTransferController ctl = new StockTransferController();
		db.setServerName("192.168.0.6");
		db.setDatabaseName("navatest");
		
		sub = ctl.manageItem(db, req);
		return sub;
	}
	
	
	@POST 
	@Path("/v2/manageitem")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public RC_Res_InsertReceiveItemBean insertStktransferSub_V2(TF_Req_ManageItemBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		RC_Res_InsertReceiveItemBean sub = new RC_Res_InsertReceiveItemBean();
		StockTransferController ctl = new StockTransferController();
//		db.setServerName("192.168.0.6");
//		db.setDatabaseName("navatest");
		
		sub = ctl.manageItem_V2(req);
		return sub;
	}
	
	@POST 
	@Path("/cancel")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_ResultResponseBean CancelStkTransfer(TF_Req_SearchStkTransferBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_ResultResponseBean resp = new CT_Res_ResultResponseBean();
		StockTransferController ctl = new StockTransferController();
		db.setServerName("192.168.0.6");
		db.setDatabaseName("navatest");
		
		resp = ctl.CancelStkTransfer(db, req);
		return resp;
	}
	
	
	@POST 
	@Path("/v2/cancel")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_ResultResponseBean CancelStkTransfer_V2(TF_Req_SearchStkTransferBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_ResultResponseBean resp = new CT_Res_ResultResponseBean();
		StockTransferController ctl = new StockTransferController();
//		db.setServerName("192.168.0.6");
//		db.setDatabaseName("navatest");
		
		resp = ctl.CancelStkTransfer_V2(req);
		return resp;
	}

	@POST 
	@Path("/search")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public TF_Res_SearchStkTransferBean searchTransfer(CT_Req_SearchTypeBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		TF_Res_SearchStkTransferBean tf = new TF_Res_SearchStkTransferBean();
		StockTransferController ctl = new StockTransferController();
		db.setServerName("192.168.0.6");
		db.setDatabaseName("navatest");
		
		tf = ctl.searchStkTransfer(db, req);
		return tf;
	}
	
	
	@POST 
	@Path("/v2/search")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public TF_Res_SearchStkTransferBean searchTransfer_V2(CT_Req_SearchTypeBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		TF_Res_SearchStkTransferBean tf = new TF_Res_SearchStkTransferBean();
		StockTransferController ctl = new StockTransferController();
		db.setServerName("192.168.0.6");
		db.setDatabaseName("navatest");
		
		tf = ctl.searchStkTransfer_V2(req);
		return tf;
	}
	
	
	@POST 
	@Path("/searchdetails")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public TF_Res_StkTransferDetailsBean searchTransferDetails(CT_Req_SearchTypeBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		TF_Res_StkTransferDetailsBean tfDetails = new TF_Res_StkTransferDetailsBean();
		StockTransferController ctl = new StockTransferController();
		db.setServerName("192.168.0.6");
		db.setDatabaseName("navatest");
		
		tfDetails = ctl.searchStkTransferDetails(db, req);
		return tfDetails;
	}
	
	
	@POST 
	@Path("/v2/searchdetails")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public TF_Res_StkTransferDetailsBean searchTransferDetails_V2(CT_Req_SearchTypeBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		TF_Res_StkTransferDetailsBean tfDetails = new TF_Res_StkTransferDetailsBean();
		StockTransferController ctl = new StockTransferController();
//		db.setServerName("192.168.0.6");
//		db.setDatabaseName("navatest");
		
		tfDetails = ctl.searchStkTransferDetails_V2(req);
		return tfDetails;
	}
	
	
	@POST 
	@Path("/searchitem")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_ItemDataBean searchItem(CT_Req_SearchTypeBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_ItemDataBean itm = new CT_Res_ItemDataBean();
		StockTransferController ctl = new StockTransferController();
		
		itm = ctl.searchitem(search);
		return itm;
	}
	
	
	@POST 
	@Path("/v2/searchitem")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_ItemDataBean searchItem_V2(CT_Req_SearchTypeBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_ItemDataBean itm = new CT_Res_ItemDataBean();
		StockTransferController ctl = new StockTransferController();
		
		itm = ctl.searchitem_V2(search);
		return itm;
	}
	
	
	@POST 
	@Path("/searchitemstock")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_ItemDataBean searchItemStock(CT_Req_SearchStockWareHouseBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_ItemDataBean itm = new CT_Res_ItemDataBean();
		StockTransferController ctl = new StockTransferController();
		
		itm = ctl.searchItemStock(search);
		return itm;
	}
	
	
	@POST 
	@Path("/v2/searchitemstock")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_ItemDataBean searchItemStock_V2(CT_Req_SearchStockWareHouseBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_ItemDataBean itm = new CT_Res_ItemDataBean();
		StockTransferController ctl = new StockTransferController();
		
		itm = ctl.searchItemStock_V2(search);
		return itm;
	}
	
	

	@POST 
	@Path("/searchwarehouse")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_WareHouseBean searchWareHouse(CT_Req_SearchTypeBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_WareHouseBean wh = new CT_Res_WareHouseBean();
		StockTransferController ctl = new StockTransferController();
		
		wh = ctl.searchwh(search);
		return wh;
	}
	
	
	@POST 
	@Path("/v2/searchwarehouse")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_WareHouseBean searchWareHouse_V2(CT_Req_SearchTypeBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_WareHouseBean wh = new CT_Res_WareHouseBean();
		StockTransferController ctl = new StockTransferController();
		
		wh = ctl.searchwh_V2(search);
		return wh;
	}
	
	
	
	@POST 
	@Path("/searchshelf")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_WareHouseBean searchShelf(CT_Req_SearchRefCodeBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_WareHouseBean shelf = new CT_Res_WareHouseBean();
		StockTransferController ctl = new StockTransferController();
		
		shelf = ctl.searchShelf(search);
		return shelf;
	}
	
	
	@POST 
	@Path("/v2/searchshelf")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_WareHouseBean searchShelf_V2(CT_Req_SearchRefCodeBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_WareHouseBean shelf = new CT_Res_WareHouseBean();
		StockTransferController ctl = new StockTransferController();
		
		shelf = ctl.searchShelf_V2(search);
		return shelf;
	}
	
	
	@POST 
	@Path("/searchsale")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_DataMasterBean searchSale(CT_Req_SearchTypeBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_DataMasterBean sale = new CT_Res_DataMasterBean();
		StockTransferController ctl = new StockTransferController();
		
		sale = ctl.searchSale(search);
		return sale;
	}
	
	@POST 
	@Path("/v2/searchsale")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_DataMasterBean searchSale_V2(CT_Req_SearchTypeBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_DataMasterBean sale = new CT_Res_DataMasterBean();
		StockTransferController ctl = new StockTransferController();
		
		sale = ctl.searchSale_V2(search);
		return sale;
	}
	
	@POST 
	@Path("/v2/saleapprove")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public CT_Res_DataMasterBean searchSaleApprove_V2(CT_Req_SearchTypeBean search){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		CT_Res_DataMasterBean sale = new CT_Res_DataMasterBean();
		StockTransferController ctl = new StockTransferController();
		
		sale = ctl.searchSaleApprove_V2(search);
		return sale;
	}
	
	
	@POST 
	@Path("/v2/reporttf")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public TF_Res_ReportUsedTFBean reportUsedTransfer_V2(TF_Req_ReportUsedTFBean req){
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		TF_Res_ReportUsedTFBean report = new TF_Res_ReportUsedTFBean();
		StockTransferController ctl = new StockTransferController();
		
		report = ctl.reportUseTransfer_V2(req);
		return report;
	}
	
}
