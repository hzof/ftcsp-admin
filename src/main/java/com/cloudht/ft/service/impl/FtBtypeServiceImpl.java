package com.cloudht.ft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cloudht.ft.dao.FtBtypeDao;
import com.cloudht.ft.domain.FtBtypeDO;
import com.cloudht.ft.service.FtBtypeService;



@Service
public class FtBtypeServiceImpl implements FtBtypeService {
	@Autowired
	private FtBtypeDao ftBtypeDao;
	
	@Override
	public FtBtypeDO get(Integer ftBtypeId){
		return ftBtypeDao.get(ftBtypeId);
	}
	
	@Override
	public List<FtBtypeDO> list(Map<String, Object> map){
		return ftBtypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ftBtypeDao.count(map);
	}
	
	@Override
	public int save(FtBtypeDO ftBtype){
		return ftBtypeDao.save(ftBtype);
	}
	
	@Override
	public int update(FtBtypeDO ftBtype){
		return ftBtypeDao.update(ftBtype);
	}
	
	@Override
	public int remove(Integer ftBtypeId){
		return ftBtypeDao.remove(ftBtypeId);
	}
	
	@Override
	public int batchRemove(Integer[] ftBtypeIds){
		return ftBtypeDao.batchRemove(ftBtypeIds);
	}
	
}
