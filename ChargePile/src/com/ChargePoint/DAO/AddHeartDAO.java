package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.AddHeart;

public interface AddHeartDAO{
	
	public List<AddHeart> selectAddHeartList(AddHeart addHeart);
	public int selectAddHeartCountByReview(Map<String, Object> map) ;
	public List<AddHeart> getAddHeartByPage(Map<String, Object> map);
	public boolean insertAddHeart(AddHeart addHeart);
	public boolean deleteAddHeart(AddHeart addHeart);
	public boolean updateAddHeart(AddHeart addHeart);

}
