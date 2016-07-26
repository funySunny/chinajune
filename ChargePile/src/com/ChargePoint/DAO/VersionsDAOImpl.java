package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.Versions;

@SuppressWarnings("deprecation")
public class VersionsDAOImpl extends SqlMapClientDaoSupport implements VersionsDAO{

	@Override
	public List<Versions> getVersionsList(Versions versions) {
		return getSqlMapClientTemplate().queryForList("selectVersionsList", versions);
	}
	
	@Override
	public Versions getNewVersions() {
		return (Versions) getSqlMapClientTemplate().queryForObject("selectNewVersions");
	}
	
	@Override
	public List<Versions> getVersionsByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectVersionsByPage", map);
	}

	@Override
	public boolean addVersions(Versions versions) {
		boolean res = false;
		try{
			getSqlMapClientTemplate().insert("insertVersions", versions);
			res = true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("insertVersions wrong!!!");
		}
		return  res;
	}

	@Override
	public boolean deleteVersions(Versions versions) {
		boolean result = false;
		int res = -1;
		try{
			res = getSqlMapClientTemplate().delete("deleteVersions", versions);
			if(res > 0){
				 result = true;
			 }
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("删除Versions为"+versions+"数据失败");
		}
		return result; 
	}

	@Override
	public boolean updateVersions(Versions user) {
		boolean result = false;
		int res = -1;
		try{
			res = getSqlMapClientTemplate().update("updateVersions", user);
			if(res > 0){
				 result = true;
			 }
		}catch(Exception e){
			System.out.println("修改用户出错");
			e.printStackTrace();
		}
		return result;
	}

}
