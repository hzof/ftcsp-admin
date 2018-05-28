package com.cloudht.doc.service;

import com.cloudht.doc.domain.ExNegotiationBaseDO;

import java.util.List;
import java.util.Map;

/**
 * 议付信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-25 15:42:53
 */
public interface ExNegotiationBaseService {
	
	ExNegotiationBaseDO get(Long exNegotiationBaseId);
	
	List<ExNegotiationBaseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ExNegotiationBaseDO exNegotiationBase);
	
	int update(ExNegotiationBaseDO exNegotiationBase);
	
	int remove(Long exNegotiationBaseId);
	
	int batchRemove(Long[] exNegotiationBaseIds);
}
