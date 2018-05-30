package com.cloudht.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cloudht.common.dao.SysHscodeDao;
import com.cloudht.common.domain.SysHscodeDO;
import com.cloudht.common.service.SysHscodeService;



@Service
public class SysHscodeServiceImpl implements SysHscodeService {
	@Autowired
	private SysHscodeDao sysHscodeDao;
	
	@Override
	public SysHscodeDO get(Integer sysHscodeId){
		return sysHscodeDao.get(sysHscodeId);
	}
	
	@Override
	public List<SysHscodeDO> list(Map<String, Object> map){
		return sysHscodeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysHscodeDao.count(map);
	}
	
	@Override
	public int save(SysHscodeDO sysHscode){
		return sysHscodeDao.save(sysHscode);
	}
	
	@Override
	public int update(SysHscodeDO sysHscode){
		return sysHscodeDao.update(sysHscode);
	}
	
	@Override
	public int remove(Integer sysHscodeId){
		return sysHscodeDao.remove(sysHscodeId);
	}
	
	@Override
	public int batchRemove(Integer[] sysHscodeIds){
		return sysHscodeDao.batchRemove(sysHscodeIds);
	}
	
}
