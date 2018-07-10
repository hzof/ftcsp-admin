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

import com.cloudht.ft.domain.FtBtypeDO;
import com.cloudht.ft.service.FtBtypeService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;

/**
 * 往来单位信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-05 18:50:41
 */
 
@Controller
@RequestMapping("/ft/ftBtype")
public class FtBtypeController {
	@Autowired
	private FtBtypeService ftBtypeService;
	
	@GetMapping()
	@RequiresPermissions("ft:ftBtype:ftBtype")
	String FtBtype(){
	    return "ft/ftBtype/ftBtype";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ft:ftBtype:ftBtype")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FtBtypeDO> ftBtypeList = ftBtypeService.list(query);
		int total = ftBtypeService.count(query);
		PageUtils pageUtils = new PageUtils(ftBtypeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ft:ftBtype:add")
	String add(){
	    return "ft/ftBtype/add";
	}

	@GetMapping("/edit/{ftBtypeId}")
	@RequiresPermissions("ft:ftBtype:edit")
	String edit(@PathVariable("ftBtypeId") Integer ftBtypeId,Model model){
		FtBtypeDO ftBtype = ftBtypeService.get(ftBtypeId);
		model.addAttribute("ftBtype", ftBtype);
	    return "ft/ftBtype/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ft:ftBtype:add")
	public R save( FtBtypeDO ftBtype){
		if(ftBtypeService.save(ftBtype)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ft:ftBtype:edit")
	public R update( FtBtypeDO ftBtype){
		ftBtypeService.update(ftBtype);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ft:ftBtype:remove")
	public R remove( Integer ftBtypeId){
		if(ftBtypeService.remove(ftBtypeId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ft:ftBtype:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ftBtypeIds){
		ftBtypeService.batchRemove(ftBtypeIds);
		return R.ok();
	}
	
}
