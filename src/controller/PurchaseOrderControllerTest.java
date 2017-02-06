package controller;

import static org.junit.Assert.*;

import org.junit.Test;

import bean_req.CT_Req_SearchCenterBean;
import bean_req.CT_Req_ServerDataBaseBean;
import bean_req.PO_Req_SearchVendorNotReceiptBean;
import bean_res.PO_Res_VendorNotReceiptBean;
import bean_req.PO_Req_SearchVendorNotReceiptBean;

public class PurchaseOrderControllerTest {

	@Test
	public void test() {
		
		PO_Res_VendorNotReceiptBean vendor = new PO_Res_VendorNotReceiptBean();
		PurchaseOrderController ctl = new PurchaseOrderController();
		CT_Req_SearchCenterBean search = new CT_Req_SearchCenterBean();
		CT_Req_ServerDataBaseBean db = new CT_Req_ServerDataBaseBean();
		db.setServerName("192.168.0.6");
		db.setDatabaseName("navatest");
		
		search.setAccessToken("");
		search.setSearch("");
		
		vendor = ctl.searchVendorNotReceipt(db,search);
		
		System.out.println(vendor.getApList().get(0).getName());

	}

}
