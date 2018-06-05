package com.cloudht.ft.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 委托方合同
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-05 14:47:30
 */
public class FtClientContractDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//合同管理id
	private Integer ftClientContractId;
	//合同编号
	private String contractNo;
	//委托方
	private Integer ftClientId;
	//合同甲方，引用公司表的主键
	private Integer ftClientCompantId;
	//甲方名称
	private String firstPartyName;
	//甲方地址
	private String firstPartyAddress;
	//乙方名称
	private String secondPartyName;
	//乙方地址
	private String secondPartyAddress;
	//合同签订地址
	private String signedAt;
	//生效日期
	private Date effectDate;
	//失效日期
	private Date invalidDate;
	//签订日期
	private Date signingDate;
	//备注
	private String remark;
	//附件，不超过1m的图片
	private String filePath;
	//创建时间
	private Date gmtCreate;
	//修改时间
	private Date gmtModified;
	//是否删除：0-否，1-是
	private Integer isDelete;

	/**
	 * 设置：合同管理id
	 */
	public void setFtClientContractId(Integer ftClientContractId) {
		this.ftClientContractId = ftClientContractId;
	}
	/**
	 * 获取：合同管理id
	 */
	public Integer getFtClientContractId() {
		return ftClientContractId;
	}
	/**
	 * 设置：合同编号
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	/**
	 * 获取：合同编号
	 */
	public String getContractNo() {
		return contractNo;
	}
	/**
	 * 设置：委托方
	 */
	public void setFtClientId(Integer ftClientId) {
		this.ftClientId = ftClientId;
	}
	/**
	 * 获取：委托方
	 */
	public Integer getFtClientId() {
		return ftClientId;
	}
	/**
	 * 设置：合同甲方，引用公司表的主键
	 */
	public void setFtClientCompantId(Integer ftClientCompantId) {
		this.ftClientCompantId = ftClientCompantId;
	}
	/**
	 * 获取：合同甲方，引用公司表的主键
	 */
	public Integer getFtClientCompantId() {
		return ftClientCompantId;
	}
	/**
	 * 设置：甲方名称
	 */
	public void setFirstPartyName(String firstPartyName) {
		this.firstPartyName = firstPartyName;
	}
	/**
	 * 获取：甲方名称
	 */
	public String getFirstPartyName() {
		return firstPartyName;
	}
	/**
	 * 设置：甲方地址
	 */
	public void setFirstPartyAddress(String firstPartyAddress) {
		this.firstPartyAddress = firstPartyAddress;
	}
	/**
	 * 获取：甲方地址
	 */
	public String getFirstPartyAddress() {
		return firstPartyAddress;
	}
	/**
	 * 设置：乙方名称
	 */
	public void setSecondPartyName(String secondPartyName) {
		this.secondPartyName = secondPartyName;
	}
	/**
	 * 获取：乙方名称
	 */
	public String getSecondPartyName() {
		return secondPartyName;
	}
	/**
	 * 设置：乙方地址
	 */
	public void setSecondPartyAddress(String secondPartyAddress) {
		this.secondPartyAddress = secondPartyAddress;
	}
	/**
	 * 获取：乙方地址
	 */
	public String getSecondPartyAddress() {
		return secondPartyAddress;
	}
	/**
	 * 设置：合同签订地址
	 */
	public void setSignedAt(String signedAt) {
		this.signedAt = signedAt;
	}
	/**
	 * 获取：合同签订地址
	 */
	public String getSignedAt() {
		return signedAt;
	}
	/**
	 * 设置：生效日期
	 */
	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}
	/**
	 * 获取：生效日期
	 */
	public Date getEffectDate() {
		return effectDate;
	}
	/**
	 * 设置：失效日期
	 */
	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}
	/**
	 * 获取：失效日期
	 */
	public Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 设置：签订日期
	 */
	public void setSigningDate(Date signingDate) {
		this.signingDate = signingDate;
	}
	/**
	 * 获取：签订日期
	 */
	public Date getSigningDate() {
		return signingDate;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：附件，不超过1m的图片
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * 获取：附件，不超过1m的图片
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * 设置：创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getGmtModified() {
		return gmtModified;
	}
	/**
	 * 设置：是否删除：0-否，1-是
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：是否删除：0-否，1-是
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
}
