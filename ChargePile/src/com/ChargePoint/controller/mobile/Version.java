package com.ChargePoint.controller.mobile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ChargePoint.Utils.JsonUtil;
import com.ChargePoint.Utils.TextUtils;
import com.ChargePoint.bean.Versions;
import com.ChargePoint.services.VersionsService;

@Controller
@RequestMapping("/mobile/")
public class Version {
	
	@RequestMapping(value="checkNewVersions", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> checkNewVersions(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String versionNO = null;
		versionNO = TextUtils.TOUTF8(request.getParameter("versionNO"));
		Object res = VersionsService.checkNewVersions(versionNO);
		modelMap.put("res", res);
		return modelMap;
	}
	
	@RequestMapping(value="addVersions", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> addVersions(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String jsonStr = null;
		try {
			jsonStr = URLDecoder.decode(request.getParameter("jsonStr"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		Versions versions = null;
		try {
			versions = JsonUtil.json2Class(jsonStr,Versions.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean res = VersionsService.addVersions(versions);
		modelMap.put("res", res);
		return modelMap;
	}
	
}
