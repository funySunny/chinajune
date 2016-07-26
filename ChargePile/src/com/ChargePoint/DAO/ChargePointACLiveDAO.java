package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.ChargePointACLive;
import com.ChargePoint.bean.ChargePointACLive2;

public interface ChargePointACLiveDAO{
	
	public List<ChargePointACLive> selectChargePointACLiveList(ChargePointACLive2 chargePointLive);
	public List<ChargePointACLive> getChargePointACLiveByPage(Map<String, Object> map);
	public ChargePointACLive selectFirstChargePointACLive(String tableName);
	public boolean insertChargePointACLive(ChargePointACLive2 chargePointLive);
	public boolean deleteChargePointACLive(ChargePointACLive chargePointLive);
	public boolean updateChargePointACLive(ChargePointACLive chargePointLive);
}
