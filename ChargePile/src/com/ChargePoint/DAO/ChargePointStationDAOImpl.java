package com.ChargePoint.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.ChargePointStation;

public class ChargePointStationDAOImpl extends SqlMapClientDaoSupport implements ChargePointStationDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<ChargePointStation> getChargePointStationList(ChargePointStation chargePointStation) {
		return getSqlMapClientTemplate().queryForList("selectChargePointStationList", chargePointStation);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChargePointStation> getChargePointStationByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectChargePointStationByPage", map);
	}

	@Override
	public boolean insertChargePointStation(ChargePointStation chargePointStation) {
		boolean res = false;
		try{
			getSqlMapClient().insert("insertChargePointStation", chargePointStation);
			res = true;
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("添加chargePointStation数据失败");
		}
	return res;
	}

	@Override
	public boolean deleteChargePointStation(ChargePointStation chargePointStation) {
		boolean res = false;
		int refC = -1;
		try{
			refC = getSqlMapClient().delete("deleteChargePointStation", chargePointStation);
			if(refC > 0 ){
				res = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("删除chargePointStation数据失败");
		}
	return res;
	}

	@Override
	public boolean updateChargePointStation(ChargePointStation chargePointStation) {
		boolean res = false;
		int refC = -1;
		try{
			refC = getSqlMapClient().update("updateChargePointStation", chargePointStation);
			if(refC > 0 ){
				res = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("更新chargePointStation数据失败");
		}
	return res;
	}

}
