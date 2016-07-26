package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.OperateResults;
import com.ChargePoint.bean.OperateResults2;


public interface OperateResultsDAO{
	
	public List<OperateResults> selectOperateResultsList(OperateResults2 operateResults);
	public List<OperateResults> selectOperateResultsByPage(Map<String, Object> map);
	public boolean insertOperateResults(OperateResults2 operateResults);
	public boolean deleteOperateResults(OperateResults2 operateResults);
	public boolean updateOperateResults(OperateResults2 operateResults);

}
