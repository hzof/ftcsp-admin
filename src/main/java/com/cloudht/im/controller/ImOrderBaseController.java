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

import com.cloudht.im.domain.ImOrderBaseDO;
import com.cloudht.im.service.ImOrderBaseService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;

/**
 * 进口订单信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-24 10:53:43
 */
 
@Controller
@RequestMapping("/im/imOrderBase")
public class ImOrderBaseController {
	@Autowired
	private ImOrderBaseService imOrderBaseService;
	
	@GetMapping()
	@RequiresPermissions("im:imOrderBase:imOrderBase")
	String ImOrderBase(){
	    return "im/imOrderBase/imOrderBase";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("im:imOrderBase:imOrderBase")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ImOrderBaseDO> imOrderBaseList = imOrderBaseService.list(query);
		int total = imOrderBaseService.count(query);
		PageUtils pageUtils = new PageUtils(imOrderBaseList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("im:imOrderBase:add")
	String add(){
	    return "im/imOrderBase/add";
	}

	@GetMapping("/edit/{imOrderBaseId}")
	@RequiresPermissions("im:imOrderBase:edit")
	String edit(@PathVariable("imOrderBaseId") Long imOrderBaseId,Model model){
		ImOrderBaseDO imOrderBase = imOrderBaseService.get(imOrderBaseId);
		model.addAttribute("imOrderBase", imOrderBase);
	    return "im/imOrderBase/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("im:imOrderBase:add")
	public R save( ImOrderBaseDO imOrderBase){
		if(imOrderBaseService.save(imOrderBase)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("im:imOrderBase:edit")
	public R update( ImOrderBaseDO imOrderBase){
		imOrderBaseService.update(imOrderBase);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("im:imOrderBase:remove")
	public R remove( Long imOrderBaseId){
		if(imOrderBaseService.remove(imOrderBaseId)>0){
		return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("im:imOrderBase:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] imOrderBaseIds){
		imOrderBaseService.batchRemove(imOrderBaseIds);
		return R.ok();
	}
	
}
