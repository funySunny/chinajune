package com.ChargePoint.controller.pc;

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
import com.ChargePoint.bean.ChargePoint;
import com.ChargePoint.bean.ChargePointHome;
import com.ChargePoint.services.ChargePointService;
import com.ChargePoint.services.CommonService;

@Controller
@RequestMapping("/admin/")
public class ChargePointManage {
	
	@RequestMapping(value="getChargePointList", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getUserList(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<ChargePoint> chargePointList = ChargePointService.getChargePointList(null);
		modelMap.put("chargePointList", chargePointList);
		modelMap.put("success", "true");
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
	
	@RequestMapping(value="getAllChargePointByPage", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> getAllChargePointByPage(HttpServletRequest request){
		List<ChargePoint> chargePointList = new ArrayList<ChargePoint>();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int limitStart = request.getParameter("offset") == null ? 0 : Integer.parseInt(request.getParameter("offset"));
		  // 每页行数
		  int limitCount = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
		  
		  if (limitStart != 0) {// 获取页数
			  limitStart = limitStart / limitCount;
		  }
		  String c_p_id = request.getParameter("c_p_id");
		  String sortName = request.getParameter("sortName");
		  String order = request.getParameter("order")== null ? "asc" : request.getParameter("order");
		  chargePointList = ChargePointService.getChargePointByPage(limitStart, limitCount,c_p_id,null,sortName,order);
		  int total = 0;
		  total = chargePointList.size();
		  modelMap.put("rows", chargePointList); //这里的 rows 和total 的key 是固定的 
		  modelMap.put("total", total);
		return modelMap;
	}
	
	@RequestMapping(value="getCPHomeByPage", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> getCPHomeByPage(HttpServletRequest request){
		List<ChargePointHome> chargePointList = new ArrayList<ChargePointHome>();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int limitStart = request.getParameter("offset") == null ? 0 : Integer.parseInt(request.getParameter("offset"));
		  // 每页行数
		  int limitCount = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
		  
		  if (limitStart != 0) {// 获取页数
			  limitStart = limitStart / limitCount;
		  }
		  String c_p_id = request.getParameter("c_p_id");
		  String is_free = request.getParameter("is_free");
		  String sortName = request.getParameter("sortName");
		  String order = request.getParameter("order")== null ? "asc" : request.getParameter("order");
		  chargePointList = ChargePointService.getHomeCPTable(limitStart, limitCount, c_p_id, is_free, sortName, order);
		  int total = 0;
		  total = chargePointList.size();
		  modelMap.put("rows", chargePointList); //这里的 rows 和total 的key 是固定的 
		  modelMap.put("total", total);
		return modelMap;
	}
	
	@RequestMapping(value="getCPMap", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> getCPMap(HttpServletRequest request){
		List<ChargePointHome> chargePointList = new ArrayList<ChargePointHome>();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		  chargePointList = ChargePointService.getCPMap();
		  modelMap.put("chargePointList", chargePointList); //这里的 rows 和total 的key 是固定的 
		return modelMap;
	}
	
	@RequestMapping(value="getChargePointByPage/{type}", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> getChargePointByPage(@PathVariable("type")String type,HttpServletRequest request){
		List<ChargePoint> chargePointList = new ArrayList<ChargePoint>();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int limitStart = request.getParameter("offset") == null ? 0 : Integer.parseInt(request.getParameter("offset"));
		  // 每页行数
		  int limitCount = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
		  
		  if (limitStart != 0) {// 获取页数
			  limitStart = limitStart / limitCount;
		  }
		  String c_p_id = request.getParameter("c_p_id");
		  String sortName = request.getParameter("sortName");
		  String order = request.getParameter("order")== null ? "asc" : request.getParameter("order");
		  type = type == null ? "0" : type;
		  chargePointList = ChargePointService.getChargePointByPage(limitStart, limitCount,c_p_id,type,sortName,order);
		  int total = 0;
		  total = CommonService.getCPTotalCount(type);
		  modelMap.put("rows", chargePointList); //这里的 rows 和total 的key 是固定的 
		  modelMap.put("total", total);
		return modelMap;
	}
	
	@RequestMapping(value="deleteChargePoint/{id}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> deleteChargePoint(HttpServletRequest request,@PathVariable("id")String id){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		id = id.trim();
		ChargePoint chargePoint = new ChargePoint();
		chargePoint.setC_p_id(id);
		boolean res = ChargePointService.deleteChargePoint(chargePoint);
		modelMap.put("deleteResult", res);
		return modelMap;
	}
	
	@RequestMapping(value="deleteChargePoints/{ids}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> deleteChargePoints(HttpServletRequest request,@PathVariable("ids")String[] ids){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int refC = 0;
		for(String id : ids){
			id = id.trim();
			ChargePoint chargePoint = new ChargePoint();
			chargePoint.setC_p_id(id);
			if(ChargePointService.deleteChargePoint(chargePoint)){
				refC++;
			}
		}
		if(refC == ids.length){
			modelMap.put("deleteResult", true);
		}else{
			modelMap.put("deleteResult", false);
		}
		return modelMap;
	}
	
	@RequestMapping(value="updateChargePoint", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> updateChargePoint(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		boolean res = false;
		String jsonStr = "";
		ChargePoint cp = null;
		try {
			jsonStr = URLDecoder.decode(request.getParameter("jsonStr"),"UTF-8");
			cp = JsonUtil.json2Class(jsonStr, ChargePoint.class);
			if(null != cp){
				res = ChargePointService.updateChargePoint(cp);
			}
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			modelMap.put("updateResult", res);
		return modelMap;
	}
	
}
