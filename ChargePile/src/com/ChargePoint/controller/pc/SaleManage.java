package com.ChargePoint.controller.pc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ChargePoint.Utils.JsonUtil;
import com.ChargePoint.Utils.TextUtils;
import com.ChargePoint.bean.ChargePoint;
import com.ChargePoint.bean.Sale;
import com.ChargePoint.services.ChargePointService;
import com.ChargePoint.services.CommonService;
import com.ChargePoint.services.SaleService;
import com.sun.org.glassfish.gmbal.ParameterNames;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@Controller
@RequestMapping("/sale/")
public class SaleManage {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	@RequestMapping(value="getSaleList", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getSaleList(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Sale> saleList = SaleService.getSaleList(null);
		modelMap.put("saleList", saleList);
		return modelMap;
	}
	
	@RequestMapping(value="getSaleCount", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> getSaleCount(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int count = SaleService.selectSaleCount();
		modelMap.put("saleCount", count);
		return modelMap;
	}
	
	@RequestMapping(value="getSaleListByAddress/{location}", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> getSaleListByAddress(@PathVariable("location")String location,HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		location = TextUtils.TOUTF8(location);
		List<Sale> saleList = SaleService.getSaleListByAddress(location);
		modelMap.put("saleList", saleList);
		return modelMap;
	}
	
	@RequestMapping(value="getSaleAddressByLevel/{level}", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> getSaleAddressByLevel(@PathVariable("level")int level,HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<String> addressList = SaleService.getSaleAddressByLevel(level);
		modelMap.put("addressList", addressList);
		return modelMap;
	}
	
	@RequestMapping(value="getSaleAddressTreeData", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> getSaleAddressTreeData(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Object> treeData = new LinkedList<Object>();
		Map<String,Object> tree1 = null;
		Map<String,Object> tree2 = null;
		Map<String,Object> tree3 = null;
		List<String> citys = null;
		List<Object> citysObject = null;
		List<Sale> locations = null;
		List<Object> locationsObject = null;
		/*
		var treeViewData = [{
		  text: '一级菜单 1',
  nodes: [{
	  text: '二级菜单 ',
      href: '#a',
      tags: ['0']
  },{
	  text: '二级菜单2 ',
      href: '#a',
      tags: ['0'],
      nodes : [{
    	  text: '3级菜单 ',
          href: '#a',
          tags: ['0']
      }]
  }]},
    {
     text: '一级菜单 2',
     href: '#parent1',
     tags: ['4']  	  
    }      
          ];
	          */
		
//		获取省份
		List<String> provinces = SaleService.getSaleAddressByLevel(1);
		for(String province : provinces){
//			当前省份下的城市
			citys = new LinkedList<String>();
			citys = SaleService.getSaleAddressByLevel2(province); 
//			当前省会下有城市
			if(null != citys){
				for(String city : citys){
				locations = new LinkedList<Sale>();
				locations = SaleService.getSaleListByAddress(city);
				
//				当前城市下有区、县
				if(null != locations){
					tree1 = new TreeMap<String, Object>();
					
//					地区唯一
					if(locations.size() == 1){
						tree3 = new TreeMap<String, Object>();
						tree2 = new TreeMap<String, Object>();
						tree2.put("text", city);
						tree3.put("text", locations.get(0).getLocation());
						tree2.put("nodes", tree3);
//						地区不唯一全部列举
					}else{
						tree2 = new TreeMap<String, Object>();
						locationsObject = new LinkedList<Object>();
						for(Sale location : locations){
							tree3 = new TreeMap<String, Object>();
							tree3.put("text", location.getLocation().toString());
							locationsObject.add(tree3);
						}
						tree2.put("nodes", locationsObject);
					}
					citysObject = new LinkedList<Object>();
					citysObject.add(tree2);
					tree1.put("text", province);
					tree1.put("nodes", citysObject);
					treeData.add(tree1);
//					当前城市下没有区、县
				}else{
					tree1 = new TreeMap<String, Object>();
					tree1.put("text", province);
					tree2 = new TreeMap<String, Object>();
					tree2.put("text", city);
					tree1.put("nodes", tree2);
					treeData.add(tree1);
				}
				}
//				当前省会下没有城市
			}else{
				tree1 = new TreeMap<String, Object>();
				tree1.put("text", province);
				treeData.add(tree1);
			}
		}//end for
		
		modelMap.put("treeData", treeData);
		return modelMap;
	}
	
	@RequestMapping(value="getSaleByPage", method= RequestMethod.GET)
	@ResponseBody//返回json对象
	public Map<String,Object> getSaleByPage(HttpServletRequest request){
		List<Sale> saleList = new ArrayList<Sale>();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int limitStart = request.getParameter("offset") == null ? 0 : Integer.parseInt(request.getParameter("offset"));
		  // 每页行数
		  int limitCount = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
		  if (limitStart != 0) {// 获取页数
			  limitStart = limitStart / limitCount;
		  }
		  String sortName = request.getParameter("sortName");
		  String order = request.getParameter("order")== null ? "asc" : request.getParameter("order");
		  String s_t = request.getParameter("start_time");
		  String e_t = request.getParameter("end_time");
		  saleList = SaleService.getSaleByPage(limitStart, limitCount,s_t,e_t,sortName,order);
		  int total = 0;
		  total = CommonService.getTotalCount("sale");
		  modelMap.put("rows", saleList); //这里的 rows 和total 的key 是固定的 
		  modelMap.put("total", total);
		return modelMap;
	}
	
	@RequestMapping(value="deleteSale/{id}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> deleteUser(HttpServletRequest request,@PathVariable("id")String id){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		id = id.trim();
		boolean res = SaleService.deleteSale(id);
		modelMap.put("deleteFlag", res);
		return modelMap;
	}
	
	@RequestMapping(value="deleteSales/{ids}", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> deleteSales(HttpServletRequest request,@PathVariable("ids")String[] ids){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int refC = 0;
		for(String id : ids){
			id = id.trim();
			if(SaleService.deleteSale(id)){
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
	
	@RequestMapping(value="addSale", method= RequestMethod.POST)
	@ResponseBody//返回json对象
	public Map<String,Object> addSale(HttpServletRequest request){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		boolean res = false;
		Sale sale = null;
		try {
			String jsonS = URLDecoder.decode(request.getParameter("jsonStr").trim(),"UTF-8");
			sale = (Sale) JsonUtil.json2Class(jsonS,Sale.class);
			res = SaleService.addSale(sale);
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
}
