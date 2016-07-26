package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.PCUser;

public interface PCUserDAO{
	
	public List<PCUser> getPCUserList(PCUser pcuser);
	public PCUser getPCUser(String userName);
	public PCUser getPCUser(String userName,String password);
	public List<PCUser> getPCUserByPage(Map<String,Object> map);
	public boolean addPCUser(PCUser pcuser);
	public boolean deletePCUser(String userName);
	public boolean updatePCUser(PCUser pcuser);	
	public boolean resetPCUserPW(PCUser pcuser);
}
