package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.WriteBack;

public interface WriteBackDAO{
	
	public List<WriteBack> selectWriteBackList(WriteBack writeBack);
	public int selectWriteBackCountByReview(Map<String, Object> map);
	public List<WriteBack> getWriteBackByPage(Map<String, Object> map);
	public boolean insertWriteBack(WriteBack writeBack);
	public boolean deleteWriteBack(WriteBack writeBack);
	public boolean updateWriteBack(WriteBack writeBack);

}
