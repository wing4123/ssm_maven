package com.wing.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@SuppressWarnings("unchecked")
public class JSON2Map {
	
	private static SimpleDateFormat defaultformat=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public Map<String,Object> json2map(JSONObject jo){
		Map<String,Object> map = new HashMap<String,Object>();
		Iterator<String> it=jo.keys();
		while(it.hasNext()){
			String key=it.next();
			Object value= jo.get(key);
			if(value instanceof JSONObject){
				json2map((JSONObject)value);
			}else if(value instanceof JSONArray){
				array2list((JSONArray)value);
			}else if(value instanceof Date){
				value=defaultformat.format(value);
			}
			map.put(key, value);
		}
		
		return map;
	}
	
	public List<HashMap<String,Object>> array2list(JSONArray ja){
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		for(int i=0,size=ja.size();i<size;i++){
			HashMap<String,Object> map = new HashMap<String,Object>();
			JSONObject jo = ja.getJSONObject(i);
			Iterator<String> it=jo.keys();
			while(it.hasNext()){
				String key=it.next();
				Object value= jo.get(key);
				if(value instanceof JSONObject){
					json2map((JSONObject)value);
				}else if(value instanceof JSONArray){
					array2list((JSONArray)value);
				}else if(value instanceof Date){
					value=defaultformat.format(value);
				}
				map.put(key, value);
			}
		}
		
		return list;
	}

}
