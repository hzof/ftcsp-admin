package com.cloudht.ft.dao;

import com.cloudht.ft.domain.FtClientDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 委托人信息
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-20 15:18:05
 */
@Mapper
public interface FtClientDao {

	FtClientDO get(Long ftClientId);
	
	List<FtClientDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(FtClientDO ftClient);
	
	int update(FtClientDO ftClient);
	
	int remove(Long ft_client_id);
	
	int batchRemove(Long[] ftClientIds);
}
