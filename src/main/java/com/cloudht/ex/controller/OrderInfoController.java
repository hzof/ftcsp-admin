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
public class OrderInfoController {

    @Autowired
    private OrderHeaderService orderHeaderService;

    @GetMapping()
    @RequiresPermissions("ex:orderInfo:orderInfo")
    String OrderInfo(){
        return "ex/orderInfo/orderInfo";
    }

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
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("ex:orderInfo:add")
    public R save(OrderHeaderDO orderHeader){
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

    @GetMapping("/commodity")
    @RequiresPermissions("ex:orderInfo:commodity")
    String commodity(){
        return "ex/orderInfo/commodity";
    }
    /**
     * 待专家受理订单
     */
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
