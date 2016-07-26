package com.ChargePoint.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.PCUserDAOImpl;
import com.ChargePoint.bean.PCUser;

public class PCUserService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static PCUserDAOImpl pcuserDAOImpl = (PCUserDAOImpl) act.getBean("PCUserDAOImpl");
	
	/**获取所有用户信息
	 * @param PCUser pcuser
	 * @return List PCUser
	 */
	public static List<PCUser> getPCUserList(PCUser pcuser){
		return pcuserDAOImpl.getPCUserList(pcuser);
	}
	
	/**根据用户名获取用户信息
	 * @param String pcuserName
	 * @return  PCUser
	 */
	public static PCUser getPCUser(String userName){
		return pcuserDAOImpl.getPCUser(userName);
	}
	
	/**根据用户名和密码获取用户信息
	 * @param String userName,String password
	 * @return  PCUser
	 */
	public static PCUser getPCUser(String userName,String password){
		return pcuserDAOImpl.getPCUser(userName,password);
	}
	
	/**分页获取用户信息
	 * @param int startIndex pageSize 
	 * @return List PCUser
	 */
	public static List<PCUser> getPCUserByPage(int startIndex,int pageSize){
		 Map<String,Object> parameterMap= new HashMap<String,Object>();
		 parameterMap.put("limitStart", startIndex);
		 parameterMap.put("limitCount", pageSize);
		return pcuserDAOImpl.getPCUserByPage(parameterMap);
	}
	
	/**添加用户
	 * @param PCUser user
	 * @return boolean
	 */
	public static boolean addPCUser(PCUser pcuser) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(new Date());
		try {
			pcuser.setReg_time(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pcuserDAOImpl.addPCUser(pcuser);
	}
	
	/**根据用户名删除用户
	 * @param String userName
	 * @return
	 */
	public static boolean deletePCUser(String userName) {
		return pcuserDAOImpl.deletePCUser(userName);
	}
	
	/**修改用户
	 * @param PCUser user
	 * @return boolean
	 */
	public static boolean updatePCUser(PCUser pcuser) {
		return pcuserDAOImpl.updatePCUser(pcuser);
	}
	
	
	/**重置密码
	 * @param PCUser user.setPW(),.setUserName(),.setAnswer()
	 * @return boolean
	 */
	public static boolean resetPCUserPW(PCUser pcuser) {
		return pcuserDAOImpl.resetPCUserPW(pcuser);
	}
}
