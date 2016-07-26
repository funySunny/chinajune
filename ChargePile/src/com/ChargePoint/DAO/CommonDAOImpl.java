package com.ChargePoint.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

@SuppressWarnings("deprecation")
public class CommonDAOImpl extends SqlMapClientDaoSupport implements CommonDAO{
	
	@Override
	public int getTotalCount(String tableName){
		return (int) getSqlMapClientTemplate().queryForObject("selectCount", tableName);
	}
	
	@Override
	public int getCPTotalCount(String type){
		return (int) getSqlMapClientTemplate().queryForObject("selectCPCount", type);
	}
	
	@Override
	public String getMaxData(Map<String,String> map) {
		return (String) getSqlMapClientTemplate().queryForObject("selectMaxData", map);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getTableNames(String tableName) {
		return getSqlMapClientTemplate().queryForList("selectTableNames",tableName);
	}

//	@Override
//	public boolean createChargePointTable(String c_p_id) {
//		boolean rf = false;
//		try {
//			getSqlMapClient().update("createChargePointTable", "charge_point_live_"+c_p_id);
//				rf = true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("建表："+"charge_point_"+c_p_id+"失败");
//		}
//			return rf;
//	}
	
	@Override
	public boolean createChargePointLiveTable(String c_p_id) {
		boolean rf = false;
		try {
			getSqlMapClient().update("createChargePointLiveTable", "charge_point_live_"+c_p_id);
				rf = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("建表："+"charge_point_live_"+c_p_id+"失败");
		}
			return rf;
	}

	@Override
	public boolean createChargePointACLiveTable(String c_p_id) {
		boolean rf = false;
		try {
			getSqlMapClient().update("createChargePointACLiveTable", "charge_point_ac_live_"+c_p_id);
				rf = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("建表："+"charge_point_ac_live_"+c_p_id+"失败");
		}
			return rf;
	}
	
	public boolean createChargeRecords(int id){
		boolean res = false;
		try{
			getSqlMapClient().update("createChargeRecord", "charge_records_"+id);
			res = true;
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("建表："+"charge_records_"+id+"失败");
		}
	return res;
	}

	@Override
	public boolean createChargeMoneyRecords(int id) {
		boolean res = false;
		try{
			getSqlMapClient().update("createChargeMoneyRecord", "charge_money_records_"+id);
			res = true;
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("建表："+"charge_money_records_"+id+"失败");
		}
	return res;
	}
	
	@Override
	public boolean createOperation(int id) {
		boolean res = false;
		try{
			getSqlMapClient().update("createOperation", "operation_"+id);
			res = true;
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("建表："+"operation_"+id+"失败");
		}
	return res;
	}
	

	@Override
	public boolean createOperationResults(int id) {
		boolean res = false;
		try{
			getSqlMapClient().update("createOperationResults", "operation_results_"+id);
			res = true;
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("建表："+"operation_results_"+id+"失败");
		}
	return res;
	}

	@Override
	public boolean createTradeRecords(int id) {
		boolean res = false;
		try{
			getSqlMapClient().update("createTradeRecord", "trade_records_"+id);
			res = true;
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("建表："+"charge_trade_records_"+id+"失败");
		}
	return res;
	}

	@Override
	public boolean dynamicSql(String sql) {
		boolean res = false;
		try{
			getSqlMapClient().update("dynamicSql", sql);
			res = true;
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("执行语句："+sql+" 失败");
		}
	return res;
	}

}
