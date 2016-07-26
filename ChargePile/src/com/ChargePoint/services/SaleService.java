package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.SaleDAOImpl;
import com.ChargePoint.bean.Sale;

public class SaleService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static SaleDAOImpl saleDAOImpl = (SaleDAOImpl) act.getBean("SaleDAOImpl");
	
	/**获取所有销售信息
	 * @param Sale Sale
	 * @return List Sale
	 */
	public static List<Sale> getSaleList(Sale Sale){
		return saleDAOImpl.selectSaleList(Sale);
	}
	
	/**获取所有销售信息(充电桩总数)
	 * @return int 
	 */
	public static int selectSaleCount() {
		return saleDAOImpl.selectSaleCount();
	}
	
	/**模糊查询地址
	 * @param place
	 * @return List Sale
	 */
	public static List<Sale> getSaleListByAddress(String place) {
		return saleDAOImpl.selectSaleListByAddress(place);
	}
	
	/**分级查询地址
	 * @param int level:1-省/直辖市，2-市，3-县/区
	 * @return List String
	 */
	public static List<String> getSaleAddressByLevel(int level) {
		return saleDAOImpl.selectSaleAddressByLevel(level);
	}
	
	/**根据省会获取市列表
	 * @param place
	 * @return List String
	 */
	public static List<String> getSaleAddressByLevel2(String place) {
		return saleDAOImpl.selectSaleAddressByLevel2(place);
	}
	
	/**分页获取销售信息
	 * @param int startIndex ,int pageSize,String startTime,String endTime, String sortName,String order
	 * @return List Sale
	 */
	public static List<Sale> getSaleByPage(int startIndex,int pageSize,String startTime,String endTime,String sortName,String order){
		 Map<String,Object> parameterMap= new HashMap<String,Object>();
		 parameterMap.put("limitStart", startIndex);
		 parameterMap.put("limitCount", pageSize);
		 parameterMap.put("startTime", startTime);
		 parameterMap.put("endTime", endTime);
		 parameterMap.put("sortName", sortName);
		 parameterMap.put("order", order);
		return saleDAOImpl.getSaleByPage(parameterMap);
	}
	
	/**添加销售记录同时创建chargeLive表
	 * @param Sale Sale
	 * @return boolean
	 */
	public static boolean addSale(Sale sale) {
		boolean r = false;
		boolean lt = false;
		String c_p_id = "";
		if(null != sale){
			c_p_id = sale.getC_p_id();
		}
		lt = CommonService.createChargePointLiveTable(c_p_id);
		if(lt){
			r = saleDAOImpl.insertSale(sale);
		}
		if(r && lt){
			return true; 
		}else{
			return false;
		}
	}
	
	/**根据cpid删除用户
	 * @param String cpid
	 * @return
	 */
	public static boolean deleteSale(String c_p_id) {
		return saleDAOImpl.deleteSale(c_p_id);
	}
	
	/**修改销售信息
	 * @param Sale Sale
	 * @return boolean
	 */
	public static boolean updateSale(Sale Sale) {
		return saleDAOImpl.updateSale(Sale);
	}
	
}
