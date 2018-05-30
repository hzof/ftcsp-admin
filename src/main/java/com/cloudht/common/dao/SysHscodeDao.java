package com.cloudht.common.dao;

import com.cloudht.common.domain.SysHscodeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * HS编码
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-30 16:21:30
 */
@Mapper
public interface SysHscodeDao {

	SysHscodeDO get(Integer sysHscodeId);
	
	List<SysHscodeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysHscodeDO sysHscode);
	
	int update(SysHscodeDO sysHscode);
	
	int remove(Integer sys_hscode_id);
	
	int batchRemove(Integer[] sysHscodeIds);
}
