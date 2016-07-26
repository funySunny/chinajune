package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.Review;

@SuppressWarnings("deprecation")
public class ReviewDAOImpl extends SqlMapClientDaoSupport implements ReviewDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Review> selectReviewList(Review review) {
		return getSqlMapClientTemplate().queryForList("selectReviewList", review);
	}

	@Override
	public Float selectReviewAvgScoreByStationID(Integer stationID) {
		return (Float) getSqlMapClientTemplate().queryForObject("selectReviewAvgScoreByStationID", stationID);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Review> getReviewByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectReviewByPage", map);
	}

	@Override
	public boolean insertReview(Review review) {
		boolean res = false;
		try {
			getSqlMapClientTemplate().insert("insertReview", review);
			res = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertReview wrong!!!");
		}
		return res;
	}

	@Override
	public boolean deleteReview(Review review) {
		boolean f = false;
		int res = -1;
		try {
			res = getSqlMapClientTemplate().delete("deleteReview", review);
			if(res > 0){
				 f = true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除review为" + review + "数据失败");
		}
		return f;
	}

	@Override
	public boolean updateReview(Review review) {
		boolean result = false;
		int res = -1;
		try {
			res = getSqlMapClientTemplate().update("updateReview", review);
			if(res > 0){
				 result = true;
			 }
		} catch (Exception e) {
			System.out.println("修改评论出错");
			e.printStackTrace();
		}
		return result;
	}

}
