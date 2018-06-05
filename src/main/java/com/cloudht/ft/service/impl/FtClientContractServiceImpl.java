package com.cloudht.ft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cloudht.ft.dao.FtClientContractDao;
import com.cloudht.ft.domain.FtClientContractDO;
import com.cloudht.ft.service.FtClientContractService;



@Service
public class FtClientContractServiceImpl implements FtClientContractService {
	@Autowired
	private FtClientContractDao ftClientContractDao;
	
	@Override
	public FtClientContractDO get(Integer ftClientContractId){
		return ftClientContractDao.get(ftClientContractId);
	}
	
	@Override
	public List<FtClientContractDO> list(Map<String, Object> map){
		return ftClientContractDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ftClientContractDao.count(map);
	}
	
	@Override
	public int save(FtClientContractDO ftClientContract){
		return ftClientContractDao.save(ftClientContract);
	}
	
	@Override
	public int update(FtClientContractDO ftClientContract){
		return ftClientContractDao.update(ftClientContract);
	}
	
	@Override
	public int remove(Integer ftClientContractId){
		return ftClientContractDao.remove(ftClientContractId);
	}
	
	@Override
	public int batchRemove(Integer[] ftClientContractIds){
		return ftClientContractDao.batchRemove(ftClientContractIds);
	}
	
}
