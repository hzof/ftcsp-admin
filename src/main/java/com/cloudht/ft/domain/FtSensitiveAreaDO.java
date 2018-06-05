package com.cloudht.ft.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 敏感地区
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-05 18:50:41
 */
public class FtSensitiveAreaDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//敏感地区管理表主键
	private Integer ftSensitiveAreaId;
	//省
	private String province;
	//市
	private String city;
	//市/县/区
	private String district;
	//创建人，引用用户表的id
	private Integer userId;
	//备注
	private String remark;
	//创建时间
	private Date gmtCreate;

	/**
	 * 设置：敏感地区管理表主键
	 */
	public void setFtSensitiveAreaId(Integer ftSensitiveAreaId) {
		this.ftSensitiveAreaId = ftSensitiveAreaId;
	}
	/**
	 * 获取：敏感地区管理表主键
	 */
	public Integer getFtSensitiveAreaId() {
		return ftSensitiveAreaId;
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
	 * 设置：市/县/区
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * 获取：市/县/区
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * 设置：创建人，引用用户表的id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：创建人，引用用户表的id
	 */
	public Integer getUserId() {
		return userId;
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
}
