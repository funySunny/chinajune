package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

public interface CommonDAO{
	
	public int getTotalCount(String tableName);
	public int getCPTotalCount(String type);
	public List<String> getTableNames(String tableName);
	public String getMaxData(Map<String,String> map);
	public boolean createChargePointLiveTable(String c_p_id);
	public boolean createChargePointACLiveTable(String c_p_id);
	public boolean createChargeMoneyRecords(int id);
	public boolean createChargeRecords(int id);
	public boolean createTradeRecords(int id);
	public boolean createOperation(int id);
	public boolean createOperationResults(int id);
	public boolean dynamicSql(String sql);
}
