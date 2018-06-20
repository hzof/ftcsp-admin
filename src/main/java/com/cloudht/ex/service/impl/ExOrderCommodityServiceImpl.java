package com.cloudht.ex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cloudht.ex.dao.ExOrderCommodityDao;
import com.cloudht.ex.domain.ExOrderCommodityDO;
import com.cloudht.ex.service.ExOrderCommodityService;



@Service
public class ExOrderCommodityServiceImpl implements ExOrderCommodityService {
	@Autowired
	private ExOrderCommodityDao exOrderCommodityDao;
	
	@Override
	public ExOrderCommodityDO get(Long exOrderCommodityId){
		return exOrderCommodityDao.get(exOrderCommodityId);
	}
	
	@Override
	public List<ExOrderCommodityDO> list(Map<String, Object> map){
		return exOrderCommodityDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return exOrderCommodityDao.count(map);
	}
	
	@Override
	public int save(ExOrderCommodityDO exOrderCommodity){
		return exOrderCommodityDao.save(exOrderCommodity);
	}
	
	@Override
	public int update(ExOrderCommodityDO exOrderCommodity){
		return exOrderCommodityDao.update(exOrderCommodity);
	}
	
	@Override
	public int remove(Long exOrderCommodityId){
		return exOrderCommodityDao.remove(exOrderCommodityId);
	}
	
	@Override
	public int batchRemove(Long[] exOrderCommodityIds){
		return exOrderCommodityDao.batchRemove(exOrderCommodityIds);
	}
	
}
