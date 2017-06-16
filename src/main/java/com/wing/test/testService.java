package com.wing.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wing.dao.EasyDao;

@Service
public class testService {
	
	@Autowired
	protected EasyDao basicService;
	
	public List<HashMap<String, Object>> getUserlist(){
		Map<String,Object> args = new HashMap<String,Object>();
		args.put("#SQL", "select fid,fname,fage,fgender ,date_format(fbirthday,'%Y-%m-%d') fbirthday, fcreatetime from test");
		List<HashMap<String, Object>> result=basicService.SelectListBySqlWithWhere(args);
		
		return result;
	}
	
	public List<HashMap<String, Object>> getUserById(String userid){
		Map<String,Object> args = new HashMap<String,Object>();
		args.put("#SQL", "select fid,fname,fage,fgender, date_format(fbirthday,'%Y-%m-%d') fbirthday,date_format(fcreatetime,'%Y-%m-%d %H:%i:%s') fcreatetime from test where fid=#{userid}");
		args.put("userid", userid);
		
		List<HashMap<String, Object>> result=basicService.SelectListBySqlWithWhere(args);
		
		return result;
	}
}
