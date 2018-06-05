package com.cloudht.ft.dao;

import com.cloudht.ft.domain.FtSensitiveAreaDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 敏感地区
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-05 18:50:41
 */
@Mapper
public interface FtSensitiveAreaDao {

	FtSensitiveAreaDO get(Integer ftSensitiveAreaId);
	
	List<FtSensitiveAreaDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(FtSensitiveAreaDO ftSensitiveArea);
	
	int update(FtSensitiveAreaDO ftSensitiveArea);
	
	int remove(Integer ft_sensitive_area_id);
	
	int batchRemove(Integer[] ftSensitiveAreaIds);
}
