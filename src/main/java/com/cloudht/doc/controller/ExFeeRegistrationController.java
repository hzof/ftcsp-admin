package com.cloudht.doc.controller;

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

import com.cloudht.doc.domain.ExFeeRegistrationDO;
import com.cloudht.doc.service.ExFeeRegistrationService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 费用明细登记
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-25 15:42:53
 */
 
@Controller
@RequestMapping("/doc/exFeeRegistration")
public class ExFeeRegistrationController {
	@Autowired
	private ExFeeRegistrationService exFeeRegistrationService;
	
	@GetMapping()
	@RequiresPermissions("doc:exFeeRegistration:exFeeRegistration")
	String ExFeeRegistration(){
	    return "doc/exFeeRegistration/exFeeRegistration";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("doc:exFeeRegistration:exFeeRegistration")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ExFeeRegistrationDO> exFeeRegistrationList = exFeeRegistrationService.list(query);
		int total = exFeeRegistrationService.count(query);
		PageUtils pageUtils = new PageUtils(exFeeRegistrationList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("doc:exFeeRegistration:add")
	String add(){
	    return "doc/exFeeRegistration/add";
	}

	@GetMapping("/edit/{exFeeRegistrationId}")
	@RequiresPermissions("doc:exFeeRegistration:edit")
	String edit(@PathVariable("exFeeRegistrationId") Long exFeeRegistrationId,Model model){
		ExFeeRegistrationDO exFeeRegistration = exFeeRegistrationService.get(exFeeRegistrationId);
		model.addAttribute("exFeeRegistration", exFeeRegistration);
	    return "doc/exFeeRegistration/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("doc:exFeeRegistration:add")
	public R save( ExFeeRegistrationDO exFeeRegistration){
		if(exFeeRegistrationService.save(exFeeRegistration)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("doc:exFeeRegistration:edit")
	public R update( ExFeeRegistrationDO exFeeRegistration){
		exFeeRegistrationService.update(exFeeRegistration);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("doc:exFeeRegistration:remove")
	public R remove( Long exFeeRegistrationId){
		if(exFeeRegistrationService.remove(exFeeRegistrationId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("doc:exFeeRegistration:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] exFeeRegistrationIds){
		exFeeRegistrationService.batchRemove(exFeeRegistrationIds);
		return R.ok();
	}
	
}
