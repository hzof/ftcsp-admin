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

import com.cloudht.doc.domain.ExShipOrderCommodityDO;
import com.cloudht.doc.service.ExShipOrderCommodityService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;

/**
 * 托单商品
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-25 15:42:53
 */
 
@Controller
@RequestMapping("/doc/exShipOrderCommodity")
public class ExShipOrderCommodityController {
	@Autowired
	private ExShipOrderCommodityService exShipOrderCommodityService;
	
	@GetMapping()
	@RequiresPermissions("doc:exShipOrderCommodity:exShipOrderCommodity")
	String ExShipOrderCommodity(){
	    return "doc/exShipOrderCommodity/exShipOrderCommodity";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("doc:exShipOrderCommodity:exShipOrderCommodity")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ExShipOrderCommodityDO> exShipOrderCommodityList = exShipOrderCommodityService.list(query);
		int total = exShipOrderCommodityService.count(query);
		PageUtils pageUtils = new PageUtils(exShipOrderCommodityList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("doc:exShipOrderCommodity:add")
	String add(){
	    return "doc/exShipOrderCommodity/add";
	}

	@GetMapping("/edit/{exShipOrderCommodityId}")
	@RequiresPermissions("doc:exShipOrderCommodity:edit")
	String edit(@PathVariable("exShipOrderCommodityId") Long exShipOrderCommodityId,Model model){
		ExShipOrderCommodityDO exShipOrderCommodity = exShipOrderCommodityService.get(exShipOrderCommodityId);
		model.addAttribute("exShipOrderCommodity", exShipOrderCommodity);
	    return "doc/exShipOrderCommodity/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("doc:exShipOrderCommodity:add")
	public R save( ExShipOrderCommodityDO exShipOrderCommodity){
		if(exShipOrderCommodityService.save(exShipOrderCommodity)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("doc:exShipOrderCommodity:edit")
	public R update( ExShipOrderCommodityDO exShipOrderCommodity){
		exShipOrderCommodityService.update(exShipOrderCommodity);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("doc:exShipOrderCommodity:remove")
	public R remove( Long exShipOrderCommodityId){
		if(exShipOrderCommodityService.remove(exShipOrderCommodityId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("doc:exShipOrderCommodity:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] exShipOrderCommodityIds){
		exShipOrderCommodityService.batchRemove(exShipOrderCommodityIds);
		return R.ok();
	}
	
}
