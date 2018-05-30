package com.cloudht.common.service;

import com.cloudht.common.domain.SysBankInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 银行信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-30 16:21:30
 */
public interface SysBankInfoService {
	
	SysBankInfoDO get(Integer sysBankInfoId);
	
	List<SysBankInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysBankInfoDO sysBankInfo);
	
	int update(SysBankInfoDO sysBankInfo);
	
	int remove(Integer sysBankInfoId);
	
	int batchRemove(Integer[] sysBankInfoIds);
}
