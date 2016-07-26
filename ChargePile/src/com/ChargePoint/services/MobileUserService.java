package com.ChargePoint.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.MobileUserDAOImpl;
import com.ChargePoint.Utils.DESUtils;
import com.ChargePoint.Utils.TextUtils;
import com.ChargePoint.Utils.TimeFormatUtil;
import com.ChargePoint.bean.MobileUser;

public class MobileUserService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static MobileUserDAOImpl mobileUserDAOImpl = (MobileUserDAOImpl) act.getBean("MobileUserDAOImpl");
	
	/**获取所有用户信息
	 * @param MobileUser mobileUser
	 * @return List MobileUser
	 */
	public static List<MobileUser> getMobileUserList(MobileUser MobileUser){
		return mobileUserDAOImpl.getMobileUserList(MobileUser);
	}
	
	/**根据用户名获取用户信息
	 * @param String MobileUserName
	 * @return  MobileUser
	 */
	public static MobileUser getMobileUser(String MobileUserName){
		return mobileUserDAOImpl.getMobileUser(MobileUserName);
	}
	
	/**检查用户获取用户账号密码
	 * @param String MobileUserName
	 * @return  MobileUser
	 */
	public static MobileUser getMobileUser(String MobileUserName,String password){
		return mobileUserDAOImpl.getMobileUser(MobileUserName,password);
	}
	
	/**分页获取用户信息
	 * @param int startIndex pageSize 
	 * @return List MobileUser
	 */
	public static List<MobileUser> getMobileUserByPage(int startIndex,int pageSize){
		 Map<String,Object> parameterMap= new HashMap<String,Object>();
		 parameterMap.put("limitStart", startIndex);
		 parameterMap.put("limitCount", pageSize);
		return mobileUserDAOImpl.getMobileUserByPage(parameterMap);
	}
	
	/**添加用户(同时更新余额为0.00、新建充值记录表、新建充电记录表、交易记录表)
	 * @param MobileUser mobileUser
	 * @return boolean
	 */
	public static boolean addMobileUser(MobileUser mobileUser) {
		boolean res = false;
		String userName = mobileUser.getUser_name();
		mobileUser.setReg_time(TimeFormatUtil.getFormattedNow());
		String money = null;
		try {
			money = DESUtils.encrypt("0.00", userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer id = mobileUserDAOImpl.addMobileUser(mobileUser);
		if(-1 != id){
			res = MobileUserService.updateMoney(userName,money);
			boolean s = CommonService.createChargeRecord(id) && CommonService.createChargeMoneyRecord(id);
			boolean sd = CommonService.createTradeRecord(id);
			boolean sdk = CommonService.createOperation(id);
			boolean ssd = CommonService.createOperationResults(id);
			return res && s && sd && sdk && ssd;
		}else{
			return false;
		}
	}
	
	/**根据用户名删除用户(同时删除用户下的所有记录)
	 * @param String MobileUserName
	 * @return
	 */
	public static boolean deleteMobileUser(String mobileUserName) {
		MobileUser mobileUser = MobileUserService.getMobileUser(mobileUserName);
		if(null != mobileUser){
			boolean r1 = CommonService.dropRecordsTables(String.valueOf(mobileUser.getId()));
			boolean r2 = mobileUserDAOImpl.deleteMobileUser(mobileUserName);
			if(r1 && r2){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**修改用户
	 * @param MobileUser mobileUser
	 * @return boolean
	 */
	public static boolean updateMobileUser(MobileUser mobileUser) {
		return mobileUserDAOImpl.updateMobileUser(mobileUser);
	}
	
	/**修改余额
	 * @param String userid String MOney
	 * @return boolean
	 */
	public static synchronized boolean updateMoney(String userName,String money) {
		Map<String,Object> map = new HashMap<String, Object>();
		String tempM = "0.00";
		try {
			tempM =  DESUtils.encrypt(money, userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("userName", userName);
		map.put("money", tempM);
		return mobileUserDAOImpl.updateMoney(map);
	}
	
}
