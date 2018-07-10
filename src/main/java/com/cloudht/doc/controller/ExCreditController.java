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

import com.cloudht.doc.domain.ExCreditDO;
import com.cloudht.doc.service.ExCreditService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;

/**
 * 信用证
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-25 15:42:52
 */
 
@Controller
@RequestMapping("/doc/exCredit")
public class ExCreditController {
	@Autowired
	private ExCreditService exCreditService;
	
	@GetMapping()
	@RequiresPermissions("doc:exCredit:exCredit")
	String ExCredit(){
	    return "doc/exCredit/exCredit";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("doc:exCredit:exCredit")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ExCreditDO> exCreditList = exCreditService.list(query);
		int total = exCreditService.count(query);
		PageUtils pageUtils = new PageUtils(exCreditList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("doc:exCredit:add")
	String add(){
	    return "doc/exCredit/add";
	}

	@GetMapping("/edit/{exCreditId}")
	@RequiresPermissions("doc:exCredit:edit")
	String edit(@PathVariable("exCreditId") Long exCreditId,Model model){
		ExCreditDO exCredit = exCreditService.get(exCreditId);
		model.addAttribute("exCredit", exCredit);
	    return "doc/exCredit/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("doc:exCredit:add")
	public R save( ExCreditDO exCredit){
		if(exCreditService.save(exCredit)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("doc:exCredit:edit")
	public R update( ExCreditDO exCredit){
		exCreditService.update(exCredit);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("doc:exCredit:remove")
	public R remove( Long exCreditId){
		if(exCreditService.remove(exCreditId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("doc:exCredit:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] exCreditIds){
		exCreditService.batchRemove(exCreditIds);
		return R.ok();
	}
	
}
