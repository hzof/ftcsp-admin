package com.cloudht.common.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudht.common.domain.SysBankAccountDO;
import com.cloudht.common.service.SysBankAccountService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;

/**
 * 银行账户信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-30 16:21:30
 */
 
@Controller
@RequestMapping("/common/sysBankAccount")
public class SysBankAccountController {
	@Autowired
	private SysBankAccountService sysBankAccountService;
	
	@GetMapping()
	@RequiresPermissions("common:sysBankAccount:sysBankAccount")
	String SysBankAccount(){
	    return "common/sysBankAccount/sysBankAccount";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:sysBankAccount:sysBankAccount")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysBankAccountDO> sysBankAccountList = sysBankAccountService.list(query);
		int total = sysBankAccountService.count(query);
		PageUtils pageUtils = new PageUtils(sysBankAccountList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("common:sysBankAccount:add")
	String add(){
	    return "common/sysBankAccount/add";
	}

	@GetMapping("/edit/{sysBankAccountId}")
	@RequiresPermissions("common:sysBankAccount:edit")
	String edit(@PathVariable("sysBankAccountId") Integer sysBankAccountId,Model model){
		SysBankAccountDO sysBankAccount = sysBankAccountService.get(sysBankAccountId);
		model.addAttribute("sysBankAccount", sysBankAccount);
	    return "common/sysBankAccount/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:sysBankAccount:add")
	public R save( SysBankAccountDO sysBankAccount){
		if(sysBankAccountService.save(sysBankAccount)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:sysBankAccount:edit")
	public R update( SysBankAccountDO sysBankAccount){
		sysBankAccountService.update(sysBankAccount);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("common:sysBankAccount:remove")
	public R remove( Integer sysBankAccountId){
		if(sysBankAccountService.remove(sysBankAccountId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:sysBankAccount:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] sysBankAccountIds){
		sysBankAccountService.batchRemove(sysBankAccountIds);
		return R.ok();
	}
	
}
