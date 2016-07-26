package com.ChargePoint.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ChargePoint.DAO.CompanyDAOImpl;
import com.ChargePoint.Utils.TextUtils;
import com.ChargePoint.bean.Company;

public class CompanyService {
	
//	加载spring-ibatis配置
	static ApplicationContext act = new ClassPathXmlApplicationContext("/spring-ibatis-config.xml");
	
//	注入dataSource
	static CompanyDAOImpl companyDAOImpl = (CompanyDAOImpl) act.getBean("CompanyDAOImpl");
	
	/**获取所有company信息
	 * @param Company Company
	 * @return List Company
	 */
	public static List<Company> getCompanyList(Company Company){
		return companyDAOImpl.getCompanyList(Company);
	}
	
	/**根据company名获取company信息
	 * @param String CompanyName
	 * @return  Company
	 */
	public static Company getCompany(String companyName){
		return companyDAOImpl.getCompany(TextUtils.TOUTF8(companyName));
	}
	
	/**分页获取company信息
	 * @param int startIndex pageSize String searchText,String sortName,String order
	 * @return List Company
	 */
	public static List<Company> getCompanyByPage(int startIndex,int pageSize,String searchText,String sortName,String order){
		 Map<String,Object> parameterMap= new HashMap<String,Object>();
		 parameterMap.put("limitStart", startIndex);
		 parameterMap.put("limitCount", pageSize);
		 parameterMap.put("sortName", sortName);
		 parameterMap.put("order", order);
		 parameterMap.put("searchText", TextUtils.TOUTF8(searchText));
		return companyDAOImpl.getCompanyByPage(parameterMap);
	}
	
	/**添加company
	 * @param Company Company
	 * @return boolean
	 */
	public static boolean addCompany(Company company) {
		return companyDAOImpl.addCompany(company);
	}
	
	/**根据company名删除company
	 * @param String CompanyName
	 * @return
	 */
	public static boolean deleteCompany(String companyName) {
		return companyDAOImpl.deleteCompany(TextUtils.TOUTF8(companyName));
	}
	
	/**修改company
	 * @param Company Company
	 * @return boolean
	 */
	public static boolean updateCompany(Company company) {
		return companyDAOImpl.updateCompany(company);
	}
	
}
