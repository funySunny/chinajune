package com.ChargePoint.controller.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ChargePoint.bean.ChargePoint;
import com.ChargePoint.bean.MobileUser;
import com.ChargePoint.services.ChargePointService;
import com.ChargePoint.services.CommonService;
import com.ChargePoint.services.MobileUserService;

@Controller
@RequestMapping("/mobile/")
public class ChargeMoneyRecord {
	/*
	@RequestMapping(value="checkRegister", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> register(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<ChargePoint> chargePointList = ChargePointService.getChargePointList(null);
		modelMap.put("chargePointList", chargePointList);
		modelMap.put("success", "true");
		return modelMap;
	}
	
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
	
	@RequestMapping(value="getChargePointByPage", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> getUserByPage(HttpServletRequest request){
		List<ChargePoint> chargePointList = new ArrayList<ChargePoint>();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int limitStart = request.getParameter("offset") == null ? 1 : Integer.parseInt(request.getParameter("offset"));
		  // 每页行数
		  int limitCount = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
		  if (limitStart != 0) {// 获取页数
			  limitStart = limitStart / limitCount;
		  }
		  limitStart += 1;
//		  ChargePoint chargePoint = new ChargePoint();
		  chargePointList = ChargePointService.getChargePointByPage(limitStart, limitCount,null,null,null,null);
		  int total = 0;
		  total = CommonService.getTotalCount("charge_point");
		  modelMap.put("rows", chargePointList); //这里的 rows 和total 的key 是固定的 
		  modelMap.put("total", total);
		return modelMap;
	}
	
	@RequestMapping(value="deleteChargePoint/{id}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> deleteUser(HttpServletRequest request,@PathVariable("id")String id){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		id = id.trim();
		ChargePoint chargePoint = new ChargePoint();
		chargePoint.setC_p_id(id);
		boolean res = ChargePointService.deleteChargePoint(chargePoint);
		modelMap.put("deleteResult", res);
		return modelMap;
	}
	*/
}
