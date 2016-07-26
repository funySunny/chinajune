package com.ChargePoint.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.ChargeMoneyRecords;
import com.ChargePoint.bean.ChargeMoneyRecords2;
import com.ChargePoint.bean.ChargePoint;
import com.ChargePoint.bean.ChargeRecords;
import com.ChargePoint.bean.ChargeRecords2;

@SuppressWarnings("deprecation")
public class ChargeMoneyRecordsDAOImpl extends SqlMapClientDaoSupport implements ChargeMoneyRecordsDAO{

	@Override
	public List<ChargeMoneyRecords> selectChargeMoneyRecordsList(ChargeMoneyRecords2 chargeMoneyRecords) {
		return getSqlMapClientTemplate().queryForList("selectChargeMoneyRecords", chargeMoneyRecords);
	}
	
	@Override
	public List<ChargeMoneyRecords> selectChargeMoneyRecordsByPage(Map<String, Object> parameterObject) {
		return getSqlMapClientTemplate().queryForList("selectChargeMoneyRecordsByPage", parameterObject);
	}
	
	@Override
	public List<ChargeMoneyRecords> searchChargeMoneyRecords(Map<String, String> parameterObject) {
		return getSqlMapClientTemplate().queryForList("searchChargeMoneyRecords", parameterObject);
	}

	@Override
	public boolean insertChargeMoneyRecords(ChargeMoneyRecords2 chargeMoneyRecords) {
		boolean res = false;
		try{
			getSqlMapClientTemplate().insert("insertChargeMoneyRecords", chargeMoneyRecords);
			res = true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("insertChargeMoneyRecords wrong!!!");
		}
		return  res;
	}
	
	@Override
	public boolean deleteChargeMoneyRecords(ChargeMoneyRecords2 chargeMoneyRecords) {
		boolean res = false;
		int refC = -1;
		try{
			refC = getSqlMapClient().delete("deleteChargeMoneyRecords", chargeMoneyRecords);
			if(refC > 0 ){
				res = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("删除chargePoint数据失败");
		}
	return res;
	}

	@Override
	public boolean updateChargeMoneyRecords(ChargeMoneyRecords2 chargeMoneyRecords) {
		boolean res = false;
		int refC = -1;
		try{
			refC = getSqlMapClient().update("updateChargeMoneyRecords", chargeMoneyRecords);
			if(refC > 0 ){
				res = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("更新ChargeMoneyRecords数据失败");
		}
	return res;
	}

}
