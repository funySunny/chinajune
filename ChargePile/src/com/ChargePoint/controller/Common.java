package com.ChargePoint.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.ChargePoint.Utils.CreateValidateImage;
import com.ChargePoint.Utils.JsonUtil;
import com.ChargePoint.Utils.MailUtil;
import com.ChargePoint.Utils.TextUtils;
import com.ChargePoint.bean.MobileUser;
import com.ChargePoint.services.CommonService;
import com.ChargePoint.services.MobileUserService;

@Controller
@RequestMapping("/common/")
public class Common{
	
	@RequestMapping(value="getTotalCount",method = RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getTotalCount(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int pageCount = 0;
		String tableName = request.getParameter("tableName").trim();
		pageCount = CommonService.getTotalCount(tableName);
		modelMap.put("pageCount", pageCount);  
		modelMap.put("success", "true");
		return modelMap;
	}
	
	@RequestMapping(value="getCPTotalCount/{type}",method = RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getCPTotalCount(HttpServletRequest request,@PathVariable("type")String type){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int pageCount = 0;
		pageCount = CommonService.getCPTotalCount(type);
		modelMap.put("pageCount", pageCount);  
		return modelMap;
	}

	@RequestMapping(value="getUserSetting",method = RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getUserSetting(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int pageCount = 0;
		String userName = request.getParameter("tableName").trim();
		modelMap.put("pageCount", pageCount);  
		modelMap.put("success", "true");
		return modelMap;
	}	
	
	@RequestMapping(value="getByPage",method = RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getByPage(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int pageCount = 0;
		String userName = request.getParameter("tableName").trim();
		modelMap.put("pageCount", pageCount);  
		return modelMap;
	}
	
	@RequestMapping(value="uploadUserPhoto/{name}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> uploadUserPhoto(HttpServletRequest request,@PathVariable("name")String name,@RequestParam("file")MultipartFile file){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String contextPath = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
		boolean res = false;
		String fileName = "";   
		String filePath="";   
		name = name.trim();
	    String path = request.getSession().getServletContext().getRealPath("userPictures");  
	    if(null != file){
	    String ofileName = file.getOriginalFilename();  
//	    String fileName = new Date().getTime()+".jpg";
	    fileName = name + ofileName.substring(ofileName.lastIndexOf("."),ofileName.length());
//	    System.out.println(path);  
	    File targetFile = new File(path, fileName);  
	    if(!targetFile.exists()){  
	        targetFile.mkdirs();  
	    }  
	    //保存  
	    try {  
	        file.transferTo(targetFile);
	        filePath = basePath+"userPictures/"+fileName;
	        res = true;
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    } 
	    
	    }//end if file null
//	    System.out.println(filePath);
	    modelMap.put("filePath", filePath);//将上传文件路径返回供下一步使用
		modelMap.put("success", res);
		
		return modelMap;
	}
	
	@RequestMapping(value="uploadLicensePhoto", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> uploadLicensePhoto(HttpServletRequest request,@RequestParam("jsonStr")String jsonStr,@RequestParam("file")MultipartFile file){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		MobileUser mobileUser = null;
		boolean res = false;
		try {
		jsonStr = URLDecoder.decode(jsonStr, "UTF-8");
		mobileUser = JsonUtil.json2Class(jsonStr,MobileUser.class);
		String name = mobileUser.getUser_name();
		String contextPath = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
		String fileName = "";   
		String filePath="";   
		name = TextUtils.TOUTF8(name.trim());
	    String path = request.getSession().getServletContext().getRealPath("licensePictures");
//		String path = "D:\\uploadLicense";
	    if(null != file){
	    String ofileName = file.getOriginalFilename();  
//	    String fileName = new Date().getTime()+".jpg";
	    fileName = name + ofileName.substring(ofileName.lastIndexOf("."),ofileName.length());
//	    System.out.println(path);  
	    File targetFile = new File(path, fileName);  
	    if(!targetFile.exists()){  
	        targetFile.mkdirs();  
	    }  
	    //保存  
	    try {  
	        file.transferTo(targetFile);
	        filePath = basePath+"licensePictures/"+fileName;
	        mobileUser.setLicense(filePath);
	        res = MobileUserService.updateMobileUser(mobileUser);
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    } 
	    
	    }//end if file null
	    //将上传文件路径返回供下一步使用
	    System.out.println(filePath);
	    
//	    modelMap.put("filePath", filePath);
	    
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		modelMap.put("res", res);
		return modelMap;
	}
	
	@RequestMapping("/getCodeImg")
	public String getImg(HttpServletRequest request, HttpServletResponse response){ 
		//设置相应类型,告诉浏览器输出的内容为图片
		response.setContentType("image/jpeg"); 
		//设置响应头信息，告诉浏览器不要缓存此内容 
		response.setHeader("Pragma", "No-cache");   
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);  
		CreateValidateImage createValidateImage = new CreateValidateImage(); 
		try {  
			//输出图片方法 
			createValidateImage.getRandcode(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			}  
		//必须返回null
		return null;
			}
	
	@RequestMapping(value="sendEmailCode",method = RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> sendEmail(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String sendTo = request.getParameter("emailAddr").trim();
		String emailCode = TextUtils.getRandomString(6); 
		String contents = "【<a href='http://www.chinajune.com/' target='_blank'>中工巨能</a>】"
		+"您正在修改登录密码，验证码为：<strong style='color: #0087ff;'>"
//				获取六位随机字符串
				+emailCode+
				"</strong>，请在1小时之内按页面提示提交验证码，切勿将验证码泄露于他人。";
//		String contents = ;
		boolean res = false;
		res = MailUtil.sendEmail(sendTo, "巨能充后台管理系统重置密码", contents);
		modelMap.put("success", res);
		modelMap.put("emailCode", emailCode);
		return modelMap;
	}
	
}
