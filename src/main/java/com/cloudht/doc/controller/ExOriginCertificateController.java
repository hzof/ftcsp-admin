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

import com.cloudht.doc.domain.ExOriginCertificateDO;
import com.cloudht.doc.service.ExOriginCertificateService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;

/**
 * 产地证信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-25 15:42:53
 */
 
@Controller
@RequestMapping("/doc/exOriginCertificate")
public class ExOriginCertificateController {
	@Autowired
	private ExOriginCertificateService exOriginCertificateService;
	
	@GetMapping()
	@RequiresPermissions("doc:exOriginCertificate:exOriginCertificate")
	String ExOriginCertificate(){
	    return "doc/exOriginCertificate/exOriginCertificate";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("doc:exOriginCertificate:exOriginCertificate")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ExOriginCertificateDO> exOriginCertificateList = exOriginCertificateService.list(query);
		int total = exOriginCertificateService.count(query);
		PageUtils pageUtils = new PageUtils(exOriginCertificateList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("doc:exOriginCertificate:add")
	String add(){
	    return "doc/exOriginCertificate/add";
	}

	@GetMapping("/edit/{exOriginCertificateId}")
	@RequiresPermissions("doc:exOriginCertificate:edit")
	String edit(@PathVariable("exOriginCertificateId") Long exOriginCertificateId,Model model){
		ExOriginCertificateDO exOriginCertificate = exOriginCertificateService.get(exOriginCertificateId);
		model.addAttribute("exOriginCertificate", exOriginCertificate);
	    return "doc/exOriginCertificate/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("doc:exOriginCertificate:add")
	public R save( ExOriginCertificateDO exOriginCertificate){
		if(exOriginCertificateService.save(exOriginCertificate)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("doc:exOriginCertificate:edit")
	public R update( ExOriginCertificateDO exOriginCertificate){
		exOriginCertificateService.update(exOriginCertificate);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("doc:exOriginCertificate:remove")
	public R remove( Long exOriginCertificateId){
		if(exOriginCertificateService.remove(exOriginCertificateId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("doc:exOriginCertificate:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] exOriginCertificateIds){
		exOriginCertificateService.batchRemove(exOriginCertificateIds);
		return R.ok();
	}
	
}
