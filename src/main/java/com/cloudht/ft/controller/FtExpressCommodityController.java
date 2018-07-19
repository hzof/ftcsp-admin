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

import com.cloudht.ft.domain.FtExpressCommodityDO;
import com.cloudht.ft.service.FtExpressCommodityService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 快件商品
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-24 16:41:46
 */
 
@Controller
@RequestMapping("/ft/ftExpressCommodity")
public class FtExpressCommodityController {
	@Autowired
	private FtExpressCommodityService ftExpressCommodityService;
	
	@GetMapping()
	@RequiresPermissions("ft:ftExpressCommodity:ftExpressCommodity")
	String FtExpressCommodity(){
	    return "ft/ftExpressCommodity/ftExpressCommodity";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ft:ftExpressCommodity:ftExpressCommodity")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FtExpressCommodityDO> ftExpressCommodityList = ftExpressCommodityService.list(query);
		int total = ftExpressCommodityService.count(query);
		PageUtils pageUtils = new PageUtils(ftExpressCommodityList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ft:ftExpressCommodity:add")
	String add(){
	    return "ft/ftExpressCommodity/add";
	}

	@GetMapping("/edit/{ftExpressCommodityId}")
	@RequiresPermissions("ft:ftExpressCommodity:edit")
	String edit(@PathVariable("ftExpressCommodityId") Long ftExpressCommodityId,Model model){
		FtExpressCommodityDO ftExpressCommodity = ftExpressCommodityService.get(ftExpressCommodityId);
		model.addAttribute("ftExpressCommodity", ftExpressCommodity);
	    return "ft/ftExpressCommodity/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ft:ftExpressCommodity:add")
	public R save( FtExpressCommodityDO ftExpressCommodity){
		if(ftExpressCommodityService.save(ftExpressCommodity)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ft:ftExpressCommodity:edit")
	public R update( FtExpressCommodityDO ftExpressCommodity){
		ftExpressCommodityService.update(ftExpressCommodity);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ft:ftExpressCommodity:remove")
	public R remove( Long ftExpressCommodityId){
		if(ftExpressCommodityService.remove(ftExpressCommodityId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ft:ftExpressCommodity:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ftExpressCommodityIds){
		ftExpressCommodityService.batchRemove(ftExpressCommodityIds);
		return R.ok();
	}
	
}
