package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.AddHeartDAOImpl;
import com.ChargePoint.bean.AddHeart;

public class AddHeartService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static AddHeartDAOImpl addHeartDAOImpl = (AddHeartDAOImpl) act.getBean("AddHeartDAOImpl");
	
	/**获取所有点赞信息
	 * @param AddHeart addHeart
	 * @return List AddHeart
	 */
	public static List<AddHeart> getAddHeartList(AddHeart addHeart){
		return addHeartDAOImpl.selectAddHeartList(addHeart);
	}
	
	/**根据评论获取点赞个数
	 * @param Integer stationID,Integer reviewID
	 * @return int 
	 */
	public static int getAddHeartCountByReview(Integer stationID,Integer reviewID){
		Map<String,Object> parameterMap= new HashMap<String,Object>();
		 parameterMap.put("station_id", stationID);
		 parameterMap.put("review_id", reviewID);
		return addHeartDAOImpl.selectAddHeartCountByReview(parameterMap);
	}
	
	/**分页获取点赞信息
	 * @param int startIndex pageSize 
	 * @return List AddHeart
	 */
	public static List<AddHeart> getAddHeartByPage(int startIndex,int pageSize){
		 Map<String,Object> parameterMap= new HashMap<String,Object>();
		 parameterMap.put("limitStart", startIndex);
		 parameterMap.put("limitCount", pageSize);
		return addHeartDAOImpl.getAddHeartByPage(parameterMap);
	}
	
	/**添加点赞
	 * @param AddHeart addHeart
	 * @return boolean
	 */
	public static boolean addAddHeart(AddHeart addHeart) {
		return addHeartDAOImpl.insertAddHeart(addHeart);
	}
	
	/**删除点赞
	 * @param AddHeart addHeart
	 * @return
	 */
	public static boolean deleteAddHeart(AddHeart addHeart) {
		return addHeartDAOImpl.deleteAddHeart(addHeart);
	}
	
	/**修改点赞
	 * @param AddHeart addHeart
	 * @return boolean
	 */
	public static boolean updateAddHeart(AddHeart addHeart) {
		return addHeartDAOImpl.updateAddHeart(addHeart);
	}
	
}
