package com.ChargePoint.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.ChargeRecords;
import com.ChargePoint.bean.ChargeRecords2;

@SuppressWarnings("deprecation")
public class ChargeRecordsDAOImpl extends SqlMapClientDaoSupport implements ChargeRecordsDAO{

	@Override
	public List<ChargeRecords> getChargeRecordsList(ChargeRecords2 ChargeRecords2) {
		return getSqlMapClientTemplate().queryForList("selectChargeRecords", ChargeRecords2);
	}
	
	@Override
	public List<ChargeRecords> getChargeRecordsByPage(Map<String,Object> map){
		return getSqlMapClientTemplate().queryForList("selectChargeRecordsByPage", map);
	}

	@Override
	public List<ChargeRecords> searchChargeRecordsList(Map<String, String> parameterObject) {
		return getSqlMapClientTemplate().queryForList("searchChargeRecords", parameterObject);
	}

	@Override
	public boolean addChargeRecords(ChargeRecords2 chargeRecords) {
		boolean res = false;
		try{
			getSqlMapClientTemplate().insert("insertChargeRecords", chargeRecords);
			res = true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("insertChargeRecords wrong!!!");
		}
		return  res;
	}

	@Override
	public boolean deleteChargeRecords(ChargeRecords2 chargeRecords) {
		boolean res = false;
		int refC = -1;
		try{
			refC = getSqlMapClient().delete("deleteChargeRecord", chargeRecords);
			if(refC > 0 ){
				res = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("删除ChargeRecord数据失败");
		}
	return res;
	}

}
