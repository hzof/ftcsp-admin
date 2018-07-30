package com.cloudht.ft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cloudht.ft.dao.FtClientCompanyDao;
import com.cloudht.ft.domain.FtClientCompanyDO;
import com.cloudht.ft.service.FtClientCompanyService;



@Service
public class FtClientCompanyServiceImpl implements FtClientCompanyService {
	@Autowired
	private FtClientCompanyDao ftClientCompanyDao;
	
	@Override
	public FtClientCompanyDO get(Integer ftClientCompanyId){
		return ftClientCompanyDao.get(ftClientCompanyId);
	}
	
	@Override
	public List<FtClientCompanyDO> list(Map<String, Object> map){
		return ftClientCompanyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ftClientCompanyDao.count(map);
	}
	
	@Override
	public int save(FtClientCompanyDO ftClientCompany){
		return ftClientCompanyDao.save(ftClientCompany);
	}
	
	@Override
	public int update(FtClientCompanyDO ftClientCompany){
		return ftClientCompanyDao.update(ftClientCompany);
	}
	
	@Override
	public int remove(Integer ftClientCompanyId){
		return ftClientCompanyDao.remove(ftClientCompanyId);
	}
	
	@Override
	public int batchRemove(Integer[] ftClientCompanyIds){
		return ftClientCompanyDao.batchRemove(ftClientCompanyIds);
	}

	@Override
	@Deprecated
	public List<Map<Long,String>> queryIdByNamelist(FtClientCompanyDO ftClientCompany) {
		return ftClientCompanyDao.queryIdByNamelist(ftClientCompany);
	}
	/**
	 * 根据含有公司名称关键字的字符串模糊查询公司信息
	 * @param likeCompanyName 含有公司名称关键字的字符串
	 * @return 公司对象集合
	 */
	@Override
	public List<FtClientCompanyDO> queryClientByLikeCompanyName(String likeCompanyName){
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("companyName", likeCompanyName);
		return this.ftClientCompanyDao.listLikeCompanyName(hashMap);
	}
	
}
