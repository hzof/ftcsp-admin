package com.cloudht.ft.service;

import com.cloudht.ft.domain.FtClientDO;
import com.sxyht.common.utils.Query;

import java.util.List;
import java.util.Map;

/**
 * 委托人信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-20 15:18:05
 */
public interface FtClientService {
	
	FtClientDO get(Long ftClientId);
	
	List<FtClientDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FtClientDO ftClient);
	
	int update(FtClientDO ftClient);
	
	int remove(Long ftClientId);
	
	int batchRemove(Long[] ftClientIds);

	List<Map<String, Object>> clientList(Map<String, Object> map);

	String getClientCode();

	FtClientDO getNewServiceContractNo(FtClientDO ftClientDO);

	List<Map<String, Object>> contractSuperviseList(Query query);
}
