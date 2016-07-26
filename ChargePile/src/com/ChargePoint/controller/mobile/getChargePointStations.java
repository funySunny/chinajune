package com.ChargePoint.controller.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
import com.ChargePoint.bean.ChargePoint;
import com.ChargePoint.bean.ChargePointStation;
import com.ChargePoint.bean.ChargeRecords;
import com.ChargePoint.bean.ChargeRecords2;
import com.ChargePoint.services.ChargePointService;
import com.ChargePoint.services.ChargePointStationService;
import com.ChargePoint.services.ChargeRecordsService;
import com.ChargePoint.services.CommonService;
import com.ChargePoint.services.ReviewService;

@Controller
@RequestMapping("/mobile/")
public class getChargePointStations {
	
	@RequestMapping(value="getChargePointStationMap", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getChargePointStationMap(HttpServletRequest request){
		List<ChargePointStation> chargePointStationList = new ArrayList<ChargePointStation>();
		List<Map<String, Object>> mapData = new LinkedList<Map<String, Object>>();
		Map<String, Object> dataMap = null;
		Map<String, Object> modelMap = new HashMap<String, Object>();
		chargePointStationList = ChargePointStationService.getChargePointStationList(null);
		if(null != chargePointStationList){
//			获取所有充电站数据				
			for(ChargePointStation chargePointStation : chargePointStationList){
//			获取map所需数据
			Integer id = chargePointStation.getId();
			String location = chargePointStation.getLocation();
			String place = chargePointStation.getPlace();
			String name = chargePointStation.getName();
			int avgScore = ReviewService.getReviewAvgScoreByStationID(id);
//			获取充电桩状态
			ChargePoint cp = new ChargePoint();
			cp.setStation_id(id);
//			获取该站点下所有充电桩数量
			int totalSize = ChargePointService.getChargePointList(cp).size();
//			获取该站点下空闲充电桩数量
			cp.setIs_free("0");
			int freeSize = ChargePointService.getChargePointList(cp).size();
			dataMap = new HashMap<String, Object>();
			dataMap.put("id", id);
			dataMap.put("avgScore", avgScore);
			dataMap.put("location", location);
			dataMap.put("place", place);
			dataMap.put("name", name);
			dataMap.put("totalSize", totalSize);
			dataMap.put("freeSize", freeSize);
			mapData.add(dataMap);
			}
			modelMap.put("mapData", mapData);
		}else{
			modelMap.put("mapData", null);
		}
		return modelMap;
	}
	
	@RequestMapping(value="getChargePointStationMapDetails", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getChargePointStationMapDetials(HttpServletRequest request){
		List<ChargePoint> chargePointList = null;
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer cpsID = Integer.parseInt(request.getParameter("id"));
		ChargePointStation chargePointStationDetials = ChargePointStationService.getChargePointStation(cpsID);
			ChargePoint cp = new ChargePoint();
			cp.setStation_id(cpsID);
			chargePointList = ChargePointService.getChargePointList(cp);
//			获取该站点下空闲充电桩数量
			cp.setIs_free("0");
			int freeSize = ChargePointService.getChargePointList(cp).size();
			modelMap.put("freeSize", freeSize);
			modelMap.put("chargePointList", chargePointList);
			modelMap.put("chargePointStationDetails", chargePointStationDetials);
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
//	@RequestMapping(value="deleteChargeRecord/{id}", method= RequestMethod.POST)
//	@ResponseBody//返回json对象
//	public Map<String,Object> deleteChargeRecord(HttpServletRequest request,@PathVariable("id")String id){
//		Map<String, Object> modelMap = new HashMap<String, Object>();
//		id = id.trim();
//		ChargeRecords2 chargeRecords = new ChargeRecords2();
//		chargeRecords.setTable_name(id);
//		chargeRecords.setId((Integer.parseInt(id)));
//		boolean res = ChargeRecordsService.deleteChargeRecords(chargeRecords);
//		modelMap.put("deleteResult", res);
//		return modelMap;
//	}
//	
//	@RequestMapping(value="deleteChargeRecord", method= RequestMethod.POST)
//	@ResponseBody//返回json对象
//	public Map<String,Object> deleteChargeRecord(HttpServletRequest request){
//		Map<String, Object> modelMap = new HashMap<String, Object>();
//		ChargeRecords2 chargeRecords = null;
//		String jsonStr = "";
//		try {
//			jsonStr = URLDecoder.decode(request.getParameter("jsonStr"),"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}		
//		int finalFlag = 0;
//		List<String> tableNames = CommonService.getTableNames("charge_records_");
//		for(String tableName : tableNames){
//			chargeRecords = new ChargeRecords2(); 
//			try {
//				chargeRecords = JsonUtil.json2Class(jsonStr, ChargeRecords2.class);
//				String tName = tableName.substring(15, tableName.length());
//				chargeRecords.setTable_name(tName);
//				boolean res = ChargeRecordsService.deleteChargeRecords(chargeRecords);
//				if(res){finalFlag++;}
//			} catch (JsonMappingException e) {
//				e.printStackTrace();
//			} catch (JsonParseException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		  }
//		if(finalFlag != 0){
//			modelMap.put("deleteResult", true);
//		}else{
//			modelMap.put("deleteResult", false);
//		}
//		return modelMap;
//	}
	
//	@RequestMapping(value="deleteChargeRecords", method= RequestMethod.POST)
//	@ResponseBody//返回json对象
//	public Map<String,Object> deleteChargeRecords(HttpServletRequest request){
//		Map<String, Object> modelMap = new HashMap<String, Object>();
//		ChargeRecords2 chargeRecords = null;
//		int finalFlag = 0;
//		String jsonStrs = null;
//		try {
//			jsonStrs = URLDecoder.decode(request.getParameter("jsonStr"),"UTF-8");
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
////		int jSize = jsonStrs.length();
//		List<String> tableNames = CommonService.getTableNames("charge_records_");
////		JSONArray jA = null;
////		try {
////			jA = new JSONArray(jsonStrs);
////		} catch (JSONException e1) {
////			e1.printStackTrace();
////		}
//		for(String tableName : tableNames){
//			chargeRecords = new ChargeRecords2(); 
//			try {
////				for(int i = 0; i < jSize; i++){
////					String jsonStr = null;
////					try {
////						jsonStr = jA.getString(i);
////					} catch (JSONException e) {
////						e.printStackTrace();
////					}
//				String[] ten = jsonStrs.split("#");
//				for(String jsonStr : ten){
////				String decodeJsonStr = URLDecoder.decode(jsonStr,"UTF-8");
//				chargeRecords = JsonUtil.json2Class(jsonStr, ChargeRecords2.class);
//				String tName = tableName.substring(15, tableName.length());
//				chargeRecords.setTable_name(tName);
//				boolean res = ChargeRecordsService.deleteChargeRecords(chargeRecords);
//				if(res){finalFlag++;}
//				}
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			} catch (JsonMappingException e) {
//				e.printStackTrace();
//			} catch (JsonParseException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		  }
//		if(finalFlag != 0){
//			modelMap.put("deleteResult", true);
//		}else{
//			modelMap.put("deleteResult", false);
//		}
//		return modelMap;
//	}
}
