package com.cloudht.ft.dao;

import com.cloudht.ft.domain.FtClientCompanyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 委托方公司表
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-12 11:32:46
 */
@Mapper
public interface FtClientCompanyDao {

	FtClientCompanyDO get(Integer ftClientCompanyId);
	
	List<FtClientCompanyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(FtClientCompanyDO ftClientCompany);
	
	int update(FtClientCompanyDO ftClientCompany);
	
	int remove(Integer ft_client_company_id);
	
	int batchRemove(Integer[] ftClientCompanyIds);
	
	/**
	 * 根据公司名称关键字模糊查询
	 * @param ftClientCompany
	 * @return
	 */
	List<Map<Long,String>> queryIdByNamelist(FtClientCompanyDO ftClientCompany);
}
