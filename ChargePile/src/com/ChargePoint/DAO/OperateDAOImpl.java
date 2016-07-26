package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.Operate;
import com.ChargePoint.bean.Operate2;

public class OperateDAOImpl extends SqlMapClientDaoSupport implements OperateDAO{

	@Override
	public List<Operate> selectOperateList(Operate2 operate) {
		return getSqlMapClientTemplate().queryForList("selectOperate", operate);
	}

	@Override
	public List<Operate> selectOperateByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectOperateByPage", map);
	}

	@Override
	public boolean updateOperate(Operate2 operate) {
		boolean result = false;
		int reC = -1;
		try{
			reC = getSqlMapClientTemplate().update("updateOperate", operate);
			if(-1 != reC && 0 != reC){
				result = true;
			}
		}catch(Exception e){
			System.out.println("修改Operate出错");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean insertOperate(Operate2 operate) {
		boolean res = false;
		try{
			getSqlMapClientTemplate().insert("insertOperate", operate);
			res = true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("insertOperate wrong!!!");
		}
		return  res;
	}

	@Override
	public boolean deleteOperate(Operate2 operate) {
		boolean result = false;
		int reC = -1;
		try{
			reC = getSqlMapClientTemplate().delete("deleteOperate", operate);
			if(-1 != reC && 0 != reC){
				result = true;
			}
		}catch(Exception e){
			System.out.println("删除Operate出错");
			e.printStackTrace();
		}
		return result;
	}

}
