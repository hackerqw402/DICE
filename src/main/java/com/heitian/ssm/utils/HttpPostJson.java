package com.heitian.ssm.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;
import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.IOUtils;



 
public class HttpPostJson {
	
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //String URL = "http://localhost:18090";
       /* String Json = findXmlInfo();
        String URL = "https://device.jpush.cn/v3/tags/zhu";
        Json = "{\"姓名\" : \"大憨\",\"年龄\" : 24}";
        String postResult =  doHttpPost(Json,URL); 
        System.out.println("postResult:"+postResult);
      //设置标签
        Json = "{\"registration_ids\": {\"add\": [\"070faac1b59\"],\"remove\": []}}";
        //Json="{\"platform\": \"all\",\"audience\" : {\"alias\" : [\"4314\", \"892\", \"4531\" ]},\"notification\" : {\"alert\" : \"Hi, JPush!\",\"android\" : {}, \"ios\" : {\"extras\" : {\"newsid\" : 321}}}}";
        //Json="{\"platform\": \"all\",\"audience\" : {\"alias\" : [ \"d2834057_31b1_4da4_8323_098bf04069af\" ]},\"notification\" : {\"alert\" : \"Hi, JPush!\",\"notification\": {\"android\": {\"alert\": \"Hi, JPush!\",\"title\": \"Send to Android\",\"builder_id\": 1,\"extras\": {\"newsid\": 321}},\"ios\": {\"alert\": \"Hi, JPush!\",\"sound\": \"default\",\"badge\": \"+1\",\"extras\": {\"newsid\": 321}}}}}";
        //Json="{\"platform\": \"all\",\"audience\" : \"all\",\"notification\" : {\"alert\" : \"Hi, JPush!\",\"android\" : {}, \"ios\" : {\"extras\" : {\"newsid\" : 321}}}}";
        String postResult =  doHttpPost(Json,URL); 
        System.out.println("postResult:"+postResult);*/
         
