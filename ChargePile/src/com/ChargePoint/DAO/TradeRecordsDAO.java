package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.TradeRecords;
import com.ChargePoint.bean.TradeRecords2;

public interface TradeRecordsDAO{
	
	public List<TradeRecords> selectTradeRecordsList(TradeRecords2 tradeRecords);
	public List<TradeRecords> getTradeRecordsByPage(Map<String, Object> map);
	public boolean insertTradeRecords(TradeRecords2 tradeRecords);
	public boolean deleteTradeRecords(TradeRecords2 tradeRecords);
	public boolean updateTradeRecords(TradeRecords2 tradeRecords);

}
