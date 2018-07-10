package com.cloudht.ft.controller;

import java.util.HashMap;
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

import com.cloudht.ft.domain.FtClientDO;
import com.cloudht.ft.service.FtClientCompanyService;
import com.cloudht.ft.service.FtClientService;
import com.cloudht.common.utils.PageUtils;
import com.cloudht.common.utils.Query;
import com.cloudht.common.utils.R;
import com.cloudht.common.utils.ShiroUtils;

/**
 * 委托人信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-20 15:18:05
 */
 
@Controller
@RequestMapping("/ft/ftClient")
public class FtClientController {
	@Autowired
	private FtClientService ftClientService;
	@Autowired
	private FtClientCompanyService ftClientCompanyService;
	@GetMapping()
	@RequiresPermissions("ft:ftClient:ftClient")
	String FtClient(){
	    return "ft/ftClient/ftClient";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ft:ftClient:ftClient")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        List<Map<String,Object>> clientList = ftClientService.clientList(query);
		//List<FtClientDO> ftClientList = ftClientService.list(query);
		int total = ftClientService.count(query);
		PageUtils pageUtils = new PageUtils(clientList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ft:ftClient:add")
	String add(){
	    return "ft/ftClient/add";
	}

	@GetMapping("/edit/{ftClientId}")
	@RequiresPermissions("ft:ftClient:edit")
	String edit(@PathVariable("ftClientId") Long ftClientId,Model model){
		//FtClientDO ftClient = ftClientService.get(ftClientId);
		//Long ftClientId2 = ftClient.getFtClientId();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ftClientId", ftClientId);
		try {
			model.addAttribute("ftClientCompany", ftClientCompanyService.list(map).get(0));
		} catch (Exception e) {
			// 为null的时候get（0）会出异常
			return null;
		}
	    return "ft/ftClientCompany/edit";
	}
	/**
	 *  跳转到资质审核页面
	 * @param ftClientId
	 * @param model
	 * @return
	 */
	@GetMapping("/companyAudit/{ftClientId}")
	@RequiresPermissions("ft:ftClient:edit")
	String companyAudit(@PathVariable("ftClientId") Long ftClientId,Model model){
		try {
			model.addAttribute("ftClient",ftClientService.get(ftClientId));
		} catch (Exception e) {
			// 为null的时候get会出异常
			return null;
		}
	    return "ft/ftClient/companyAudit";
	}
	@GetMapping("/distributionMarketing/{ftClientId}")
	String distributionMarketing(@PathVariable("ftClientId") Long ftClientId,Model model){
		model.addAttribute("ftClientId", ftClientId);
	    return "ft/ftClient/distributionMarketing";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ft:ftClient:add")
	public R save( FtClientDO ftClient){
		if(ftClientService.save(ftClient)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ft:ftClient:edit")
	public R update( FtClientDO ftClient){
		ftClientService.update(ftClient);
		return R.ok();
	}
	/**
	 * 申请资质审核的函数
	 * @param ftClient 含有客户id的对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/qualificationAudit")
	@RequiresPermissions("ft:ftClient:edit")
	public R qualificationAudit( FtClientDO ftClient){
		ftClient.setAuditStatus(2);//设置为资质审核中
		return ftClientService.update(ftClient)==1?R.ok():R.error(1,"申请失败");
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ft:ftClient:remove")
	public R remove( Long ftClientId){
		if(ftClientService.remove(ftClientId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ft:ftClient:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ftClientIds){
		ftClientService.batchRemove(ftClientIds);
		return R.ok();
	}
	/**
	 * 客户中心销售管理页面跳转
	 * @return
	 */
	@GetMapping("/clientSalesManagement")
	public String clientSalesManagement(Model model) {
		Long userId = ShiroUtils.getUserId();
		System.out.println(userId);
		model.addAttribute("userId", userId);
		return "ft/ftClient/clientSalesManagement";
	}
	/**
	 * 客户管理-操作管理页面跳转
	 * /ft/client/clientOperationManage
	 * @return
	 */
	@GetMapping("/clientOperationManage")
	public String clientOperationManage() {
		return "ft/ftClient/clientOperationManage";
	}
	/**
	 *  客户管理-客服管理页面跳转
	 * /ft/client/clientSupportStaff
	 * @return
	 */
	@GetMapping("/clientSupportStaff")
	public String clientSupportStaff() {
		return "ft/ftClient/clientSupportStaff";
	}
	/**
	 *  客户资质审核页面跳转
	 * @return
	 */
	@GetMapping("/clientCheck")
	@RequiresPermissions("ft:ftClient:ftClient")
	public String clientCheck() {
		return "ft/ftClient/clientCheck";
	}
}
