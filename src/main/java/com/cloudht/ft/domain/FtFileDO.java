package com.cloudht.ft.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-07-17 16:40:02
 */
public class FtFileDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//文件表主键
	private Long ftFileId;
	//客户表主键
	private Long ftClientId;
	//文件来源
	private Integer fileSource;
	//引用表的主键
	private Long refKey;
	//文件类型
	private Integer type;
	//URL地址
	private String url;
	//是否可见 0-不可见 1-可见
	private Integer isVisible;
	//创建时间
	private Date createDate;

	/**
	 * 设置：文件表主键
	 */
	public void setFtFileId(Long ftFileId) {
		this.ftFileId = ftFileId;
	}
	/**
	 * 获取：文件表主键
	 */
	public Long getFtFileId() {
		return ftFileId;
	}
	/**
	 * 设置：客户表主键
	 */
	public void setFtClientId(Long ftClientId) {
		this.ftClientId = ftClientId;
	}
	/**
	 * 获取：客户表主键
	 */
	public Long getFtClientId() {
		return ftClientId;
	}
	/**
	 * 设置：文件来源按照如下列举的数字传入
	 * 1-在不需要使用此字段时填入 common
	 * 2-客户合同管理的附件
	 */
	public void setFileSource(Integer fileSource) {
		this.fileSource = fileSource;
	}
	/**
	 * 获取：文件来源
	 */
	public Integer getFileSource() {
		return fileSource;
	}
	/**
	 * 设置：引用表的主键
	 */
	public void setRefKey(Long refKey) {
		this.refKey = refKey;
	}
	/**
	 * 获取：引用表的主键
	 */
	public Long getRefKey() {
		return refKey;
	}
	/**
	 * 设置：文件类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：文件类型
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：URL地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：URL地址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：是否可见 0-不可见 1-可见
	 */
	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}
	/**
	 * 获取：是否可见 0-不可见 1-可见
	 */
	public Integer getIsVisible() {
		return isVisible;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	@Override
	public String toString() {
		return "FtFileDO [ftFileId=" + ftFileId + ", ftClientId=" + ftClientId + ", fileSource=" + fileSource
				+ ", refKey=" + refKey + ", type=" + type + ", url=" + url + ", isVisible=" + isVisible
				+ ", createDate=" + createDate + "]";
	}
}
