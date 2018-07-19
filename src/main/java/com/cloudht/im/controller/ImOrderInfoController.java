package com.cloudht.im.controller;

import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;
import com.cloudht.im.domain.ImOrderBaseDO;
import com.cloudht.im.service.ImOrderBaseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author：YXling Create In 10:58 2018/5/24
 */

@Controller
@RequestMapping("/im/imOrderInfo")
public class ImOrderInfoController {

    @Autowired
    private ImOrderBaseService imOrderBaseService;

    @GetMapping()
    @RequiresPermissions("im:imOrderInfo:imOrderInfo")
    String ImOrderInfo(){
        return "im/imOrderInfo/imOrderInfo";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("im:imOrderInfo:imOrderInfo")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<ImOrderBaseDO> imOrderBaseList = imOrderBaseService.list(query);
        int total = imOrderBaseService.count(query);
        PageUtils pageUtils = new PageUtils(imOrderBaseList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("im:imOrderInfo:add")
    String add(){
        return "im/imOrderBase/add";
    }

    @GetMapping("/edit/{imOrderBaseId}")
    @RequiresPermissions("im:imOrderInfo:edit")
    String edit(@PathVariable("imOrderBaseId") Long imOrderBaseId,Model model){
        ImOrderBaseDO imOrderBase = imOrderBaseService.get(imOrderBaseId);
        model.addAttribute("imOrderBase", imOrderBase);
        return "im/imOrderBase/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("im:imOrderInfo:add")
    public R save( ImOrderBaseDO imOrderBase){
        if(imOrderBaseService.save(imOrderBase)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("im:imOrderInfo:edit")
    public R update( ImOrderBaseDO imOrderBase){
        imOrderBaseService.update(imOrderBase);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("im:imOrderInfo:remove")
    public R remove(Long imOrderBaseId){
        if(imOrderBaseService.remove(imOrderBaseId)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("im:imOrderInfo:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] imOrderBaseIds){
        imOrderBaseService.batchRemove(imOrderBaseIds);
        return R.ok();
    }
}
