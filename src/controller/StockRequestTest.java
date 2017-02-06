package controller;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bean_req.PR_Req_SearchStockRequestBean;
import bean_res.PR_Res_SearchStockRequestBean;


public class StockRequestTest {

	@Test
	public void test() {
		PR_Res_SearchStockRequestBean reqData = new PR_Res_SearchStockRequestBean();
		StockRequestController test  = new StockRequestController();
		PR_Req_SearchStockRequestBean reqItemSearch = new PR_Req_SearchStockRequestBean();
				
		reqItemSearch.setType(0);
		reqItemSearch.setSearch("1");
		
		
		reqData = test.stkReqSearch("bcnp", reqItemSearch);
	}
	

}
