package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.ChargeRecords;
import com.ChargePoint.bean.Company;

public interface CompanyDAO{
	
	public List<Company> getCompanyList(Company company);
	public Company getCompany(String companyName);
	public List<Company> getCompanyByPage(Map<String,Object> map);
	public boolean addCompany(Company company);
	public boolean deleteCompany(String companyName);
	public boolean updateCompany(Company Company);	

}
