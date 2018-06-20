package com.cloudht.ft.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudht.ft.domain.FtClientDO;
import com.cloudht.ft.service.FtClientService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;

/**
 * 委托人信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-20 15:18:05
 */
 
@Controller
@RequestMapping("/ft/ftClient")
public class FtClientController {
	@Autowired
	private FtClientService ftClientService;
	
	@GetMapping()
	@RequiresPermissions("ft:ftClient:ftClient")
	String FtClient(){
	    return "ft/ftClient/ftClient";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ft:ftClient:ftClient")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FtClientDO> ftClientList = ftClientService.list(query);
		int total = ftClientService.count(query);
		PageUtils pageUtils = new PageUtils(ftClientList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ft:ftClient:add")
	String add(){
	    return "ft/ftClient/add";
	}

	@GetMapping("/edit/{ftClientId}")
	@RequiresPermissions("ft:ftClient:edit")
	String edit(@PathVariable("ftClientId") Long ftClientId,Model model){
		FtClientDO ftClient = ftClientService.get(ftClientId);
		model.addAttribute("ftClient", ftClient);
	    return "ft/ftClient/edit";
	}
	@GetMapping("/distributionMarketing/{ftClientId}")
	String distributionMarketing(@PathVariable("ftClientId") Long ftClientId,Model model){
		model.addAttribute("ftClientId", ftClientId);
	    return "ft/ftClient/distributionMarketing";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ft:ftClient:add")
	public R save( FtClientDO ftClient){
		if(ftClientService.save(ftClient)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ft:ftClient:edit")
	public R update( FtClientDO ftClient){
		ftClientService.update(ftClient);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ft:ftClient:remove")
	public R remove( Long ftClientId){
		if(ftClientService.remove(ftClientId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ft:ftClient:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ftClientIds){
		ftClientService.batchRemove(ftClientIds);
		return R.ok();
	}
	
}