         //delete();
 
    }
     
     
    private static String findXmlInfo() {
        // TODO Auto-generated method stub
        return null;
    }
 
    public static String doHttpPost(String xmlInfo,String URL){         
        //LogUtil.logger.info("发起的数据:"+xmlInfo);
        byte[] xmlData = xmlInfo.getBytes();            
         InputStream instr  = null; 
          try{                          
                 URL url = new URL(URL);                
                 HttpsURLConnection urlCon = (HttpsURLConnection)url.openConnection();               
                 urlCon.setDoOutput(true);              
                 urlCon.setDoInput(true);               
                 urlCon.setUseCaches(false);  
                 urlCon.setRequestProperty("Accept", "application/json");
                 //urlCon.setRequestProperty("Authorization", "Basic "+Base64.encode((DeviceServiceImpl.appKey+":"+DeviceServiceImpl.masterSecret).getBytes())); 
                 urlCon.setRequestProperty("Content-Type", "text/xml");       
                 urlCon.setRequestProperty("Content-length",String.valueOf(xmlData.length)); 
                // LogUtil.logger.info(String.valueOf(xmlData.length));
                 DataOutputStream printout = new DataOutputStream(urlCon.getOutputStream());            
                 printout.write(xmlData);               
                 printout.flush();              
                 printout.close();
                 instr = urlCon.getInputStream();
                 //LogUtil.logger.info(String.valueOf(urlCon.getResponseCode()));
                 byte[] bis = IOUtils.toByteArray(instr);
                 String ResponseString = new String(bis, "UTF-8");  
                 if ((ResponseString == null) || ("".equals(ResponseString.trim()))) {
                    // LogUtil.logger.info("返回空");
                    }
                 //LogUtil.logger.info("返回数据为:" + ResponseString);
                 return ResponseString;    
             
          }catch(Exception e){    
        	  	//ExceptionUtil.exceptionStackTraceLog(e);
                return "0";
          }             
          finally {             
                 try { 
                        instr.close();  
                 }catch (Exception ex) {      
                        return "0";
                     }                  
                 }                  
          }                     
    
    public static String doHttpPostJson(String jsonInfo,String URL){         
        //LogUtil.logger.info("发起的数据:"+jsonInfo);
        InputStream instr  = null; 
        try {
            //创建连接
            URL url = new URL(URL);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type",
                    "application/json");
            //connection.setRequestProperty("Charset", "UTF-8");

            connection.connect();

            //POST请求
            DataOutputStream out = new DataOutputStream(
                    connection.getOutputStream());
            //String iso = new String(jsonInfo.getBytes("utf-8"),"iso-8859-1");  
            //String utf8 = new String(iso.getBytes("iso-8859-1"),"utf-8");  
            //LogUtil.logger.info("发起的数据js:"+utf8);
           //out.writeBytes(jsonInfo);
            //out.writeBytes(utf8);
            out.write(jsonInfo.getBytes("utf-8"));
            out.flush();
            out.close();

            instr = connection.getInputStream();
            //LogUtil.logger.info(String.valueOf(connection.getResponseCode()));
            byte[] bis = IOUtils.toByteArray(instr);
            String ResponseString = new String(bis, "UTF-8");  
            
            //读取响应
/*            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                //lines = new String(lines.getBytes(), "gbk");
            	lines = new String(lines.getBytes(),"UTF8");
                sb.append(lines);
            }
            System.out.println(sb);
                // 断开连接
                connection.disconnect();
             reader.close();
            return sb.toString();*/
            // 断开连接
            connection.disconnect();
            return ResponseString;
       } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return e.toString();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return e.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return e.toString();
        }
        finally {             
            try { 
                  instr.close();  
            }catch (Exception ex) {      
                   return ex.toString();
                }                  
            }                  

          }                     

	public static String doPost(String urlString, String josnObj) throws IOException {
		
		// 创建连接
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("POST");
		connection.setUseCaches(false);
		connection.setInstanceFollowRedirects(true);
		connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");  
		connection.connect();

		// POST请求
		DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		out.write(josnObj.toString().getBytes("UTF-8"));
		out.flush();
		out.close();
		
		//读取响应
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String lines;
        StringBuffer sb = new StringBuffer("");
        while ((lines = reader.readLine()) != null) {
            lines = new String(lines.getBytes(), "utf-8");
            sb.append(lines);
        }
        String tmpString = sb.toString();
        String []tmp = tmpString.split(",");
        String []tmp1 = tmp[1].split(":");
        String []tmp2 = tmp1[1].split("\"");
        System.out.println(tmp2[1]);
        
        reader.close();
		
        //断开连接
		connection.disconnect();
		if(tmp2[1].isEmpty()){
			System.out.println("success");
        	return "succes";
        }
		else {
			System.out.println("send faield");
			return "input";
		}
	}
	
	
	
	/** 
     * 上传图片 
     *  
     * @param urlStr 
     * @param textMap 
     * @param fileMap 
     * @return 
     */  
    public static String formUpload(String urlString, String josnObj) {  
    	// 创建连接
    	InputStream instr  = null; 
    	try {
    		URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");  
			connection.connect();

			// POST请求
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			out.write(josnObj.toString().getBytes("UTF-8"));
			out.flush();
			out.close();
			instr = connection.getInputStream();
	        //LogUtil.logger.info(String.valueOf(connection.getResponseCode()));
	        byte[] bis = IOUtils.toByteArray(instr);
	        String ResponseString = new String(bis, "UTF-8");  
	        System.out.println(ResponseString);
            // 断开连接
            connection.disconnect();
            return ResponseString;
			
			//读取响应
	      /*  BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String lines;
	        StringBuffer sb = new StringBuffer("");
	        while ((lines = reader.readLine()) != null) {
	        	System.out.println(lines);
	        	System.out.println(lines.getBytes());
	        	
	            lines = new String(lines.getBytes(), "utf-8");
	            System.out.println(lines);
	            sb.append(lines);
	        }*/
	       // String tmpString = sb.toString();
	       
	        //System.out.println(tmpString);
	        
	       // reader.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return josnObj;
    		

     

    } 


  
    /**
     * 上传方法
     * 返回上传完毕的文件名
     * *
     */
    public String upload(File f)
    {
       
        return null;
    }
    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost( String param,String url) {
        PrintWriter out = null;
        BufferedReader in = null;
        //LogUtil.logger.info("发起的数据:"+param);
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("Accept", "application/json");
            //conn.setRequestProperty("Authorization", "Basic "+Base64.encode((DeviceServiceImpl.appKey+":"+DeviceServiceImpl.masterSecret).getBytes())); 
            conn.setRequestProperty("connection", "Keep-Alive");
           
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
    
    
    
    	public static String delete(String tagname){
    		URL url = null;
    		try {
    		    url = new URL("https://device.jpush.cn/v3/tags/"+tagname);
    		} catch (MalformedURLException exception) {
    		    exception.printStackTrace();
    		}
    		HttpURLConnection httpURLConnection = null;
    		try {
    		    httpURLConnection = (HttpURLConnection) url.openConnection();
    		    httpURLConnection.setRequestProperty("Accept", "application/json"); 
    		    httpURLConnection.setRequestProperty("Authorization", "Basic ZjI1ODdiODBkNjZlY2Q2MDE5MDE1MTYwOjJkNmYwYTcxZjJkOGE3NzBlYjgwMjZjYw==");
    		    httpURLConnection.setRequestProperty("Content-Type",
    		                "application/x-www-form-urlencoded");
    		    httpURLConnection.setRequestMethod("DELETE");
    		    //LogUtil.logger.info("移除标签返回状态:" + httpURLConnection.getResponseCode());
    		    return String.valueOf(httpURLConnection.getResponseCode());
    		} catch (IOException exception) {
    		    exception.printStackTrace();
    		    return "";
    		} finally {         
    		    if (httpURLConnection != null) {
    		        httpURLConnection.disconnect();
    		    }
    		} 
    	}
}