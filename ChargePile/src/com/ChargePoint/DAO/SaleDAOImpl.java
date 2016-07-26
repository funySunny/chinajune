package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ChargePoint.bean.ChargePoint;
import com.ChargePoint.bean.Sale;

@SuppressWarnings("deprecation")
public class SaleDAOImpl extends SqlMapClientDaoSupport implements SaleDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Sale> selectSaleList(Sale sale) {
		return getSqlMapClientTemplate().queryForList("selectSaleList", sale);
	}
	
	@Override
	public int selectSaleCount() {
		return (int) getSqlMapClientTemplate().queryForObject("selectSaleCount");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sale> selectSaleListByAddress(String place) {
		return getSqlMapClientTemplate().queryForList("selectSaleAddress",
				place);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectSaleAddressByLevel(int level) {
		return getSqlMapClientTemplate().queryForList("selectSaleAddressByLevel",
				level);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectSaleAddressByLevel2(String place) {
		return getSqlMapClientTemplate().queryForList("selectSaleAddressByLevel2",
				place);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sale> getSaleByPage(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("selectSaleByPage", map);
	}

	@Override
	public boolean insertSale(Sale sale) {
		boolean res = false;
		try {
			getSqlMapClientTemplate().insert("insertSale", sale);
			res = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertSale wrong!!!");
		}
		return res;
	}

	@Override
	public boolean deleteSale(String cpid) {
		boolean f = false;
		try {
			getSqlMapClientTemplate().delete("deleteSale", cpid);
			f = true;
		} catch (Exception e) {
			System.out.println("删除sale为" + cpid + "数据失败");
		}
		return f;
	}

	@Override
	public boolean updateSale(Sale sale) {
		boolean result = false;
		try {
			getSqlMapClientTemplate().update("updateSale", sale);
			result = true;
		} catch (Exception e) {
			System.out.println("修改销售出错");
			e.printStackTrace();
		}
		return result;
	}

}
