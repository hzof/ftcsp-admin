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

import com.cloudht.ft.domain.FtInspectionCommodityDO;
import com.cloudht.ft.service.FtInspectionCommodityService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 查验商品
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-24 16:41:47
 */
 
@Controller
@RequestMapping("/ft/ftInspectionCommodity")
public class FtInspectionCommodityController {
	@Autowired
	private FtInspectionCommodityService ftInspectionCommodityService;
	
	@GetMapping()
	@RequiresPermissions("ft:ftInspectionCommodity:ftInspectionCommodity")
	String FtInspectionCommodity(){
	    return "ft/ftInspectionCommodity/ftInspectionCommodity";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ft:ftInspectionCommodity:ftInspectionCommodity")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FtInspectionCommodityDO> ftInspectionCommodityList = ftInspectionCommodityService.list(query);
		int total = ftInspectionCommodityService.count(query);
		PageUtils pageUtils = new PageUtils(ftInspectionCommodityList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ft:ftInspectionCommodity:add")
	String add(){
	    return "ft/ftInspectionCommodity/add";
	}

	@GetMapping("/edit/{ftInspectionCommodityId}")
	@RequiresPermissions("ft:ftInspectionCommodity:edit")
	String edit(@PathVariable("ftInspectionCommodityId") Integer ftInspectionCommodityId,Model model){
		FtInspectionCommodityDO ftInspectionCommodity = ftInspectionCommodityService.get(ftInspectionCommodityId);
		model.addAttribute("ftInspectionCommodity", ftInspectionCommodity);
	    return "ft/ftInspectionCommodity/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ft:ftInspectionCommodity:add")
	public R save( FtInspectionCommodityDO ftInspectionCommodity){
		if(ftInspectionCommodityService.save(ftInspectionCommodity)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ft:ftInspectionCommodity:edit")
	public R update( FtInspectionCommodityDO ftInspectionCommodity){
		ftInspectionCommodityService.update(ftInspectionCommodity);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ft:ftInspectionCommodity:remove")
	public R remove( Integer ftInspectionCommodityId){
		if(ftInspectionCommodityService.remove(ftInspectionCommodityId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ft:ftInspectionCommodity:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ftInspectionCommodityIds){
		ftInspectionCommodityService.batchRemove(ftInspectionCommodityIds);
		return R.ok();
	}
	
}
