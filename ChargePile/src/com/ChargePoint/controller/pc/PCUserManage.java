package com.ChargePoint.controller.pc;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
import com.ChargePoint.bean.MobileUser;
import com.ChargePoint.bean.PCUser;
import com.ChargePoint.services.MobileUserService;
import com.ChargePoint.services.PCUserService;

@Controller
@RequestMapping("/admin/")
public class PCUserManage {
	@RequestMapping(value="getPCUserList", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getPCUserList(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>(10);
		List<PCUser> userList = PCUserService.getPCUserList(null);
		modelMap.put("userList", userList);
		modelMap.put("success", "true");
		return modelMap;
	}
	
	@RequestMapping(value="getPCUser", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getPCUser(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String userName = request.getParameter("userName").trim();
		PCUser user = PCUserService.getPCUser(userName);
		modelMap.put("user", user);
		return modelMap;
	}
	
	@RequestMapping(value="getPCUserByPage", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getPCUserByPage(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int startIndex = Integer.parseInt(request.getParameter("startIndex"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		List<PCUser> userList = PCUserService.getPCUserByPage(startIndex, pageSize);
		modelMap.put("userList", userList);
		modelMap.put("success", "true");
		return modelMap;
	}
	
	@RequestMapping(value="deletePCUser/{userName}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> deletePCUser(HttpServletRequest request,@PathVariable("userName")String userName){
		Map<String, Object> modelMap = new HashMap<String, Object>(10);
		userName = userName.trim();
		boolean res = PCUserService.deletePCUser(userName);
		modelMap.put("deleteResult", res);
		modelMap.put("success", "true");
		return modelMap;
	}
	
	@RequestMapping(value="updatePCUser", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> updatePCUser(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		boolean res = false;
		String jsonStr = "";
		PCUser user = null;
		try {
			jsonStr = URLDecoder.decode(request.getParameter("jsonStr"),"UTF-8");
			user = JsonUtil.json2Class(jsonStr, PCUser.class);
			if(null != user){
				res = PCUserService.updatePCUser(user);
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
	
	@RequestMapping(value="getMobileUser", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getMobileUser(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String userName = request.getParameter("userName").trim();
		MobileUser user = MobileUserService.getMobileUser(userName);
		modelMap.put("user", user);
		return modelMap;
	}
	
	@RequestMapping(value="getMobileUserByPage", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getMobileUserByPage(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int startIndex = Integer.parseInt(request.getParameter("startIndex"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		List<MobileUser> userList = MobileUserService.getMobileUserByPage(startIndex, pageSize);
		modelMap.put("userList", userList);
		return modelMap;
	}
	
	@RequestMapping(value="deleteMobileUser/{userName}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> deleteMobileUser(HttpServletRequest request,@PathVariable("userName")String userName){
		Map<String, Object> modelMap = new HashMap<String, Object>(10);
		userName = userName.trim();
		boolean res = MobileUserService.deleteMobileUser(userName);
		modelMap.put("deleteResult", res);
		modelMap.put("success", "true");
		return modelMap;
	}
	
	@RequestMapping(value="updateMobileUser", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> updateMobileUser(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>(10);
		boolean res = false;
		String jsonStr = "";
		MobileUser user = null;
		try {
			jsonStr = URLDecoder.decode(request.getParameter("jsonStr"),"UTF-8");
			user = JsonUtil.json2Class(jsonStr, MobileUser.class);
			if(null != user){
				res = MobileUserService.updateMobileUser(user);
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
