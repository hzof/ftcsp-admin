package com.cloudht.ft.controller;

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

import com.cloudht.ft.domain.FtFileDO;
import com.cloudht.ft.service.FtFileService;
import com.sxyht.common.utils.PageUtils;
import com.sxyht.common.utils.Query;
import com.sxyht.common.utils.R;

/**
 * 文件表
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-07-19 09:21:58
 */
 
@Controller
@RequestMapping("/ft/ftFile")
public class FtFileController {
	@Autowired
	private FtFileService ftFileService;
	
	@GetMapping()
	@RequiresPermissions("ft:ftFile:ftFile")
	String FtFile(){
	    return "ft/ftFile/ftFile";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ft:ftFile:ftFile")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FtFileDO> ftFileList = ftFileService.list(query);
		int total = ftFileService.count(query);
		PageUtils pageUtils = new PageUtils(ftFileList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ft:ftFile:add")
	String add(){
	    return "ft/ftFile/add";
	}

	@GetMapping("/edit/{ftFileId}")
	@RequiresPermissions("ft:ftFile:edit")
	String edit(@PathVariable("ftFileId") Long ftFileId,Model model){
		FtFileDO ftFile = ftFileService.get(ftFileId);
		model.addAttribute("ftFile", ftFile);
	    return "ft/ftFile/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ft:ftFile:add")
	public R save( FtFileDO ftFile){
		if(ftFileService.save(ftFile)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ft:ftFile:edit")
	public R update( FtFileDO ftFile){
		ftFileService.update(ftFile);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ft:ftFile:remove")
	public R remove( Long ftFileId){
		if(ftFileService.remove(ftFileId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ft:ftFile:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ftFileIds){
		ftFileService.batchRemove(ftFileIds);
		return R.ok();
	}
	/**
	 * /ft/ftFile/upload
	 * @param file
	 * @param request
	 * @return
	 */
	@ResponseBody
	@PostMapping("/upload")
	R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		try {
			FtFileDO saveFile = this.ftFileService.saveFile(file, "D:/applog/", 1, 2l, 2l);
			if(saveFile!=null)
				return R.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return R.error();
	}
}
