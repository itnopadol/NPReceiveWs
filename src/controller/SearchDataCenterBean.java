package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;

import bean_req.CT_Req_SearchCenterBean;
import bean_req.CT_Req_SearchGenDocNoBean;
import bean_req.CT_Req_SearchModuleTypeBean;
import bean_req.CT_Req_SearchTypeBean;
import bean_req.CT_Req_ServerDataBaseBean;
import bean_res.CT_Res_DataResultBean;
import bean_res.CT_Res_ItemDataBean;
import bean_res.RC_Res_TestAPI;
import connect.SQLConn;




import java.io.InputStreamReader;

import javax.ws.rs.core.Response;




public class SearchDataCenterBean {
	SQLConn ds = SQLConn.INSTANCE ;
	
	
	public double checkItemQtyReceive (CT_Req_ServerDataBaseBean dbName,String docNo,String itemCode){
		double qty=0;
		String vQuery;

		
		try {
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			vQuery = "exec dbo.USP_RC_SearchItemReceive_API '"+docNo+"','"+itemCode+"'";
			
			System.out.println(vQuery);
			
			ResultSet rs = st.executeQuery(vQuery);
			
			while(rs.next()){
				qty = rs.getDouble("qty");
			}
			st.close();
			rs.close();
					
		} catch (SQLException e) {
			// TODO: handle exception
			qty =0;
			System.out.println(e.getMessage());
		}finally{
			ds.close();
		}
		return qty;
	}
	
	
	public String searchDocNo() {
		String docNo1="";
		
		RC_Res_TestAPI getDocNo;
		
		try {

			URL url = new URL("http://localhost:8082/NPReceiveWs/rc/api");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			//BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

			String output;
			String docNo;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				docNo = output;
				System.out.println("Data:"+docNo);
				docNo1 = docNo;
			}
			
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		
		
    	Gson gson = new Gson();
    	String json = gson.toJson(docNo1); 
    	//Response response = gson.fromJson(json, Response.class);

    	//RC_Res_TestAPI staff = gson.fromJson(docNo1), RC_Res_TestAPI.class);
    	RC_Res_TestAPI staff = gson.fromJson(docNo1, RC_Res_TestAPI.class);
    	System.out.println("Docno :"+staff.getDocNo());
		
		return docNo1;
	}
	


	public String searchDocNoPost() {
		String docNo1="";
		
		RC_Res_TestAPI getDocNo;
		
		
		 try {

				URL url = new URL("http://qserver.nopadol.com:8080/NPReceiveWs/rc/podetails");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");

				String input = "{\"accessToken\":\"100\",\"search\":\"PO5806-0033\"}";

				OutputStream os = conn.getOutputStream();
				os.write(input.getBytes());
				os.flush();

				if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
				}

//				BufferedReader br = new BufferedReader(new InputStreamReader(
//						(conn.getInputStream())));
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
				
				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}

				conn.disconnect();

			  } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			 }


		
    	Gson gson = new Gson();
    	String json = gson.toJson(docNo1); 
    	//Response response = gson.fromJson(json, Response.class);

    	//RC_Res_TestAPI staff = gson.fromJson(docNo1), RC_Res_TestAPI.class);
    	RC_Res_TestAPI staff = gson.fromJson(docNo1, RC_Res_TestAPI.class);
    	System.out.println("Docno :"+staff.getDocNo());
		
		return docNo1;
	}

	
	
	public String postNewDocno(CT_Req_SearchGenDocNoBean req){
		String newDocNo="";
		String docNo="";
		
		//CT_Res_DataResultBean staff;
		
		try {

			URL url = new URL("http://qserver.nopadol.com:8080/NPDataCenterWs/center/gendocno");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			//String input = "{\"req\":\"iPad 4\"}";
			//String input = req.toString();
			//System.out.println("input="+input);
			String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"module\":\""+req.getModule()+"\",\"tableName\":\""+req.getTableName()+"\",\"type\":\""+req.getType()+"\",\"header\":\""+req.getHeader()+"\"}";
			System.out.println("input="+input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

//			BufferedReader br = new BufferedReader(new InputStreamReader(
//					(conn.getInputStream())));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				docNo = output;
				System.out.println("json format :"+output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		
		
    	Gson gson = new Gson();
    	String json = gson.toJson(docNo); 
    	CT_Res_DataResultBean docno = gson.fromJson(docNo, CT_Res_DataResultBean.class);
    	System.out.println("Docno :"+docno.getData());
		
    	newDocNo = docno.getData();
    	
		return newDocNo;
	}
	
	
	public CT_Res_ItemDataBean searchItem(CT_Req_SearchTypeBean req){
		String newDocNo="";
		String docNo="";
		
		//CT_Res_DataResultBean staff;
		
		try {

			URL url = new URL("http://qserver.nopadol.com:8080/NPDataCenterWs/center/searchitem");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			//String input = "{\"req\":\"iPad 4\"}";
			//String input = req.toString();
			//System.out.println("input="+input);
			String input = "{\"accessToken\":\""+req.getAccessToken()+"\",\"type\":\""+req.getType()+"\",\"search\":\""+req.getSearch()+"\"}";
			System.out.println("input="+input);
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

//			BufferedReader br = new BufferedReader(new InputStreamReader(
//					(conn.getInputStream())));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				docNo = output;
				System.out.println("json format :"+output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}
		
		//StringEntity str = null;
		
    	Gson gson = new Gson();
    	String json = gson.toJson(docNo); 
    	CT_Res_ItemDataBean itemData = gson.fromJson(docNo, CT_Res_ItemDataBean.class);
    	System.out.println("Docno :"+itemData.getData());
    	
    	
    	System.out.println(json.charAt(0));

		
    	newDocNo = itemData.getData().get(0).getItemName();
    	
    	System.out.println("newDocNo:"+newDocNo);
    	
		return itemData;
	}
	
}
