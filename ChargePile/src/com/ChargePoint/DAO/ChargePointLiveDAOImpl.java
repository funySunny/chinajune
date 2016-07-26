package com.ChargePoint.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.ChargePointLive;
import com.ChargePoint.bean.ChargePointLive2;

@SuppressWarnings("deprecation")
public class ChargePointLiveDAOImpl extends SqlMapClientDaoSupport implements ChargePointLiveDAO{
	
	@Override
	public List<ChargePointLive> selectChargePointLiveList(ChargePointLive2 chargePointLive) {
		return getSqlMapClientTemplate().queryForList("selectChargePointLive", chargePointLive);
	}

	@Override
	public List<ChargePointLive> getChargePointLiveByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectChargePointLiveByPage", map);
	}
	
	@Override
	public ChargePointLive selectFirstChargePointLive(String tableName) {
		return (ChargePointLive) getSqlMapClientTemplate().queryForObject("selectFirstChargePointLive", tableName);
	}
	
	@Override
	public boolean insertChargePointLive(ChargePointLive2 chargePointLive) {
		boolean res = false;
		try{
			getSqlMapClient().insert("insertChargePointLive", chargePointLive);
			res = true;
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("添加chargePointLive数据失败");
		}
	return res;
	}
	
	@Override
	public boolean deleteChargePointLive(ChargePointLive chargePointLive) {
		boolean res = false;
		int refC = -1;
		try{
			refC = getSqlMapClient().delete("deleteChargePointLive", chargePointLive);
			if(refC > 0 ){
				res = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("删除chargePointLive数据失败");
		}
	return res;
	}
	
	@Override
	public boolean updateChargePointLive(ChargePointLive chargePointLive) {
		boolean res = false;
		int refC = -1;
		try{
			refC = getSqlMapClient().update("updateChargePointLive", chargePointLive);
			if(refC > 0 ){
				res = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("更新chargePointLive数据失败");
		}
	return res;
	}

}
