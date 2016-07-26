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
import com.ChargePoint.bean.Company;
import com.ChargePoint.services.CommonService;
import com.ChargePoint.services.CompanyService;

@Controller
@RequestMapping("/company/")
public class CompanyManage {
	
	@RequestMapping(value="getCompanyList", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getCompanyList(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Company> companyList = CompanyService.getCompanyList(null);
		modelMap.put("companyList", companyList);
		return modelMap;
	}
	
	@RequestMapping(value="addCompany", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> addCompany(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		boolean res = false;
		Company company = null;
		try {
			String jsonS = URLDecoder.decode(request.getParameter("jsonStr").trim(),"UTF-8");
			company = (Company) JsonUtil.json2Class(jsonS,Company.class);
			res = CompanyService.addCompany(company);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelMap.put("addFlag", res);
		return modelMap;
	}
	
	@RequestMapping(value="getCompanyByPage", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> getCompanyByPage(HttpServletRequest request){
		List<Company> companyList = new ArrayList<Company>();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int limitStart = request.getParameter("offset") == null ? 0 : Integer.parseInt(request.getParameter("offset"));
		  // 每页行数
		  int limitCount = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
		  if (limitStart != 0) {// 获取页数
			  limitStart = limitStart / limitCount;
		  }
		  String sortName = request.getParameter("sortName");
		  String order = request.getParameter("order")== null ? "asc" : request.getParameter("order");
		  String searchText = request.getParameter("searchText");
		  companyList = CompanyService.getCompanyByPage(limitStart, limitCount,searchText,sortName,order);
		  int total = 0;
		  total = CommonService.getTotalCount("company");
		  modelMap.put("rows", companyList); //这里的 rows 和total 的key 是固定的 
		  modelMap.put("total", total);
		return modelMap;
	}
	
	@RequestMapping(value="deleteCompany/{companyName}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> deleteCompany(HttpServletRequest request,@PathVariable("companyName")String companyName){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		companyName = companyName.trim();
		boolean res = CompanyService.deleteCompany(companyName);
		modelMap.put("deleteFlag", res);
		return modelMap;
	}
	
	@RequestMapping(value="deleteCompanys/{companyNames}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> deleteCompanys(HttpServletRequest request,@PathVariable("companyNames")String[] companyNames){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int refC = 0;
		for(String companyName : companyNames){
			companyName = companyName.trim();
			if(CompanyService.deleteCompany(companyName)){
				refC++;
			}
		}
		if(refC == companyNames.length){
			modelMap.put("deleteResult", true);
		}else{
			modelMap.put("deleteResult", false);
		}
		return modelMap;
	}
	
}
