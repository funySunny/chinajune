package com.ChargePoint.controller.mobile;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ChargePoint.Utils.TextUtils;
import com.ChargePoint.bean.ChargePoint;
import com.ChargePoint.bean.ChargePointStation;
import com.ChargePoint.bean.MobileUser;
import com.ChargePoint.bean.TempCharge;
import com.ChargePoint.services.ChargePointService;
import com.ChargePoint.services.ChargePointStationService;
import com.ChargePoint.services.MobileUserService;
import com.ChargePoint.services.TempChargeService;

@Controller
@RequestMapping("/mobile/")
public class PreCharge {
	
	/**开始充电前的准备
	 * @param request userName，cpid
	 * @return res
	 */
	@RequestMapping(value="preCharge", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> preCharge(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String userName = null;
		boolean res = false;
		userName = TextUtils.TOUTF8(request.getParameter("userName"));
		final String cpid = request.getParameter("cpid");
		MobileUser user = MobileUserService.getMobileUser(userName);
		final int uID = user.getId();
//		有此充电桩且充电桩为空闲状态
		ChargePoint chargePoint = ChargePointService.getChargePoint(cpid);
		if(null != chargePoint && "0".equals(chargePoint.getIs_free())){
		TempCharge tempCharge = new TempCharge();
		tempCharge.setC_p_id(cpid);
		tempCharge.setUser_id(String.valueOf(uID));
		List<TempCharge> tempCharges = null;
//		查找是否存在未完成操作的数据
		tempCharges = TempChargeService.getTempChargeList(tempCharge);
		if(0 == tempCharges.size()){
//		不存在未完成操作的数据，绑定充电桩与用户并写表
		res = TempChargeService.addTempCharge(tempCharge);
		final Runnable runnable = new Runnable() {
			@Override
			public void run() {
//				线程开始
				try {
					Thread.sleep(300*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				TempCharge cancelTempCharge = new TempCharge();
				cancelTempCharge.setC_p_id(cpid);
				cancelTempCharge.setUser_id(String.valueOf(uID));
				TempChargeService.deleteTempCharge(cancelTempCharge);
//				网络超时自动删除数据 
				Thread.currentThread().interrupt();
			}
		};
		Thread t = new Thread(runnable);
		t.start();
		}
//		可以充电就获取充电桩信息
		if(res){
			ChargePoint cp = ChargePointService.getChargePoint(cpid);
			ChargePointStation cps = ChargePointStationService.getChargePointStation(cp.getStation_id());
			modelMap.put("chargePoint", cp);
			modelMap.put("chargePointStation", cps);
		}
		}
		modelMap.put("res", res);
		return modelMap;
	}
	
	/**超时为确认充点电
	 * @param request
	 * @return
	 */
	@RequestMapping(value="cancelPreCharge", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> cancelPreCharge(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String cpid = request.getParameter("cpid");
		String userName = null;
		userName = TextUtils.TOUTF8(request.getParameter("userName"));
		MobileUser user = MobileUserService.getMobileUser(userName);
		int uID = user.getId();
		TempCharge cancelTempCharge = new TempCharge();
		cancelTempCharge.setC_p_id(cpid);
		cancelTempCharge.setUser_id(String.valueOf(uID));
		boolean res = TempChargeService.deleteTempCharge(cancelTempCharge);
		modelMap.put("res", res);
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
	 
	@RequestMapping(value="getUserProfile/{userName}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getUserProfile(HttpServletRequest request,@PathVariable("userName")String userName){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		userName = TextUtils.TOUTF8(userName);
		User user = UserService.getUser(userName);
		modelMap.put("user", user);
		return modelMap;
	}*/
}
