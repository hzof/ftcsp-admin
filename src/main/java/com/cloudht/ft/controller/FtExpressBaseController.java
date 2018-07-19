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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudht.ft.domain.FtExpressBaseDO;
import com.cloudht.ft.service.FtExpressBaseService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 快件信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-24 16:41:45
 */
 
@Controller
@RequestMapping("/ft/ftExpressBase")
public class FtExpressBaseController {
	@Autowired
	private FtExpressBaseService ftExpressBaseService;
	
	@GetMapping()
	@RequiresPermissions("ft:ftExpressBase:ftExpressBase")
	String FtExpressBase(){
	    return "ft/ftExpressBase/ftExpressBase";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ft:ftExpressBase:ftExpressBase")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FtExpressBaseDO> ftExpressBaseList = ftExpressBaseService.list(query);
		int total = ftExpressBaseService.count(query);
		PageUtils pageUtils = new PageUtils(ftExpressBaseList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ft:ftExpressBase:add")
	String add(){
	    return "ft/ftExpressBase/add";
	}

	@GetMapping("/edit/{ftExpressBaseId}")
	@RequiresPermissions("ft:ftExpressBase:edit")
	String edit(@PathVariable("ftExpressBaseId") Long ftExpressBaseId,Model model){
		FtExpressBaseDO ftExpressBase = ftExpressBaseService.get(ftExpressBaseId);
		model.addAttribute("ftExpressBase", ftExpressBase);
	    return "ft/ftExpressBase/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ft:ftExpressBase:add")
	public R save( FtExpressBaseDO ftExpressBase){
		if(ftExpressBaseService.save(ftExpressBase)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ft:ftExpressBase:edit")
	public R update( FtExpressBaseDO ftExpressBase){
		ftExpressBaseService.update(ftExpressBase);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ft:ftExpressBase:remove")
	public R remove( Long ftExpressBaseId){
		if(ftExpressBaseService.remove(ftExpressBaseId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ft:ftExpressBase:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ftExpressBaseIds){
		ftExpressBaseService.batchRemove(ftExpressBaseIds);
		return R.ok();
	}
	
}
