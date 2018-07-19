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

import com.cloudht.im.domain.ImAgencyContractDO;
import com.cloudht.im.service.ImAgencyContractService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 进口代理合同
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-24 10:53:43
 */
 
@Controller
@RequestMapping("/im/imAgencyContract")
public class ImAgencyContractController {
	@Autowired
	private ImAgencyContractService imAgencyContractService;
	
	@GetMapping()
	@RequiresPermissions("im:imAgencyContract:imAgencyContract")
	String ImAgencyContract(){
	    return "im/imAgencyContract/imAgencyContract";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("im:imAgencyContract:imAgencyContract")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ImAgencyContractDO> imAgencyContractList = imAgencyContractService.list(query);
		int total = imAgencyContractService.count(query);
		PageUtils pageUtils = new PageUtils(imAgencyContractList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("im:imAgencyContract:add")
	String add(){
	    return "im/imAgencyContract/add";
	}

	@GetMapping("/edit/{imAgencyContractId}")
	@RequiresPermissions("im:imAgencyContract:edit")
	String edit(@PathVariable("imAgencyContractId") Long imAgencyContractId,Model model){
		ImAgencyContractDO imAgencyContract = imAgencyContractService.get(imAgencyContractId);
		model.addAttribute("imAgencyContract", imAgencyContract);
	    return "im/imAgencyContract/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("im:imAgencyContract:add")
	public R save( ImAgencyContractDO imAgencyContract){
		if(imAgencyContractService.save(imAgencyContract)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("im:imAgencyContract:edit")
	public R update( ImAgencyContractDO imAgencyContract){
		imAgencyContractService.update(imAgencyContract);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("im:imAgencyContract:remove")
	public R remove( Long imAgencyContractId){
		if(imAgencyContractService.remove(imAgencyContractId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("im:imAgencyContract:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] imAgencyContractIds){
		imAgencyContractService.batchRemove(imAgencyContractIds);
		return R.ok();
	}
	
}
