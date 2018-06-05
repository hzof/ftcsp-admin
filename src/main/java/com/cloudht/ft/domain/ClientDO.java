package com.cloudht.ft.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 委托人信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-05 09:27:00
 */
public class ClientDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long ftClientId;
	//委托方用户ID
	private Long clientUserId;
	//营销人员ID
	private Long marketerId;
	//审核状态:0-新注册，1-已分配营销，2-资质审核中，3-审核不通过，4-审核通过，5-已分配客服，6-已分配操作人员
	private Integer auditStatus;
	//审核备注
	private String auditRemark;
	//客户代码
	private String clientNo;
	//服务合同号
	private String serviceContractNo;
	//客服人员ID
	private Long servicerId;
	//操作人员ID
	private Long operatorId;
	//客户类型：0-有效客户，1-暂停出货客户，2-未出货客户
	private Integer clientType;
	//创建时间
	private Date gmtCreate;
	//修改时间
	private Date gmtModified;
	//是否删除：0-否，1-是
	private Integer isDelete;

	/**
	 * 设置：主键
	 */
	public void setFtClientId(Long ftClientId) {
		this.ftClientId = ftClientId;
	}
	/**
	 * 获取：主键
	 */
	public Long getFtClientId() {
		return ftClientId;
	}
	/**
	 * 设置：委托方用户ID
	 */
	public void setClientUserId(Long clientUserId) {
		this.clientUserId = clientUserId;
	}
	/**
	 * 获取：委托方用户ID
	 */
	public Long getClientUserId() {
		return clientUserId;
	}
	/**
	 * 设置：营销人员ID
	 */
	public void setMarketerId(Long marketerId) {
		this.marketerId = marketerId;
	}
	/**
	 * 获取：营销人员ID
	 */
	public Long getMarketerId() {
		return marketerId;
	}
	/**
	 * 设置：审核状态:0-新注册，1-已分配营销，2-资质审核中，3-审核不通过，4-审核通过，5-已分配客服，6-已分配操作人员
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	/**
	 * 获取：审核状态:0-新注册，1-已分配营销，2-资质审核中，3-审核不通过，4-审核通过，5-已分配客服，6-已分配操作人员
	 */
	public Integer getAuditStatus() {
		return auditStatus;
	}
	/**
	 * 设置：审核备注
	 */
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
	/**
	 * 获取：审核备注
	 */
	public String getAuditRemark() {
		return auditRemark;
	}
	/**
	 * 设置：客户代码
	 */
	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}
	/**
	 * 获取：客户代码
	 */
	public String getClientNo() {
		return clientNo;
	}
	/**
	 * 设置：服务合同号
	 */
	public void setServiceContractNo(String serviceContractNo) {
		this.serviceContractNo = serviceContractNo;
	}
	/**
	 * 获取：服务合同号
	 */
	public String getServiceContractNo() {
		return serviceContractNo;
	}
	/**
	 * 设置：客服人员ID
	 */
	public void setServicerId(Long servicerId) {
		this.servicerId = servicerId;
	}
	/**
	 * 获取：客服人员ID
	 */
	public Long getServicerId() {
		return servicerId;
	}
	/**
	 * 设置：操作人员ID
	 */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	/**
	 * 获取：操作人员ID
	 */
	public Long getOperatorId() {
		return operatorId;
	}
	/**
	 * 设置：客户类型：0-有效客户，1-暂停出货客户，2-未出货客户
	 */
	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}
	/**
	 * 获取：客户类型：0-有效客户，1-暂停出货客户，2-未出货客户
	 */
	public Integer getClientType() {
		return clientType;
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
