package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.Feedbacks;

public interface FeedbacksDAO{

	public List<Feedbacks> getFeedbacksList(Feedbacks feedback);

	public List<Feedbacks> getFeedbacksByPage(Map<String, Object> map);

	public boolean addFeedbacks(Feedbacks feedback);

	public boolean deleteFeedbacks(Feedbacks feedback);

	public boolean updateFeedbacks(Feedbacks feedback);
	
}
