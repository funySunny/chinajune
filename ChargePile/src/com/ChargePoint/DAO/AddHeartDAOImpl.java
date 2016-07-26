package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.AddHeart;

@SuppressWarnings("deprecation")
public class AddHeartDAOImpl extends SqlMapClientDaoSupport implements AddHeartDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<AddHeart> selectAddHeartList(AddHeart addHeart) {
		return getSqlMapClientTemplate().queryForList("selectAddHeartList", addHeart);
	}
	
	@Override
	public int selectAddHeartCountByReview(Map<String, Object> map) {
		return (int) getSqlMapClientTemplate().queryForObject("selectAddHeartCountByReview", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AddHeart> getAddHeartByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectAddHeartByPage", map);
	}

	@Override
	public boolean insertAddHeart(AddHeart addHeart) {
		boolean res = false;
		try {
			getSqlMapClientTemplate().insert("insertAddHeart", addHeart);
			res = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertAddHeart wrong!!!");
		}
		return res;
	}

	@Override
	public boolean deleteAddHeart(AddHeart addHeart) {
		boolean f = false;
		int res = -1;
		try {
			res = getSqlMapClientTemplate().delete("deleteAddHeart", addHeart);
			if(res > 0){
				 f = true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除addHeart为" + addHeart + "数据失败");
		}
		return f;
	}

	@Override
	public boolean updateAddHeart(AddHeart addHeart) {
		boolean result = false;
		int res = -1;
		try {
			res = getSqlMapClientTemplate().update("updateAddHeart", addHeart);
			if(res > 0){
				 result = true;
			 }
		} catch (Exception e) {
			System.out.println("修改点赞出错");
			e.printStackTrace();
		}
		return result;
	}

}
