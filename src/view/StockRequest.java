package view;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import controller.StockRequestController;
import controller.testCode;

import bean_req.PR_Req_SearchStockRequestBean;
import bean_res.PR_Res_SearchStockRequestBean;

@Path(value="/pr")
public class StockRequest {
	@POST 
	@Path("/search")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public PR_Res_SearchStockRequestBean search(PR_Req_SearchStockRequestBean req){
		PR_Res_SearchStockRequestBean stk = new PR_Res_SearchStockRequestBean();
		StockRequestController ctl = new StockRequestController();
		
		stk = ctl.stkReqSearch("bcnp", req);
		
		return stk;
	}

}
