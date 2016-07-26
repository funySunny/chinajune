package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.OperateResultsDAOImpl;
import com.ChargePoint.bean.OperateResults;
import com.ChargePoint.bean.OperateResults2;

public class OperateResultsService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static OperateResultsDAOImpl operateResultsDAOImpl = (OperateResultsDAOImpl) act.getBean("OperateResultsDAOImpl");
	
	
	/**获取OperateResults列表
	 * @param operate
	 * @return List OperateResults
	 */
	public static List<OperateResults> getOperateResultsList(OperateResults2 operate){
		return operateResultsDAOImpl.selectOperateResultsList(operate);
	}
	
	/**分页获取operate列表
	 * @param String tableName
	 * @param int limitStart, int limitCount , String sortName,String order
	 * @return List OperateResults
	 */
	public static List<OperateResults> getOperateResultsByPage(String tableName ,int limitStart , int limitCount ,String sortName,String order){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", tableName);
		map.put("limitStart", limitStart);
		map.put("limitCount", limitCount);
		map.put("sortName", sortName);
		map.put("order", order);
		return operateResultsDAOImpl.selectOperateResultsByPage(map);
	}
	
	/**添加operate记录
	 * @param operate
	 * @return boolean
	 */
	public static boolean addOperateResults(OperateResults2 operate){
		return operateResultsDAOImpl.insertOperateResults(operate);
	}
	
	/**删除operate记录
	 * @param operate
	 * @return boolean
	 */
	public static boolean deleteoperate(OperateResults2 operate){
		return operateResultsDAOImpl.deleteOperateResults(operate);
	};
	
	/**更新operate记录
	 * @param operate
	 * @return boolean
	 */
	public static boolean updateoperate(OperateResults2 operate){
		return operateResultsDAOImpl.updateOperateResults(operate);
	};
}
