package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.Company;
import com.ChargePoint.bean.Feedbacks;

public class FeedbacksDAOImpl extends SqlMapClientDaoSupport implements FeedbacksDAO{

	@Override
	public List<Feedbacks> getFeedbacksList(Feedbacks feedback) {
		return getSqlMapClientTemplate().queryForList("selectFeedbacksList", feedback);
	}

	@Override
	public List<Feedbacks> getFeedbacksByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectFeedbacksByPage", map);
	}

	@Override
	public boolean addFeedbacks(Feedbacks company) {
		boolean res = false;
		try{
			getSqlMapClientTemplate().insert("insertFeedbacks", company);
			res = true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("insertFeedbacks wrong!!!");
		}
		return  res;
	}

	@Override
	public boolean deleteFeedbacks(Feedbacks feedback) {
		boolean f = false;
		int re = -1;
		try{
			re = getSqlMapClientTemplate().delete("deleteFeedbacks", feedback);
			f = true;
		}catch(Exception e){
			System.out.println("删除Feedbacks为"+feedback+"数据失败");
		}
		return f;
	}

	@Override
	public boolean updateFeedbacks(Feedbacks feedback) {
		boolean result = false;
		try{
			 getSqlMapClientTemplate().update("updateFeedbacks", feedback);
			 result = true;
		}catch(Exception e){
			System.out.println("修改反馈信息出错");
			e.printStackTrace();
		}
		return result;
	}
	
}
