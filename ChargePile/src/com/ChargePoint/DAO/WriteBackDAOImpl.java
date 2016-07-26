package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.WriteBack;

@SuppressWarnings("deprecation")
public class WriteBackDAOImpl extends SqlMapClientDaoSupport implements WriteBackDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<WriteBack> selectWriteBackList(WriteBack writeBack) {
		return getSqlMapClientTemplate().queryForList("selectWriteBackList", writeBack);
	}
	
	@Override
	public int selectWriteBackCountByReview(Map<String, Object> map) {
		return (int) getSqlMapClientTemplate().queryForObject("selectWriteBackCountByReview", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WriteBack> getWriteBackByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectWriteBackByPage", map);
	}

	@Override
	public boolean insertWriteBack(WriteBack writeBack) {
		boolean res = false;
		try {
			getSqlMapClientTemplate().insert("insertWriteBack", writeBack);
			res = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertWriteBack wrong!!!");
		}
		return res;
	}

	@Override
	public boolean deleteWriteBack(WriteBack writeBack) {
		boolean f = false;
		int res = -1;
		try {
			res = getSqlMapClientTemplate().delete("deleteWriteBack", writeBack);
			if(res > 0){
				 f = true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除writeBack为" + writeBack + "数据失败");
		}
		return f;
	}

	@Override
	public boolean updateWriteBack(WriteBack writeBack) {
		boolean result = false;
		int res = -1;
		try {
			res = getSqlMapClientTemplate().update("updateWriteBack", writeBack);
			if(res > 0){
				 result = true;
			 }
		} catch (Exception e) {
			System.out.println("修改回复出错");
			e.printStackTrace();
		}
		return result;
	}

}
