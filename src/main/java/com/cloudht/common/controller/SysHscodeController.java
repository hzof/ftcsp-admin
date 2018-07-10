package com.cloudht.common.controller;

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

import com.cloudht.common.domain.SysHscodeDO;
import com.cloudht.common.service.SysHscodeService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;

/**
 * HS编码
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-30 16:21:30
 */
 
@Controller
@RequestMapping("/common/sysHscode")
public class SysHscodeController {
	@Autowired
	private SysHscodeService sysHscodeService;
	
	@GetMapping()
	@RequiresPermissions("common:sysHscode:sysHscode")
	String SysHscode(){
	    return "common/sysHscode/sysHscode";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:sysHscode:sysHscode")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysHscodeDO> sysHscodeList = sysHscodeService.list(query);
		int total = sysHscodeService.count(query);
		PageUtils pageUtils = new PageUtils(sysHscodeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("common:sysHscode:add")
	String add(){
	    return "common/sysHscode/add";
	}

	@GetMapping("/edit/{sysHscodeId}")
	@RequiresPermissions("common:sysHscode:edit")
	String edit(@PathVariable("sysHscodeId") Integer sysHscodeId,Model model){
		SysHscodeDO sysHscode = sysHscodeService.get(sysHscodeId);
		model.addAttribute("sysHscode", sysHscode);
	    return "common/sysHscode/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:sysHscode:add")
	public R save( SysHscodeDO sysHscode){
		if(sysHscodeService.save(sysHscode)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:sysHscode:edit")
	public R update( SysHscodeDO sysHscode){
		sysHscodeService.update(sysHscode);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("common:sysHscode:remove")
	public R remove( Integer sysHscodeId){
		if(sysHscodeService.remove(sysHscodeId)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:sysHscode:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] sysHscodeIds){
		sysHscodeService.batchRemove(sysHscodeIds);
		return R.ok();
	}
	
}
