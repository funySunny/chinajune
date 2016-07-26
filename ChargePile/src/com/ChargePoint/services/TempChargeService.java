package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.TempChargeDAOImpl;
import com.ChargePoint.bean.TempCharge;

public class TempChargeService {

	// 加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");

	// 注入dataSource
	static TempChargeDAOImpl tempChargeDAOImpl = (TempChargeDAOImpl) act.getBean("TempChargeDAOImpl");

	/**
	 * 获取TempCharge列表
	 * 
	 * @param tempCharge
	 * @return List TempCharge
	 */
	public static List<TempCharge> getTempChargeList(TempCharge tempCharge) {
		return tempChargeDAOImpl.selectTempChargeList(tempCharge);
	}

	/**
	 * 分页获取tempCharge列表
	 * 
	 * @param String
	 *            tableName
	 * @param int
	 *            limitStart
	 * @param int
	 *            limitCount
	 * @return List TempCharge
	 */
	public static List<TempCharge> getTempChargeByPage(int limitStart, int limitCount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("limitStart", limitStart);
		map.put("limitCount", limitCount);
		return tempChargeDAOImpl.selectTempChargeByPage(map);
	}

	/**
	 * 添加tempCharge记录
	 * 
	 * @param tempCharge
	 * @return boolean
	 */
	public static boolean addTempCharge(TempCharge tempCharge) {
		return tempChargeDAOImpl.insertTempCharge(tempCharge);
	};

	/**
	 * 删除tempCharge记录
	 * 
	 * @param tempCharge
	 * @return boolean
	 */
	public static boolean deleteTempCharge(TempCharge tempCharge) {
		return tempChargeDAOImpl.deleteTempCharge(tempCharge);
	}

	/**
	 * 更新tempCharge记录
	 * 
	 * @param tempCharge
	 * @return boolean
	 */
	public static boolean updateTempCharge(TempCharge tempCharge) {
		return tempChargeDAOImpl.updateTempCharge(tempCharge);
	}
}
