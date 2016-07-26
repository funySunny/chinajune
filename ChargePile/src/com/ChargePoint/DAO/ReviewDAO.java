package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.Review;

public interface ReviewDAO{
	
	public List<Review> selectReviewList(Review sale);
	public Float selectReviewAvgScoreByStationID(Integer stationID);
	public List<Review> getReviewByPage(Map<String, Object> map);
	public boolean insertReview(Review sale);
	public boolean deleteReview(Review review);
	public boolean updateReview(Review sale);

}
