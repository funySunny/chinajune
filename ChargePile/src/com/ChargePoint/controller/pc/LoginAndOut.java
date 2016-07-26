package com.ChargePoint.controller.pc;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ChargePoint.Utils.CookieTool;
import com.ChargePoint.Utils.TextUtils;
import com.ChargePoint.bean.PCUser;
import com.ChargePoint.services.PCUserService;

@Controller
public class LoginAndOut {
	
//	用value使用admin会下载json
	@RequestMapping(value="login/pc",method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		boolean lf = false;
		String errorMsg = "";
		String forwardPage = "redirect:/pages/customerHome.jsp";
		int errorCode = 0;
		String iun = TextUtils.TOUTF8(request.getParameter("userName").trim());
		String ipw = TextUtils.TOUTF8(request.getParameter("pw").trim());
		String ir = null;
		ir = request.getParameter("isRemember");
		PCUser u = null;
		u = PCUserService.getPCUser(iun);
		if(null != u){
			String pW = u.getPassword();
			if(!pW.equals(ipw)){
			errorMsg = "密码错误";
			errorCode = 2;
			}else
		if(pW.equals(ipw)){
			lf = true;
			if(null != ir && ir.equals("true")){//选中
				//设置cookie有效期是两个星期，根据需要自定义
				String encodedUn = null;
				try {
//					保存中文的时候需要对中文进行编码，而且从Cookie中取出内容的时候也要进行解码
					encodedUn = URLEncoder.encode(iun, "utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				CookieTool.addCookie(response,"cookieName", encodedUn, 60 * 60 * 24 * 7 *2);
				CookieTool.addCookie(response,"cookiePW", ipw, 60 * 60 * 24 * 7 *2);
			}
			switch(u.getAccess()){
			case "0":forwardPage = "redirect:/pages/index.jsp";break;
			case "1":forwardPage = "redirect:/pages/salerHome.jsp";break;
			default : forwardPage = "redirect:/pages/customerHome.jsp";
			}
		}
			
		}
		else{
				errorMsg = "账号不存在";
				errorCode = 1;
			}
		modelMap.put("errorCode", errorCode);
		modelMap.put("errorMsg", errorMsg);
		if(lf){
			request.getSession().setAttribute("userName", iun);
			return new ModelAndView(forwardPage, null);
		}else{
			return new ModelAndView("forward:/index.jsp", modelMap);
		}
	}
	
	@RequestMapping(value="logout/pc",method = RequestMethod.POST)
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		Enumeration<String> enumer = session.getAttributeNames();
		while(enumer.hasMoreElements()){
			request.getSession().removeAttribute(enumer.nextElement().toString());
		}
		return new ModelAndView("redirect:/index.jsp");
	}
	
	@RequestMapping(value="login/clearCookie",method = RequestMethod.POST)
	public void clearCookie(HttpServletRequest request,HttpServletResponse response){
		CookieTool.addCookie(response, "cookieName", null, 0); // 清除Cookie
		CookieTool.addCookie(response, "cookiePW", null, 0); // 清除Cookie
	}
}
