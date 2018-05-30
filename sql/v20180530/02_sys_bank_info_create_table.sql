CREATE TABLE `sys_bank_info`  (
  `sys_bank_info_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '银行信息表主键',
  `bank_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行名称',
  `bank_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '代码',
  `bank_address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行地址',
  `bank_swift` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行识别代码，例BKCHCNBJ300',
  `remarks` varchar(96) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) UNSIGNED NOT NULL COMMENT '是否作废，0：否，1：是',
  PRIMARY KEY (`sys_bank_info_id`) USING BTREE,
  UNIQUE INDEX `code`(`bank_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '银行信息' ROW_FORMAT = Dynamic;
