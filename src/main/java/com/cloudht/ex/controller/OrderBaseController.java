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

import com.cloudht.ex.domain.OrderBaseDO;
import com.cloudht.ex.service.OrderBaseService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 出口订单基本信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-18 11:36:14
 */
 
@Controller
@RequestMapping("/ex/orderBase")
public class OrderBaseController {
	@Autowired
	private OrderBaseService orderBaseService;
	
	@GetMapping()
	@RequiresPermissions("ex:orderBase:orderBase")
	String OrderBase(){
	    return "ex/orderBase/orderBase";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ex:orderBase:orderBase")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OrderBaseDO> orderBaseList = orderBaseService.list(query);
		int total = orderBaseService.count(query);
		PageUtils pageUtils = new PageUtils(orderBaseList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ex:orderBase:add")
	String add(){
	    return "ex/orderBase/add";
	}

	@GetMapping("/edit/{exOrderBaseId}")
	@RequiresPermissions("ex:orderBase:edit")
	String edit(@PathVariable("exOrderBaseId") Long exOrderBaseId,Model model){
		OrderBaseDO orderBase = orderBaseService.get(exOrderBaseId);
		model.addAttribute("orderBase", orderBase);
	    return "ex/orderBase/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ex:orderBase:add")
	public R save( OrderBaseDO orderBase){
		if(orderBaseService.save(orderBase)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ex:orderBase:edit")
	public R update( OrderBaseDO orderBase){
		orderBaseService.update(orderBase);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ex:orderBase:remove")
	public R remove( Long exOrderBaseId){
		if(orderBaseService.remove(exOrderBaseId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ex:orderBase:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] exOrderBaseIds){
		orderBaseService.batchRemove(exOrderBaseIds);
		return R.ok();
	}
	
}
