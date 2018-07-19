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

import com.cloudht.ex.domain.OrderServiceDO;
import com.cloudht.ex.service.OrderServiceService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 出口订单服务
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-18 11:36:14
 */
 
@Controller
@RequestMapping("/ex/orderService")
public class OrderServiceController {
	@Autowired
	private OrderServiceService orderServiceService;
	
	@GetMapping()
	@RequiresPermissions("ex:orderService:orderService")
	String OrderService(){
	    return "ex/orderService/orderService";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ex:orderService:orderService")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OrderServiceDO> orderServiceList = orderServiceService.list(query);
		int total = orderServiceService.count(query);
		PageUtils pageUtils = new PageUtils(orderServiceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ex:orderService:add")
	String add(){
	    return "ex/orderService/add";
	}

	@GetMapping("/edit/{exOrderServiceId}")
	@RequiresPermissions("ex:orderService:edit")
	String edit(@PathVariable("exOrderServiceId") Integer exOrderServiceId,Model model){
		OrderServiceDO orderService = orderServiceService.get(exOrderServiceId);
		model.addAttribute("orderService", orderService);
	    return "ex/orderService/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ex:orderService:add")
	public R save( OrderServiceDO orderService){
		if(orderServiceService.save(orderService)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ex:orderService:edit")
	public R update( OrderServiceDO orderService){
		orderServiceService.update(orderService);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ex:orderService:remove")
	public R remove( Integer exOrderServiceId){
		if(orderServiceService.remove(exOrderServiceId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ex:orderService:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] exOrderServiceIds){
		orderServiceService.batchRemove(exOrderServiceIds);
		return R.ok();
	}
	
}
