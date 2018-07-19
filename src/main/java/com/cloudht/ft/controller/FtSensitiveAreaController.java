package com.cloudht.ft.controller;

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

import com.cloudht.ft.domain.FtSensitiveAreaDO;
import com.cloudht.ft.service.FtSensitiveAreaService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 敏感地区
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-05 18:50:41
 */
 
@Controller
@RequestMapping("/ft/ftSensitiveArea")
public class FtSensitiveAreaController {
	@Autowired
	private FtSensitiveAreaService ftSensitiveAreaService;
	
	@GetMapping()
	@RequiresPermissions("ft:ftSensitiveArea:ftSensitiveArea")
	String FtSensitiveArea(){
	    return "ft/ftSensitiveArea/ftSensitiveArea";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ft:ftSensitiveArea:ftSensitiveArea")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FtSensitiveAreaDO> ftSensitiveAreaList = ftSensitiveAreaService.list(query);
		int total = ftSensitiveAreaService.count(query);
		PageUtils pageUtils = new PageUtils(ftSensitiveAreaList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ft:ftSensitiveArea:add")
	String add(){
	    return "ft/ftSensitiveArea/add";
	}

	@GetMapping("/edit/{ftSensitiveAreaId}")
	@RequiresPermissions("ft:ftSensitiveArea:edit")
	String edit(@PathVariable("ftSensitiveAreaId") Integer ftSensitiveAreaId,Model model){
		FtSensitiveAreaDO ftSensitiveArea = ftSensitiveAreaService.get(ftSensitiveAreaId);
		model.addAttribute("ftSensitiveArea", ftSensitiveArea);
	    return "ft/ftSensitiveArea/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ft:ftSensitiveArea:add")
	public R save( FtSensitiveAreaDO ftSensitiveArea){
		if(ftSensitiveAreaService.save(ftSensitiveArea)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ft:ftSensitiveArea:edit")
	public R update( FtSensitiveAreaDO ftSensitiveArea){
		ftSensitiveAreaService.update(ftSensitiveArea);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ft:ftSensitiveArea:remove")
	public R remove( Integer ftSensitiveAreaId){
		if(ftSensitiveAreaService.remove(ftSensitiveAreaId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ft:ftSensitiveArea:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ftSensitiveAreaIds){
		ftSensitiveAreaService.batchRemove(ftSensitiveAreaIds);
		return R.ok();
	}
	
}
