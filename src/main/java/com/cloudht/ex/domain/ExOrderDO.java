package com.cloudht.ex.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 出口订单
 * 
 * @author yuxueling
 * @email 980899486@qq.com
 * @date 2018-06-15 10:31:08
 */
public class ExOrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long exOrderId;
	//委托方
	private Long ftClientId;
	//委托方公司名称
	private String companyName;
	//出口发票号
	private String exportInvoiceNo;
	//外销合同号
	private String exportContractNo;
	//交货日期
	private Date deliveryDate;
	//联系人
	private String orderContact;
	//办公室电话
	private String officePhone;
	//手机
	private String orderPhone;
	//收货人
	private String consignee;
	//订单备注
	private String orderRemark;
	//是否已结算：0-未结算状态，1-已结算状态
	private Integer isSettled;
	//审核状态：0-未提交，1-待受理，2-待专家受理，3-拒绝受理，4-已撤销，5-撤回修改，6-已受理
	private Integer auditStatus;
	//受理时间
	private Date processTime;
	//贸易国别
	private String tradeCountry;
	//贸易方式
	private String tradeWay;
	//价格条款
	private String priceTerms;
	//运费
	private Integer freight;
	//运抵国
	private String destinationCountry;
	//币别
	private String currency;
	//装运期限
	private Date shipmentDeadline;
	//运输方式
	private String transportMode;
	//起运港
	private String departurePort;
	//转运港
	private String transitPort;
	//目的港
	private String destinationPort;
	//境内货源地
	private String territorySourcePlace;
	//生产厂家
	private String manufactureFactory;
	//厂家联系人
	private String factoryContact;
	//厂家联系电话
	private String factoryPhone;
	//结汇方式
	private String settlementWay;
	//信用证号码
	private String creditNo;
	//是否有结汇单证：0-否，1-是
	private Integer isSettleExg;
	//提单
	private Integer billLadingNum;
	//发票
	private Integer invoiceNum;
	//装箱单
	private Integer packingListNum;
	//汇票
	private Integer draftNum;
	//品质证
	private Integer qualityCertificateNum;
	//重量单
	private Integer weightListNum;
	//产地证
	private Integer certificateOriginNum;
	//检疫证
	private Integer certificateQuarantineNum;
	//保险单
	private Integer insurancePolicyNum;
	//其它
	private String others;
	//已确认证件（多选“，”分隔）：00-商检，01-订舱，02-报关，03-提单确认，04-结汇单证，05-产地证
	private String credentials;
	//操作类型：0-非全套操作，1-全套操作，2-客户制单
	private Integer operationType;
	//客服服务记录/备注
	private String serviceRemark;
	//环节名称
	private String linkName;
	//环节状态
	private String linkStatus;
	//完成时间
	private Date finishDate;
	//已制作托单：0-否，1-是
	private Integer isShipOrder;
	//已制作报检：0-否，1-是
	private Integer isCustomsInspection;
	//已制作报关：0-否，1-是
	private Integer isCustomsDeclaration;
	//已制作产地证：0-否，1-是
	private Integer isOriginCertificate;
	//已制作议付单证：0-否，1-是
	private Integer isNegotiation;
	//已制作托收：0-否，1-是
	private Integer isCollection;
	//已制作订单环节：0-否，1-是
	private Integer isOrderLink;
	//指定船公司
	private String specifyShipCompany;
	//指定货代类型:0-平台指定，1-自己指定
	private Integer appointForwarderType;
	//货代公司
	private String forwarderCompanyName;
	//货代联系人
	private String forwarderContact;
	//货代手机
	private String forwarderPhone;
	//货代传真
	private String forwarderFax;
	//货代公司地址
	private String forwarderAddress;
	//报关行名称
	private String customsBrokerName;
	//报关行代码
	private String customsBrokerCode;
	//进仓通知书文件ID
	private Long entryNoticeFileId;
	//装箱方式：0-拼箱，1-整柜，2-拼车？，3-整车？
	private Integer encasementType;
	//保险或融资服务(多选“,”分隔):00-信用保险,01-退税融资,02-LC融资,03-其他融资
	private String insuranceFinanceService;
	//总包装数
	private Integer pkgs;
	//总体积
	private Float totalVolume;
	//总毛重
	private Float totalRoughWeight;
	//总净重
	private Float totalNetWeight;
	//总金额
	private Integer totalAmount;
	//换汇成本
	private Integer foreignExgCost;
	//创建人ID
	private Long createBy;
	//客服人员id
	private Integer servicerId;
	//客服人员名字
	private String servicerName;
	//创建时间
	private Date gmtCreate;
	//是否已删除：0-否，1-是
	private Integer isDeleted;
	//需要查询的状态数组
	private String[] auditStatusArray;
	public String[] getAuditStatusArray() {
		return auditStatusArray;
	}
	public void setAuditStatusArray(String[] auditStatusArray) {
		this.auditStatusArray = auditStatusArray;
	}
	/**
	 * 设置：主键
	 */
	public void setExOrderId(Long exOrderId) {
		this.exOrderId = exOrderId;
	}
	/**
	 * 获取：主键
	 */
	public Long getExOrderId() {
		return exOrderId;
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
	 * 设置：委托方公司名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：委托方公司名称
	 */
	public String getCompanyName() {
		return companyName;
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
	 * 设置：联系人
	 */
	public void setOrderContact(String orderContact) {
		this.orderContact = orderContact;
	}
	/**
	 * 获取：联系人
	 */
	public String getOrderContact() {
		return orderContact;
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
	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}
	/**
	 * 获取：手机
	 */
	public String getOrderPhone() {
		return orderPhone;
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
	 * 设置：订单备注
	 */
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	/**
	 * 获取：订单备注
	 */
	public String getOrderRemark() {
		return orderRemark;
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
	 * 设置：贸易国别
	 */
	public void setTradeCountry(String tradeCountry) {
		this.tradeCountry = tradeCountry;
	}
	/**
	 * 获取：贸易国别
	 */
	public String getTradeCountry() {
		return tradeCountry;
	}
	/**
	 * 设置：贸易方式
	 */
	public void setTradeWay(String tradeWay) {
		this.tradeWay = tradeWay;
	}
	/**
	 * 获取：贸易方式
	 */
	public String getTradeWay() {
		return tradeWay;
	}
	/**
	 * 设置：价格条款
	 */
	public void setPriceTerms(String priceTerms) {
		this.priceTerms = priceTerms;
	}
	/**
	 * 获取：价格条款
	 */
	public String getPriceTerms() {
		return priceTerms;
	}
	/**
	 * 设置：运费
	 */
	public void setFreight(Integer freight) {
		this.freight = freight;
	}
	/**
	 * 获取：运费
	 */
	public Integer getFreight() {
		return freight;
	}
	/**
	 * 设置：运抵国
	 */
	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}
	/**
	 * 获取：运抵国
	 */
	public String getDestinationCountry() {
		return destinationCountry;
	}
	/**
	 * 设置：币别
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * 获取：币别
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 设置：装运期限
	 */
	public void setShipmentDeadline(Date shipmentDeadline) {
		this.shipmentDeadline = shipmentDeadline;
	}
	/**
	 * 获取：装运期限
	 */
	public Date getShipmentDeadline() {
		return shipmentDeadline;
	}
	/**
	 * 设置：运输方式
	 */
	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}
	/**
	 * 获取：运输方式
	 */
	public String getTransportMode() {
		return transportMode;
	}
	/**
	 * 设置：起运港
	 */
	public void setDeparturePort(String departurePort) {
		this.departurePort = departurePort;
	}
	/**
	 * 获取：起运港
	 */
	public String getDeparturePort() {
		return departurePort;
	}
	/**
	 * 设置：转运港
	 */
	public void setTransitPort(String transitPort) {
		this.transitPort = transitPort;
	}
	/**
	 * 获取：转运港
	 */
	public String getTransitPort() {
		return transitPort;
	}
	/**
	 * 设置：目的港
	 */
	public void setDestinationPort(String destinationPort) {
		this.destinationPort = destinationPort;
	}
	/**
	 * 获取：目的港
	 */
	public String getDestinationPort() {
		return destinationPort;
	}
	/**
	 * 设置：境内货源地
	 */
	public void setTerritorySourcePlace(String territorySourcePlace) {
		this.territorySourcePlace = territorySourcePlace;
	}
	/**
	 * 获取：境内货源地
	 */
	public String getTerritorySourcePlace() {
		return territorySourcePlace;
	}
	/**
	 * 设置：生产厂家
	 */
	public void setManufactureFactory(String manufactureFactory) {
		this.manufactureFactory = manufactureFactory;
	}
	/**
	 * 获取：生产厂家
	 */
	public String getManufactureFactory() {
		return manufactureFactory;
	}
	/**
	 * 设置：厂家联系人
	 */
	public void setFactoryContact(String factoryContact) {
		this.factoryContact = factoryContact;
	}
	/**
	 * 获取：厂家联系人
	 */
	public String getFactoryContact() {
		return factoryContact;
	}
	/**
	 * 设置：厂家联系电话
	 */
	public void setFactoryPhone(String factoryPhone) {
		this.factoryPhone = factoryPhone;
	}
	/**
	 * 获取：厂家联系电话
	 */
	public String getFactoryPhone() {
		return factoryPhone;
	}
	/**
	 * 设置：结汇方式
	 */
	public void setSettlementWay(String settlementWay) {
		this.settlementWay = settlementWay;
	}
	/**
	 * 获取：结汇方式
	 */
	public String getSettlementWay() {
		return settlementWay;
	}
	/**
	 * 设置：信用证号码
	 */
	public void setCreditNo(String creditNo) {
		this.creditNo = creditNo;
	}
	/**
	 * 获取：信用证号码
	 */
	public String getCreditNo() {
		return creditNo;
	}
	/**
	 * 设置：是否有结汇单证：0-否，1-是
	 */
	public void setIsSettleExg(Integer isSettleExg) {
		this.isSettleExg = isSettleExg;
	}
	/**
	 * 获取：是否有结汇单证：0-否，1-是
	 */
	public Integer getIsSettleExg() {
		return isSettleExg;
	}
	/**
	 * 设置：提单
	 */
	public void setBillLadingNum(Integer billLadingNum) {
		this.billLadingNum = billLadingNum;
	}
	/**
	 * 获取：提单
	 */
	public Integer getBillLadingNum() {
		return billLadingNum;
	}
	/**
	 * 设置：发票
	 */
	public void setInvoiceNum(Integer invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
	/**
	 * 获取：发票
	 */
	public Integer getInvoiceNum() {
		return invoiceNum;
	}
	/**
	 * 设置：装箱单
	 */
	public void setPackingListNum(Integer packingListNum) {
		this.packingListNum = packingListNum;
	}
	/**
	 * 获取：装箱单
	 */
	public Integer getPackingListNum() {
		return packingListNum;
	}
	/**
	 * 设置：汇票
	 */
	public void setDraftNum(Integer draftNum) {
		this.draftNum = draftNum;
	}
	/**
	 * 获取：汇票
	 */
	public Integer getDraftNum() {
		return draftNum;
	}
	/**
	 * 设置：品质证
	 */
	public void setQualityCertificateNum(Integer qualityCertificateNum) {
		this.qualityCertificateNum = qualityCertificateNum;
	}
	/**
	 * 获取：品质证
	 */
	public Integer getQualityCertificateNum() {
		return qualityCertificateNum;
	}
	/**
	 * 设置：重量单
	 */
	public void setWeightListNum(Integer weightListNum) {
		this.weightListNum = weightListNum;
	}
	/**
	 * 获取：重量单
	 */
	public Integer getWeightListNum() {
		return weightListNum;
	}
	/**
	 * 设置：产地证
	 */
	public void setCertificateOriginNum(Integer certificateOriginNum) {
		this.certificateOriginNum = certificateOriginNum;
	}
	/**
	 * 获取：产地证
	 */
	public Integer getCertificateOriginNum() {
		return certificateOriginNum;
	}
	/**
	 * 设置：检疫证
	 */
	public void setCertificateQuarantineNum(Integer certificateQuarantineNum) {
		this.certificateQuarantineNum = certificateQuarantineNum;
	}
	/**
	 * 获取：检疫证
	 */
	public Integer getCertificateQuarantineNum() {
		return certificateQuarantineNum;
	}
	/**
	 * 设置：保险单
	 */
	public void setInsurancePolicyNum(Integer insurancePolicyNum) {
		this.insurancePolicyNum = insurancePolicyNum;
	}
	/**
	 * 获取：保险单
	 */
	public Integer getInsurancePolicyNum() {
		return insurancePolicyNum;
	}
	/**
	 * 设置：其它
	 */
	public void setOthers(String others) {
		this.others = others;
	}
	/**
	 * 获取：其它
	 */
	public String getOthers() {
		return others;
	}
	/**
	 * 设置：已确认证件（多选“，”分隔）：00-商检，01-订舱，02-报关，03-提单确认，04-结汇单证，05-产地证
	 */
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	/**
	 * 获取：已确认证件（多选“，”分隔）：00-商检，01-订舱，02-报关，03-提单确认，04-结汇单证，05-产地证
	 */
	public String getCredentials() {
		return credentials;
	}
	/**
	 * 设置：操作类型：0-非全套操作，1-全套操作，2-客户制单
	 */
	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}
	/**
	 * 获取：操作类型：0-非全套操作，1-全套操作，2-客户制单
	 */
	public Integer getOperationType() {
		return operationType;
	}
	/**
	 * 设置：客服服务记录/备注
	 */
	public void setServiceRemark(String serviceRemark) {
		this.serviceRemark = serviceRemark;
	}
	/**
	 * 获取：客服服务记录/备注
	 */
	public String getServiceRemark() {
		return serviceRemark;
	}
	/**
	 * 设置：环节名称
	 */
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	/**
	 * 获取：环节名称
	 */
	public String getLinkName() {
		return linkName;
	}
	/**
	 * 设置：环节状态
	 */
	public void setLinkStatus(String linkStatus) {
		this.linkStatus = linkStatus;
	}
	/**
	 * 获取：环节状态
	 */
	public String getLinkStatus() {
		return linkStatus;
	}
	/**
	 * 设置：完成时间
	 */
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	/**
	 * 获取：完成时间
	 */
	public Date getFinishDate() {
		return finishDate;
	}
	/**
	 * 设置：已制作托单：0-否，1-是
	 */
	public void setIsShipOrder(Integer isShipOrder) {
		this.isShipOrder = isShipOrder;
	}
	/**
	 * 获取：已制作托单：0-否，1-是
	 */
	public Integer getIsShipOrder() {
		return isShipOrder;
	}
	/**
	 * 设置：已制作报检：0-否，1-是
	 */
	public void setIsCustomsInspection(Integer isCustomsInspection) {
		this.isCustomsInspection = isCustomsInspection;
	}
	/**
	 * 获取：已制作报检：0-否，1-是
	 */
	public Integer getIsCustomsInspection() {
		return isCustomsInspection;
	}
	/**
	 * 设置：已制作报关：0-否，1-是
	 */
	public void setIsCustomsDeclaration(Integer isCustomsDeclaration) {
		this.isCustomsDeclaration = isCustomsDeclaration;
	}
	/**
	 * 获取：已制作报关：0-否，1-是
	 */
	public Integer getIsCustomsDeclaration() {
		return isCustomsDeclaration;
	}
	/**
	 * 设置：已制作产地证：0-否，1-是
	 */
	public void setIsOriginCertificate(Integer isOriginCertificate) {
		this.isOriginCertificate = isOriginCertificate;
	}
	/**
	 * 获取：已制作产地证：0-否，1-是
	 */
	public Integer getIsOriginCertificate() {
		return isOriginCertificate;
	}
	/**
	 * 设置：已制作议付单证：0-否，1-是
	 */
	public void setIsNegotiation(Integer isNegotiation) {
		this.isNegotiation = isNegotiation;
	}
	/**
	 * 获取：已制作议付单证：0-否，1-是
	 */
	public Integer getIsNegotiation() {
		return isNegotiation;
	}
	/**
	 * 设置：已制作托收：0-否，1-是
	 */
	public void setIsCollection(Integer isCollection) {
		this.isCollection = isCollection;
	}
	/**
	 * 获取：已制作托收：0-否，1-是
	 */
	public Integer getIsCollection() {
		return isCollection;
	}
	/**
	 * 设置：已制作订单环节：0-否，1-是
	 */
	public void setIsOrderLink(Integer isOrderLink) {
		this.isOrderLink = isOrderLink;
	}
	/**
	 * 获取：已制作订单环节：0-否，1-是
	 */
	public Integer getIsOrderLink() {
		return isOrderLink;
	}
	/**
	 * 设置：指定船公司
	 */
	public void setSpecifyShipCompany(String specifyShipCompany) {
		this.specifyShipCompany = specifyShipCompany;
	}
	/**
	 * 获取：指定船公司
	 */
	public String getSpecifyShipCompany() {
		return specifyShipCompany;
	}
	/**
	 * 设置：指定货代类型:0-平台指定，1-自己指定
	 */
	public void setAppointForwarderType(Integer appointForwarderType) {
		this.appointForwarderType = appointForwarderType;
	}
	/**
	 * 获取：指定货代类型:0-平台指定，1-自己指定
	 */
	public Integer getAppointForwarderType() {
		return appointForwarderType;
	}
	/**
	 * 设置：货代公司
	 */
	public void setForwarderCompanyName(String forwarderCompanyName) {
		this.forwarderCompanyName = forwarderCompanyName;
	}
	/**
	 * 获取：货代公司
	 */
	public String getForwarderCompanyName() {
		return forwarderCompanyName;
	}
	/**
	 * 设置：货代联系人
	 */
	public void setForwarderContact(String forwarderContact) {
		this.forwarderContact = forwarderContact;
	}
	/**
	 * 获取：货代联系人
	 */
	public String getForwarderContact() {
		return forwarderContact;
	}
	/**
	 * 设置：货代手机
	 */
	public void setForwarderPhone(String forwarderPhone) {
		this.forwarderPhone = forwarderPhone;
	}
	/**
	 * 获取：货代手机
	 */
	public String getForwarderPhone() {
		return forwarderPhone;
	}
	/**
	 * 设置：货代传真
	 */
	public void setForwarderFax(String forwarderFax) {
		this.forwarderFax = forwarderFax;
	}
	/**
	 * 获取：货代传真
	 */
	public String getForwarderFax() {
		return forwarderFax;
	}
	/**
	 * 设置：货代公司地址
	 */
	public void setForwarderAddress(String forwarderAddress) {
		this.forwarderAddress = forwarderAddress;
	}
	/**
	 * 获取：货代公司地址
	 */
	public String getForwarderAddress() {
		return forwarderAddress;
	}
	/**
	 * 设置：报关行名称
	 */
	public void setCustomsBrokerName(String customsBrokerName) {
		this.customsBrokerName = customsBrokerName;
	}
	/**
	 * 获取：报关行名称
	 */
	public String getCustomsBrokerName() {
		return customsBrokerName;
	}
	/**
	 * 设置：报关行代码
	 */
	public void setCustomsBrokerCode(String customsBrokerCode) {
		this.customsBrokerCode = customsBrokerCode;
	}
	/**
	 * 获取：报关行代码
	 */
	public String getCustomsBrokerCode() {
		return customsBrokerCode;
	}
	/**
	 * 设置：进仓通知书文件ID
	 */
	public void setEntryNoticeFileId(Long entryNoticeFileId) {
		this.entryNoticeFileId = entryNoticeFileId;
	}
	/**
	 * 获取：进仓通知书文件ID
	 */
	public Long getEntryNoticeFileId() {
		return entryNoticeFileId;
	}
	/**
	 * 设置：装箱方式：0-拼箱，1-整柜，2-拼车？，3-整车？
	 */
	public void setEncasementType(Integer encasementType) {
		this.encasementType = encasementType;
	}
	/**
	 * 获取：装箱方式：0-拼箱，1-整柜，2-拼车？，3-整车？
	 */
	public Integer getEncasementType() {
		return encasementType;
	}
	/**
	 * 设置：保险或融资服务(多选“,”分隔):00-信用保险,01-退税融资,02-LC融资,03-其他融资
	 */
	public void setInsuranceFinanceService(String insuranceFinanceService) {
		this.insuranceFinanceService = insuranceFinanceService;
	}
	/**
	 * 获取：保险或融资服务(多选“,”分隔):00-信用保险,01-退税融资,02-LC融资,03-其他融资
	 */
	public String getInsuranceFinanceService() {
		return insuranceFinanceService;
	}
	/**
	 * 设置：总包装数
	 */
	public void setPkgs(Integer pkgs) {
		this.pkgs = pkgs;
	}
	/**
	 * 获取：总包装数
	 */
	public Integer getPkgs() {
		return pkgs;
	}
	/**
	 * 设置：总体积
	 */
	public void setTotalVolume(Float totalVolume) {
		this.totalVolume = totalVolume;
	}
	/**
	 * 获取：总体积
	 */
	public Float getTotalVolume() {
		return totalVolume;
	}
	/**
	 * 设置：总毛重
	 */
	public void setTotalRoughWeight(Float totalRoughWeight) {
		this.totalRoughWeight = totalRoughWeight;
	}
	/**
	 * 获取：总毛重
	 */
	public Float getTotalRoughWeight() {
		return totalRoughWeight;
	}
	/**
	 * 设置：总净重
	 */
	public void setTotalNetWeight(Float totalNetWeight) {
		this.totalNetWeight = totalNetWeight;
	}
	/**
	 * 获取：总净重
	 */
	public Float getTotalNetWeight() {
		return totalNetWeight;
	}
	/**
	 * 设置：总金额
	 */
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * 获取：总金额
	 */
	public Integer getTotalAmount() {
		return totalAmount;
	}
	/**
	 * 设置：换汇成本
	 */
	public void setForeignExgCost(Integer foreignExgCost) {
		this.foreignExgCost = foreignExgCost;
	}
	/**
	 * 获取：换汇成本
	 */
	public Integer getForeignExgCost() {
		return foreignExgCost;
	}
	/**
	 * 设置：创建人ID
	 */
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建人ID
	 */
	public Long getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：客服人员id
	 */
	public void setServicerId(Integer servicerId) {
		this.servicerId = servicerId;
	}
	/**
	 * 获取：客服人员id
	 */
	public Integer getServicerId() {
		return servicerId;
	}
	/**
	 * 设置：客服人员名字
	 */
	public void setServicerName(String servicerName) {
		this.servicerName = servicerName;
	}
	/**
	 * 获取：客服人员名字
	 */
	public String getServicerName() {
		return servicerName;
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
}
