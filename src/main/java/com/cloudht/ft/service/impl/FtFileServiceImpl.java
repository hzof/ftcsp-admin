package com.cloudht.ft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cloudht.common.config.FtcspConfig;
import com.cloudht.ft.dao.FtFileDao;
import com.cloudht.ft.domain.FtFileDO;
import com.cloudht.ft.service.FtFileService;
import com.sxyht.common.utils.FileType;
import com.sxyht.common.utils.FileUtil;



@Service
public class FtFileServiceImpl implements FtFileService {
	@Autowired
	private FtFileDao ftFileDao;
	@Autowired
	private FtcspConfig ftcspConfig;
	
	@Override
	public FtFileDO get(Long ftFileId){
		return ftFileDao.get(ftFileId);
	}
	
	@Override
	public List<FtFileDO> list(Map<String, Object> map){
		return ftFileDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ftFileDao.count(map);
	}
	
	@Override
	public int save(FtFileDO ftFile){
		return ftFileDao.save(ftFile);
	}
	
	@Override
	public int update(FtFileDO ftFile){
		return ftFileDao.update(ftFile);
	}
	
	@Override
	public int remove(Long ftFileId){
		return ftFileDao.remove(ftFileId);
	}
	
	@Override
	public int batchRemove(Long[] ftFileIds){
		return ftFileDao.batchRemove(ftFileIds);
	}
	/**
	 * 保存文件到系统中及将信息保存到数据库
	 * @param file 需要保存的文件 传入null时返回值为null
	 * @param filePath 保存的路径 传入null时返回值为null
	 * @param fileSource 文件来源
	 * @param refKey 引用表的主键
	 * @param ftClientId 选填，不需要时传入null
	 * @return 保存成功时返回FtFileDO对象，保存失败时返回null
	 */
	@Override
	public FtFileDO saveFile(MultipartFile file,String filePath,Integer fileSource,Long refKey,Long ftClientId) {
		if(file==null||"null".equals(filePath)||fileSource==null||refKey==null)
			return null;
		String fileName = file.getOriginalFilename();//获取客戶的路勁及文件名称
		fileName = FileUtil.renameToUUID(fileName);//重新设置文件名称
		filePath=filePath+"/";
		String url = "/files/"+filePath+fileName;
		filePath= this.ftcspConfig.getUploadPath()+filePath;//重新設置文件路勁
		try {
			FileUtil.uploadFile(file.getBytes(),filePath, fileName);//存储到文件系统中
		} catch (Exception e) {
			return null;
		}
		FtFileDO ftFileDO = new FtFileDO();//创建数据库存储对象
		ftFileDO.setType(FileType.fileType(fileName));//设置文件类型
		ftFileDO.setUrl(url);//设置访问路径
		ftFileDO.setCreateDate(new Date());//设置创建时间
		ftFileDO.setFileSource(fileSource);//设置文件来源
		ftFileDO.setRefKey(refKey);//设置引用表的主键
		ftFileDO.setIsVisible(1);//1代表可见，默认值
		if(ftClientId!=null)
			ftFileDO.setFtClientId(ftClientId);
		if(ftFileDao.save(ftFileDO)>0)//存儲到數據庫的文件表中，保存时顺便返回主键
			return ftFileDO;//大于0说明保存成功，返回含有文件信息的file对象
		return null;
	}
	/**
	 * 
	 * @param fileSource 必输项，严禁输入null，
	 * @param refKey 引用表的主鍵
	 * @param ftClientId 客戶表的主鍵
	 * @return
	 */
	@Override
	public List<FtFileDO> getClientContractFile(Integer fileSource,Long refKey,Long ftClientId) {
		if(fileSource==null)
			return null;
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(refKey!=null)
			map.put("refKey", refKey);
		if(ftClientId!=null)
			map.put("ftClientId", ftClientId);
		return this.ftFileDao.list(map);
	}
}
