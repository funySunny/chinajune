package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.Operate;
import com.ChargePoint.bean.Operate2;

public interface OperateDAO{
	
	public List<Operate> selectOperateList(Operate2 operate);
	public List<Operate> selectOperateByPage(Map<String, Object> map);
	public boolean insertOperate(Operate2 operate);
	public boolean deleteOperate(Operate2 operate);
	public boolean updateOperate(Operate2 operate);

}
