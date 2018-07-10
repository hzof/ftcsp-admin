package com.cloudht.ft.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 委托方公司表
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-07-03 11:42:19
 */
public class FtClientCompanyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer ftClientCompanyId;
	//委托方
	private Long ftClientId;
	//公司类型：0-境内公司 1-个人注册 2-境外公司
	private Integer companyType;
	//公司名称
	private String companyName;
	//公司所属省
	private String province;
	//公司所属市
	private String city;
	//公司详细地址
	private String detailedAddress;
	//统一社会信用代码
	private String companyCode;
	//营业执照url
	private String businessLicenseUrl;
	//身份信息面对应文件表的url
	private String identityCardUrl;
	//身份证国徽面的url
	private String identityCardbUrl;
	//姓名
	private String name;
	//性别 0-男 1-女
	private Integer sex;
	//手机
	private String mobilePhone;
	//公司固话
	private String companyPhone;
	//创建时间
	private Date gmtCreate;
	//修改时间
	private Date gmtModified;
	//是否删除：0-否，1-是
	private Integer isDelete;

	/**
	 * 设置：主键
	 */
	public void setFtClientCompanyId(Integer ftClientCompanyId) {
		this.ftClientCompanyId = ftClientCompanyId;
	}
	/**
	 * 获取：主键
	 */
	public Integer getFtClientCompanyId() {
		return ftClientCompanyId;
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
	 * 设置：公司类型：0-境内公司 1-个人注册 2-境外公司
	 */
	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
	}
	/**
	 * 获取：公司类型：0-境内公司 1-个人注册 2-境外公司
	 */
	public Integer getCompanyType() {
		return companyType;
	}
	/**
	 * 设置：公司名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：公司名称
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：公司所属省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：公司所属省
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：公司所属市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：公司所属市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：公司详细地址
	 */
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	/**
	 * 获取：公司详细地址
	 */
	public String getDetailedAddress() {
		return detailedAddress;
	}
	/**
	 * 设置：统一社会信用代码
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	/**
	 * 获取：统一社会信用代码
	 */
	public String getCompanyCode() {
		return companyCode;
	}
	/**
	 * 设置：营业执照url
	 */
	public void setBusinessLicenseUrl(String businessLicenseUrl) {
		this.businessLicenseUrl = businessLicenseUrl;
	}
	/**
	 * 获取：营业执照url
	 */
	public String getBusinessLicenseUrl() {
		return businessLicenseUrl;
	}
	/**
	 * 设置：身份信息面对应文件表的url
	 */
	public void setIdentityCardUrl(String identityCardUrl) {
		this.identityCardUrl = identityCardUrl;
	}
	/**
	 * 获取：身份信息面对应文件表的url
	 */
	public String getIdentityCardUrl() {
		return identityCardUrl;
	}
	/**
	 * 设置：身份证国徽面的url
	 */
	public void setIdentityCardbUrl(String identityCardbUrl) {
		this.identityCardbUrl = identityCardbUrl;
	}
	/**
	 * 获取：身份证国徽面的url
	 */
	public String getIdentityCardbUrl() {
		return identityCardbUrl;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：性别 0-男 1-女
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别 0-男 1-女
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：手机
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	/**
	 * 获取：手机
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	/**
	 * 设置：公司固话
	 */
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	/**
	 * 获取：公司固话
	 */
	public String getCompanyPhone() {
		return companyPhone;
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
