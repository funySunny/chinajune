package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.ChargePointLiveDAOImpl;
import com.ChargePoint.bean.ChargePointLive;
import com.ChargePoint.bean.ChargePointLive2;

public class ChargePointLiveService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static ChargePointLiveDAOImpl chargePointLiveDAOImpl = (ChargePointLiveDAOImpl) act.getBean("ChargePointLiveDAOImpl");
	
	
	/**获取chargePointLive列表
	 * @param chargePointLive
	 * @return List ChargePointLive
	 */
	public static List<ChargePointLive> getChargePointLiveList(ChargePointLive2 chargePointLive){
		return chargePointLiveDAOImpl.selectChargePointLiveList(chargePointLive);
	}
	
	/**分页获取chargePointLive列表
	 * @param String tableName
	 * @param int limitStart
	 * @param int limitCount
	 * @return List ChargePointLive
	 */
	public static List<ChargePointLive> getChargePointLiveByPage(int limitStart , int limitCount){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("limitStart", limitStart);
		map.put("limitCount", limitCount);
		return chargePointLiveDAOImpl.getChargePointLiveByPage(map);
	}
	
	/**获取chargePointLive最新数据
	 * @param tableName
	 * @return ChargePointLive
	 */
	public static ChargePointLive getFirstChargePointLive(String tableName) {
		return chargePointLiveDAOImpl.selectFirstChargePointLive(tableName);
	}
	
	/**添加chargePointLive记录
	 * @param chargePointLive
	 * @return boolean
	 */
	public static boolean addChargePointLive(ChargePointLive2 chargePointLive){
		return chargePointLiveDAOImpl.insertChargePointLive(chargePointLive);
	};
	
	/**删除chargePointLive记录
	 * @param chargePointLive
	 * @return boolean
	 */
	public static boolean deleteChargePointLive(ChargePointLive chargePointLive){
		return chargePointLiveDAOImpl.deleteChargePointLive(chargePointLive);
	}
	
	/**更新chargePointLive记录
	 * @param chargePointLive
	 * @return boolean
	 */
	public static boolean updatechargePointLive(ChargePointLive chargePointLive){
		return chargePointLiveDAOImpl.updateChargePointLive(chargePointLive);
	}
}
