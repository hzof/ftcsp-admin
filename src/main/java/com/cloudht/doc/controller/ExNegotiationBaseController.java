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

import com.cloudht.doc.domain.ExNegotiationBaseDO;
import com.cloudht.doc.service.ExNegotiationBaseService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 议付信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-25 15:42:53
 */
 
@Controller
@RequestMapping("/doc/exNegotiationBase")
public class ExNegotiationBaseController {
	@Autowired
	private ExNegotiationBaseService exNegotiationBaseService;
	
	@GetMapping()
	@RequiresPermissions("doc:exNegotiationBase:exNegotiationBase")
	String ExNegotiationBase(){
	    return "doc/exNegotiationBase/exNegotiationBase";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("doc:exNegotiationBase:exNegotiationBase")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ExNegotiationBaseDO> exNegotiationBaseList = exNegotiationBaseService.list(query);
		int total = exNegotiationBaseService.count(query);
		PageUtils pageUtils = new PageUtils(exNegotiationBaseList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("doc:exNegotiationBase:add")
	String add(){
	    return "doc/exNegotiationBase/add";
	}

	@GetMapping("/edit/{exNegotiationBaseId}")
	@RequiresPermissions("doc:exNegotiationBase:edit")
	String edit(@PathVariable("exNegotiationBaseId") Long exNegotiationBaseId,Model model){
		ExNegotiationBaseDO exNegotiationBase = exNegotiationBaseService.get(exNegotiationBaseId);
		model.addAttribute("exNegotiationBase", exNegotiationBase);
	    return "doc/exNegotiationBase/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("doc:exNegotiationBase:add")
	public R save( ExNegotiationBaseDO exNegotiationBase){
		if(exNegotiationBaseService.save(exNegotiationBase)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("doc:exNegotiationBase:edit")
	public R update( ExNegotiationBaseDO exNegotiationBase){
		exNegotiationBaseService.update(exNegotiationBase);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("doc:exNegotiationBase:remove")
	public R remove( Long exNegotiationBaseId){
		if(exNegotiationBaseService.remove(exNegotiationBaseId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("doc:exNegotiationBase:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] exNegotiationBaseIds){
		exNegotiationBaseService.batchRemove(exNegotiationBaseIds);
		return R.ok();
	}
	
}
