package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.ChargePointStation;

public interface ChargePointStationDAO{
	
	public List<ChargePointStation> getChargePointStationList(ChargePointStation chargePointStation);
	public List<ChargePointStation> getChargePointStationByPage(Map<String, Object> map);
	public boolean insertChargePointStation(ChargePointStation chargePointStation);
	public boolean deleteChargePointStation(ChargePointStation chargePointStation);
	public boolean updateChargePointStation(ChargePointStation chargePointStation);

}
