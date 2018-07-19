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

import com.cloudht.im.domain.ImFileDO;
import com.cloudht.im.service.ImFileService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 出口文件
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-24 15:03:11
 */
 
@Controller
@RequestMapping("/im/imFile")
public class ImFileController {
	@Autowired
	private ImFileService imFileService;
	
	@GetMapping()
	@RequiresPermissions("im:imFile:imFile")
	String ImFile(){
	    return "im/imFile/imFile";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("im:imFile:imFile")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ImFileDO> imFileList = imFileService.list(query);
		int total = imFileService.count(query);
		PageUtils pageUtils = new PageUtils(imFileList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("im:imFile:add")
	String add(){
	    return "im/imFile/add";
	}

	@GetMapping("/edit/{imFileId}")
	@RequiresPermissions("im:imFile:edit")
	String edit(@PathVariable("imFileId") Long imFileId,Model model){
		ImFileDO imFile = imFileService.get(imFileId);
		model.addAttribute("imFile", imFile);
	    return "im/imFile/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("im:imFile:add")
	public R save( ImFileDO imFile){
		if(imFileService.save(imFile)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("im:imFile:edit")
	public R update( ImFileDO imFile){
		imFileService.update(imFile);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("im:imFile:remove")
	public R remove( Long imFileId){
		if(imFileService.remove(imFileId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("im:imFile:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] imFileIds){
		imFileService.batchRemove(imFileIds);
		return R.ok();
	}
	
}
