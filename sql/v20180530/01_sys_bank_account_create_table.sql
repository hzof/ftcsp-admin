CREATE TABLE `sys_bank_account`  (
  `sys_bank_account_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '银行账号信息表主键',
  `sys_bank_info_id` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '引用了sys_bank_information表的主键',
  `account_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `currency` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '币别',
  `account_type` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '账号性质/账号类型，0：结算户',
  `accounting_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应会计代码',
  `accounting_subject` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应会计科目名称',
  `purpose` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对接用途',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`sys_bank_account_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '银行账户信息' ROW_FORMAT = Dynamic;
