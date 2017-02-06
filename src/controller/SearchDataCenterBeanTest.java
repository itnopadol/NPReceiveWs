package controller;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Test;

import bean_req.CT_Req_SearchCenterBean;
import bean_req.CT_Req_SearchGenDocNoBean;
import bean_req.CT_Req_SearchModuleTypeBean;
import bean_req.CT_Req_SearchTypeBean;
import bean_res.CT_Res_ItemDataBean;

public class SearchDataCenterBeanTest {

	@Test
	public void test() {
		CT_Res_ItemDataBean data = new CT_Res_ItemDataBean();
		SearchDataCenterBean ctl = new SearchDataCenterBean();
		CT_Req_SearchTypeBean req = new CT_Req_SearchTypeBean();
		String docNo;
		
		req.setAccessToken("wqeqweqwe");
		req.setType(0);
		req.setSearch("885");

		
		
		data = ctl.searchItem(req);
		

		
		System.out.println("เลขที่เอกสาร :"+data.getData().get(0).getItemName());
	}

}
