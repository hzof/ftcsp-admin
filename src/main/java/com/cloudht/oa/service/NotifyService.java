package com.cloudht.oa.service;

import com.cloudht.oa.domain.NotifyDO;
import com.sxyht.common.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 通知通告
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2017-10-05 17:11:16
 */
public interface NotifyService {

	NotifyDO get(Long id);

	List<NotifyDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(NotifyDO notify);

	int update(NotifyDO notify);

	int remove(Long id);

	int batchRemove(Long[] ids);

//	Map<String, Object> message(Long userId);

	PageUtils selfList(Map<String, Object> map);
}
