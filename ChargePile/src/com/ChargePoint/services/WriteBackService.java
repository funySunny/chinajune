package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.WriteBackDAOImpl;
import com.ChargePoint.Utils.TimeFormatUtil;
import com.ChargePoint.bean.WriteBack;

public class WriteBackService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static WriteBackDAOImpl writeBackDAOImpl = (WriteBackDAOImpl) act.getBean("WriteBackDAOImpl");
	
	/**获取所有回复信息
	 * @param WriteBack writeBack
	 * @return List WriteBack
	 */
	public static List<WriteBack> getWriteBackList(WriteBack writeBack){
		return writeBackDAOImpl.selectWriteBackList(writeBack);
	}
	/**获取回复信息个数
	 * @param Integer stationID,Integer reviewID
	 * @return int 
	 */
	public static int getWriteBackCountByReview(Integer stationID,Integer reviewID){
		Map<String,Object> parameterMap= new HashMap<String,Object>();
		 parameterMap.put("station_id", stationID);
		 parameterMap.put("review_id", reviewID);
		return writeBackDAOImpl.selectWriteBackCountByReview(parameterMap);
	}
	
	/**分页获取回复信息
	 * @param int startIndex pageSize 
	 * @return List WriteBack
	 */
	public static List<WriteBack> getWriteBackByPage(int startIndex,int pageSize){
		 Map<String,Object> parameterMap= new HashMap<String,Object>();
		 parameterMap.put("limitStart", startIndex);
		 parameterMap.put("limitCount", pageSize);
		return writeBackDAOImpl.getWriteBackByPage(parameterMap);
	}
	
	/**添加回复
	 * @param WriteBack writeBack
	 * @return boolean
	 */
	public static boolean addWriteBack(WriteBack writeBack) {
		try {
			writeBack.setTime(TimeFormatUtil.getFormattedNow());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writeBackDAOImpl.insertWriteBack(writeBack);
	}
	
	/**删除回复
	 * @param WriteBack writeBack
	 * @return
	 */
	public static boolean deleteWriteBack(WriteBack writeBack) {
		return writeBackDAOImpl.deleteWriteBack(writeBack);
	}
	
	/**修改回复
	 * @param WriteBack writeBack
	 * @return boolean
	 */
	public static boolean updateWriteBack(WriteBack writeBack) {
		return writeBackDAOImpl.updateWriteBack(writeBack);
	}
	
}
