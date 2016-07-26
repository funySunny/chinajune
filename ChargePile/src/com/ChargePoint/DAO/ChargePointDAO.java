package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.ChargePoint;
import com.ChargePoint.bean.ChargePointHome;

public interface ChargePointDAO{
	
	public List<ChargePoint> selectChargePointList(ChargePoint chargePoint);
	public ChargePoint selectChargePoint(String c_p_id);
	public List<ChargePoint> selectChargePointListByUserName(String userName);
	public List<ChargePoint> getChargePointByPage(Map<String, Object> map);
	public List<ChargePointHome> getHomeCPTable(Map<String,Object> map);
	public boolean insertChargePoint(ChargePoint chargePoint);
	public boolean deleteChargePoint(ChargePoint chargePoint);
	public boolean updateChargePoint(ChargePoint chargePoint);

}
