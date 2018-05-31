package com.cloudht.common.dao;

import com.cloudht.common.domain.SysBankInfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 银行信息
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-30 16:21:30
 */
@Mapper
public interface SysBankInfoDao {

	SysBankInfoDO get(Integer sysBankInfoId);
	
	List<SysBankInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysBankInfoDO sysBankInfo);
	
	int update(SysBankInfoDO sysBankInfo);
	
	int remove(Integer sys_bank_info_id);
	
	int batchRemove(Integer[] sysBankInfoIds);
}
