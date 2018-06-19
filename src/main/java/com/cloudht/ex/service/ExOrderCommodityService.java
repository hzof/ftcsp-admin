package com.cloudht.ex.service;

import com.cloudht.ex.domain.ExOrderCommodityDO;

import java.util.List;
import java.util.Map;

/**
 * 出口订单商品
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-15 16:42:43
 */
public interface ExOrderCommodityService {
	
	ExOrderCommodityDO get(Long exOrderCommodityId);
	
	List<ExOrderCommodityDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ExOrderCommodityDO exOrderCommodity);
	
	int update(ExOrderCommodityDO exOrderCommodity);
	
	int remove(Long exOrderCommodityId);
	
	int batchRemove(Long[] exOrderCommodityIds);
}
