package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;

import bean_req.CT_Req_SearchGenDocNoBean;
import bean_req.CT_Req_ServerDataBaseBean;
import bean_res.CT_Res_DataResultBean;

import connect.SQLConn;

public class DocNoController {
	SQLConn ds = SQLConn.INSTANCE ;
	
	
	private java.text.SimpleDateFormat dtDoc= new java.text.SimpleDateFormat();
	private java.text.SimpleDateFormat dt= new java.text.SimpleDateFormat();
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	String vQuery;
	
	public String genDocNo(CT_Req_ServerDataBaseBean dbName,int docType){
		String vDocNo;
		int maxNo;
		int numMax;
		String header;
		String gDocNo;

		int nowYearInt;
		int nowYearInt1;
		
		String genNo;
		String genNo1;
		
		String  nowMonth;
		String  nowDay;
		
		String nowYear;
		String nowYear2;
		String nowYear3;
		
		genNo1 = "";
		
		
		try{
			Statement st = ds.getSqlStatement(dbName.getServerName(), dbName.getDatabaseName());
			
			if (docType==0){
				vQuery = "select isnull(right(MAX(docno),4),0) as maxno from dbo.BCAPINVOICE where DocNo like 'RV%' and month(createdatetime) = month(getdate()) and year(createdatetime)= year(getdate())";
			}
			if (docType==1){
				vQuery = "select isnull(right(MAX(docno),4),0) as maxno from dbo.BCAPINVOICE where DocNo like 'RV%' and month(createdatetime) = month(getdate()) and year(createdatetime)= year(getdate())";
			}
			
			System.out.println(vQuery);
			
			ResultSet rs = st.executeQuery(vQuery);
			while(rs.next()){
				maxNo = rs.getInt("maxno");
				System.out.println("maxNo:"+maxNo);
				numMax = maxNo+1;
				genNo = String.valueOf(numMax);
				if(genNo.length() == 1){
					genNo1 = "000"+genNo;
				}
				if(genNo.length() == 2){
					genNo1 = "00"+genNo;
				}
				if(genNo.length() == 3){
					genNo1 = "0"+genNo;
				}
				if(genNo.length() == 4){
					genNo1 = genNo;
				}
				
				System.out.println(genNo1);
			}
			
		    rs.close();
		    st.close();
		    
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ds.close();
		}
		
		
		Date date = new Date();
		
		System.out.println(dateFormat.format(date));
		
		nowYear = dateFormat.format(date).substring(0, 4);
		nowYearInt = Integer.parseInt(nowYear);
		if (nowYearInt >= 2550){
			nowYearInt1 = nowYearInt;
		}else{
			nowYearInt1 = nowYearInt+543;
		}
		
		nowYear2 = String.valueOf(nowYearInt1);
		nowYear3 = nowYear2.substring(2, 4);
		
		nowMonth = dateFormat.format(date).substring(5, 7);
		nowDay = dateFormat.format(date).substring(8, 10);
		
		header = "RV";

		gDocNo = header+nowYear3+nowMonth+"-"+genNo1;
		System.out.println("Date : "+gDocNo);
		
		vDocNo = gDocNo;
		
		System.out.println(vDocNo);
		
		
		return vDocNo;
	}
	
	public String genNewDocno(CT_Req_SearchGenDocNoBean req){
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
	
	
	public String genNewDocno_V2(CT_Req_SearchGenDocNoBean req){
		String newDocNo="";
		String docNo="";
		
		//CT_Res_DataResultBean staff;
		
		try {

			URL url = new URL("http://qserver.nopadol.com:8080/NPDataCenterWs/center/v2/gendocno");
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
}
