package com.ChargePoint.controller.mobile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ChargePoint.Utils.JsonUtil;
import com.ChargePoint.bean.ChargeRecords;
import com.ChargePoint.bean.ChargeRecords2;
import com.ChargePoint.services.ChargeRecordsService;
import com.ChargePoint.services.CommonService;

@Controller
@RequestMapping("/mobile/")
public class ChargeRecord {
	
	@RequestMapping(value="getChargeRecordsByPage/{user_id}", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> getChargeRecordsByPage(HttpServletRequest request,@PathVariable("user_id")String user_id){
		List<ChargeRecords> chargeRecordsList = new ArrayList<ChargeRecords>();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int limitStart = request.getParameter("offset") == null ? 0 : Integer.parseInt(request.getParameter("offset"));
		  // 每页行数
		  int limitCount = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
		  
		  if (limitStart != 0) {// 获取页数
			  limitStart = limitStart / limitCount;
		  }
		  String searchText = request.getParameter("searchText");
		  String sortName = request.getParameter("sortName");
		  String order = request.getParameter("order")== null ? "asc" : request.getParameter("order");
		  String trade_status = request.getParameter("trade_status");
		  chargeRecordsList = ChargeRecordsService.getChargeRecordsByPage("charge_records_"+user_id,limitStart, limitCount,searchText,trade_status,sortName,order);
		  int total = 0;
		  total = chargeRecordsList.size();
		  modelMap.put("rows", chargeRecordsList); //这里的 rows 和total 的key 是固定的 
		  modelMap.put("total", total);
		return modelMap;
	}
	
	@RequestMapping(value="getAllChargeRecordsByPage", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> getAllChargeRecordsByPage(HttpServletRequest request){
		List<ChargeRecords> chargeRecordList = new ArrayList<ChargeRecords>();
		List<ChargeRecords> chargeRecordsList = new ArrayList<ChargeRecords>();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int limitStart = request.getParameter("offset") == null ? 0 : Integer.parseInt(request.getParameter("offset"));
		  // 每页行数
		  int limitCount = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
		  
		  if (limitStart != 0) {// 获取页数
			  limitStart = limitStart / limitCount;
		  }
		  String searchText = request.getParameter("searchText");
		  String sortName = request.getParameter("sortName");
		  String order = request.getParameter("order")== null ? "asc" : request.getParameter("order");
		  String trade_status = request.getParameter("trade_status");
		  List<String> tableNames = CommonService.getTableNames("charge_records_");
		  for(String tableName : tableNames){
			  chargeRecordList = ChargeRecordsService.getChargeRecordsByPage(tableName,limitStart, limitCount,searchText,trade_status,sortName,order);
			  for(ChargeRecords cr :chargeRecordList){
				  chargeRecordsList.add(cr);
			  }
		  }
		  int total = 0;
		  total = chargeRecordsList.size();
		  modelMap.put("rows", chargeRecordsList); //这里的 rows 和total 的key 是固定的 
		  modelMap.put("total", total);
		return modelMap;
	}
	
	/*
	@RequestMapping(value="checkUserName", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> checkUserName(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String un = request.getParameter("name") == null ? "" : request.getParameter("name");
		User user = UserService.getUser(un);
		if(null != user){
			modelMap.put("valid", false);
		}else{
			modelMap.put("valid", true);
		}
//		{ "valid": true } or { "valid": false } to BootstrapValidator
		return modelMap;
	}
	
	@RequestMapping(value="getChargePointListByUserName", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getChargePointListByUserName(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String userName = request.getParameter("userName").trim();
		List<ChargePoint> chargePointList = ChargePointService.getChargePointListByUserName(userName);
		modelMap.put("chargePointList", chargePointList);
		return modelMap;
	}
	
	*/
	@RequestMapping(value="deleteChargeRecord/{id}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> deleteChargeRecord(HttpServletRequest request,@PathVariable("id")String id){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		id = id.trim();
		ChargeRecords2 chargeRecords = new ChargeRecords2();
		chargeRecords.setTable_name(id);
		chargeRecords.setId((Integer.parseInt(id)));
		boolean res = ChargeRecordsService.deleteChargeRecords(chargeRecords);
		modelMap.put("deleteResult", res);
		return modelMap;
	}
	
	@RequestMapping(value="deleteChargeRecord", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> deleteChargeRecord(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		ChargeRecords2 chargeRecords = null;
		String jsonStr = "";
		try {
			jsonStr = URLDecoder.decode(request.getParameter("jsonStr"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		int finalFlag = 0;
		List<String> tableNames = CommonService.getTableNames("charge_records_");
		for(String tableName : tableNames){
			chargeRecords = new ChargeRecords2(); 
			try {
				chargeRecords = JsonUtil.json2Class(jsonStr, ChargeRecords2.class);
				String tName = tableName.substring(15, tableName.length());
				chargeRecords.setTable_name(tName);
				boolean res = ChargeRecordsService.deleteChargeRecords(chargeRecords);
				if(res){finalFlag++;}
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }
		if(finalFlag != 0){
			modelMap.put("deleteResult", true);
		}else{
			modelMap.put("deleteResult", false);
		}
		return modelMap;
	}
	
	@RequestMapping(value="deleteChargeRecords", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> deleteChargeRecords(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		ChargeRecords2 chargeRecords = null;
		int finalFlag = 0;
		String jsonStrs = null;
		try {
			jsonStrs = URLDecoder.decode(request.getParameter("jsonStr"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
//		int jSize = jsonStrs.length();
		List<String> tableNames = CommonService.getTableNames("charge_records_");
//		JSONArray jA = null;
//		try {
//			jA = new JSONArray(jsonStrs);
//		} catch (JSONException e1) {
//			e1.printStackTrace();
//		}
		for(String tableName : tableNames){
			chargeRecords = new ChargeRecords2(); 
			try {
//				for(int i = 0; i < jSize; i++){
//					String jsonStr = null;
//					try {
//						jsonStr = jA.getString(i);
//					} catch (JSONException e) {
//						e.printStackTrace();
//					}
				String[] ten = jsonStrs.split("#");
				for(String jsonStr : ten){
//				String decodeJsonStr = URLDecoder.decode(jsonStr,"UTF-8");
				chargeRecords = JsonUtil.json2Class(jsonStr, ChargeRecords2.class);
				String tName = tableName.substring(15, tableName.length());
				chargeRecords.setTable_name(tName);
				boolean res = ChargeRecordsService.deleteChargeRecords(chargeRecords);
				if(res){finalFlag++;}
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }
		if(finalFlag != 0){
			modelMap.put("deleteResult", true);
		}else{
			modelMap.put("deleteResult", false);
		}
		return modelMap;
	}
}
