package com.cloudht.ex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cloudht.ex.dao.ExOrderDao;
import com.cloudht.ex.domain.ExOrderDO;
import com.cloudht.ex.service.ExOrderService;



@Service
public class ExOrderServiceImpl implements ExOrderService {
	@Autowired
	private ExOrderDao exOrderDao;
	
	@Override
	public ExOrderDO get(Long exOrderId){
		return exOrderDao.get(exOrderId);
	}
	
	@Override
	public List<ExOrderDO> list(Map<String, Object> map){
		return exOrderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return exOrderDao.count(map);
	}
	
	@Override
	public int save(ExOrderDO exOrder){
		return exOrderDao.save(exOrder);
	}
	
	@Override
	public int update(ExOrderDO exOrder){
		return exOrderDao.update(exOrder);
	}
	
	@Override
	public int remove(Long exOrderId){
		return exOrderDao.remove(exOrderId);
	}
	
	@Override
	public int batchRemove(Long[] exOrderIds){
		return exOrderDao.batchRemove(exOrderIds);
	}
	
}
