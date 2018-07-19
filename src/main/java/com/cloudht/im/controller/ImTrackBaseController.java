package com.cloudht.im.controller;

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

import com.cloudht.im.domain.ImTrackBaseDO;
import com.cloudht.im.service.ImTrackBaseService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 通关跟踪单
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-24 10:53:43
 */
 
@Controller
@RequestMapping("/im/imTrackBase")
public class ImTrackBaseController {
	@Autowired
	private ImTrackBaseService imTrackBaseService;
	
	@GetMapping()
	@RequiresPermissions("im:imTrackBase:imTrackBase")
	String ImTrackBase(){
	    return "im/imTrackBase/imTrackBase";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("im:imTrackBase:imTrackBase")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ImTrackBaseDO> imTrackBaseList = imTrackBaseService.list(query);
		int total = imTrackBaseService.count(query);
		PageUtils pageUtils = new PageUtils(imTrackBaseList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("im:imTrackBase:add")
	String add(){
	    return "im/imTrackBase/add";
	}

	@GetMapping("/edit/{imTrackBaseId}")
	@RequiresPermissions("im:imTrackBase:edit")
	String edit(@PathVariable("imTrackBaseId") Long imTrackBaseId,Model model){
		ImTrackBaseDO imTrackBase = imTrackBaseService.get(imTrackBaseId);
		model.addAttribute("imTrackBase", imTrackBase);
	    return "im/imTrackBase/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("im:imTrackBase:add")
	public R save( ImTrackBaseDO imTrackBase){
		if(imTrackBaseService.save(imTrackBase)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("im:imTrackBase:edit")
	public R update( ImTrackBaseDO imTrackBase){
		imTrackBaseService.update(imTrackBase);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("im:imTrackBase:remove")
	public R remove( Long imTrackBaseId){
		if(imTrackBaseService.remove(imTrackBaseId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("im:imTrackBase:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] imTrackBaseIds){
		imTrackBaseService.batchRemove(imTrackBaseIds);
		return R.ok();
	}
	
}
