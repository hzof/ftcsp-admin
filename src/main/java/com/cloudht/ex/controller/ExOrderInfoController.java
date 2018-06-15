package com.cloudht.ex.controller;

import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;
import com.cloudht.ex.domain.OrderHeaderDO;
import com.cloudht.ex.service.OrderHeaderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @Author：YXling Create In 11:40 2018/5/18
 */
@Controller
@RequestMapping("/ex/orderInfo")
public class ExOrderInfoController {

    @Autowired
    private OrderHeaderService orderHeaderService;

    @GetMapping()
    @RequiresPermissions("ex:orderInfo:orderInfo")
    String OrderInfo(){
        return "ex/orderInfo/orderInfo";
    }

    /**
     * 代理下单，待受理订单，待专家处理订单，已完成订单页面列表请求
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("ex:orderInfo:orderInfo")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<OrderHeaderDO> orderHeaderList = orderHeaderService.list(query);
        int total = orderHeaderService.count(query);
        PageUtils pageUtils = new PageUtils(orderHeaderList, total);
        return pageUtils;
    }
    
    /**
     *   订单中心-出口订单-代理下单页面点击提交订单按钮后跳转到信息确认页面
     *         
     * @return 跳转到信息确认页面视图
     */
    @GetMapping("/submitOrder/{exOrderHeaderId}")
    @RequiresPermissions("ex:orderInfo:edit")
    String submitOrder(@PathVariable("exOrderHeaderId") Long exOrderHeaderId, Model model){
        OrderHeaderDO orderHeader = orderHeaderService.get(exOrderHeaderId);
        model.addAttribute("orderHeader", orderHeader);
        return "ex/orderInfo/submitOrder";
    }
 
    @GetMapping("/add")
    @RequiresPermissions("ex:orderInfo:add")
    String add(){
        return "ex/orderInfo/add";
    }

    @GetMapping("/edit/{exOrderHeaderId}")
    @RequiresPermissions("ex:orderInfo:edit")
    String edit(@PathVariable("exOrderHeaderId") Long exOrderHeaderId, Model model){
        OrderHeaderDO orderHeader = orderHeaderService.get(exOrderHeaderId);
        model.addAttribute("orderHeader", orderHeader);
        return "ex/orderInfo/edit";
    }
    /**
     * “受理订单”负责跳转到受理订单信息确认页面
     * @author Hzof
     */
    @GetMapping("/admissibleOrder/{exOrderHeaderId}")
    public String acceptance(@PathVariable("exOrderHeaderId") Long exOrderHeaderId, Model model) {
    	OrderHeaderDO orderHeader = orderHeaderService.get(exOrderHeaderId);
    	model.addAttribute("orderHeader",orderHeader);
    	return "ex/orderInfo/admissibleOrder";//跳转到受理订单的信息确认页面
    }
    
    /**
     * 代理下出口订单的保存
     */
    @ResponseBody
    @PostMapping("/proxyExOrderSave")
    @RequiresPermissions("ex:orderInfo:add")
    public R save(OrderHeaderDO orderHeader){
    	System.out.println(orderHeader.toString());
        if(orderHeaderService.save(orderHeader)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("ex:orderInfo:edit")
    public R update( OrderHeaderDO orderHeader){
        orderHeaderService.update(orderHeader);
        return R.ok();
    }
    
    /**
     * url:/ex/orderInfo/commodity
     * 给待受理的订单添加商品信息
     * @return
     */
    @GetMapping("/commodity/{exOrderHeaderId}")
    @RequiresPermissions("ex:orderInfo:commodity")
    String commodity(@PathVariable("exOrderHeaderId") Long exOrderHeaderId,Model model){
    	OrderHeaderDO orderHeaderDO = orderHeaderService.get(exOrderHeaderId);
    	
        return "ex/orderInfo/commodity";
    }
    @RequestMapping("/orderInfoExpert")
    public String orderInfoExpert() {
    	return "ex/orderInfo/orderInfoExpert";
    }
    @RequestMapping("/orderInfoWait")
    public String orderInfoWait() {
    	return "ex/orderInfo/orderInfoWait";
    }
    @RequestMapping("/orderInfoFinish")
    public String orderInfoFinish() {
    	return "ex/orderInfo/orderInfoFinish";
    }
}
