package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.TempCharge;

public interface TempChargeDAO{
	
	public List<TempCharge> selectTempChargeList(TempCharge tempCharge);
	public List<TempCharge> selectTempChargeByPage(Map<String, Object> map);
	public boolean insertTempCharge(TempCharge tempCharge);
	public boolean deleteTempCharge(TempCharge tempCharge);
	public boolean updateTempCharge(TempCharge tempCharge);

}
