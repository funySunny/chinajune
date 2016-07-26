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
import com.ChargePoint.bean.ChargePointStation;
import com.ChargePoint.services.ChargePointService;
import com.ChargePoint.services.ChargePointStationService;

@Controller
@RequestMapping("/admin/")
public class ChargePointStationManage {
	
	@RequestMapping(value="getChargePointStationList", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getUserList(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<ChargePointStation> chargePointStation = ChargePointStationService.getChargePointStationList(null);
		modelMap.put("chargePointStation", chargePointStation);
		return modelMap;
	}
	
	@RequestMapping(value="getAllChargePointStationByPage", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> getAllChargePointStationByPage(HttpServletRequest request){
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
	
	@RequestMapping(value="deleteChargePointStation/{id}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> deleteChargePointStation(HttpServletRequest request,@PathVariable("id")String id){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		id = id.trim();
		ChargePointStation chargePointStation = new ChargePointStation();
		chargePointStation.setC_p_id(id);
		boolean res = ChargePointStationService.deleteChargePointStation(chargePointStation);
		modelMap.put("deleteResult", res);
		return modelMap;
	}
	
	@RequestMapping(value="deleteChargePointStations/{ids}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> deleteChargePointStations(HttpServletRequest request,@PathVariable("ids")String[] ids){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int refC = 0;
		for(String id : ids){
			id = id.trim();
			ChargePointStation chargePointStation = new ChargePointStation();
			chargePointStation.setC_p_id(id);
			if(ChargePointStationService.deleteChargePointStation(chargePointStation)){
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
	
	@RequestMapping(value="updateChargePointStation", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> updateChargePointStation(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		boolean res = false;
		String jsonStr = "";
		ChargePointStation cps = null;
		try {
			jsonStr = URLDecoder.decode(request.getParameter("jsonStr"),"UTF-8");
			cps = JsonUtil.json2Class(jsonStr, ChargePointStation.class);
			if(null != cps){
				res = ChargePointStationService.updateChargePointStation(cps);
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
	
	@RequestMapping(value="addChargePointStation", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> addChargePointStation(HttpServletRequest request,@PathVariable("id")String id){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		boolean res = false;
		ChargePointStation chargePointStation = null;
		String jsonS;
		try {
			jsonS = URLDecoder.decode(request.getParameter("jsonStr").trim(),"UTF-8");
			chargePointStation = (ChargePointStation) JsonUtil.json2Class(jsonS,ChargePointStation.class);
			}catch (JsonMappingException e) {
				e.printStackTrace();
			}catch (JsonParseException e) {
				e.printStackTrace();
			}catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		res = ChargePointStationService.addChargePointStation(chargePointStation);
		modelMap.put("addResult", res);
		return modelMap;
	}

}
