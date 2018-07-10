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

import com.cloudht.doc.domain.ExCreditFeeDO;
import com.cloudht.doc.service.ExCreditFeeService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;

/**
 * 信用证费用
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-25 15:42:52
 */
 
@Controller
@RequestMapping("/doc/exCreditFee")
public class ExCreditFeeController {
	@Autowired
	private ExCreditFeeService exCreditFeeService;
	
	@GetMapping()
	@RequiresPermissions("doc:exCreditFee:exCreditFee")
	String ExCreditFee(){
	    return "doc/exCreditFee/exCreditFee";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("doc:exCreditFee:exCreditFee")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ExCreditFeeDO> exCreditFeeList = exCreditFeeService.list(query);
		int total = exCreditFeeService.count(query);
		PageUtils pageUtils = new PageUtils(exCreditFeeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("doc:exCreditFee:add")
	String add(){
	    return "doc/exCreditFee/add";
	}

	@GetMapping("/edit/{exCreditFeeId}")
	@RequiresPermissions("doc:exCreditFee:edit")
	String edit(@PathVariable("exCreditFeeId") Long exCreditFeeId,Model model){
		ExCreditFeeDO exCreditFee = exCreditFeeService.get(exCreditFeeId);
		model.addAttribute("exCreditFee", exCreditFee);
	    return "doc/exCreditFee/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("doc:exCreditFee:add")
	public R save( ExCreditFeeDO exCreditFee){
		if(exCreditFeeService.save(exCreditFee)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("doc:exCreditFee:edit")
	public R update( ExCreditFeeDO exCreditFee){
		exCreditFeeService.update(exCreditFee);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("doc:exCreditFee:remove")
	public R remove( Long exCreditFeeId){
		if(exCreditFeeService.remove(exCreditFeeId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("doc:exCreditFee:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] exCreditFeeIds){
		exCreditFeeService.batchRemove(exCreditFeeIds);
		return R.ok();
	}
	
}
