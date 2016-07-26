package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.TempCharge;

public class TempChargeDAOImpl extends SqlMapClientDaoSupport implements TempChargeDAO{

	@Override
	public List<TempCharge> selectTempChargeList(TempCharge temptempCharge) {
		return getSqlMapClientTemplate().queryForList("selectTempCharge", temptempCharge);
	}

	@Override
	public List<TempCharge> selectTempChargeByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectTempChargeByPage", map);
	}

	@Override
	public boolean updateTempCharge(TempCharge tempCharge) {
		boolean result = false;
		int reC = -1;
		try{
			reC = getSqlMapClientTemplate().update("updateTempCharge", tempCharge);
			if(reC > 0){
				result = true;
			}
		}catch(Exception e){
			System.out.println("修改tempCharge出错");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean insertTempCharge(TempCharge tempCharge) {
		boolean res = false;
		try{
			getSqlMapClientTemplate().insert("insertTempCharge", tempCharge);
			res = true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("inserttempCharge wrong!!!");
		}
		return  res;
	}

	@Override
	public boolean deleteTempCharge(TempCharge tempCharge) {
		boolean result = false;
		int reC = -1;
		try{
			reC = getSqlMapClientTemplate().delete("deleteTempCharge", tempCharge);
			if(-1 != reC && 0 != reC){
				result = true;
			}
		}catch(Exception e){
			System.out.println("删除tempCharge出错");
			e.printStackTrace();
		}
		return result;
	}


}
