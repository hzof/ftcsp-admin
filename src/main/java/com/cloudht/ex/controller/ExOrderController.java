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
import com.cloudht.ex.domain.ExOrderDO;
import com.cloudht.ex.service.ExOrderCommodityService;
import com.cloudht.ex.service.ExOrderService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;

/**
 * 出口订单
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-15 10:31:08
 */
 
@Controller
@RequestMapping("/ex/exOrder")
public class ExOrderController {
	@Autowired
	private ExOrderService exOrderService;
	@Autowired
	private ExOrderCommodityService exOrderCommodityService;
	
	@GetMapping()
	@RequiresPermissions("ex:exOrder:exOrder")
	String ExOrder(){
	    return "ex/exOrder/exOrder";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ex:exOrder:exOrder")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ExOrderDO> exOrderList = exOrderService.list(query);
		int total = exOrderService.count(query);
		PageUtils pageUtils = new PageUtils(exOrderList, total);
		return pageUtils;
	}
	/**
	 * 跳转到添加订单页面
	 * /ex/exOrder/add
	 * @return
	 */
	@GetMapping("/add")
	@RequiresPermissions("ex:exOrder:add")
	String add(){
	    return "ex/exOrder/add";
	}

	/**
	 * 跳转到修改订单页面
	 * /ex/exOrder/edit/{exOrderId}
	 * @param exOrderId 要修改订单的主键id
	 */
	@GetMapping("/edit/{exOrderId}")
	@RequiresPermissions("ex:exOrder:edit")
	String edit(@PathVariable("exOrderId") Long exOrderId,Model model){
		ExOrderDO exOrder = exOrderService.get(exOrderId);
		model.addAttribute("exOrder", exOrder);
	    return "ex/exOrder/edit";
	}
	/**
	 * @param exOrderId 订单表主键
	 * @return 为订单表添加商品的页面
	 */
	@GetMapping("/addCommodity/{exOrderId}")
	@RequiresPermissions("ex:exOrder:edit")
	public String addCommodity(@PathVariable("exOrderId") Long exOrderId,Model model) {
		model.addAttribute("exOrderId",exOrderId);
		return "ex/exOrder/addCommodity";
	}
	/**
	 * 保存为订单添加的商品信息
	 * @param exOrderCommodity 订单商品对象
	 * @return 返回成功或错误提示
	 */
	@ResponseBody
	@PostMapping("/addCommoditysave")
	@RequiresPermissions("ex:exOrder:add")
	public R addCommoditysave(ExOrderCommodityDO exOrderCommodity) {
		if(exOrderCommodityService.save(exOrderCommodity)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 跳转到待受理订单页面/ex/exOrder/exOrderWait
	 */
	@GetMapping("/exOrderWait")
	public String wait0() {
		return "ex/exOrder/exOrderWait";
	}
	/**
	 * 跳转到已受理订单页面/ex/exOrder/exOrderFinish
	 */
	@GetMapping("/exOrderFinish")
	public String finish() {
		return "ex/exOrder//exOrderFinish";
	}
	/**
	 * 跳转到待专家受理订单页面/ex/exOrder/exOrderExpert
	 */
	@GetMapping("/exOrderExpert")
	public String expert() {
		return "ex/exOrder/exOrderExpert";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ex:exOrder:add")
	public R save( ExOrderDO exOrder){
		if(exOrderService.save(exOrder)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ex:exOrder:edit")
	public R update( ExOrderDO exOrder){
		exOrderService.update(exOrder);
		return R.ok();
	}
	
	/**
	 * 删除/ex/exOrder/remove
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ex:exOrder:remove")
	public R remove( Long exOrderId){
		if(exOrderService.remove(exOrderId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除/ex/exOrder/batchRemove
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ex:exOrder:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] exOrderIds){
		exOrderService.batchRemove(exOrderIds);
		return R.ok();
	}
	
}
