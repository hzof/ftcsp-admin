package com.cloudht.ft.dao;

import com.cloudht.ft.domain.FtFileDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文件表
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-07-17 16:40:02
 */
@Mapper
public interface FtFileDao {

	FtFileDO get(Long ftFileId);
	
	List<FtFileDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(FtFileDO ftFile);
	
	int update(FtFileDO ftFile);
	
	int remove(Long ft_file_id);
	
	int batchRemove(Long[] ftFileIds);
}
