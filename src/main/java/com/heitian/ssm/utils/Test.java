package com.heitian.ssm.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Http������
 */
public class Test{
	/**
	 * ����https���� 
	 * @param requestUrl �����ַ
	 * @param map ����ͷ��ʶ��Ϣ
	 * @return
	 */
	public static String httpsRequest(String requestUrl,Map<String,String> map){
		StringBuffer buffer=new StringBuffer();
		try{
			// Create a trust manager that does not validate certificate chains
	        TrustManager[] trustAllCerts=new TrustManager[]{new X509TrustManager(){
	        	public X509Certificate[] getAcceptedIssuers(){
	        		return null;
	        	}
	        	public void checkClientTrusted(X509Certificate[] certs,String authType)
	        		throws CertificateException{
	        		
	        	}
	        	public void checkServerTrusted(X509Certificate[] certs,String authType)
	        		throws CertificateException{
	        		
	        	}
	        }};
	        // Install the all-trusting trust manager
	        SSLContext sc=SSLContext.getInstance("SSL");
	        sc.init(null,trustAllCerts,new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	        // Create all-trusting host name verifier
	        HostnameVerifier allHostsValid=new HostnameVerifier(){
	        	public boolean verify(String hostname,SSLSession session){
	        		return true;
	            }
	        };
	        // Install the all-trusting host verifier
	        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	        URL url=new URL(requestUrl);
	        URLConnection con=url.openConnection();
	        con.setDoOutput(true);
	        con.setDoInput(true);
	        con.setUseCaches(false);
	        if(map!=null){
	        	for(Map.Entry<String,String> entry : map.entrySet()){
	        		con.setRequestProperty(entry.getKey(),entry.getValue());
				}
	        }
	        con.connect();
	        //��ȡ�������˷��ص�����
			InputStream is=con.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"utf-8");
			BufferedReader br=new BufferedReader(isr);
			String line=null;
			while((line=br.readLine())!=null){
				buffer.append(line);
			}
			is.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return buffer.toString();
	}
	public static void main(String[] args){
		Map<String,String> map=new HashMap<String,String>();
		map.put("Authorization","Basic ZGlyZWN0X2FwaV91c2VyOmRpcmVjdF9hcGlfdXNlcl9wc3c=");
		map.put("Content-Type","application/json");
		String s=httpsRequest("https://th-apex-http-callout.herokuapp.com/animals",map);
		System.out.println(s);
	}
}