package com.cloudht.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cloudht.common.dao.SysBankAccountDao;
import com.cloudht.common.domain.SysBankAccountDO;
import com.cloudht.common.service.SysBankAccountService;



@Service
public class SysBankAccountServiceImpl implements SysBankAccountService {
	@Autowired
	private SysBankAccountDao sysBankAccountDao;
	
	@Override
	public SysBankAccountDO get(Integer sysBankAccountId){
		return sysBankAccountDao.get(sysBankAccountId);
	}
	
	@Override
	public List<SysBankAccountDO> list(Map<String, Object> map){
		return sysBankAccountDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysBankAccountDao.count(map);
	}
	
	@Override
	public int save(SysBankAccountDO sysBankAccount){
		return sysBankAccountDao.save(sysBankAccount);
	}
	
	@Override
	public int update(SysBankAccountDO sysBankAccount){
		return sysBankAccountDao.update(sysBankAccount);
	}
	
	@Override
	public int remove(Integer sysBankAccountId){
		return sysBankAccountDao.remove(sysBankAccountId);
	}
	
	@Override
	public int batchRemove(Integer[] sysBankAccountIds){
		return sysBankAccountDao.batchRemove(sysBankAccountIds);
	}
	
}
