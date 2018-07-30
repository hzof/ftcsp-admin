package com.cloudht.ft.service;

import com.cloudht.ft.domain.FtClientCompanyDO;

import java.util.List;
import java.util.Map;

/**
 * 委托方公司表
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-12 11:32:46
 */
public interface FtClientCompanyService {
	
	FtClientCompanyDO get(Integer ftClientCompanyId);
	
	List<FtClientCompanyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FtClientCompanyDO ftClientCompany);
	
	int update(FtClientCompanyDO ftClientCompany);
	
	int remove(Integer ftClientCompanyId);
	
	int batchRemove(Integer[] ftClientCompanyIds);
	
	/**
	 * 根据公司名称模糊查询带有公司id和公司名称的集合
	 * @param ftClientCompany 成员变量companyName，含有成员变量关键字的值
	 * @return Map
	 */
	public List<Map<Long,String>> queryIdByNamelist(FtClientCompanyDO ftClientCompany);
	/**
	 * 根据含有公司名称关键字的字符串模糊查询公司信息
	 * @param likeCompanyName 含有公司名称关键字的字符串
	 * @return 公司对象集合
	 */
	List<FtClientCompanyDO> queryClientByLikeCompanyName(String likeCompanyName);
}
