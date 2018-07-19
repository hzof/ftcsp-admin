package com.cloudht.ft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.cloudht.common.domain.DictDO;
import com.cloudht.ft.dao.FtClientDao;
import com.cloudht.ft.domain.FtClientDO;
import com.cloudht.ft.service.FtClientService;
import com.sxyht.common.utils.Query;

@Service
public class FtClientServiceImpl implements FtClientService {
	@Autowired
	private FtClientDao ftClientDao;
	@Autowired
	private com.cloudht.ft.dao.CustomerCenter customerCenter;
	@Autowired
	private com.cloudht.common.service.DictService dictService;
	
	@Override
	public FtClientDO get(Long ftClientId){
		return ftClientDao.get(ftClientId);
	}
	
	@Override
	public List<FtClientDO> list(Map<String, Object> map){
		return this.ftClientDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ftClientDao.count(map);
	}
	
	@Override
	public int save(FtClientDO ftClient){
		return ftClientDao.save(ftClient);
	}
	
	@Override
	public int update(FtClientDO ftClient){
		return ftClientDao.update(ftClient);
	}
	
	@Override
	public int remove(Long ftClientId){
		return ftClientDao.remove(ftClientId);
	}
	
	@Override
	public int batchRemove(Long[] ftClientIds){
		return ftClientDao.batchRemove(ftClientIds);
	}
	@Override
	public List<Map<String, Object>> clientList(Map<String, Object> map) {
		return customerCenter.clientList(map);
	}
	@Override
	public synchronized String getClientCode() {
		List<DictDO> listByType = dictService.listByType("endClientCode");
		DictDO dictDO = listByType.get(0);
		String value = dictDO.getValue();
		String[] split = value.split(",");
		int index=0;
		int[] endClientCode = new int[4];
		for(String str : split) {
			Integer.parseInt(str);
			endClientCode[index]=Integer.parseInt(str);
			index++;
		}
		if(endClientCode[3]<25) {
			endClientCode[3]++;
		}else if(endClientCode[2]<25) {
			endClientCode[2]++;	
			endClientCode[3]=0;
		}else if(endClientCode[1]<25) {
			endClientCode[1]++;
			endClientCode[2]=0;
			endClientCode[3]=0;
		}else if(endClientCode[0]<25) {
			endClientCode[0]++;
			endClientCode[1]=0;
			endClientCode[2]=0;
			endClientCode[3]=0;
		}else {
			return null;//总共456975种组合，走到这里说明所有值都被用完了
		}
		StringBuffer clientCode = new StringBuffer();
		char[] letter= {'H','A','Q','W','S','X','C','D','E','R',
				'F','V','B','G','T','Y','Z','N','M','J','U','I','K','L','O','P'};
		for(int i :endClientCode)
			clientCode.append(letter[i]);
		String str =endClientCode[0]+","+endClientCode[1]+","+endClientCode[2]+","+endClientCode[3];
		dictDO.setValue(str);
		int update = dictService.update(dictDO);
		if(update == 1) {
			return clientCode.toString();
		}
		return null;//数据库未正确更新，返回null
	}
	/**
	 * 获取新的客户服务合同号，已经有的会原值返回，传入null会返回null
	 * @param ftClientDO
	 * @return 客户服务合同号
	 */
	@Override
	public FtClientDO getNewServiceContractNo(FtClientDO ftClientDO) {
		//将null排除掉
		if(ftClientDO==null||ftClientDO.getClientNo()==null||ftClientDO.getClientNo().equals(""))
			return ftClientDO;
		String serviceContractNo = ftClientDO.getServiceContractNo();
		//将已经有服务合同号情况的排除掉
		if(serviceContractNo!=null&&(!"".equals(serviceContractNo)))
			return ftClientDO;
		Random random=new Random();
		int nextInt = random.nextInt(99999999);
		if(nextInt<9999999)
			nextInt+=9999999;
		ftClientDO.setServiceContractNo(ftClientDO.getClientNo()+"-"+nextInt);
		return ftClientDO;
	}

	@Override
	public List<Map<String, Object>> contractSuperviseList(Query query) {
		return this.customerCenter.contractSuperviseList(query);
		
	}
}
