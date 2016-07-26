package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.ChargeRecordsDAOImpl;
import com.ChargePoint.bean.ChargeMoneyRecords2;
import com.ChargePoint.bean.ChargePoint;
import com.ChargePoint.bean.ChargePointLive;
import com.ChargePoint.bean.ChargeRecords;
import com.ChargePoint.bean.ChargeRecords2;

public class ChargeRecordsService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static ChargeRecordsDAOImpl chargeRecordsDAOImpl = (ChargeRecordsDAOImpl) act.getBean("ChargeRecordsDAOImpl");
	
	/**获取充电记录信息
	 * @param int id
	 * @param searchText
	 * @return List ChargeRecords
	 */
	public static List<ChargeRecords> getChargeRecords(ChargeRecords2 c){
		return chargeRecordsDAOImpl.getChargeRecordsList(c);
	}
	
	/**分页获取充电记录信息
	 * @param int limitStart 页码
	 * @param int limitCount 每页数量
	 * @param String searchText 查询关键字
	 * @param String sortName 排序字段
	 * @param String order 排序规则 asc desc
	 * @return List ChargeRecords
	 */
	public static List<ChargeRecords> getChargeRecordsByPage(String tableName,int limitStart , int limitCount ,String searchText,String trade_status,String sortName,String order){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", tableName);
		map.put("limitStart", limitStart);
		map.put("limitCount", limitCount);
		map.put("searchText", searchText);
		map.put("trade_status", trade_status);
		map.put("sortName", sortName);
		map.put("order", order);
		return chargeRecordsDAOImpl.getChargeRecordsByPage(map);
	}
	
	/**添加chargeRecords记录(无需设置total_count与total_degree)
	 * @param chargeMoneyRecords
	 * @return boolean
	 */
	public static boolean addChargeRecords(ChargeRecords2 chargeRecords){
//		数据初始化及零值处理
		Float degree = chargeRecords.getDegree();
		degree = (degree == null) ? 0.00f : degree;
		String totalDegreeStr = CommonService.getMaxData(chargeRecords.getTable_name(), "total_degree");
		totalDegreeStr = (totalDegreeStr == null) ? "0.00" : totalDegreeStr;
		Float totalDegree = Float.valueOf(totalDegreeStr);
		chargeRecords.setTotal_degree(degree + totalDegree);
		Integer total_count = chargeRecords.getTotal_count();
		total_count = (total_count == null) ? 1 : total_count;
		return chargeRecordsDAOImpl.addChargeRecords(chargeRecords);
	}
	
	/**搜索充电记录信息
	 * @param int id
	 * @param searchText
	 * @return List ChargeRecords
	 */
	public static List<ChargeRecords> searchChargeRecords(int id,String searchText){
		Map<String,String> map = new HashMap<String,String>();
		map.put("tableName", "charge_records_"+id);
		map.put("searchText", searchText);
		return chargeRecordsDAOImpl.searchChargeRecordsList(map);
	}
	
	/**删除充电记录
	 * @param ChargeRecords2
	 * @return boolean
	 */
	public static boolean deleteChargeRecords(ChargeRecords2 chargeRecord){
		return chargeRecordsDAOImpl.deleteChargeRecords(chargeRecord);
	}
	
}
