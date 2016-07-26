package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.ChargePointStationDAOImpl;
import com.ChargePoint.bean.ChargePointStation;

public class ChargePointStationService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static ChargePointStationDAOImpl chargePointStationDAOImpl = (ChargePointStationDAOImpl) act.getBean("ChargePointStationDAOImpl");
	
	
	/**获取chargePointStation列表
	 * @param chargePointStation
	 * @return List ChargePointStation
	 */
	public static List<ChargePointStation> getChargePointStationList(ChargePointStation chargePointStation){
		return chargePointStationDAOImpl.getChargePointStationList(chargePointStation);
	}
	
	/**获取chargePointStation
	 * @param chargePointStationName
	 * @return List ChargePointStation
	 */
	public static ChargePointStation getChargePointStation(Integer chargePointStationID){
		ChargePointStation chargePointStation = new ChargePointStation();
		chargePointStation.setId(chargePointStationID);
		return chargePointStationDAOImpl.getChargePointStationList(chargePointStation).get(0);
	}
	
	/**分页获取交流、直流chargePointStation列表
	 * @param int limitStart 页码
	 * @param int limitCount 每页数量
	 * @param String c_p_id 查询id条件
	 * @param String place 查询充电站位置
	 * @param String sortName 排序字段
	 * @param String order 排序规则 asc desc
	 * @return List ChargePointStation
	 */
	public static List<ChargePointStation> getChargePointStationByPage(int limitStart , int limitCount ,String c_p_id,String place,String sortName,String order){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("limitStart", limitStart);
		map.put("limitCount", limitCount);
		map.put("c_p_id", c_p_id);
		map.put("place", place);
		map.put("sortName", sortName);
		map.put("order", order);
		return chargePointStationDAOImpl.getChargePointStationByPage(map);
	}
	
	/**添加chargePointStation记录
	 * @param chargePointStation
	 * @return boolean
	 */
	public static boolean addChargePointStation(ChargePointStation chargePointStation){
		return chargePointStationDAOImpl.insertChargePointStation(chargePointStation);
	};
	
	/**删除chargePointStation记录
	 * @param chargePointStation
	 * @return boolean
	 */
	public static boolean deleteChargePointStation(ChargePointStation chargePointStation){
		return chargePointStationDAOImpl.deleteChargePointStation(chargePointStation);
	}
	
	/**更新chargePointStation记录
	 * @param chargePointStation
	 * @return boolean
	 */
	public static boolean updateChargePointStation(ChargePointStation chargePointStation){
		return chargePointStationDAOImpl.updateChargePointStation(chargePointStation);
	}
	
}
