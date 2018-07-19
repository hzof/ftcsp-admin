package com.cloudht.doc.controller;

import com.cloudht.doc.domain.ExOrderOperationDO;
import com.cloudht.doc.service.ExOrderOperationService;
import com.cloudht.ex.domain.OrderHeaderDO;
import com.cloudht.ex.service.OrderHeaderService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author：YXling Create In 15:46 2018/5/25
 */
@Controller
@RequestMapping("/doc/exOrderOperation")
public class ExOrderOperationController {
    @Autowired
    private ExOrderOperationService exOrderOperationService;

    @Autowired
    private OrderHeaderService orderHeaderService;

    @GetMapping()
    @RequiresPermissions("doc:exOrderOperation:exOrderOperation")
    String exOrderOperation(){
        return "doc/exOrderOperation/exOrderOperation";
    }


    @ResponseBody
    @GetMapping("/orderList")
    @RequiresPermissions("ex:exOrderOperation:orderList")
    public PageUtils orderList(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<OrderHeaderDO> orderHeaderList = orderHeaderService.list(query);
        int total = orderHeaderService.count(query);
        PageUtils pageUtils = new PageUtils(orderHeaderList, total);
        return pageUtils;
    }


    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("doc:exOrderOperation:exOrderOperation")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<ExOrderOperationDO> exOrderOperationList = exOrderOperationService.list(query);
        int total = exOrderOperationService.count(query);
        PageUtils pageUtils = new PageUtils(exOrderOperationList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("doc:exOrderOperation:add")
    String add(){
        return "doc/exOrderOperation/add";
    }

    @GetMapping("/edit/{exOrderOperationId}")
    @RequiresPermissions("doc:exOrderOperation:edit")
    String edit(@PathVariable("exOrderOperationId") Long exOrderOperationId,Model model){
        ExOrderOperationDO exOrderOperation = exOrderOperationService.get(exOrderOperationId);
        model.addAttribute("exOrderOperation", exOrderOperation);
        return "doc/exOrderOperation/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("doc:exOrderOperation:add")
    public R save( ExOrderOperationDO exOrderOperation){
        if(exOrderOperationService.save(exOrderOperation)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("doc:exOrderOperation:edit")
    public R update( ExOrderOperationDO exOrderOperation){
        exOrderOperationService.update(exOrderOperation);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("doc:exOrderOperation:remove")
    public R remove(Long exOrderOperationId){
        if(exOrderOperationService.remove(exOrderOperationId)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("doc:exOrderOperation:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] exOrderOperationIds){
        exOrderOperationService.batchRemove(exOrderOperationIds);
        return R.ok();
    }

}
