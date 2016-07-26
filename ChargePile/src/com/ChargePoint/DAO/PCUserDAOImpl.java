package com.ChargePoint.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.PCUser;

@SuppressWarnings("deprecation")
public class PCUserDAOImpl extends SqlMapClientDaoSupport implements PCUserDAO{

	@Override
	public List<PCUser> getPCUserList(PCUser user) {
		return getSqlMapClientTemplate().queryForList("selectPCUserList", user);
	}
	
	@Override
	public PCUser getPCUser(String userName) {
		return (PCUser) getSqlMapClientTemplate().queryForObject("selectPCUser", userName);
	}
	
	@Override
	public PCUser getPCUser(String userName, String password) {
		PCUser user = new PCUser();
		user.setUser_name(userName);
		user.setPassword(password);
		return (PCUser) getSqlMapClientTemplate().queryForObject("checkPCUserpw", user);
	}
	
	@Override
	public List<PCUser> getPCUserByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectPCUserByPage", map);
	}

	@Override
	public boolean addPCUser(PCUser user) {
		boolean res = false;
		try{
			getSqlMapClientTemplate().insert("insertPCUser", user);
			res = true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("insertPCUser wrong!!!");
		}
		return  res;
	}

	@Override
	public boolean deletePCUser(String userName) {
		boolean result = false;
		int res = -1;
		try{
			res = getSqlMapClientTemplate().delete("deletePCUser", userName);
			if(res > 0){
				 result = true;
			 }
		}catch(Exception e){
			System.out.println("删除PCUser为"+userName+"数据失败");
		}
		return result; 
	}

	@Override
	public boolean updatePCUser(PCUser user) {
		boolean result = false;
		int res = -1;
		try{
			res = getSqlMapClientTemplate().update("updatePCUser", user);
			if(res > 0){
				 result = true;
			 }
		}catch(Exception e){
			System.out.println("修改用户出错");
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean resetPCUserPW(PCUser user) {
		boolean result = false;
		int res = -1;
		try{
			 res = getSqlMapClientTemplate().update("resetPCUserPW", user);
			 if(res > 0){
				 result = true;
			 }
		}catch(Exception e){
			System.out.println("重置密码出错");
			e.printStackTrace();
		}
		return result;
	}

}
