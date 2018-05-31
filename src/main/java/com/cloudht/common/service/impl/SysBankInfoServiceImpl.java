package com.cloudht.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cloudht.common.dao.SysBankInfoDao;
import com.cloudht.common.domain.SysBankInfoDO;
import com.cloudht.common.service.SysBankInfoService;



@Service
public class SysBankInfoServiceImpl implements SysBankInfoService {
	@Autowired
	private SysBankInfoDao sysBankInfoDao;
	
	@Override
	public SysBankInfoDO get(Integer sysBankInfoId){
		return sysBankInfoDao.get(sysBankInfoId);
	}
	
	@Override
	public List<SysBankInfoDO> list(Map<String, Object> map){
		return sysBankInfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysBankInfoDao.count(map);
	}
	
	@Override
	public int save(SysBankInfoDO sysBankInfo){
		return sysBankInfoDao.save(sysBankInfo);
	}
	
	@Override
	public int update(SysBankInfoDO sysBankInfo){
		return sysBankInfoDao.update(sysBankInfo);
	}
	
	@Override
	public int remove(Integer sysBankInfoId){
		return sysBankInfoDao.remove(sysBankInfoId);
	}
	
	@Override
	public int batchRemove(Integer[] sysBankInfoIds){
		return sysBankInfoDao.batchRemove(sysBankInfoIds);
	}
	
}
