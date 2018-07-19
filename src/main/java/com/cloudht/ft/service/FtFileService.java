package com.cloudht.ft.service;

import com.cloudht.ft.domain.FtFileDO;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件表
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-07-17 16:40:02
 */
public interface FtFileService {
	
	FtFileDO get(Long ftFileId);
	
	List<FtFileDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FtFileDO ftFile);
	
	int update(FtFileDO ftFile);
	
	int remove(Long ftFileId);
	
	int batchRemove(Long[] ftFileIds);
	/**
	 * 保存文件到系统中及将信息保存到数据库
	 * @param file 需要保存的文件 传入null时返回值为null
	 * @param filePath 保存的路径 传入null时返回值为null
	 * @param fileSource 文件来源
	 * @param refKey 引用表的主键
	 * @param ftClientId 选填，不需要时传入null
	 * @return 保存成功时返回FtFileDO对象，保存失败时返回null
	 */
	FtFileDO saveFile(MultipartFile file, String filePath, Integer fileSource, Long refKey, Long ftClientId);
}
