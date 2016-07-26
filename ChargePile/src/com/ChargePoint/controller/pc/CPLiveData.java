package com.ChargePoint.controller.pc;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ChargePoint.Utils.TextUtils;
import com.ChargePoint.bean.ChargePointLive;
import com.ChargePoint.bean.PCUser;
import com.ChargePoint.services.ChargePointLiveService;
import com.ChargePoint.services.CommonService;
import com.ChargePoint.services.PCUserService;

@Controller
@RequestMapping("/CPLive/")
public class CPLiveData {
	
	@RequestMapping(value="getAllCPLive", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getAllCPLive(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<String> tableNames = null;
		tableNames = CommonService.getTableNames("charge_point_live");
		List<ChargePointLive> chargePointLives = new LinkedList<ChargePointLive>();
		for(String tableName : tableNames){
			chargePointLives.add(ChargePointLiveService.getFirstChargePointLive(tableName));
		}
		modelMap.put("chargePointLives", chargePointLives);
		return modelMap;
	}
	
	@RequestMapping(value="Login", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> checkPCUser(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String un = TextUtils.TOUTF8(request.getParameter("userName"));
		String pw =	request.getParameter("password");
		PCUser user = PCUserService.getPCUser(un);
		String msg = "";
		if(null != user){
			PCUser cU = PCUserService.getPCUser(un, pw);
			if(cU != null){
				msg = "成功";
			}else{
				msg = "密码错误";
			}
		}else{
			msg = "账号不存在";
		}
		modelMap.put("msg", msg);
		return modelMap;
	}
	
	/*
	@RequestMapping(value="getChargePointListByPCUserName", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getChargePointListByPCUserName(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String userName = request.getParameter("userName").trim();
		List<ChargePoint> chargePointList = ChargePointService.getChargePointListByPCUserName(userName);
		modelMap.put("chargePointList", chargePointList);
		return modelMap;
	}
	
	@RequestMapping(value="getChargePointByPage", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> getPCUserByPage(HttpServletRequest request){
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
	public Map<String,Object> deletePCUser(HttpServletRequest request,@PathVariable("id")String id){
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
