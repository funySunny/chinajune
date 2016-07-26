package com.ChargePoint.controller.pc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ChargePoint.Utils.JsonUtil;
import com.ChargePoint.bean.Company;
import com.ChargePoint.bean.PCUser;
import com.ChargePoint.services.CompanyService;
import com.ChargePoint.services.PCUserService;
import com.tenpay.util.MD5Util;

@Controller
@RequestMapping("/pc/")
public class RNR {
	@RequestMapping(value="register",method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> register(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		boolean res = false;
		String jsonStr = "";
		PCUser user = null;
		try {
			jsonStr = URLDecoder.decode(request.getParameter("jsonStr"),"UTF-8");
			user = JsonUtil.json2Class(jsonStr, PCUser.class);
		}catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
//        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName); 
        res = PCUserService.addPCUser(user);
		modelMap.put("success", res);
		return modelMap;
	}
	
	@RequestMapping(value="checkUserName", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> checkPCUserName(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String un = request.getParameter("name") == null ? "" : request.getParameter("name");
		PCUser user = PCUserService.getPCUser(un);
		if(null != user){
			modelMap.put("valid", false);
		}else{
			modelMap.put("valid", true);
		}
//		{ "valid": true } or { "valid": false } to BootstrapValidator
		return modelMap;
	}
	
	@RequestMapping(value="resetCheckUserName", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> rcheckPCUserName(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String un = request.getParameter("name") == null ? "" : request.getParameter("name");
		PCUser user = PCUserService.getPCUser(un);
		if(null != user){
			modelMap.put("valid", true);
		}else{
			modelMap.put("valid", false);
		}
//		{ "valid": true } or { "valid": false } to BootstrapValidator
		return modelMap;
	}
	
	@RequestMapping(value="checkpw", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> checkpw(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String un = request.getParameter("name") == null ? "--" : request.getParameter("name");
		String pw = request.getParameter("pw") == null ? "--" : request.getParameter("pw");
		PCUser user = PCUserService.getPCUser(un,MD5Util.MD5Encode(pw, "UTF-8").toUpperCase());
		if(null != user){
			modelMap.put("valid", true);
		}else{
			modelMap.put("valid", false);
		}
//		{ "valid": true } or { "valid": false } to BootstrapValidator
		return modelMap;
	}
	
	@RequestMapping(value="checkValidateCode", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> checkValidateCode(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String validateCode = request.getParameter("validateCode") == null ? "" : request.getParameter("validateCode");
		HttpSession session = request.getSession();
		String randomRegCode = (String)session.getAttribute("VALIDATECODE");
		if(validateCode.equalsIgnoreCase(randomRegCode)){
			modelMap.put("valid", true);
		}else{
			modelMap.put("valid", false);
		}
//		{ "valid": true } or { "valid": false } to BootstrapValidator
		return modelMap;
	}
	
	@RequestMapping(value="checkRegNO", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> checkRegNO(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String RegNO = request.getParameter("reg_no") == null ? "" : request.getParameter("reg_no");
		Company company = new Company();
		company.setReg_no(RegNO);
		List<Company> c = CompanyService.getCompanyList(company); 
		if(0 != c.size()){
			modelMap.put("valid", true);
		}else{
			modelMap.put("valid", false);
		}
//		{ "valid": true } or { "valid": false } to BootstrapValidator
		return modelMap;
	}
	
	@RequestMapping(value="modifyPCUser", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> modifyPCUser(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		boolean res = false;
		String jsonStr = "";
		PCUser user = null;
		try {
			jsonStr = URLDecoder.decode(request.getParameter("jsonStr"),"UTF-8");
			user = JsonUtil.json2Class(jsonStr, PCUser.class);
		}catch(UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		res = PCUserService.updatePCUser(user);
		modelMap.put("modifyFlag", res);
		return modelMap;
	}
	
	@RequestMapping(value="resetPCUserPW", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> resetPCUserPW(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		boolean res = false;
		String jsonStr = "";
		PCUser user = null;
		try {
			jsonStr = URLDecoder.decode(request.getParameter("jsonStr"),"UTF-8");
			user = JsonUtil.json2Class(jsonStr, PCUser.class);
		}catch(UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		res = PCUserService.resetPCUserPW(user);
		modelMap.put("resetFlag", res);
		if(res){
			modelMap.put("resetedPCUser", PCUserService.getPCUser(user.getUser_name()));
		}
		return modelMap;
	}
	
}
