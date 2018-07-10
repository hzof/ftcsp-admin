package com.cloudht.im.controller;

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

import com.cloudht.im.domain.ImOrderCommodityDO;
import com.cloudht.im.service.ImOrderCommodityService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;

/**
 * 进口订单商品
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-24 10:53:43
 */
 
@Controller
@RequestMapping("/im/imOrderCommodity")
public class ImOrderCommodityController {
	@Autowired
	private ImOrderCommodityService imOrderCommodityService;
	
	@GetMapping()
	@RequiresPermissions("im:imOrderCommodity:imOrderCommodity")
	String ImOrderCommodity(){
	    return "im/imOrderCommodity/imOrderCommodity";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("im:imOrderCommodity:imOrderCommodity")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ImOrderCommodityDO> imOrderCommodityList = imOrderCommodityService.list(query);
		int total = imOrderCommodityService.count(query);
		PageUtils pageUtils = new PageUtils(imOrderCommodityList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("im:imOrderCommodity:add")
	String add(){
	    return "im/imOrderCommodity/add";
	}

	@GetMapping("/edit/{imOrderCommodityId}")
	@RequiresPermissions("im:imOrderCommodity:edit")
	String edit(@PathVariable("imOrderCommodityId") Long imOrderCommodityId,Model model){
		ImOrderCommodityDO imOrderCommodity = imOrderCommodityService.get(imOrderCommodityId);
		model.addAttribute("imOrderCommodity", imOrderCommodity);
	    return "im/imOrderCommodity/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("im:imOrderCommodity:add")
	public R save( ImOrderCommodityDO imOrderCommodity){
		if(imOrderCommodityService.save(imOrderCommodity)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("im:imOrderCommodity:edit")
	public R update( ImOrderCommodityDO imOrderCommodity){
		imOrderCommodityService.update(imOrderCommodity);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("im:imOrderCommodity:remove")
	public R remove( Long imOrderCommodityId){
		if(imOrderCommodityService.remove(imOrderCommodityId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("im:imOrderCommodity:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] imOrderCommodityIds){
		imOrderCommodityService.batchRemove(imOrderCommodityIds);
		return R.ok();
	}
	
}
