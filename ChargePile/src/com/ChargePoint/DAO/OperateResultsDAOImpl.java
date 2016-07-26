package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.Company;
import com.ChargePoint.bean.OperateResults;
import com.ChargePoint.bean.OperateResults2;

public class OperateResultsDAOImpl extends SqlMapClientDaoSupport implements OperateResultsDAO{

	@Override
	public List<OperateResults> selectOperateResultsList(OperateResults2 operate) {
		return getSqlMapClientTemplate().queryForList("selectOperateResults", operate);
	}

	@Override
	public List<OperateResults> selectOperateResultsByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectOperateResultsByPage", map);
	}

	@Override
	public boolean updateOperateResults(OperateResults2 operate) {
		boolean result = false;
		int reC = -1;
		try{
			reC = getSqlMapClientTemplate().update("updateOperateResults", operate);
			if(-1 != reC && 0 != reC){
				result = true;
			}
		}catch(Exception e){
			System.out.println("修改OperateResults出错");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean insertOperateResults(OperateResults2 operate) {
		boolean res = false;
		try{
			getSqlMapClientTemplate().insert("insertOperateResults", operate);
			res = true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("insertOperateResults wrong!!!");
		}
		return  res;
	}

	@Override
	public boolean deleteOperateResults(OperateResults2 operate) {
		boolean result = false;
		int reC = -1;
		try{
			reC = getSqlMapClientTemplate().delete("deleteOperateResults", operate);
			if(-1 != reC && 0 != reC){
				result = true;
			}
		}catch(Exception e){
			System.out.println("删除OperateResults出错");
			e.printStackTrace();
		}
		return result;
	}
	
}
