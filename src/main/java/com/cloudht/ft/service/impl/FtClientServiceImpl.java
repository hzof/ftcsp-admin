package com.cloudht.ft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cloudht.ft.dao.FtClientDao;
import com.cloudht.ft.domain.FtClientDO;
import com.cloudht.ft.service.FtClientService;



@Service
public class FtClientServiceImpl implements FtClientService {
	@Autowired
	private FtClientDao ftClientDao;
	@Autowired
	private com.cloudht.ft.dao.CustomerCenter customerCenter;
	
	@Override
	public FtClientDO get(Long ftClientId){
		return ftClientDao.get(ftClientId);
	}
	
	@Override
	public List<FtClientDO> list(Map<String, Object> map){
		return this.ftClientDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ftClientDao.count(map);
	}
	
	@Override
	public int save(FtClientDO ftClient){
		return ftClientDao.save(ftClient);
	}
	
	@Override
	public int update(FtClientDO ftClient){
		return ftClientDao.update(ftClient);
	}
	
	@Override
	public int remove(Long ftClientId){
		return ftClientDao.remove(ftClientId);
	}
	
	@Override
	public int batchRemove(Long[] ftClientIds){
		return ftClientDao.batchRemove(ftClientIds);
	}
	@Override
	public List<Map<String, Object>> clientList(Map<String, Object> map) {
		return customerCenter.clientList(map);
	}
	
}
