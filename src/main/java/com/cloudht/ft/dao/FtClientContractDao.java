package com.cloudht.ft.dao;

import com.cloudht.ft.domain.FtClientContractDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 委托方合同
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-05 14:47:30
 */
@Mapper
public interface FtClientContractDao {

	FtClientContractDO get(Integer ftClientContractId);
	
	List<FtClientContractDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(FtClientContractDO ftClientContract);
	
	int update(FtClientContractDO ftClientContract);
	
	int remove(Integer ft_client_contract_id);
	
	int batchRemove(Integer[] ftClientContractIds);
}
