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

import com.cloudht.common.domain.SysBankInfoDO;
import com.cloudht.common.service.SysBankInfoService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 银行信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-30 16:21:30
 */
 
@Controller
@RequestMapping("/common/sysBankInfo")
public class SysBankInfoController {
	@Autowired
	private SysBankInfoService sysBankInfoService;
	
	@GetMapping()
	@RequiresPermissions("common:sysBankInfo:sysBankInfo")
	String SysBankInfo(){
	    return "common/sysBankInfo/sysBankInfo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:sysBankInfo:sysBankInfo")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysBankInfoDO> sysBankInfoList = sysBankInfoService.list(query);
		int total = sysBankInfoService.count(query);
		PageUtils pageUtils = new PageUtils(sysBankInfoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("common:sysBankInfo:add")
	String add(){
	    return "common/sysBankInfo/add";
	}

	@GetMapping("/edit/{sysBankInfoId}")
	@RequiresPermissions("common:sysBankInfo:edit")
	String edit(@PathVariable("sysBankInfoId") Integer sysBankInfoId,Model model){
		SysBankInfoDO sysBankInfo = sysBankInfoService.get(sysBankInfoId);
		model.addAttribute("sysBankInfo", sysBankInfo);
	    return "common/sysBankInfo/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:sysBankInfo:add")
	public R save( SysBankInfoDO sysBankInfo){
		if(sysBankInfoService.save(sysBankInfo)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:sysBankInfo:edit")
	public R update( SysBankInfoDO sysBankInfo){
		sysBankInfoService.update(sysBankInfo);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("common:sysBankInfo:remove")
	public R remove( Integer sysBankInfoId){
		if(sysBankInfoService.remove(sysBankInfoId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:sysBankInfo:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] sysBankInfoIds){
		sysBankInfoService.batchRemove(sysBankInfoIds);
		return R.ok();
	}
	
}
