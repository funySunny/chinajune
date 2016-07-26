package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.OperateDAOImpl;
import com.ChargePoint.bean.Operate;
import com.ChargePoint.bean.Operate2;

public class OperateService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static OperateDAOImpl operateDAOImpl = (OperateDAOImpl) act.getBean("OperateDAOImpl");
	
	
	/**获取Operate列表
	 * @param operate
	 * @return List Operate
	 */
	public static List<Operate> getOperateList(Operate2 operate){
		return operateDAOImpl.selectOperateList(operate);
	}
	
	/**分页获取operate列表
	 * @param String tableName
	 * @param int limitStart, int limitCount , String sortName,String order
	 * @return List Operate
	 */
	public static List<Operate> getOperateByPage(String tableName ,int limitStart , int limitCount ,String sortName,String order){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", tableName);
		map.put("limitStart", limitStart);
		map.put("limitCount", limitCount);
		map.put("sortName", sortName);
		map.put("order", order);
		return operateDAOImpl.selectOperateByPage(map);
	}
	
	/**添加operate记录
	 * @param operate
	 * @return boolean
	 */
	public static boolean addOperate(Operate2 operate){
		return operateDAOImpl.insertOperate(operate);
	}
	
	/**删除operate记录
	 * @param operate
	 * @return boolean
	 */
	public static boolean deleteoperate(Operate2 operate){
		return operateDAOImpl.deleteOperate(operate);
	};
	
	/**更新operate记录
	 * @param operate
	 * @return boolean
	 */
	public static boolean updateoperate(Operate2 operate){
		return operateDAOImpl.updateOperate(operate);
	};
}
