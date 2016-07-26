package com.ChargePoint.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.ChargePoint;
import com.ChargePoint.bean.ChargePointHome;

@SuppressWarnings("deprecation")
public class ChargePointDAOImpl extends SqlMapClientDaoSupport implements ChargePointDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<ChargePoint> selectChargePointList(ChargePoint chargePoint) {
		return getSqlMapClientTemplate().queryForList("selectChargePointList", chargePoint);
	}
	
	@Override
	public ChargePoint selectChargePoint(String c_p_id) {
		return (ChargePoint) getSqlMapClientTemplate().queryForObject("selectChargePoint", c_p_id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChargePoint> selectChargePointListByUserName(String userName) {
		return getSqlMapClientTemplate().queryForList("selectChargePointListByUserName", userName);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChargePoint> getChargePointByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectChargePointByPage", map);
	}

	@Override
	public boolean insertChargePoint(ChargePoint chargePoint) {
		boolean res = false;
		try{
			getSqlMapClient().insert("insertChargePoint", chargePoint);
			res = true;
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("添加chargePoint数据失败");
		}
	return res;
	}

	@Override
	public boolean deleteChargePoint(ChargePoint chargePoint) {
		boolean res = false;
		int refC = -1;
		try{
			refC = getSqlMapClient().delete("deleteChargePoint", chargePoint);
			if(refC > 0 ){
				res = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("删除chargePoint数据失败");
		}
	return res;
	}

	@Override
	public boolean updateChargePoint(ChargePoint chargePoint) {
		boolean res = false;
		int refC = -1;
		try{
			refC = getSqlMapClient().update("updateChargePoint", chargePoint);
			if(refC > 0 ){
				res = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("更新chargePoint数据失败");
		}
	return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChargePointHome> getHomeCPTable(Map<String,Object> map) {
		return getSqlMapClientTemplate().queryForList("selectHomeCPTable",map);
	}

}
