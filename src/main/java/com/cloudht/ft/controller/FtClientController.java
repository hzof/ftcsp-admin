package com.cloudht.ft.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.multipart.MultipartFile;

import com.cloudht.ft.domain.FtClientDO;
import com.cloudht.ft.domain.FtFileDO;
import com.cloudht.ft.service.FtClientCompanyService;
import com.cloudht.ft.service.FtClientService;
import com.cloudht.ft.service.FtFileService;
import com.cloudht.system.domain.UserDO;
import com.cloudht.system.service.UserService;
import com.sxyht.common.interfaces.FileSourceEnum;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;
import com.sxyht.common.utils.ShiroUtils;

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
	@Autowired
	private UserService  userService;
	@Autowired
	private FtFileService  ftFileService;
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
        for(int i=0;i<clientList.size();i++) {
        	Map<String, Object> client = clientList.get(i);
        	Object object = client.get("servicerId");
        	String valueOf = String.valueOf(object);
        	if(!valueOf.equals("null") && ! "".equals(valueOf)) {
        		Long parseLong = Long.parseLong(valueOf);
        		client.put("servicerName", userService.get(parseLong).getName());
        	}
        	String valueOf2 = String.valueOf(client.get("operatorId"));
        	if(!valueOf2.equals("null") && ! "".equals(valueOf2)) {
        		Long parseLong = Long.parseLong(valueOf2);
        		client.put("operatorName", userService.get(parseLong).getName());
        	}
        }
		//List<FtClientDO> ftClientList = ftClientService.list(query);
		int total = ftClientService.count(query);
		PageUtils pageUtils = new PageUtils(clientList, total);
		return pageUtils;
	}
	@ResponseBody
	@GetMapping("/contractSuperviseList")
	@RequiresPermissions("ft:ftClient:ftClient")
	public PageUtils contractSuperviseList(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<Map<String,Object>> clientList = ftClientService.contractSuperviseList(query);
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
	
	/**
	 * 跳转到分配客服页面
	 * @param ftClientId 客户id主键
	 * @return
	 */
	@GetMapping("/distributionCustomerService/{ftClientId}")
	@RequiresPermissions("ft:ftClient:edit")
	String distributionCustomerService(@PathVariable("ftClientId") Long ftClientId,Model model){
		model.addAttribute("ftClientId", ftClientId);
		/*try {
			FtClientCompanyDO ftClientCompanyDO = ftClientCompanyService.list(map).get(0);
			ftClientCompanyDO.setFtClientId(ftClientId);//此行用于防止未填写公司信息时候的报错
		} catch (Exception e) {
			FtClientCompanyDO ftClientCompanyDO = new FtClientCompanyDO();
			ftClientCompanyDO.setFtClientId(ftClientId);
			model.addAttribute("ftClient", ftClientCompanyDO);
			
		}*/
	    return "ft/ftClient/distributionCustomerService";
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
	@GetMapping("/editContract/{ftClientId}")
	@RequiresPermissions("ft:ftClient:edit")
	String editContract(@PathVariable("ftClientId") Long ftClientId,Model model) {
		FtClientDO ftClientDO = this.ftClientService.get(ftClientId);
		if(ftClientDO!=null) {
			model.addAttribute("ftClient", ftClientDO);
			return "ft/ftClient/editContract";//跳转到编辑合同视图
		}
		return null;
	}
	@GetMapping("/distributionOperation/{ftClientId}")
	@RequiresPermissions("ft:ftClient:edit")
	String distributionOperation(@PathVariable("ftClientId") Long ftClientId,Model model){
		model.addAttribute("ftClientId", ftClientId);
	    return "ft/ftClient/searchOperation";//跳转到搜索操作人员界面
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
			FtClientDO ftClientDO = ftClientService.get(ftClientId);
			ftClientDO.setMarketerName(this.userService.get(ftClientDO.getMarketerId()).getUsername());
			model.addAttribute("ftClient",ftClientDO);
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
	 * 分配客服后的保存函数
	 * @param ftClient 含有客户id，客服id和客服名称的对象
	 * @return 是否成功
	 */
	@ResponseBody
	@RequestMapping("/distributionCustomerServiceSave")
	@RequiresPermissions("ft:ftClient:edit")
	public R distributionCustomerServiceSave( FtClientDO ftClient){
		try {
			UserDO userDO = userService.get(ftClient.getServicerId());
			if(userDO.getName().equals(ftClient.getServicerName())) {
				ftClientService.update(ftClient);
				return R.ok();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return R.error("分配客服失败");
	}
	/**
	 * 分配操作后的保存函数
	 * @param ftClient
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/distributionOperationSave")
	@RequiresPermissions("ft:ftClient:edit")
	public R distributionOperationSave( FtClientDO ftClient){
		try {
			UserDO userDO = userService.get(ftClient.getOperatorId());
			if(userDO.getName().equals(ftClient.getOperatorName())) {
				ftClientService.update(ftClient);
				return R.ok();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return R.error("分配操作失败");
	}
	
	/**
	 * 是否通过审核的函数
	 * @param ftClient 
	 * @return 是否成功
	 */
	@ResponseBody
	@RequestMapping("/isThroughAudit")
	@RequiresPermissions("ft:ftClient:edit")
	public R isThroughAudit( FtClientDO ftClient){
		Long ftClientId = ftClient.getFtClientId();
		FtClientDO ftClientDO = this.ftClientService.get(ftClientId);
		String clientNo = ftClientDO.getClientNo();
		if("".equals(clientNo)||clientNo==null) {//
			System.out.println(clientNo);
			String clientCode = ftClientService.getClientCode();
			ftClient.setClientNo(clientCode);
		}else {
			ftClient.setClientNo(clientNo);
		}
		ftClientService.update(ftClientService.getNewServiceContractNo(ftClient));
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
		Long userId = ((UserDO)ShiroUtils.getUser()).getUserId();
		model.addAttribute("userId", userId);
		return "ft/ftClient/clientSalesManagement";
	}
	/**
	 * 跳转到客服跟踪页面
	 */
	@GetMapping("/serviceTrack")
	public String serviceTrack(Model model) {
		Long userId = ((UserDO)ShiroUtils.getUser()).getUserId();
		model.addAttribute("userId", userId);
		return "ft/ftClient/serviceTrack";
	}
	/**
	 * 客户管理下操作跟踪页面跳转
	 * /ft/ftClient/operationTrack 
	 * @return
	 */
	@GetMapping("/operationTrack")
	public String operationTrack(Model model) {
		model.addAttribute("userId", ((UserDO)ShiroUtils.getUser()).getUserId());
		return "ft/ftClient/operationTrack";
	}
	/**
	 * 客户管理下分配操作的页面跳转
	 * /ft/ftClient/distributionOperation
	 * @return
	 */
	@GetMapping("/distributionOperation")
	public String distributionOperation(Model model) {
		model.addAttribute("userId", ((UserDO)ShiroUtils.getUser()).getUserId());
		return "ft/ftClient/distributionOperation";
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
	/**
	 * /ft/client/contractSupervise
	 * 跳转到客户合同管理页面
	 * @return 合同管理视图
	 */
	@GetMapping("/contractSupervise")
	@RequiresPermissions("ft:ftClient:ftClient")
	public String contractSupervise() {
		return "ft/ftClient/contractSupervise";
	}
	/**
	 * 上傳到客戶合同
	 * /ft/ftClient/uploadContract
	 * @param file
	 * @param request
	 * @return
	 */
	@ResponseBody
	@PostMapping("/uploadContract")
	public R uploadFile(@RequestParam("file") MultipartFile file, Long ftClientId){
		try {
			FtFileDO saveFile = this.ftFileService.saveFile(file, "clientContract/", FileSourceEnum.CLIENT_CONTRACT_ATTACHMENT, ftClientId, ftClientId);
			if(saveFile!=null)
				return R.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return R.error();
	}
	@GetMapping("/displayAttachments/{ftClientId}")
	@RequiresPermissions("ft:ftClient:edit")
	String displayAttachments(@PathVariable("ftClientId") Long ftClientId,Model model){
		model.addAttribute("ftClientId", ftClientId);
	    return "ft/ftClient/displayAttachments";
	}
	
}
