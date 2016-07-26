package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.ChargePointLive;
import com.ChargePoint.bean.ChargePointLive2;

public interface ChargePointLiveDAO{
	
	public List<ChargePointLive> selectChargePointLiveList(ChargePointLive2 chargePointLive);
	public List<ChargePointLive> getChargePointLiveByPage(Map<String, Object> map);
	public ChargePointLive selectFirstChargePointLive(String tableName);
	public boolean insertChargePointLive(ChargePointLive2 chargePointLive);
	public boolean deleteChargePointLive(ChargePointLive chargePointLive);
	public boolean updateChargePointLive(ChargePointLive chargePointLive);
}
