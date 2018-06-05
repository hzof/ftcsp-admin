package com.cloudht.ft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cloudht.ft.dao.FtSensitiveAreaDao;
import com.cloudht.ft.domain.FtSensitiveAreaDO;
import com.cloudht.ft.service.FtSensitiveAreaService;



@Service
public class FtSensitiveAreaServiceImpl implements FtSensitiveAreaService {
	@Autowired
	private FtSensitiveAreaDao ftSensitiveAreaDao;
	
	@Override
	public FtSensitiveAreaDO get(Integer ftSensitiveAreaId){
		return ftSensitiveAreaDao.get(ftSensitiveAreaId);
	}
	
	@Override
	public List<FtSensitiveAreaDO> list(Map<String, Object> map){
		return ftSensitiveAreaDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ftSensitiveAreaDao.count(map);
	}
	
	@Override
	public int save(FtSensitiveAreaDO ftSensitiveArea){
		return ftSensitiveAreaDao.save(ftSensitiveArea);
	}
	
	@Override
	public int update(FtSensitiveAreaDO ftSensitiveArea){
		return ftSensitiveAreaDao.update(ftSensitiveArea);
	}
	
	@Override
	public int remove(Integer ftSensitiveAreaId){
		return ftSensitiveAreaDao.remove(ftSensitiveAreaId);
	}
	
	@Override
	public int batchRemove(Integer[] ftSensitiveAreaIds){
		return ftSensitiveAreaDao.batchRemove(ftSensitiveAreaIds);
	}
	
}
