package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.ChargePointDAOImpl;
import com.ChargePoint.bean.ChargePoint;
import com.ChargePoint.bean.ChargePointHome;

public class ChargePointService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static ChargePointDAOImpl chargePointDAOImpl = (ChargePointDAOImpl) act.getBean("ChargePointDAOImpl");
	
	
	/**获取chargePoint列表
	 * @param chargePoint
	 * @return List ChargePoint
	 */
	public static List<ChargePoint> getChargePointList(ChargePoint chargePoint){
		return chargePointDAOImpl.selectChargePointList(chargePoint);
	}
	
	/**通过充电桩id获取充电桩数据
	 * @param c_p_id
	 * @return ChargePoint chargePoint
	 */
	public static ChargePoint getChargePoint(String c_p_id) {
		return chargePointDAOImpl.selectChargePoint(c_p_id);
	}
	
	/**根据用户名查找充电桩
	 * @param userName
	 * @return List ChargePoint
	 */
	public static List<ChargePoint> getChargePointListByUserName(String userName) {
		return chargePointDAOImpl.selectChargePointListByUserName(userName);
	}
	
	/**分页获取交流、直流chargePoint列表
	 * @param int limitStart 页码
	 * @param int limitCount 每页数量
	 * @param String c_p_id 查询id条件
	 * @param String c_p_type 查询充电桩类型0-直流1-交流
	 * @param String sortName 排序字段
	 * @param String order 排序规则 asc desc
	 * @return List ChargePoint
	 */
	public static List<ChargePoint> getChargePointByPage(int limitStart , int limitCount ,String c_p_id,String c_p_type,String sortName,String order){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("limitStart", limitStart);
		map.put("limitCount", limitCount);
		map.put("c_p_id", c_p_id);
		map.put("c_p_type", c_p_type);
		map.put("sortName", sortName);
		map.put("order", order);
		return chargePointDAOImpl.getChargePointByPage(map);
	}
	
	/**查询admin home 所需数据
	 * @param int limitStart 页码
	 * @param int limitCount 每页数量
	 * @param String c_p_id 查询id条件
	 * @param String c_p_type 查询充电桩类型0-直流1-交流
	 * @param String sortName 排序字段
	 * @param String order 排序规则 asc desc
	 * @return List ChargePointHome
	 */
	public static List<ChargePointHome> getHomeCPTable(int limitStart , int limitCount ,String c_p_id,String is_free,String sortName,String order){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("limitStart", limitStart);
		map.put("limitCount", limitCount);
		map.put("c_p_id", c_p_id);
		map.put("is_free", is_free);
		map.put("sortName", sortName);
		map.put("order", order);
		return chargePointDAOImpl.getHomeCPTable(map);
	}
	
	/**查询地图充电桩列表所需数据
	 * @return List ChargePointHome
	 */
	public static List<ChargePointHome> getCPMap(){
		return chargePointDAOImpl.getHomeCPTable(null);
	}
	
	/**添加chargePoint记录
	 * @param chargePoint
	 * @return boolean
	 */
	public static boolean addChargePoint(ChargePoint chargePoint){
		return chargePointDAOImpl.insertChargePoint(chargePoint);
	};
	
	/**删除chargePoint记录
	 * @param chargePoint
	 * @return boolean
	 */
	public static boolean deleteChargePoint(ChargePoint chargePoint){
		return chargePointDAOImpl.deleteChargePoint(chargePoint);
	}
	
	/**更新chargePoint记录
	 * @param chargePoint
	 * @return boolean
	 */
	public static boolean updateChargePoint(ChargePoint chargePoint){
		return chargePointDAOImpl.updateChargePoint(chargePoint);
	}
	
}
