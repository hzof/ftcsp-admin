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

import com.cloudht.ex.domain.ExFileDO;
import com.cloudht.ex.service.ExFileService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;

/**
 * 出口文件
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-24 15:08:02
 */
 
@Controller
@RequestMapping("/ex/exFile")
public class ExFileController {
	@Autowired
	private ExFileService exFileService;
	
	@GetMapping()
	@RequiresPermissions("ex:exFile:exFile")
	String ExFile(){
	    return "ex/exFile/exFile";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ex:exFile:exFile")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ExFileDO> exFileList = exFileService.list(query);
		int total = exFileService.count(query);
		PageUtils pageUtils = new PageUtils(exFileList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ex:exFile:add")
	String add(){
	    return "ex/exFile/add";
	}

	@GetMapping("/edit/{exFileId}")
	@RequiresPermissions("ex:exFile:edit")
	String edit(@PathVariable("exFileId") Long exFileId,Model model){
		ExFileDO exFile = exFileService.get(exFileId);
		model.addAttribute("exFile", exFile);
	    return "ex/exFile/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ex:exFile:add")
	public R save( ExFileDO exFile){
		if(exFileService.save(exFile)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ex:exFile:edit")
	public R update( ExFileDO exFile){
		exFileService.update(exFile);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ex:exFile:remove")
	public R remove( Long exFileId){
		if(exFileService.remove(exFileId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ex:exFile:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] exFileIds){
		exFileService.batchRemove(exFileIds);
		return R.ok();
	}
	
}
