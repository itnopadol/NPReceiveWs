package controller;

import static org.junit.Assert.*;

import org.junit.Test;

import bean_req.CT_Req_SearchStockWareHouseBean;
import bean_req.CT_Req_SearchTypeBean;
import bean_req.CT_Req_ServerDataBaseBean;
import bean_res.CT_Res_ItemDataBean;
import bean_res.TF_Res_SearchStkTransferBean;
import bean_res.TF_Res_StkTransferDetailsBean;

public class StockTransferControllerTest {

	@Test
	public void test() {
		CT_Req_SearchTypeBean req = new CT_Req_SearchTypeBean();
		StockTransferController ctl = new StockTransferController();
		TF_Res_StkTransferDetailsBean data = new TF_Res_StkTransferDetailsBean();
		
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		db.setServerName("192.168.0.6");
		db.setDatabaseName("navatest");
		
		req.setAccessToken("");
		req.setType(1);
		req.setSearch("TF5908-0003");

		
		data = ctl.searchStkTransferDetails(db, req);
		
		System.out.println("DocNo :"+data.getDocNo());
	}

}
