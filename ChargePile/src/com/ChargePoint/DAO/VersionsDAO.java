package com.ChargePoint.DAO;

import java.util.List;
import java.util.Map;

import com.ChargePoint.bean.Versions;

public interface VersionsDAO{

	public List<Versions> getVersionsList(Versions versions);
	
	public Versions getNewVersions();

	public List<Versions> getVersionsByPage(Map<String, Object> map);

	public boolean addVersions(Versions versions);

	public boolean deleteVersions(Versions versions);

	public boolean updateVersions(Versions versions);
	
}
