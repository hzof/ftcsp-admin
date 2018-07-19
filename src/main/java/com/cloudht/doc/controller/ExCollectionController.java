package com.cloudht.doc.controller;

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

import com.cloudht.doc.domain.ExCollectionDO;
import com.cloudht.doc.service.ExCollectionService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 托收收汇
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-25 15:42:52
 */
 
@Controller
@RequestMapping("/doc/exCollection")
public class ExCollectionController {
	@Autowired
	private ExCollectionService exCollectionService;
	
	@GetMapping()
	@RequiresPermissions("doc:exCollection:exCollection")
	String ExCollection(){
	    return "doc/exCollection/exCollection";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("doc:exCollection:exCollection")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ExCollectionDO> exCollectionList = exCollectionService.list(query);
		int total = exCollectionService.count(query);
		PageUtils pageUtils = new PageUtils(exCollectionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("doc:exCollection:add")
	String add(){
	    return "doc/exCollection/add";
	}

	@GetMapping("/edit/{exCollectionId}")
	@RequiresPermissions("doc:exCollection:edit")
	String edit(@PathVariable("exCollectionId") Long exCollectionId,Model model){
		ExCollectionDO exCollection = exCollectionService.get(exCollectionId);
		model.addAttribute("exCollection", exCollection);
	    return "doc/exCollection/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("doc:exCollection:add")
	public R save( ExCollectionDO exCollection){
		if(exCollectionService.save(exCollection)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("doc:exCollection:edit")
	public R update( ExCollectionDO exCollection){
		exCollectionService.update(exCollection);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("doc:exCollection:remove")
	public R remove( Long exCollectionId){
		if(exCollectionService.remove(exCollectionId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("doc:exCollection:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] exCollectionIds){
		exCollectionService.batchRemove(exCollectionIds);
		return R.ok();
	}
	
}
