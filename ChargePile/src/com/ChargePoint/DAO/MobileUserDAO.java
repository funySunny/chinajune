package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.MobileUser;

public interface MobileUserDAO{
	
	public List<MobileUser> getMobileUserList(MobileUser mobileUser);
	public MobileUser getMobileUser(String mobileUserName);
	public MobileUser getMobileUser(String mobileUserName,String password);
	public List<MobileUser> getMobileUserByPage(Map<String,Object> map);
	public Integer addMobileUser(MobileUser mobileUser);
	public boolean deleteMobileUser(String mobileUserName);
	public boolean updateMobileUser(MobileUser mobileUser);	
	public boolean updateMoney(Map<String,Object> map);

}
