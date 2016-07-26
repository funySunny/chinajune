package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.TempAppointmentDAOImpl;
import com.ChargePoint.Utils.TimeFormatUtil;
import com.ChargePoint.bean.TempAppointment;

public class TempAppointmentService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static TempAppointmentDAOImpl tempAppointmentDAOImpl = (TempAppointmentDAOImpl) act.getBean("TempAppointmentDAOImpl");
	
	
	/**获取TempAppointment列表
	 * @param tempAppointment
	 * @return List TempAppointment
	 */
	public static List<TempAppointment> getTempAppointmentList(TempAppointment tempAppointment){
		return tempAppointmentDAOImpl.selectTempAppointmentList(tempAppointment);
	}
	
	/**分页获取tempAppointment列表
	 * @param String tableName
	 * @param int limitStart
	 * @param int limitCount
	 * @return List TempAppointment
	 */
	public static List<TempAppointment> getTempAppointmentByPage(int limitStart , int limitCount){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("limitStart", limitStart);
		map.put("limitCount", limitCount);
		return tempAppointmentDAOImpl.selectTempAppointmentByPage(map);
	}
	
	/**添加tempAppointment记录
	 * @param tempAppointment
	 * @return boolean
	 */
	public static boolean addTempAppointment(TempAppointment tempAppointment){
		return tempAppointmentDAOImpl.insertTempAppointment(tempAppointment);
	}
	
	/**删除tempAppointment记录
	 * @param tempAppointment
	 * @return boolean
	 */
	public static boolean deleteTempAppointment(TempAppointment tempAppointment){
		return tempAppointmentDAOImpl.deleteTempAppointment(tempAppointment);
	};
	
	/**更新tempAppointment记录
	 * @param tempAppointment
	 * @return boolean
	 */
	public static boolean updateTempAppointment(TempAppointment tempAppointment){
		return tempAppointmentDAOImpl.updateTempAppointment(tempAppointment);
	};
}
