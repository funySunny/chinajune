package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.DataExchangeDAOImpl;
import com.ChargePoint.bean.DataExchange;

public class DataExchangeService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static DataExchangeDAOImpl dataExchangeDAOImpl = (DataExchangeDAOImpl) act.getBean("DataExchangeDAOImpl");
	
	
	/**获取DataExchange列表
	 * @param dataExchange
	 * @return List DataExchange
	 */
	public static List<DataExchange> getDataExchangeList(DataExchange dataExchange){
		return dataExchangeDAOImpl.selectDataExchangeList(dataExchange);
	}
	
	/**分页获取dataExchange列表
	 * @param int limitStart
	 * @param int limitCount
	 * @return List DataExchange
	 */
	public static List<DataExchange> getDataExchangeByPage(int limitStart , int limitCount){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("limitStart", limitStart);
		map.put("limitCount", limitCount);
		return dataExchangeDAOImpl.selectDataExchangeByPage(map);
	}
	
	/**添加dataExchange记录
	 * @param dataExchange
	 * @return boolean
	 */
	public static boolean addDataExchange(DataExchange dataExchange){
		return dataExchangeDAOImpl.insertDataExchange(dataExchange);
	}
	
	/**删除dataExchange记录
	 * @param dataExchange
	 * @return boolean
	 */
	public static boolean deletedataExchange(DataExchange dataExchange){
		return dataExchangeDAOImpl.deleteDataExchange(dataExchange);
	}
	
	/**更新dataExchange记录
	 * @param dataExchange
	 * @return boolean
	 */
	public static boolean updatedataExchange(DataExchange dataExchange){
		return dataExchangeDAOImpl.updateDataExchange(dataExchange);
	}
}
