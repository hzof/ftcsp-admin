package com.cloudht.ft.service;

import com.cloudht.ft.domain.FtClientContractDO;

import java.util.List;
import java.util.Map;

/**
 * 委托方合同
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-05 14:47:30
 */
public interface FtClientContractService {
	
	FtClientContractDO get(Integer ftClientContractId);
	
	List<FtClientContractDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FtClientContractDO ftClientContract);
	
	int update(FtClientContractDO ftClientContract);
	
	int remove(Integer ftClientContractId);
	
	int batchRemove(Integer[] ftClientContractIds);
}
