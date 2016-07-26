package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.TempAppointment;

public class TempAppointmentDAOImpl extends SqlMapClientDaoSupport implements TempAppointmentDAO{

	@Override
	public List<TempAppointment> selectTempAppointmentList(TempAppointment temptempAppointment) {
		return getSqlMapClientTemplate().queryForList("selectTempAppointment", temptempAppointment);
	}

	@Override
	public List<TempAppointment> selectTempAppointmentByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectTempAppointmentByPage", map);
	}

	@Override
	public boolean updateTempAppointment(TempAppointment tempAppointment) {
		boolean result = false;
		int reC = -1;
		try{
			reC = getSqlMapClientTemplate().update("updateTempAppointment", tempAppointment);
			if(reC > 0){
				result = true;
			}
		}catch(Exception e){
			System.out.println("修改tempAppointment出错");
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean insertTempAppointment(TempAppointment tempAppointment) {
		boolean res = false;
		try{
			getSqlMapClientTemplate().insert("insertTempAppointment", tempAppointment);
			res = true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("inserttempAppointment wrong!!!");
		}
		return  res;
	}

	@Override
	public boolean deleteTempAppointment(TempAppointment tempAppointment) {
		boolean result = false;
		int reC = -1;
		try{
			reC = getSqlMapClientTemplate().delete("deleteTempAppointment", tempAppointment);
			if(-1 != reC && 0 != reC){
				result = true;
			}
		}catch(Exception e){
			System.out.println("删除tempAppointment出错");
			e.printStackTrace();
		}
		return result;
	}


}
