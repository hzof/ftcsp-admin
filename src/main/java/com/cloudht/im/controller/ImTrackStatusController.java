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

import com.cloudht.im.domain.ImTrackStatusDO;
import com.cloudht.im.service.ImTrackStatusService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;

/**
 * 通关跟踪状态
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-24 10:53:43
 */
 
@Controller
@RequestMapping("/im/imTrackStatus")
public class ImTrackStatusController {
	@Autowired
	private ImTrackStatusService imTrackStatusService;
	
	@GetMapping()
	@RequiresPermissions("im:imTrackStatus:imTrackStatus")
	String ImTrackStatus(){
	    return "im/imTrackStatus/imTrackStatus";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("im:imTrackStatus:imTrackStatus")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ImTrackStatusDO> imTrackStatusList = imTrackStatusService.list(query);
		int total = imTrackStatusService.count(query);
		PageUtils pageUtils = new PageUtils(imTrackStatusList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("im:imTrackStatus:add")
	String add(){
	    return "im/imTrackStatus/add";
	}

	@GetMapping("/edit/{imTrackStatusId}")
	@RequiresPermissions("im:imTrackStatus:edit")
	String edit(@PathVariable("imTrackStatusId") Long imTrackStatusId,Model model){
		ImTrackStatusDO imTrackStatus = imTrackStatusService.get(imTrackStatusId);
		model.addAttribute("imTrackStatus", imTrackStatus);
	    return "im/imTrackStatus/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("im:imTrackStatus:add")
	public R save( ImTrackStatusDO imTrackStatus){
		if(imTrackStatusService.save(imTrackStatus)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("im:imTrackStatus:edit")
	public R update( ImTrackStatusDO imTrackStatus){
		imTrackStatusService.update(imTrackStatus);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("im:imTrackStatus:remove")
	public R remove( Long imTrackStatusId){
		if(imTrackStatusService.remove(imTrackStatusId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("im:imTrackStatus:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] imTrackStatusIds){
		imTrackStatusService.batchRemove(imTrackStatusIds);
		return R.ok();
	}
	
}
