package com.cloudht.fi.controller;

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

import com.cloudht.fi.domain.ReleaseRateDO;
import com.cloudht.fi.service.ReleaseRateService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 汇率发布
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-23 23:00:36
 */
 
@Controller
@RequestMapping("/fi/releaseRate")
public class ReleaseRateController {
	@Autowired
	private ReleaseRateService releaseRateService;
	
	@GetMapping()
	@RequiresPermissions("fi:releaseRate:releaseRate")
	String ReleaseRate(){
	    return "fi/releaseRate/releaseRate";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("fi:releaseRate:releaseRate")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ReleaseRateDO> releaseRateList = releaseRateService.list(query);
		int total = releaseRateService.count(query);
		PageUtils pageUtils = new PageUtils(releaseRateList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("fi:releaseRate:add")
	String add(){
	    return "fi/releaseRate/add";
	}

	@GetMapping("/edit/{fiReleaseRateId}")
	@RequiresPermissions("fi:releaseRate:edit")
	String edit(@PathVariable("fiReleaseRateId") Integer fiReleaseRateId,Model model){
		ReleaseRateDO releaseRate = releaseRateService.get(fiReleaseRateId);
		model.addAttribute("releaseRate", releaseRate);
	    return "fi/releaseRate/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("fi:releaseRate:add")
	public R save( ReleaseRateDO releaseRate){
		if(releaseRateService.save(releaseRate)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("fi:releaseRate:edit")
	public R update( ReleaseRateDO releaseRate){
		releaseRateService.update(releaseRate);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("fi:releaseRate:remove")
	public R remove( Integer fiReleaseRateId){
		if(releaseRateService.remove(fiReleaseRateId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("fi:releaseRate:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] fiReleaseRateIds){
		releaseRateService.batchRemove(fiReleaseRateIds);
		return R.ok();
	}
	
}
