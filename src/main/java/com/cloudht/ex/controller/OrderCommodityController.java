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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudht.ex.domain.OrderCommodityDO;
import com.cloudht.ex.service.OrderCommodityService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;

/**
 * 出口订单商品
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-18 11:36:14
 */
 
@Controller
@RequestMapping("/ex/orderCommodity")
public class OrderCommodityController {
	@Autowired
	private OrderCommodityService orderCommodityService;
	
	@GetMapping()
	@RequiresPermissions("ex:orderCommodity:orderCommodity")
	String OrderCommodity(){
	    return "ex/orderCommodity/orderCommodity";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ex:orderCommodity:orderCommodity")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OrderCommodityDO> orderCommodityList = orderCommodityService.list(query);
		int total = orderCommodityService.count(query);
		PageUtils pageUtils = new PageUtils(orderCommodityList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ex:orderCommodity:add")
	String add(){
	    return "ex/orderCommodity/add";
	}

	@GetMapping("/edit/{exOrderCommodityId}")
	@RequiresPermissions("ex:orderCommodity:edit")
	String edit(@PathVariable("exOrderCommodityId") Long exOrderCommodityId,Model model){
		OrderCommodityDO orderCommodity = orderCommodityService.get(exOrderCommodityId);
		model.addAttribute("orderCommodity", orderCommodity);
	    return "ex/orderCommodity/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ex:orderCommodity:add")
	public R save( OrderCommodityDO orderCommodity){
		if(orderCommodityService.save(orderCommodity)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ex:orderCommodity:edit")
	public R update( OrderCommodityDO orderCommodity){
		orderCommodityService.update(orderCommodity);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ex:orderCommodity:remove")
	public R remove( Long exOrderCommodityId){
		if(orderCommodityService.remove(exOrderCommodityId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ex:orderCommodity:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] exOrderCommodityIds){
		orderCommodityService.batchRemove(exOrderCommodityIds);
		return R.ok();
	}
	
}
