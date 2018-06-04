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

import com.cloudht.ft.domain.ClientDO;
import com.cloudht.ft.service.ClientService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;

/**
 * 委托人信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-17 18:19:12
 */
 
@Controller
@RequestMapping("/ft/client")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@GetMapping()
	@RequiresPermissions("ft:client:client")
	String Client(){
	    return "ft/client/client";
	}
	/**
	 * 客户资质审核页面跳转
	 * @return
	 */
	@GetMapping("/clientCheck")
	@RequiresPermissions("ft:client:client")
	public String clientCheck() {
		return "ft/client/clientCheck";
	}
	/**
	 * 客户中心销售管理页面跳转
	 * @return
	 */
	@GetMapping("/clientSalesManagement")
	public String clientChec() {
		return "ft/client/clientSalesManagement";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ft:client:client")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ClientDO> clientList = clientService.list(query);
		int total = clientService.count(query);
		PageUtils pageUtils = new PageUtils(clientList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ft:client:add")
	String add(){
	    return "ft/client/add";
	}

	@GetMapping("/edit/{ftClientId}")
	@RequiresPermissions("ft:client:edit")
	String edit(@PathVariable("ftClientId") Long ftClientId,Model model){
		ClientDO client = clientService.get(ftClientId);
		model.addAttribute("client", client);
	    return "ft/client/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ft:client:add")
	public R save( ClientDO client){
		if(clientService.save(client)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ft:client:edit")
	public R update( ClientDO client){
		clientService.update(client);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ft:client:remove")
	public R remove( Long ftClientId){
		if(clientService.remove(ftClientId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ft:client:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ftClientIds){
		clientService.batchRemove(ftClientIds);
		return R.ok();
	}
	
	
}
