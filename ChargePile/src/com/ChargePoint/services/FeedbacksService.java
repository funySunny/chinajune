package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.FeedbacksDAOImpl;
import com.ChargePoint.bean.Feedbacks;

public class FeedbacksService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static FeedbacksDAOImpl feedbackDAOImpl = (FeedbacksDAOImpl) act.getBean("FeedbacksDAOImpl");
	
	
	/**获取Feedbacks列表
	 * @param Feedbacks feedback
	 * @return List Feedbacks
	 */
	public static List<Feedbacks> getFeedbacksList(Feedbacks feedback){
		return feedbackDAOImpl.getFeedbacksList(feedback);
	}
	
	/**分页获取Feedbacks列表
	 * @param int limitStart,int limitCount,String sortName,String order
	 * @return List Feedbacks
	 */
	public static List<Feedbacks> getFeedbacksByPage(int limitStart , int limitCount,String sortName,String order){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sortName", sortName);
		map.put("order", order);
		map.put("limitStart", limitStart);
		map.put("limitCount", limitCount);
		return feedbackDAOImpl.getFeedbacksByPage(map);
	}
	
	/**添加Feedbacks记录
	 * @param Feedbacks
	 * @return boolean
	 */
	public static boolean addFeedbacks(Feedbacks Feedbacks){
		return feedbackDAOImpl.addFeedbacks(Feedbacks);
	}
	
	/**删除Feedbacks记录
	 * @param id
	 * @return boolean
	 */
	public static boolean deleteFeedbacks(Feedbacks feedback){
		return feedbackDAOImpl.deleteFeedbacks(feedback);
	}
	
	/**更新Feedbacks记录
	 * @param Feedbacks
	 * @return boolean
	 */
	public static boolean updateFeedbacks(Feedbacks feedback){
		return feedbackDAOImpl.updateFeedbacks(feedback);
	}
}
