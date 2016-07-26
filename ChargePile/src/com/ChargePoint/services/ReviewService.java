package com.ChargePoint.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.ReviewDAOImpl;
import com.ChargePoint.Utils.TimeFormatUtil;
import com.ChargePoint.bean.Review;

public class ReviewService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static ReviewDAOImpl reviewDAOImpl = (ReviewDAOImpl) act.getBean("ReviewDAOImpl");
	
	/**获取所有评论信息
	 * @param Review review
	 * @return List Review
	 */
	public static List<Review> getReviewList(Review review){
		return reviewDAOImpl.selectReviewList(review);
	}
	
	/**根据站id获取所有评论平均数
	 * @param Integer stationID
	 * @return float
	 */
	public static int getReviewAvgScoreByStationID(Integer stationID) {
		Float avg = reviewDAOImpl.selectReviewAvgScoreByStationID(stationID);
//		没有评论，平均分为0
		if(null == avg){
			return 0;
		}else{
			return (int) Math.ceil(avg);
		}
	}
	
	/**分页获取评论信息
	 * @param int startIndex pageSize stationID
	 * @return List Review
	 */
	public static List<Review> getReviewByPage(int startIndex,int pageSize,Integer stationID){
		 Map<String,Object> parameterMap= new HashMap<String,Object>();
		 parameterMap.put("limitStart", startIndex);
		 parameterMap.put("limitCount", pageSize);
		 parameterMap.put("stationID", stationID);
		return reviewDAOImpl.getReviewByPage(parameterMap);
	}
	
	/**添加评论
	 * @param Review review
	 * @return boolean
	 */
	public static boolean addReview(Review review) {
		review.setTime(TimeFormatUtil.getFormattedNow());
		return reviewDAOImpl.insertReview(review);
	}
	
	/**删除评论
	 * @param Review review
	 * @return
	 */
	public static boolean deleteReview(Review review) {
		return reviewDAOImpl.deleteReview(review);
	}
	
	/**修改评论
	 * @param Review review
	 * @return boolean
	 */
	public static boolean updateReview(Review review) {
		return reviewDAOImpl.updateReview(review);
	}
	
}
