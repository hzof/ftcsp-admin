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

import com.cloudht.ft.domain.FtClientContractDO;
import com.cloudht.ft.service.FtClientContractService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 委托方合同
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-05 14:47:30
 */
 
@Controller
@RequestMapping("/ft/ftClientContract")
public class FtClientContractController {
	@Autowired
	private FtClientContractService ftClientContractService;
	/**
	 * 跳转到客户中心合同管理页面
	 * url:/ft/ftClientContract
	 * @return
	 */
	@GetMapping()
	@RequiresPermissions("ft:ftClientContract:ftClientContract")
	String FtClientContract(){
	    return "ft/ftClientContract/ftClientContract";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ft:ftClientContract:ftClientContract")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FtClientContractDO> ftClientContractList = ftClientContractService.list(query);
		int total = ftClientContractService.count(query);
		PageUtils pageUtils = new PageUtils(ftClientContractList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ft:ftClientContract:add")
	String add(){
	    return "ft/ftClientContract/add";
	}

	@GetMapping("/edit/{ftClientContractId}")
	@RequiresPermissions("ft:ftClientContract:edit")
	String edit(@PathVariable("ftClientContractId") Integer ftClientContractId,Model model){
		FtClientContractDO ftClientContract = ftClientContractService.get(ftClientContractId);
		model.addAttribute("ftClientContract", ftClientContract);
	    return "ft/ftClientContract/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ft:ftClientContract:add")
	public R save( FtClientContractDO ftClientContract){
		if(ftClientContractService.save(ftClientContract)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ft:ftClientContract:edit")
	public R update( FtClientContractDO ftClientContract){
		ftClientContractService.update(ftClientContract);
		return R.ok();
	}
	
	/**
	 * 删除/ft/ftClientContract/remove,ft:ftClientContract:remove
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ft:ftClientContract:remove")
	public R remove( Integer ftClientContractId){
		if(ftClientContractService.remove(ftClientContractId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ft:ftClientContract:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ftClientContractIds){
		ftClientContractService.batchRemove(ftClientContractIds);
		return R.ok();
	}
	
}
