package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.CommonDAOImpl;

public class CommonService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static CommonDAOImpl commonDAOImpl = (CommonDAOImpl) act.getBean("CommonDAOImpl");
	
	/**获取数据个数
	 * @param String tableName
	 * @return int 
	 */
	public static int getTotalCount(String tableName){
		return commonDAOImpl.getTotalCount(tableName);
	}
	
	/**根据类型获取充电桩数据个数
	 * @param String type
	 * @return int 
	 */
	public static int getCPTotalCount(String type){
		return commonDAOImpl.getCPTotalCount(type);
	}
	
	/**根据表名获取最大值数据
	 * @param String tableName, String column
	 * @return String 
	 */
	public static String getMaxData(String tableName, String column){
		Map<String, String> map = new HashMap<String, String>();
		map.put("tableName", tableName);
		map.put("column", column);
		return commonDAOImpl.getMaxData(map);
	}
	
	/**查询数据库类似表名
	 * @param tableName
	 * @return list String
	 */
	public static List<String> getTableNames(String tableName){
		return commonDAOImpl.getTableNames(tableName);
	}
	
	/**建charge_point表
	 * @param tableName
	 * @return boolean
	 */
//	public static boolean createChargePointTable(String tableName) {
//		return commonDAOImpl.createChargePointTable(tableName);
//		
//	}
	
	/**建charge_point_live表
	 * @param tableName
	 * @return boolean
	 */
	public static boolean createChargePointLiveTable(String c_p_id) {
		return commonDAOImpl.createChargePointLiveTable(c_p_id);
	}
	
	/**建charge_point_ac_live表
	 * @param c_p_id
	 * @return boolean
	 */
	public static boolean createChargePointACLiveTable(String c_p_id) {
		return commonDAOImpl.createChargePointACLiveTable(c_p_id);
	}
	
	/**建立用户记录表
	 * @param id
	 * @return
	 */
	public static boolean createChargeRecord(int id){
		return commonDAOImpl.createChargeRecords(id);
	}
	
	/**建立用户充值记录表
	 * @param id
	 * @return
	 */
	public static boolean createChargeMoneyRecord(int id){
		return commonDAOImpl.createChargeMoneyRecords(id);
	}
	
	/**建立用户交易记录表
	 * @param id
	 * @return
	 */
	public static boolean createTradeRecord(int id){
		return commonDAOImpl.createTradeRecords(id);
	}
	
	/**建立用户操作表
	 * @param id
	 * @return
	 */
	public static boolean createOperation(int id){
		return commonDAOImpl.createOperation(id);
	}
	
	/**建立用户操作返回表
	 * @param id
	 * @return
	 */
	public static boolean createOperationResults(int id){
		return commonDAOImpl.createOperationResults(id);
	}
	
	/**删除记录表语句
	 * @param String id
	 * @return boolean 
	 */
	public static boolean dropRecordsTables(String id) {
		return commonDAOImpl.dynamicSql("drop table charge_money_records_"+id+",charge_records_"+id+",trade_records_"+id
				+",operation_"+id+",operation_results_"+id);
	}
	
	/**执行动态sql语句
	 * @param String sql
	 * @return boolean 
	 */
	public static boolean dynamicSql(String sql) {
		return commonDAOImpl.dynamicSql(sql);
	}
	
}
