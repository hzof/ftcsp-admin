package com.cloudht.ft.service;

import com.cloudht.ft.domain.FtSensitiveAreaDO;

import java.util.List;
import java.util.Map;

/**
 * 敏感地区
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-05 18:50:41
 */
public interface FtSensitiveAreaService {
	
	FtSensitiveAreaDO get(Integer ftSensitiveAreaId);
	
	List<FtSensitiveAreaDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FtSensitiveAreaDO ftSensitiveArea);
	
	int update(FtSensitiveAreaDO ftSensitiveArea);
	
	int remove(Integer ftSensitiveAreaId);
	
	int batchRemove(Integer[] ftSensitiveAreaIds);
}
