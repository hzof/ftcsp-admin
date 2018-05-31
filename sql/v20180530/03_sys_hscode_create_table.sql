CREATE TABLE `sys_hscode`  (
  `sys_hscode_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'hs编码',
  `product_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `begin_date` datetime(0) NULL DEFAULT NULL COMMENT '起始日期',
  `end_date` datetime(0) NULL DEFAULT NULL COMMENT '截止日期',
  `product_unit` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品单位，如千克',
  `tax_rate` int(4) UNSIGNED NULL DEFAULT NULL COMMENT '税率',
  `tax_refund_rate` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '退税率',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(4) NOT NULL COMMENT '是否删除，0:否 1:是',
  PRIMARY KEY (`sys_hscode_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68091901 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'HS编码' ROW_FORMAT = Dynamic;