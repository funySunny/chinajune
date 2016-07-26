package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.TradeRecords;
import com.ChargePoint.bean.TradeRecords2;

public class TradeRecordsDAOImpl extends SqlMapClientDaoSupport implements TradeRecordsDAO{

	@Override
	public List<TradeRecords> selectTradeRecordsList(TradeRecords2 tradeRecords) {
		return getSqlMapClientTemplate().queryForList("selectTradeRecords", tradeRecords);
	}

	@Override
	public List<TradeRecords> getTradeRecordsByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectTradeRecordsByPage", map);
	}

	@Override
	public boolean updateTradeRecords(TradeRecords2 tradeRecords) {
		boolean result = false;
		int reC = -1;
		try{
			reC = getSqlMapClientTemplate().update("updateTradeRecords", tradeRecords);
			if(-1 != reC && 0 != reC){
				result = true;
			}
		}catch(Exception e){
			System.out.println("修改TradeRecords出错");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean insertTradeRecords(TradeRecords2 tradeRecords) {
		boolean res = false;
		try{
			getSqlMapClientTemplate().insert("insertTradeRecords", tradeRecords);
			res = true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("insertTradeRecords wrong!!!");
		}
		return  res;
	}

	@Override
	public boolean deleteTradeRecords(TradeRecords2 tradeRecords) {
		boolean result = false;
		int reC = -1;
		try{
			reC = getSqlMapClientTemplate().delete("deleteTradeRecords", tradeRecords);
			if(-1 != reC && 0 != reC){
				result = true;
			}
		}catch(Exception e){
			System.out.println("删除TradeRecords出错");
			e.printStackTrace();
		}
		return result;
	}
	
}
