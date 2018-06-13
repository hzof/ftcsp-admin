package com.cloudht.ex.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 出口订单头信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-05-25 17:57:46
 */
public class OrderHeaderDO extends OrderBaseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Long exOrderHeaderId;
	//委托方
	private Long ftClientId;
	//出口发票号
	private String exportInvoiceNo;
	//外销合同号
	private String exportContractNo;
	//交货日期
	private Date deliveryDate;
	//收货人
	private String consignee;
	//联系人
	private String contact;
	//办公室电话
	private String officePhone;
	//手机
	private String phone;
	//备注
	private String remark;
	//是否已结算：0-未结算状态，1-已结算状态
	private Integer isSettled;
	//审核状态：0-未提交，1-待受理，2-待专家受理，3-拒绝受理，4-已撤销，5-撤回修改，6-已受理
	private Integer auditStatus;
	//受理时间
	private Date processTime;
	//是否已删除：0-否，1-是
	private Integer isDeleted;
	//创建时间
	private Date gmtCreate;
	//修改时间
	private Date gmtModified;
	//创建人Id
	private Long createBy;
	public Long getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	/**
	 * 设置：ID
	 */
	public void setExOrderHeaderId(Long exOrderHeaderId) {
		this.exOrderHeaderId = exOrderHeaderId;
	}
	/**
	 * 获取：ID
	 */
	public Long getExOrderHeaderId() {
		return exOrderHeaderId;
	}
	/**
	 * 设置：委托方
	 */
	public void setFtClientId(Long ftClientId) {
		this.ftClientId = ftClientId;
	}
	/**
	 * 获取：委托方
	 */
	public Long getFtClientId() {
		return ftClientId;
	}
	/**
	 * 设置：出口发票号
	 */
	public void setExportInvoiceNo(String exportInvoiceNo) {
		this.exportInvoiceNo = exportInvoiceNo;
	}
	/**
	 * 获取：出口发票号
	 */
	public String getExportInvoiceNo() {
		return exportInvoiceNo;
	}
	/**
	 * 设置：外销合同号
	 */
	public void setExportContractNo(String exportContractNo) {
		this.exportContractNo = exportContractNo;
	}
	/**
	 * 获取：外销合同号
	 */
	public String getExportContractNo() {
		return exportContractNo;
	}
	/**
	 * 设置：交货日期
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	/**
	 * 获取：交货日期
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	/**
	 * 设置：收货人
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	/**
	 * 获取：收货人
	 */
	public String getConsignee() {
		return consignee;
	}
	/**
	 * 设置：联系人
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取：联系人
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 设置：办公室电话
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	/**
	 * 获取：办公室电话
	 */
	public String getOfficePhone() {
		return officePhone;
	}
	/**
	 * 设置：手机
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机
	 */
	public String getPhone() {
		return phone;
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
	 * 设置：是否已结算：0-未结算状态，1-已结算状态
	 */
	public void setIsSettled(Integer isSettled) {
		this.isSettled = isSettled;
	}
	/**
	 * 获取：是否已结算：0-未结算状态，1-已结算状态
	 */
	public Integer getIsSettled() {
		return isSettled;
	}
	/**
	 * 设置：审核状态：0-未提交，1-待受理，2-待专家受理，3-拒绝受理，4-已撤销，5-撤回修改，6-已受理
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	/**
	 * 获取：审核状态：0-未提交，1-待受理，2-待专家受理，3-拒绝受理，4-已撤销，5-撤回修改，6-已受理
	 */
	public Integer getAuditStatus() {
		return auditStatus;
	}
	/**
	 * 设置：受理时间
	 */
	public void setProcessTime(Date processTime) {
		this.processTime = processTime;
	}
	/**
	 * 获取：受理时间
	 */
	public Date getProcessTime() {
		return processTime;
	}
	/**
	 * 设置：是否已删除：0-否，1-是
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * 获取：是否已删除：0-否，1-是
	 */
	public Integer getIsDeleted() {
		return isDeleted;
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
	@Override
	public String toString() {
		return "OrderHeaderDO [exOrderHeaderId=" + exOrderHeaderId + ", ftClientId=" + ftClientId + ", exportInvoiceNo="
				+ exportInvoiceNo + ", exportContractNo=" + exportContractNo + ", deliveryDate=" + deliveryDate
				+ ", consignee=" + consignee + ", contact=" + contact + ", officePhone=" + officePhone + ", phone="
				+ phone + ", remark=" + remark + ", isSettled=" + isSettled + ", auditStatus=" + auditStatus
				+ ", processTime=" + processTime + ", isDeleted=" + isDeleted + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + ", createBy=" + createBy + "]";
	}
	
}
