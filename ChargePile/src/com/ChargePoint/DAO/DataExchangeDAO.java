package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.DataExchange;

public interface DataExchangeDAO{
	
	public List<DataExchange> selectDataExchangeList(DataExchange dataExchange);

	public List<DataExchange> selectDataExchangeByPage(Map<String,Object> parameterObject);
	
	public List<DataExchange> searchDataExchange(Map<String,String> parameterObject);
	
	public boolean insertDataExchange(DataExchange dataExchange);
	
	public boolean updateDataExchange(DataExchange dataExchange);
	
	public boolean deleteDataExchange(DataExchange dataExchange);
}
