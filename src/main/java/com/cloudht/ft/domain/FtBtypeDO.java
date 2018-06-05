package com.cloudht.ft.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 往来单位信息
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-05 18:50:41
 */
public class FtBtypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//往来单位主键
	private Integer ftBtypeId;
	//委托方公司主键
	private Integer ftClientCompanyId;
	//委托方
	private Integer ftClientId;
	//往来单位编号
	private Integer btypeNo;
	//往来单位名称
	private String btypeName;
	//往来单位类型 0-开票单位 1-贷代 2-银行 3-保险公司 4-国外客户 5-资金往来单位
	private Integer btypeType;
	//是否生产企业 0-否 1-是，单位类型选择为开票单位后填写此项
	private Integer isManufacture;
	//开始营业期限
	private Date startBusiDate;
	//结束营业期限
	private Date closeBusiDate;
	//省
	private String province;
	//市
	private String city;
	//区
	private String district;
	//详细地址
	private String address;
	//是否关注 0-否 1-是
	private Integer isAttention;
	//关注原因
	private String attentionCause;
	//状态 0-有效 1-无效
	private Integer status;
	//备注
	private String remark;
	//创建时间
	private Date gmtCreate;
	//修改时间
	private Date gmtModified;
	//是否删除：0-否，1-是
	private Integer isDelete;

	/**
	 * 设置：往来单位主键
	 */
	public void setFtBtypeId(Integer ftBtypeId) {
		this.ftBtypeId = ftBtypeId;
	}
	/**
	 * 获取：往来单位主键
	 */
	public Integer getFtBtypeId() {
		return ftBtypeId;
	}
	/**
	 * 设置：委托方公司主键
	 */
	public void setFtClientCompanyId(Integer ftClientCompanyId) {
		this.ftClientCompanyId = ftClientCompanyId;
	}
	/**
	 * 获取：委托方公司主键
	 */
	public Integer getFtClientCompanyId() {
		return ftClientCompanyId;
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
	 * 设置：往来单位编号
	 */
	public void setBtypeNo(Integer btypeNo) {
		this.btypeNo = btypeNo;
	}
	/**
	 * 获取：往来单位编号
	 */
	public Integer getBtypeNo() {
		return btypeNo;
	}
	/**
	 * 设置：往来单位名称
	 */
	public void setBtypeName(String btypeName) {
		this.btypeName = btypeName;
	}
	/**
	 * 获取：往来单位名称
	 */
	public String getBtypeName() {
		return btypeName;
	}
	/**
	 * 设置：往来单位类型 0-开票单位 1-贷代 2-银行 3-保险公司 4-国外客户 5-资金往来单位
	 */
	public void setBtypeType(Integer btypeType) {
		this.btypeType = btypeType;
	}
	/**
	 * 获取：往来单位类型 0-开票单位 1-贷代 2-银行 3-保险公司 4-国外客户 5-资金往来单位
	 */
	public Integer getBtypeType() {
		return btypeType;
	}
	/**
	 * 设置：是否生产企业 0-否 1-是，单位类型选择为开票单位后填写此项
	 */
	public void setIsManufacture(Integer isManufacture) {
		this.isManufacture = isManufacture;
	}
	/**
	 * 获取：是否生产企业 0-否 1-是，单位类型选择为开票单位后填写此项
	 */
	public Integer getIsManufacture() {
		return isManufacture;
	}
	/**
	 * 设置：开始营业期限
	 */
	public void setStartBusiDate(Date startBusiDate) {
		this.startBusiDate = startBusiDate;
	}
	/**
	 * 获取：开始营业期限
	 */
	public Date getStartBusiDate() {
		return startBusiDate;
	}
	/**
	 * 设置：结束营业期限
	 */
	public void setCloseBusiDate(Date closeBusiDate) {
		this.closeBusiDate = closeBusiDate;
	}
	/**
	 * 获取：结束营业期限
	 */
	public Date getCloseBusiDate() {
		return closeBusiDate;
	}
	/**
	 * 设置：省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：区
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * 获取：区
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * 设置：详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：是否关注 0-否 1-是
	 */
	public void setIsAttention(Integer isAttention) {
		this.isAttention = isAttention;
	}
	/**
	 * 获取：是否关注 0-否 1-是
	 */
	public Integer getIsAttention() {
		return isAttention;
	}
	/**
	 * 设置：关注原因
	 */
	public void setAttentionCause(String attentionCause) {
		this.attentionCause = attentionCause;
	}
	/**
	 * 获取：关注原因
	 */
	public String getAttentionCause() {
		return attentionCause;
	}
	/**
	 * 设置：状态 0-有效 1-无效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 0-有效 1-无效
	 */
	public Integer getStatus() {
		return status;
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
