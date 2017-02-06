package controller;

import static org.junit.Assert.*;

import org.junit.Test;

import bean_req.CT_Req_SearchGenDocNoBean;
import bean_req.CT_Req_ServerDataBaseBean;

public class DocNoControllerTest {

	@Test
	public void test() {
		String docno;
		DocNoController doc = new DocNoController();
		CT_Req_ServerDataBaseBean dbName = new CT_Req_ServerDataBaseBean();
		
		dbName.setServerName("192.168.0.6");
		dbName.setDatabaseName("navatest");
		
		CT_Req_SearchGenDocNoBean genDocno = new CT_Req_SearchGenDocNoBean();
		
		genDocno.setAccessToken("");
		genDocno.setHeader("RH");
		genDocno.setModule("Inventory");
		genDocno.setType(0);
		genDocno.setTableName("BCAPINVOICE");
		
		docno = doc.genNewDocno_V2(genDocno);
		
		System.out.println(docno);
	}

}
