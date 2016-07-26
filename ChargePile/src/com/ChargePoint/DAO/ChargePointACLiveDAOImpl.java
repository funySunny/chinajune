package com.ChargePoint.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.ChargePointACLive;
import com.ChargePoint.bean.ChargePointACLive2;

@SuppressWarnings("deprecation")
public class ChargePointACLiveDAOImpl extends SqlMapClientDaoSupport implements ChargePointACLiveDAO{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChargePointACLive> selectChargePointACLiveList(ChargePointACLive2 chargePointACLive) {
		return getSqlMapClientTemplate().queryForList("selectChargePointACLive", chargePointACLive);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChargePointACLive> getChargePointACLiveByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectChargePointACLiveByPage", map);
	}
	
	@Override
	public ChargePointACLive selectFirstChargePointACLive(String tableName) {
		return (ChargePointACLive) getSqlMapClientTemplate().queryForObject("selectFirstChargePointACLive", tableName);
	}
	
	@Override
	public boolean insertChargePointACLive(ChargePointACLive2 chargePointACLive) {
		boolean res = false;
		try{
			getSqlMapClient().insert("insertChargePointACLive", chargePointACLive);
			res = true;
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("添加chargePointACLive数据失败");
		}
	return res;
	}
	
	@Override
	public boolean deleteChargePointACLive(ChargePointACLive chargePointACLive) {
		boolean res = false;
		int refC = -1;
		try{
			refC = getSqlMapClient().delete("deleteChargePointACLive", chargePointACLive);
			if(refC > 0 ){
				res = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("删除chargePointACLive数据失败");
		}
	return res;
	}
	
	@Override
	public boolean updateChargePointACLive(ChargePointACLive chargePointACLive) {
		boolean res = false;
		int refC = -1;
		try{
			refC = getSqlMapClient().update("updateChargePointACLive", chargePointACLive);
			if(refC > 0 ){
				res = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("更新chargePointACLive数据失败");
		}
	return res;
	}

}
