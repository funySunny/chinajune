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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ChargePoint.Utils.JsonUtil;
import com.ChargePoint.bean.AddHeart;
import com.ChargePoint.bean.Review;
import com.ChargePoint.bean.WriteBack;
import com.ChargePoint.services.AddHeartService;
import com.ChargePoint.services.ReviewService;
import com.ChargePoint.services.WriteBackService;

@Controller
@RequestMapping("/mobile/")
public class getReview {
	
	@RequestMapping(value="getReviewListByStationID", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getReviewListByStationID(HttpServletRequest request){
		List<Review> reviewList = new ArrayList<Review>();
		List<Map<String,Object>> reviewListItem = new ArrayList<Map<String,Object>>();
		Map<String,Object> reviewMap = null;
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer stationID = Integer.parseInt(request.getParameter("stationID"));
//		获取平均数
		int avgScore = ReviewService.getReviewAvgScoreByStationID(stationID);
		String currentPage = request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage");
		int pageNO = Integer.parseInt(currentPage);
//		获取评论分页数据
		reviewList = ReviewService.getReviewByPage((pageNO-1)*10, 10 , stationID);
		for(Review review : reviewList){
			reviewMap = new HashMap<String,Object>();
			reviewMap.put("review", review);
			Integer review_id = review.getId();
			Integer station_id = review.getStation_id();
//		获取回复数量
			int writeBackCount = WriteBackService.getWriteBackCountByReview(station_id,review_id);
//		获取点赞数量
			int addHeartCount = AddHeartService.getAddHeartCountByReview(station_id,review_id);
			reviewMap.put("writeBackCount", writeBackCount);
			reviewMap.put("addHeartCount", addHeartCount);
			reviewListItem.add(reviewMap);
		}
		modelMap.put("reviewListItem", reviewListItem);
		modelMap.put("avgScore", avgScore);
		return modelMap;
	}
	
	@RequestMapping(value="addOrCancelHeart", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> addOrCancelHeart(HttpServletRequest request){
		boolean flag = false;
		String addOrCancel = "add";
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Integer stationID = Integer.parseInt(request.getParameter("stationID"));
		Integer reviewID = Integer.parseInt(request.getParameter("reviewID"));
		AddHeart addHeart = new AddHeart();
		addHeart.setStation_id(stationID);
		addHeart.setReview_id(reviewID);
//		点赞+1
		if(0 == AddHeartService.getAddHeartList(addHeart).size()){
			flag = AddHeartService.addAddHeart(addHeart);
		}else{
//		取消点赞-1
			flag = AddHeartService.deleteAddHeart(addHeart);
			addOrCancel = "cancel";
		}
		modelMap.put("addOrCancel", addOrCancel);
		modelMap.put("flag", flag);
		return modelMap;
	}
	
	@RequestMapping(value="getWriteBackListByReview", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getWriteBackListByReview(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<WriteBack> writeBackList = new ArrayList<WriteBack>();
		Integer stationID = Integer.parseInt(request.getParameter("stationID"));
		Integer reviewID = Integer.parseInt(request.getParameter("reviewID"));
		WriteBack writeBack = new WriteBack();
		writeBack.setStation_id(stationID);
		writeBack.setReview_id(reviewID);
		writeBackList = WriteBackService.getWriteBackList(writeBack);
		modelMap.put("writeBackList", writeBackList);
		return modelMap;
	}
	
	@RequestMapping(value="addWriteBack", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> addWriteBack(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String jsonStr = null;
		try {
			jsonStr = URLDecoder.decode(request.getParameter("jsonStr").trim(),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		WriteBack writeBack = null;
		try {
			writeBack = JsonUtil.json2Class(jsonStr, WriteBack.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean addFlag = WriteBackService.addWriteBack(writeBack);
		modelMap.put("addFlag", addFlag);
		return modelMap;
	}
	
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
//				for(int i = 0; i < jSize; i++){
//					String jsonStr = null;
//					try {
//						jsonStr = jA.getString(i);
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
