package com.cloudht.ex.service;

import com.cloudht.ex.domain.ExOrderDO;

import java.util.List;
import java.util.Map;

/**
 * 出口订单
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-15 10:31:08
 */
public interface ExOrderService {
	
	ExOrderDO get(Long exOrderId);
	
	List<ExOrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ExOrderDO exOrder);
	
	int update(ExOrderDO exOrder);
	
	int remove(Long exOrderId);
	
	int batchRemove(Long[] exOrderIds);
}
