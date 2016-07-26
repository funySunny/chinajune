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
import com.ChargePoint.bean.Feedbacks;
import com.ChargePoint.services.FeedbacksService;

@Controller
@RequestMapping("/mobile/")
public class Feedback {
	
	@RequestMapping(value="addFeedbacks", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> addFeedbacks(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String jsonStr = null;
		try {
			jsonStr = URLDecoder.decode(request.getParameter("jsonStr"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		Feedbacks feedback = null;
		try {
			feedback = JsonUtil.json2Class(jsonStr,Feedbacks.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean res = FeedbacksService.addFeedbacks(feedback);
		modelMap.put("res", res);
		return modelMap;
	}
	
}
