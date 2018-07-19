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

import com.cloudht.ex.domain.OrderConfirmDO;
import com.cloudht.ex.service.OrderConfirmService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 出口订单确认信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-18 11:36:14
 */
 
@Controller
@RequestMapping("/ex/orderConfirm")
public class OrderConfirmController {
	@Autowired
	private OrderConfirmService orderConfirmService;
	
	@GetMapping()
	@RequiresPermissions("ex:orderConfirm:orderConfirm")
	String OrderConfirm(){
	    return "ex/orderConfirm/orderConfirm";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ex:orderConfirm:orderConfirm")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OrderConfirmDO> orderConfirmList = orderConfirmService.list(query);
		int total = orderConfirmService.count(query);
		PageUtils pageUtils = new PageUtils(orderConfirmList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ex:orderConfirm:add")
	String add(){
	    return "ex/orderConfirm/add";
	}

	@GetMapping("/edit/{exOrderConfirmId}")
	@RequiresPermissions("ex:orderConfirm:edit")
	String edit(@PathVariable("exOrderConfirmId") Long exOrderConfirmId,Model model){
		OrderConfirmDO orderConfirm = orderConfirmService.get(exOrderConfirmId);
		model.addAttribute("orderConfirm", orderConfirm);
	    return "ex/orderConfirm/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ex:orderConfirm:add")
	public R save( OrderConfirmDO orderConfirm){
		if(orderConfirmService.save(orderConfirm)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ex:orderConfirm:edit")
	public R update( OrderConfirmDO orderConfirm){
		orderConfirmService.update(orderConfirm);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ex:orderConfirm:remove")
	public R remove( Long exOrderConfirmId){
		if(orderConfirmService.remove(exOrderConfirmId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ex:orderConfirm:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] exOrderConfirmIds){
		orderConfirmService.batchRemove(exOrderConfirmIds);
		return R.ok();
	}
	
}
