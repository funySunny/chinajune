package com.ChargePoint.controller.mobile;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mobile/")
public class Mobile {
	@RequestMapping(value="log", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> mobileLogin(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>(10);
		String inputUserName = request.getParameter("userName");
		String inputPassWord = request.getParameter("pW");
		
//		modelMap.put("resMsg", userName);
		modelMap.put("success", "true");
		return modelMap;
	}
}
