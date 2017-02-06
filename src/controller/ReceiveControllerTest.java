package controller;

import static org.junit.Assert.*;

import org.junit.Test;

import bean_req.CT_Req_SearchCenterBean;
import bean_req.CT_Req_ServerDataBaseBean;
import bean_res.RC_Res_SearchRecieveBean;

public class ReceiveControllerTest {

	@Test
	public void test() {
		RC_Res_SearchRecieveBean resp = new RC_Res_SearchRecieveBean();
		CT_Req_SearchCenterBean reqs = new CT_Req_SearchCenterBean();
		CT_Req_ServerDataBaseBean database = new CT_Req_ServerDataBaseBean();
		ReceiveController ctl = new ReceiveController();
		
		database.setServerName("192.168.0.6");
		database.setDatabaseName("navatest");
		
		reqs.setAccessToken("");
		reqs.setSearch("");
		
		resp = ctl.searchReceive(database, reqs);
		
		System.out.println("This Data :"+resp.getDetails().get(0).getApName());
		 	
	}

}
