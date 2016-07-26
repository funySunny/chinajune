package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.ChargeMoneyRecords;
import com.ChargePoint.bean.ChargeMoneyRecords2;

public interface ChargeMoneyRecordsDAO{
	
	public List<ChargeMoneyRecords> selectChargeMoneyRecordsList(ChargeMoneyRecords2 chargeMoneyRecords);

	public List<ChargeMoneyRecords> selectChargeMoneyRecordsByPage(Map<String,Object> parameterObject);
	
	public List<ChargeMoneyRecords> searchChargeMoneyRecords(Map<String,String> parameterObject);
	
	public boolean insertChargeMoneyRecords(ChargeMoneyRecords2 chargeMoneyRecords);
	
	public boolean updateChargeMoneyRecords(ChargeMoneyRecords2 chargeMoneyRecords);
	
	public boolean deleteChargeMoneyRecords(ChargeMoneyRecords2 chargeMoneyRecords);
}
