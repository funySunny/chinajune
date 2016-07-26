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

import com.ChargePoint.Utils.TimeFormatUtil;
import com.ChargePoint.bean.ChargePoint;
import com.ChargePoint.bean.Operate2;
import com.ChargePoint.bean.TempAppointment;
import com.ChargePoint.bean.MobileUser;
import com.ChargePoint.services.ChargePointService;
import com.ChargePoint.services.CommonService;
import com.ChargePoint.services.OperateService;
import com.ChargePoint.services.TempAppointmentService;
import com.ChargePoint.services.MobileUserService;

@Controller
@RequestMapping("/mobile/")
public class Appointment {
	@RequestMapping(value="makeAppointment", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> makeAppointment(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String c_p_id = request.getParameter("c_p_id");
		String user_id = request.getParameter("user_id");
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		int result = -1;
		
		ChargePoint chargePoint = new ChargePoint();
		chargePoint.setC_p_id(c_p_id);
		ChargePoint tempC = null;
		tempC = ChargePointService.getChargePoint(c_p_id);
//		当充电桩状态为空闲时才可以预约充电
		if(null != tempC && "0".equals(tempC.getIs_free())){
			
//		添加操作表记录
		Operate2 operate = new Operate2();
		operate.setTable_name(user_id);
		operate.setC_p_id(c_p_id);
		operate.setUser_id(user_id);
		operate.setOrder_start_time(start_time);
		operate.setOrder_end_time(end_time);
		boolean res = OperateService.addOperate(operate);
//		添加预约记录
		TempAppointment tempAppointment = new TempAppointment();
		tempAppointment.setC_p_id(c_p_id);
		tempAppointment.setUser_id(user_id);
		tempAppointment.setStart_time(start_time);
		tempAppointment.setEnd_time(end_time);
		boolean res1 = TempAppointmentService.addTempAppointment(tempAppointment);
//		更新充电桩状态为已预约
		ChargePoint c = new ChargePoint();
		synchronized(c){
		c.setC_p_id(c_p_id);
		c.setIs_free("1");//0-空闲，1-被预约，2-充电中	
		boolean res2 = ChargePointService.updateChargePoint(c);
		if(res && res1 && res2){
			result = 0;//预约成功
		}else{
			result = 1;//预约失败
		}
		}//end synchronized
		//状态为不可预约时
		}else{
			result = 2;//不可预约
		}
		modelMap.put("res", result);
		return modelMap;
	}
	
	/*
	@RequestMapping(value="checkMobileUserName", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> checkMobileUserName(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String un = request.getParameter("name") == null ? "" : request.getParameter("name");
		MobileUser user = MobileUserService.getMobileUser(un);
		if(null != user){
			modelMap.put("valid", false);
		}else{
			modelMap.put("valid", true);
		}
//		{ "valid": true } or { "valid": false } to BootstrapValidator
		return modelMap;
	}
	
	@RequestMapping(value="getChargePointListByMobileUserName", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getChargePointListByMobileUserName(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String userName = request.getParameter("userName").trim();
		List<ChargePoint> chargePointList = ChargePointService.getChargePointListByMobileUserName(userName);
		modelMap.put("chargePointList", chargePointList);
		return modelMap;
	}
	
	@RequestMapping(value="getChargePointByPage", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> getMobileUserByPage(HttpServletRequest request){
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
	public Map<String,Object> deleteMobileUser(HttpServletRequest request,@PathVariable("id")String id){
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
