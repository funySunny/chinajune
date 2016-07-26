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
import com.ChargePoint.bean.AddHeart;
import com.ChargePoint.bean.ChargeMoneyRecords;
import com.ChargePoint.bean.ChargeRecords;
import com.ChargePoint.bean.Review;
import com.ChargePoint.bean.WriteBack;
import com.ChargePoint.services.AddHeartService;
import com.ChargePoint.services.ChargeMoneyRecordsService;
import com.ChargePoint.services.ChargeRecordsService;
import com.ChargePoint.services.ReviewService;
import com.ChargePoint.services.WriteBackService;

@Controller
@RequestMapping("/mobile/")
public class getRecords {
	
	@RequestMapping(value="getChargeMoneyRecords/{userID}/{currentPage}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getChargeMoneyRecords(HttpServletRequest request,@PathVariable("userID")String userID,@PathVariable("currentPage")int currentPage){
		List<ChargeMoneyRecords> chargeMoneyRecordsList = new ArrayList<ChargeMoneyRecords>();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		currentPage = currentPage == 0 ? 1 : currentPage;
		chargeMoneyRecordsList = ChargeMoneyRecordsService.getChargeMoneyRecordsByPage("charge_money_records_"+userID, null, null, (currentPage-1)*10, 10 , null, null);
		modelMap.put("chargeMoneyRecordsList", chargeMoneyRecordsList);
		return modelMap;
	}
	
	@RequestMapping(value="getChargeRecords/{userID}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getChargeRecords(HttpServletRequest request,@PathVariable("userID")String userID){
		List<ChargeRecords> chargeRecordsList = new ArrayList<ChargeRecords>();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String currentPage = request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage");
		int pageNO = Integer.parseInt(currentPage);
		chargeRecordsList = ChargeRecordsService.getChargeRecordsByPage("charge_records_"+userID, (pageNO-1)*10, 10 ,null, null, null, null);
		modelMap.put("chargeRecordsList", chargeRecordsList);
		return modelMap;
	}
	
}
