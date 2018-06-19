/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ftcsp_admin

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-15 18:11:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ex_order`
-- ----------------------------
DROP TABLE IF EXISTS `ex_order`;
CREATE TABLE `ex_order` (
  `ex_order_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ft_client_id` bigint(20) unsigned DEFAULT NULL COMMENT '委托方',
  `company_name` varchar(32) DEFAULT NULL COMMENT '委托方公司名称',
  `export_invoice_no` varchar(16) NOT NULL COMMENT '出口发票号',
  `export_contract_no` varchar(16) NOT NULL COMMENT '外销合同号',
  `delivery_date` datetime DEFAULT NULL COMMENT '交货日期',
  `order_contact` varchar(16) DEFAULT NULL COMMENT '联系人',
  `office_phone` varchar(16) DEFAULT NULL COMMENT '办公室电话',
  `order_phone` char(11) DEFAULT NULL COMMENT '手机',
  `consignee` varchar(128) DEFAULT NULL COMMENT '收货人',
  `order_remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `is_settled` tinyint(255) unsigned DEFAULT NULL COMMENT '是否已结算：0-未结算状态，1-已结算状态',
  `audit_status` tinyint(255) unsigned DEFAULT NULL COMMENT '审核状态：0-未提交，1-待受理，2-待专家受理，3-拒绝受理，4-已撤销，5-撤回修改，6-已受理',
  `process_time` datetime DEFAULT NULL COMMENT '受理时间',
  `trade_country` varchar(64) NOT NULL COMMENT '贸易国别',
  `trade_way` varchar(16) DEFAULT NULL COMMENT '贸易方式',
  `price_terms` varchar(8) DEFAULT NULL COMMENT '价格条款',
  `freight` int(255) DEFAULT NULL COMMENT '运费',
  `destination_country` varchar(64) DEFAULT NULL COMMENT '运抵国',
  `currency` varchar(8) DEFAULT NULL COMMENT '币别',
  `shipment_deadline` datetime DEFAULT NULL COMMENT '装运期限',
  `transport_mode` varchar(8) DEFAULT NULL COMMENT '运输方式',
  `departure_port` varchar(64) DEFAULT NULL COMMENT '起运港',
  `transit_port` varchar(64) DEFAULT NULL COMMENT '转运港',
  `destination_port` varchar(64) DEFAULT NULL COMMENT '目的港',
  `territory_source_place` varchar(16) DEFAULT NULL COMMENT '境内货源地',
  `manufacture_factory` varchar(32) NOT NULL COMMENT '生产厂家',
  `factory_contact` varchar(16) DEFAULT NULL COMMENT '厂家联系人',
  `factory_phone` char(11) DEFAULT NULL COMMENT '厂家联系电话',
  `settlement_way` varchar(4) DEFAULT NULL COMMENT '结汇方式',
  `credit_no` varchar(32) DEFAULT NULL COMMENT '信用证号码',
  `is_settle_exg` tinyint(2) unsigned DEFAULT NULL COMMENT '是否有结汇单证：0-否，1-是',
  `bill_lading_num` tinyint(3) unsigned DEFAULT NULL COMMENT '提单',
  `invoice_num` tinyint(3) unsigned DEFAULT NULL COMMENT '发票',
  `packing_list_num` tinyint(3) unsigned DEFAULT NULL COMMENT '装箱单',
  `draft_num` tinyint(3) unsigned DEFAULT NULL COMMENT '汇票',
  `quality_certificate_num` tinyint(3) unsigned DEFAULT NULL COMMENT '品质证',
  `weight_list_num` tinyint(3) unsigned DEFAULT NULL COMMENT '重量单',
  `certificate_origin_num` tinyint(3) unsigned DEFAULT NULL COMMENT '产地证',
  `certificate_quarantine_num` tinyint(3) unsigned DEFAULT NULL COMMENT '检疫证',
  `insurance_policy_num` tinyint(3) unsigned DEFAULT NULL COMMENT '保险单',
  `others` varchar(32) DEFAULT NULL COMMENT '其它',
  `credentials` varchar(32) DEFAULT NULL COMMENT '已确认证件（多选“，”分隔）：00-商检，01-订舱，02-报关，03-提单确认，04-结汇单证，05-产地证',
  `operation_type` tinyint(255) unsigned DEFAULT NULL COMMENT '操作类型：0-非全套操作，1-全套操作，2-客户制单',
  `service_remark` varchar(127) DEFAULT NULL COMMENT '客服服务记录/备注',
  `link_name` varchar(8) DEFAULT NULL COMMENT '环节名称',
  `link_status` varchar(255) DEFAULT NULL COMMENT '环节状态',
  `finish_date` datetime DEFAULT NULL COMMENT '完成时间',
  `is_ship_order` tinyint(2) DEFAULT NULL COMMENT '已制作托单：0-否，1-是',
  `is_customs_inspection` tinyint(2) DEFAULT NULL COMMENT '已制作报检：0-否，1-是',
  `is_customs_declaration` tinyint(2) DEFAULT NULL COMMENT '已制作报关：0-否，1-是',
  `is_origin_certificate` tinyint(2) DEFAULT NULL COMMENT '已制作产地证：0-否，1-是',
  `is_negotiation` tinyint(2) DEFAULT NULL COMMENT '已制作议付单证：0-否，1-是',
  `is_collection` tinyint(2) DEFAULT NULL COMMENT '已制作托收：0-否，1-是',
  `is_order_link` tinyint(2) DEFAULT NULL COMMENT '已制作订单环节：0-否，1-是',
  `specify_ship_company` varchar(32) DEFAULT NULL COMMENT '指定船公司',
  `appoint_forwarder_type` tinyint(255) DEFAULT NULL COMMENT '指定货代类型:0-平台指定，1-自己指定',
  `forwarder_company_name` varchar(32) DEFAULT NULL COMMENT '货代公司',
  `forwarder_contact` varchar(16) DEFAULT NULL COMMENT '货代联系人',
  `forwarder_phone` char(11) DEFAULT NULL COMMENT '货代手机',
  `forwarder_fax` varchar(16) DEFAULT NULL COMMENT '货代传真',
  `forwarder_address` varchar(64) DEFAULT NULL COMMENT '货代公司地址',
  `customs_broker_name` varchar(32) DEFAULT NULL COMMENT '报关行名称',
  `customs_broker_code` varchar(32) DEFAULT NULL COMMENT '报关行代码',
  `entry_notice_file_id` bigint(255) DEFAULT NULL COMMENT '进仓通知书文件ID',
  `encasement_type` tinyint(255) DEFAULT NULL COMMENT '装箱方式：0-拼箱，1-整柜，2-拼车？，3-整车？',
  `insurance_finance_service` varchar(32) DEFAULT NULL COMMENT '保险或融资服务(多选“,”分隔):00-信用保险,01-退税融资,02-LC融资,03-其他融资',
  `pkgs` int(255) DEFAULT NULL COMMENT '总包装数',
  `total_volume` float(255,0) DEFAULT NULL COMMENT '总体积',
  `total_rough_weight` float(255,0) DEFAULT NULL COMMENT '总毛重',
  `total_net_weight` float(255,0) DEFAULT NULL COMMENT '总净重',
  `total_amount` int(255) DEFAULT NULL COMMENT '总金额',
  `foreign_exg_cost` int(255) DEFAULT NULL COMMENT '换汇成本',
  `create_by` bigint(20) unsigned DEFAULT NULL COMMENT '创建人ID',
  `servicer_id` int(10) unsigned DEFAULT NULL COMMENT '客服人员id',
  `servicer_name` varchar(10) DEFAULT NULL COMMENT '客服人员名字',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `is_deleted` tinyint(255) DEFAULT NULL COMMENT '是否已删除：0-否，1-是',
  PRIMARY KEY (`ex_order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='出口订单';

-- ----------------------------
-- Records of ex_order
-- ----------------------------
INSERT INTO `ex_order` VALUES ('6', null, null, '', '', '2018-06-15 14:57:20', null, '', null, '', null, null, '0', null, '', '', '', null, '', '', null, '', '', '', '', '', '', null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '0', '', null, null, null, null, '', '', null, '0', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ex_order` VALUES ('7', null, '号店', '', '', '2018-06-15 15:11:18', '', '', '', '', '', null, '0', null, '', '', '', null, '', '', null, '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '0', '', null, null, null, null, '', '', null, '0', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ex_order` VALUES ('8', null, '', '', '', '2018-06-15 15:12:27', '', '', '', '', '', null, '0', null, '', '', '', null, '', '', '2018-06-12 00:00:00', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '0', '', null, null, null, null, '', '', null, '0', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ex_order` VALUES ('9', null, '', '', '', '2018-06-15 15:16:16', '', '', '', '', '', null, '0', null, '', '', '', null, '', '', '2018-06-15 15:16:19', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '0', '', null, null, null, null, '', '', null, '0', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ex_order` VALUES ('10', null, '号店', '', '', '2018-06-15 15:20:26', '', '', '', '', '', null, '0', null, '', '', '', null, '', '', '2018-06-15 15:20:30', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '0', '', null, null, null, null, '', '', null, '0', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ex_order` VALUES ('13', null, '号店', '', '', '2018-06-15 15:39:45', '', '', '', '', '', null, '0', null, '', '', '', null, '', '', '2018-06-15 15:39:49', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '0', '', null, null, null, null, '', '', null, '0', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ex_order` VALUES ('14', null, '嗯', '', '', null, '', '', '', '', '', null, '0', null, '', '', '', null, '', '', null, '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '0', '', null, null, null, null, '', '', null, '0', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `ex_order` VALUES ('17', null, '山西华纳机械加工有限公司', '没有', '不知道', '2018-06-15 15:53:37', '葛女士', '不知道', '18635090000', 'jfiagnggjglkfjdkflsjfjssllll', '......', null, '0', null, '', '', '', null, '', '', '2018-06-15 15:54:22', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '0', '', null, null, null, null, '', '', null, '0', null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `ex_order_commodity`
-- ----------------------------
DROP TABLE IF EXISTS `ex_order_commodity`;
CREATE TABLE `ex_order_commodity` (
  `ex_order_commodity_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ex_order_id` bigint(20) unsigned DEFAULT NULL COMMENT '出口订单主键',
  `manufacturer` varchar(32) DEFAULT NULL COMMENT '生产厂家',
  `manufacturer_code` varchar(32) DEFAULT NULL COMMENT '生产厂家编号',
  `factory_article_no` varchar(32) DEFAULT NULL COMMENT '公司货号',
  `customs_code` varchar(32) DEFAULT NULL COMMENT '海关编码',
  `tax_refund_rate` float(255,0) unsigned DEFAULT NULL COMMENT '退税率%',
  `ship_mark_info` varchar(255) DEFAULT NULL COMMENT '唛头信息',
  `chinese_name` varchar(32) DEFAULT NULL COMMENT '中文品名',
  `english_name` varchar(32) DEFAULT NULL COMMENT '英文品名',
  `declare_element` varchar(255) DEFAULT NULL COMMENT '申报要素',
  `pkgs` int(255) unsigned DEFAULT NULL COMMENT '包装数量',
  `pkgs_unit` varchar(8) DEFAULT NULL COMMENT '包装数量单位',
  `total_quantity` int(255) unsigned DEFAULT NULL COMMENT '总数量',
  `total_quantity_unit` varchar(8) DEFAULT NULL COMMENT '总数量单位',
  `pack_size_length` int(255) unsigned DEFAULT NULL COMMENT '包装尺寸-长mm',
  `pack_size_width` int(255) unsigned DEFAULT NULL COMMENT '包装尺寸-宽mm',
  `pack_size_height` int(255) unsigned DEFAULT NULL COMMENT '包装尺寸-高mm',
  `total_volume` float(255,0) unsigned DEFAULT NULL COMMENT '总体积m*m*m',
  `unit_rough_weight` float(255,0) unsigned DEFAULT NULL COMMENT '单位毛重kg',
  `total_rough_weight` float(255,0) unsigned DEFAULT NULL COMMENT '总毛重kg',
  `unit_net_weight` float(255,0) unsigned DEFAULT NULL COMMENT '单位净重kg',
  `total_net_weight` float(255,0) unsigned DEFAULT NULL COMMENT '总净重kg',
  `purchase_unit_price` int(255) unsigned DEFAULT NULL COMMENT '采购单价',
  `purchase_total_price` bigint(255) unsigned DEFAULT NULL COMMENT '采购总价',
  `export_unit_price` int(255) unsigned DEFAULT NULL COMMENT '出口单价',
  `export_total_price` bigint(255) unsigned DEFAULT NULL COMMENT '出口总价',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ex_order_commodity_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='出口订单商品';

-- ----------------------------
-- Records of ex_order_commodity
-- ----------------------------
INSERT INTO `ex_order_commodity` VALUES ('1', '17', '好的', '不知道', '', '', null, '', '', '', '', null, '', null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
