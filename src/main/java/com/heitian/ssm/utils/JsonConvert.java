package com.heitian.ssm.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConvert{
	public static String myArrayJsonConvert(String type, String json){
		String ret = String.format("{\n%s:%s\n}", type,json);
		return ret;
	}
	
	public static String myArrayJsonConvert(String type, List<?> list){
		String jsonString = myJsonGenerator(list);
		String ret = String.format("{\n%s:%s\n}", type, jsonString);
		return ret;
	}
	
	public static String myUITreeArrayJsonConvert(String json){
		String ret = String.format("[%s]\n", json);
		return ret;
	}
	
	public static String myUITreeArrayJsonConvert(Map<?,?> map){
		String jsonString = myJsonGenerator(map);
		return String.format("[%s]\n", jsonString);
	}
	
	public static String myJsonGenerator(Object obj){
		ObjectMapper mapper = new ObjectMapper();
		java.text.DateFormat myFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(myFormat);
		StringBuffer jsonString = new StringBuffer();
		try {
			jsonString.append(mapper.writeValueAsString(obj));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString.toString();
	}
	public static String myJsonGenerator1(Object obj){
		ObjectMapper mapper = new ObjectMapper();
		java.text.DateFormat myFormat = new java.text.SimpleDateFormat("HH:mm:ss");
		mapper.setDateFormat(myFormat);
		StringBuffer jsonString = new StringBuffer();
		try {
			jsonString.append(mapper.writeValueAsString(obj));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString.toString();
	}
	public static String myJsonGenerator(Map<?, ?> map){
		ObjectMapper mapper = new ObjectMapper();
		StringBuffer jsonString = new StringBuffer();
		java.text.DateFormat myFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(myFormat);
		try {
			jsonString.append(mapper.writeValueAsString(map));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString.toString();
	}
	public static String myJsonGenerator(List<?> list){
		ObjectMapper mapper = new ObjectMapper();
		StringBuffer jsonString = new StringBuffer();
		java.text.DateFormat myFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(myFormat);
		try {
			jsonString.append(mapper.writeValueAsString(list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString.toString();   
	}
	
	public static String myJsonGenerator(String... strings){
		Map<String,String> map = new HashMap<String,String>();
		String name="";
		String value="";
		for( int i = 0,len = strings.length;i<len ;i++){
			if( i % 2 == 0)
				name = strings[i];
			else{
				value = strings[i];
				map.put(name, value);
				name="";
				value="";
			}
		}
		return myJsonGenerator(map);
	}
}