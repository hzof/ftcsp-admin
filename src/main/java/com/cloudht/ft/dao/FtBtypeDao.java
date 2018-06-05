package com.cloudht.ft.dao;

import com.cloudht.ft.domain.FtBtypeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 往来单位信息
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-05 18:50:41
 */
@Mapper
public interface FtBtypeDao {

	FtBtypeDO get(Integer ftBtypeId);
	
	List<FtBtypeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(FtBtypeDO ftBtype);
	
	int update(FtBtypeDO ftBtype);
	
	int remove(Integer ft_btype_id);
	
	int batchRemove(Integer[] ftBtypeIds);
}
