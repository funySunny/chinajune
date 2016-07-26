package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.ChargePointACLiveDAOImpl;
import com.ChargePoint.bean.ChargePointACLive;
import com.ChargePoint.bean.ChargePointACLive2;

public class ChargePointACLiveService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static ChargePointACLiveDAOImpl chargePointLiveDAOImpl = (ChargePointACLiveDAOImpl) act.getBean("ChargePointACLiveDAOImpl");
	
	
	/**获取chargePointLive列表
	 * @param chargePointLive
	 * @return List ChargePointACLive
	 */
	public static List<ChargePointACLive> getChargePointACLiveList(ChargePointACLive2 chargePointLive){
		return chargePointLiveDAOImpl.selectChargePointACLiveList(chargePointLive);
	}
	
	/**分页获取chargePointLive列表
	 * @param String tableName
	 * @param int limitStart
	 * @param int limitCount
	 * @return List ChargePointACLive
	 */
	public static List<ChargePointACLive> getChargePointACLiveByPage(int limitStart , int limitCount){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("limitStart", limitStart);
		map.put("limitCount", limitCount);
		return chargePointLiveDAOImpl.getChargePointACLiveByPage(map);
	}
	
	/**获取chargePointLive最新数据
	 * @param tableName
	 * @return ChargePointACLive
	 */
	public static ChargePointACLive getFirstChargePointACLive(String tableName) {
		return chargePointLiveDAOImpl.selectFirstChargePointACLive(tableName);
	}
	
	/**添加chargePointLive记录
	 * @param chargePointLive
	 * @return boolean
	 */
	public static boolean addChargePointACLive(ChargePointACLive2 chargePointLive){
		return chargePointLiveDAOImpl.insertChargePointACLive(chargePointLive);
	};
	
	/**删除chargePointLive记录
	 * @param chargePointLive
	 * @return boolean
	 */
	public static boolean deleteChargePointACLive(ChargePointACLive chargePointLive){
		return chargePointLiveDAOImpl.deleteChargePointACLive(chargePointLive);
	}
	
	/**更新chargePointLive记录
	 * @param chargePointLive
	 * @return boolean
	 */
	public static boolean updatechargePointLive(ChargePointACLive chargePointLive){
		return chargePointLiveDAOImpl.updateChargePointACLive(chargePointLive);
	}
}
