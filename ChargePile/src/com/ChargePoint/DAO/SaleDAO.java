package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.Sale;

public interface SaleDAO{
	
	public List<Sale> selectSaleList(Sale sale);
	public int selectSaleCount();
	public List<Sale> selectSaleListByAddress(String place);
	public List<String> selectSaleAddressByLevel(int level);
	public List<String> selectSaleAddressByLevel2(String place);
	public List<Sale> getSaleByPage(Map<String, Object> map);
	public boolean insertSale(Sale sale);
	public boolean deleteSale(String cpid);
	public boolean updateSale(Sale sale);

}
