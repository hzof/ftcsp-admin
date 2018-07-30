package com.cloudht.ex.controller;

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

import com.cloudht.ex.domain.ExOrderCommodityDO;
import com.cloudht.ex.service.ExOrderCommodityService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 出口订单商品
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-07-26 15:49:12
 */
 
@Controller
@RequestMapping("/ex/exOrderCommodity")
public class ExOrderCommodityController {
	@Autowired
	private ExOrderCommodityService exOrderCommodityService;
	
	@GetMapping()
	@RequiresPermissions("ex:exOrderCommodity:exOrderCommodity")
	String ExOrderCommodity(){
	    return "ex/exOrderCommodity/exOrderCommodity";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ex:exOrder:exOrder")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ExOrderCommodityDO> exOrderCommodityList = exOrderCommodityService.list(query);
		int total = exOrderCommodityService.count(query);
		PageUtils pageUtils = new PageUtils(exOrderCommodityList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ex:exOrderCommodity:add")
	String add(){
	    return "ex/exOrderCommodity/add";
	}

	@GetMapping("/edit/{exOrderCommodityId}")
	@RequiresPermissions("ex:exOrderCommodity:edit")
	String edit(@PathVariable("exOrderCommodityId") Long exOrderCommodityId,Model model){
		ExOrderCommodityDO exOrderCommodity = exOrderCommodityService.get(exOrderCommodityId);
		model.addAttribute("exOrderCommodity", exOrderCommodity);
	    return "ex/exOrderCommodity/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ex:exOrderCommodity:add")
	public R save( ExOrderCommodityDO exOrderCommodity){
		if(exOrderCommodityService.save(exOrderCommodity)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ex:exOrderCommodity:edit")
	public R update( ExOrderCommodityDO exOrderCommodity){
		exOrderCommodityService.update(exOrderCommodity);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ex:exOrderCommodity:remove")
	public R remove( Long exOrderCommodityId){
		if(exOrderCommodityService.remove(exOrderCommodityId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ex:exOrderCommodity:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] exOrderCommodityIds){
		exOrderCommodityService.batchRemove(exOrderCommodityIds);
		return R.ok();
	}
	
}
