package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.TempAppointment;

public interface TempAppointmentDAO{
	
	public List<TempAppointment> selectTempAppointmentList(TempAppointment tempAppointment);
	public List<TempAppointment> selectTempAppointmentByPage(Map<String, Object> map);
	public boolean insertTempAppointment(TempAppointment tempAppointment);
	public boolean deleteTempAppointment(TempAppointment tempAppointment);
	public boolean updateTempAppointment(TempAppointment tempAppointment);

}
