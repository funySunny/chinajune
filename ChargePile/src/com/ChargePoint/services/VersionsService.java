package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.VersionsDAOImpl;
import com.ChargePoint.Utils.TimeFormatUtil;
import com.ChargePoint.bean.Versions;

public class VersionsService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static VersionsDAOImpl versionDAOImpl = (VersionsDAOImpl) act.getBean("VersionsDAOImpl");
	
	
	/**获取Versions列表
	 * @param Versions versions
	 * @return List Versions
	 */
	public static List<Versions> getVersionsList(Versions versions){
		return versionDAOImpl.getVersionsList(versions);
	}
	
	/**分页获取Versions列表
	 * @param int limitStart,int limitCount,String sortName,String order
	 * @return List Versions
	 */
	public static List<Versions> getVersionsByPage(int limitStart , int limitCount,String sortName,String order){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sortName", sortName);
		map.put("order", order);
		map.put("limitStart", limitStart);
		map.put("limitCount", limitCount);
		return versionDAOImpl.getVersionsByPage(map);
	}
	
	/**检查最新版本
	 * @param String versionNO
	 * @return Object(true-最新版本  or versions)
	 */
	public static Object checkNewVersions(String versionNO) {
			Versions versions = versionDAOImpl.getNewVersions();
			String newVersionNO = versions.getVersion_no();
		if(versionNO != null && versionNO.equals(newVersionNO)){
			return true;
		}else{
			return versions;
		}
	}
	
	/**添加Versions记录
	 * @param Versions
	 * @return boolean
	 */
	public static boolean addVersions(Versions versions){
		versions.setUpload_time(TimeFormatUtil.getFormattedNow());
		return versionDAOImpl.addVersions(versions);
	}
	
	/**删除Versions记录
	 * @param id
	 * @return boolean
	 */
	public static boolean deleteVersions(Versions versions){
		return versionDAOImpl.deleteVersions(versions);
	}
	
	/**更新Versions记录
	 * @param Versions
	 * @return boolean
	 */
	public static boolean updateVersions(Versions versions){
		return versionDAOImpl.updateVersions(versions);
	}
}
