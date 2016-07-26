package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.ChargeRecords;
import com.ChargePoint.bean.ChargeRecords2;

public interface ChargeRecordsDAO{
	
	public List<ChargeRecords> getChargeRecordsList(ChargeRecords2 ChargeRecords2);

	public List<ChargeRecords> getChargeRecordsByPage(Map<String,Object> map);
	
	public List<ChargeRecords> searchChargeRecordsList(Map<String,String> parameterObject);
	
	public boolean addChargeRecords(ChargeRecords2 ChargeRecords2);
	
	public boolean deleteChargeRecords(ChargeRecords2 ChargeRecords2);
}
