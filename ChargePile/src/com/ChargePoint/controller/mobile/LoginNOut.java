package com.ChargePoint.controller.mobile;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ChargePoint.Utils.TextUtils;
import com.ChargePoint.bean.MobileUser;
import com.ChargePoint.services.MobileUserService;
import com.ChargePoint.services.TradeService;

@Controller
@RequestMapping("/mobile/")
public class LoginNOut {
	
	@RequestMapping(value="getMobileUserPicture", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getMobileUserPicture(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String userName = null;
		userName = TextUtils.TOUTF8(request.getParameter("userName"));
		MobileUser user = MobileUserService.getMobileUser(userName);
		String protrait = user.getHead_portrait();
		System.out.println(protrait);
		modelMap.put("protrait", protrait);
		return modelMap;
	}
	
	@RequestMapping(value="Login", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> checkMobileUser(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String un = TextUtils.TOUTF8(request.getParameter("userName"));
		String pw =	request.getParameter("password");
		MobileUser user = MobileUserService.getMobileUser(un);
		String msg = "";
		if(null != user){
//			解码余额
			MobileUser cU = MobileUserService.getMobileUser(un, pw);
			if(cU != null){
				msg = "成功";
				cU.setMoney(TradeService.getMoney(un));
				modelMap.put("user", cU);
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
	
	 */
	@RequestMapping(value="getMobileUserProfile/{userName}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getUserProfile(HttpServletRequest request,@PathVariable("userName")String userName){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		userName = TextUtils.TOUTF8(userName);
		MobileUser user = MobileUserService.getMobileUser(userName);
		modelMap.put("user", user);
		return modelMap;
	}
}
