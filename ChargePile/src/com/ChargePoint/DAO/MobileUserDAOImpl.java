package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.Utils.DESUtils;
import com.ChargePoint.bean.MobileUser;

@SuppressWarnings("deprecation")
public class MobileUserDAOImpl extends SqlMapClientDaoSupport implements MobileUserDAO{

	@Override
	public List<MobileUser> getMobileUserList(MobileUser mobileUser) {
		return getSqlMapClientTemplate().queryForList("selectMobileUserList", mobileUser);
	}
	
	@Override
	public MobileUser getMobileUser(String mobileUserName) {
		return (MobileUser) getSqlMapClientTemplate().queryForObject("selectMobileUser", mobileUserName);
	}
	
	@Override
	public MobileUser getMobileUser(String mobileUserName, String password) {
		MobileUser user = new MobileUser();
		user.setUser_name(mobileUserName);
		user.setPassword(password);
		return (MobileUser) getSqlMapClientTemplate().queryForObject("checkMobileUser", user);
	}
	
	@Override
	public List<MobileUser> getMobileUserByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectMobileUserByPage", map);
	}

	@Override
	public Integer addMobileUser(MobileUser mobileUser) {
		Integer id = -1;
		try{
			id = (Integer) getSqlMapClientTemplate().insert("insertMobileUser", mobileUser);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("insertMobileUser wrong!!!");
		}
		return  id;
	}

	@Override
	public boolean deleteMobileUser(String mobileUserName) {
		boolean f = false;
		try{
			getSqlMapClientTemplate().delete("deleteMobileUser", mobileUserName);
			f = true;
		}catch(Exception e){
			System.out.println("删除MobileUser为"+mobileUserName+"数据失败");
			e.printStackTrace();
		}
		return f; 
	}

	@Override
	public boolean updateMobileUser(MobileUser mobileUser) {
		boolean result = false;
		int res = -1;
		try{
			 res = getSqlMapClientTemplate().update("updateMobileUser", mobileUser);
			 if(-1 != res && 0 != res){
				 result = true;
			 }
		}catch(Exception e){
			System.out.println("修改用户出错");
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean updateMoney(Map<String,Object> map) {
		boolean result = false;
		int reC = -1;
		try{
			reC = getSqlMapClientTemplate().update("changeMoney", map);
			if(-1 != reC && 0 != reC){
				result = true;
			}
		}catch(Exception e){
			System.out.println("修改money出错");
			e.printStackTrace();
		}
		return result;
	}

}
