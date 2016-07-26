package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.Company;

public class CompanyDAOImpl extends SqlMapClientDaoSupport implements CompanyDAO{

	@Override
	public List<Company> getCompanyList(Company company) {
		return getSqlMapClientTemplate().queryForList("selectCompanyList", company);
	}

	@Override
	public Company getCompany(String companyName) {
		return (Company) getSqlMapClientTemplate().queryForObject("selectCompany", companyName);
	}

	@Override
	public List<Company> getCompanyByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectCompanyByPage", map);
	}

	@Override
	public boolean addCompany(Company company) {
		boolean res = false;
		try{
			getSqlMapClientTemplate().insert("insertCompany", company);
			res = true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("insertcompany wrong!!!");
		}
		return  res;
	}

	@Override
	public boolean deleteCompany(String companyName) {
		boolean f = false;
		int re = -1;
		try{
			re = getSqlMapClientTemplate().delete("deleteCompany", companyName);
			f = true;
		}catch(Exception e){
			System.out.println("删除Company为"+companyName+"数据失败");
		}
		return f;
	}

	@Override
	public boolean updateCompany(Company company) {
		boolean result = false;
		try{
			 getSqlMapClientTemplate().update("updateCompany", company);
			 result = true;
		}catch(Exception e){
			System.out.println("修改公司出错");
			e.printStackTrace();
		}
		return result;
	}
	
}
