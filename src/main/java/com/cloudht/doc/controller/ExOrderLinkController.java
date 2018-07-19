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

import com.cloudht.doc.domain.ExOrderLinkDO;
import com.cloudht.doc.service.ExOrderLinkService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 订单环节信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-25 16:34:02
 */
 
@Controller
@RequestMapping("/doc/exOrderLink")
public class ExOrderLinkController {
	@Autowired
	private ExOrderLinkService exOrderLinkService;
	
	@GetMapping()
	@RequiresPermissions("doc:exOrderLink:exOrderLink")
	String ExOrderLink(){
	    return "doc/exOrderLink/exOrderLink";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("doc:exOrderLink:exOrderLink")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ExOrderLinkDO> exOrderLinkList = exOrderLinkService.list(query);
		int total = exOrderLinkService.count(query);
		PageUtils pageUtils = new PageUtils(exOrderLinkList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("doc:exOrderLink:add")
	String add(){
	    return "doc/exOrderLink/add";
	}

	@GetMapping("/edit/{exOrderLinkId}")
	@RequiresPermissions("doc:exOrderLink:edit")
	String edit(@PathVariable("exOrderLinkId") Long exOrderLinkId,Model model){
		ExOrderLinkDO exOrderLink = exOrderLinkService.get(exOrderLinkId);
		model.addAttribute("exOrderLink", exOrderLink);
	    return "doc/exOrderLink/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("doc:exOrderLink:add")
	public R save( ExOrderLinkDO exOrderLink){
		if(exOrderLinkService.save(exOrderLink)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("doc:exOrderLink:edit")
	public R update( ExOrderLinkDO exOrderLink){
		exOrderLinkService.update(exOrderLink);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("doc:exOrderLink:remove")
	public R remove( Long exOrderLinkId){
		if(exOrderLinkService.remove(exOrderLinkId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("doc:exOrderLink:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] exOrderLinkIds){
		exOrderLinkService.batchRemove(exOrderLinkIds);
		return R.ok();
	}
	
}
