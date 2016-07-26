package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.ChargeMoneyRecordsDAOImpl;
import com.ChargePoint.bean.ChargeMoneyRecords;
import com.ChargePoint.bean.ChargeMoneyRecords2;

public class ChargeMoneyRecordsService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static ChargeMoneyRecordsDAOImpl chargeMoneyRecordsDAOImpl = (ChargeMoneyRecordsDAOImpl) act.getBean("ChargeMoneyRecordsDAOImpl");
	
	
	/**获取ChargeMoneyRecords列表
	 * @param chargeMoneyRecords
	 * @return List ChargeMoneyRecords
	 */
	public static List<ChargeMoneyRecords> getChargeMoneyRecordsList(ChargeMoneyRecords2 chargeMoneyRecords){
		return chargeMoneyRecordsDAOImpl.selectChargeMoneyRecordsList(chargeMoneyRecords);
	}
	
	/**分页获取chargeMoneyRecords列表
	 * @param String tableName
	 * @param String startTime,String endTime,int limitStart , int limitCount,String sortName,String order
	 * @return List ChargeMoneyRecords
	 */
	public static List<ChargeMoneyRecords> getChargeMoneyRecordsByPage(String table_name,String startTime,String endTime,int limitStart , int limitCount,String sortName,String order){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("table_name", table_name);
		map.put("limitStart", limitStart);
		map.put("limitCount", limitCount);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("sortName", sortName);
		map.put("order", order);
		return chargeMoneyRecordsDAOImpl.selectChargeMoneyRecordsByPage(map);
	}
	
	/**添加chargeMoneyRecords记录(无需设置total_count与total_pass)
	 * @param chargeMoneyRecords
	 * @return boolean
	 */
	public static boolean addChargeMoneyRecords(ChargeMoneyRecords2 chargeMoneyRecords){
//		数据初始化及零值处理
		Float pass = chargeMoneyRecords.getPass();
		pass = (pass == null) ? 0.00f : pass;
		String totalPassStr = CommonService.getMaxData(chargeMoneyRecords.getTable_name(), "total_pass");
		totalPassStr = (totalPassStr == null) ? "0.00" : totalPassStr;
		Float totalPass = Float.valueOf(totalPassStr);
		chargeMoneyRecords.setTotal_pass(pass + totalPass);
		Integer total_count = chargeMoneyRecords.getTotal_count();
		total_count = (total_count == null) ? 1 : total_count;
		return chargeMoneyRecordsDAOImpl.insertChargeMoneyRecords(chargeMoneyRecords);
	}
	
	/**删除chargeMoneyRecords记录
	 * @param chargeMoneyRecords
	 * @return boolean
	 */
	public static boolean deletechargeMoneyRecords(ChargeMoneyRecords2 chargeMoneyRecords){
		return chargeMoneyRecordsDAOImpl.deleteChargeMoneyRecords(chargeMoneyRecords);
	}
	
	/**更新chargeMoneyRecords记录
	 * @param chargeMoneyRecords
	 * @return boolean
	 */
	public static boolean updatechargeMoneyRecords(ChargeMoneyRecords2 chargeMoneyRecords){
		return chargeMoneyRecordsDAOImpl.updateChargeMoneyRecords(chargeMoneyRecords);
	}
}
