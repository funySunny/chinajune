package com.ChargePoint.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.DataExchange;

@SuppressWarnings("deprecation")
public class DataExchangeDAOImpl extends SqlMapClientDaoSupport implements DataExchangeDAO{

	@Override
	public List<DataExchange> selectDataExchangeList(DataExchange dataExchange) {
		return getSqlMapClientTemplate().queryForList("selectDataExchange", dataExchange);
	}
	
	@Override
	public List<DataExchange> selectDataExchangeByPage(Map<String, Object> parameterObject) {
		return getSqlMapClientTemplate().queryForList("selectDataExchangeByPage", parameterObject);
	}

	@Override
	public List<DataExchange> searchDataExchange(Map<String, String> parameterObject) {
		return getSqlMapClientTemplate().queryForList("searchDataExchange", parameterObject);
	}

	@Override
	public boolean insertDataExchange(DataExchange dataExchange) {
		boolean res = false;
		try{
			getSqlMapClientTemplate().insert("insertDataExchange", dataExchange);
			res = true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("insertDataExchange wrong!!!");
		}
		return  res;
	}
	
	@Override
	public boolean deleteDataExchange(DataExchange dataExchange) {
		boolean res = false;
		int refC = -1;
		try{
			refC = getSqlMapClient().delete("deleteDataExchange", dataExchange);
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
	public boolean updateDataExchange(DataExchange dataExchange) {
		boolean res = false;
		int refC = -1;
		try{
			refC = getSqlMapClient().update("updateDataExchange", dataExchange);
			if(refC > 0 ){
				res = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("更新DataExchange数据失败");
		}
	return res;
	}

}
