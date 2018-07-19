package com.cloudht.ex.controller;



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

import com.cloudht.ex.domain.OrderHeaderDO;
import com.cloudht.ex.service.OrderHeaderService;
import com.sxyht.common.utils.R;

/**
 * 出口订单头信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-18 11:36:14
 */
 
@Controller
@RequestMapping("/ex/orderHeader")
public class OrderHeaderController {
	@Autowired
	private OrderHeaderService orderHeaderService;


//	@ResponseBody
//	@GetMapping("/list")
//	@RequiresPermissions("ex:orderHeader:orderHeader")
//	public PageUtils list(@RequestParam Map<String, Object> params){
//		//查询列表数据
//        Query query = new Query(params);
//		List<OrderHeaderDO> orderHeaderList = orderHeaderService.list(query);
//		int total = orderHeaderService.count(query);
//		PageUtils pageUtils = new PageUtils(orderHeaderList, total);
//		return pageUtils;
//	}
	
	@GetMapping("/add")
//	@RequiresPermissions("ex:orderHeader:add")
	String add(){
	    return "ex/orderHeader/add";
	}

	@GetMapping("/edit/{exOrderHeaderId}")
	@RequiresPermissions("ex:orderHeader:edit")
	String edit(@PathVariable("exOrderHeaderId") Long exOrderHeaderId,Model model){
		OrderHeaderDO orderHeader = orderHeaderService.get(exOrderHeaderId);
		model.addAttribute("orderHeader", orderHeader);
	    return "ex/orderHeader/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
//	@RequiresPermissions("ex:orderHeader:add")
	public void save( @RequestBody OrderHeaderDO orderHeader){
		///ex/orderHeader/save
//		if(orderHeaderService.save(orderHeader)>0){
//			return R.ok();
//		}
		System.out.printf(orderHeader.toString());
		//return R.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ex:orderHeader:edit")
	public R update( OrderHeaderDO orderHeader){
		orderHeaderService.update(orderHeader);
		return R.ok();
	}

	/**
	 * 删除/ex/orderHeader/remove
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ex:orderHeader:remove")
	public R remove( Long exOrderHeaderId){
		if(orderHeaderService.remove(exOrderHeaderId)>0){
		return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ex:orderHeader:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] exOrderHeaderIds){
		orderHeaderService.batchRemove(exOrderHeaderIds);
		return R.ok();
	}

}
