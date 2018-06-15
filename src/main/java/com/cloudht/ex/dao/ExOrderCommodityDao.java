package com.cloudht.ex.dao;

import com.cloudht.ex.domain.ExOrderCommodityDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 出口订单商品
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-15 16:42:43
 */
@Mapper
public interface ExOrderCommodityDao {

	ExOrderCommodityDO get(Long exOrderCommodityId);
	
	List<ExOrderCommodityDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ExOrderCommodityDO exOrderCommodity);
	
	int update(ExOrderCommodityDO exOrderCommodity);
	
	int remove(Long ex_order_commodity_id);
	
	int batchRemove(Long[] exOrderCommodityIds);
}
