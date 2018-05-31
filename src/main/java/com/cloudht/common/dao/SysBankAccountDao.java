package com.cloudht.common.dao;

import com.cloudht.common.domain.SysBankAccountDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 银行账户信息
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-30 16:21:30
 */
@Mapper
public interface SysBankAccountDao {

	SysBankAccountDO get(Integer sysBankAccountId);
	
	List<SysBankAccountDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysBankAccountDO sysBankAccount);
	
	int update(SysBankAccountDO sysBankAccount);
	
	int remove(Integer sys_bank_account_id);
	
	int batchRemove(Integer[] sysBankAccountIds);
}
