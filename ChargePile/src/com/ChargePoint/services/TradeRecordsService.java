package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.TradeRecordsDAOImpl;
import com.ChargePoint.bean.TradeRecords;
import com.ChargePoint.bean.TradeRecords2;

public class TradeRecordsService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static TradeRecordsDAOImpl tradeRecordsDAOImpl = (TradeRecordsDAOImpl) act.getBean("TradeRecordsDAOImpl");
	
	/**获取所有交易记录信息
	 * @param TradeRecords TradeRecords
	 * @return List TradeRecords
	 */
	public static List<TradeRecords> getTradeRecordsList(TradeRecords2 TradeRecords){
		return tradeRecordsDAOImpl.selectTradeRecordsList(TradeRecords);
	}
	
	/**分页获取交易记录信息
	 * @param String tableName,int startIndex ,int pageSize,String startTime,String endTime, String sortName,String order
	 * @return List TradeRecords
	 */
	public static List<TradeRecords> getTradeRecordsByPage(String tableName ,int startIndex,int pageSize,String startTime,String endTime,String sortName,String order){
		 Map<String,Object> parameterMap= new HashMap<String,Object>();
		 parameterMap.put("tableName", tableName);
		 parameterMap.put("limitStart", startIndex);
		 parameterMap.put("limitCount", pageSize);
		 parameterMap.put("startTime", startTime);
		 parameterMap.put("endTime", endTime);
		 parameterMap.put("sortName", sortName);
		 parameterMap.put("order", order);
		return tradeRecordsDAOImpl.getTradeRecordsByPage(parameterMap);
	}
	
	/**添加交易记录
	 * @param TradeRecords TradeRecords
	 * @return boolean
	 */
	public static boolean addTradeRecords(TradeRecords2 tradeRecords) {
		return tradeRecordsDAOImpl.insertTradeRecords(tradeRecords);
	}
	
	/**删除交易记录
	 * @param TradeRecords2 tradeRecords
	 * @return boolean
	 */
	public static boolean deleteTradeRecords(TradeRecords2 tradeRecords) {
		return tradeRecordsDAOImpl.deleteTradeRecords(tradeRecords);
	}
	
	/**修改交易记录信息
	 * @param TradeRecords TradeRecords
	 * @return boolean
	 */
	public static boolean updateTradeRecords(TradeRecords2 tradeRecords) {
		return tradeRecordsDAOImpl.updateTradeRecords(tradeRecords);
	}
	
}
