package com.cloudht.ft.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 客户中心大模块下多表查询接口
 * @author Hzof
 *
 */
@Mapper
public interface CustomerCenter {
	/**
	 * 客户中心-客户管理列表页面
	 * @param clientUserId
	 * @return 
	 */
	List<Map<String,Object>> clientList(Map<String,Object> map);
	/**
	 * 客户中心下合同管理展示页
	 * @param map 筛选的条件
	 * @return 合同的结果集
	 */
	List<Map<String,Object>> contractSuperviseList(Map<String,Object> map);
}
