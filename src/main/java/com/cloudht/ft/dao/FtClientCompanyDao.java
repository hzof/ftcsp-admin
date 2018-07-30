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
	 * 
	 * 此方法已经过时，应该使用listLikeCompanyName替代
	 * @param ftClientCompany
	 * @return
	 */
	@Deprecated
	List<Map<Long,String>> queryIdByNamelist(FtClientCompanyDO ftClientCompany);
	/**
	 * 根据公司名称模糊查询公司信息
	 * @param map 含有companyName(公司名称关键字)的集合，集合内可以包含分页等其他筛选条件
	 * @return 公司信息对象的集合
	 */
	List<FtClientCompanyDO> listLikeCompanyName(Map<String,Object> map);
}
