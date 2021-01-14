DROP TABLE IF EXISTS `sys_oauth_client`;
CREATE TABLE `sys_oauth_client` (
  `client_id` varchar(50) NOT NULL COMMENT '客户端id',
  `client_name` varchar(256) DEFAULT NULL COMMENT '应用名',
  `client_secret` varchar(256) DEFAULT NULL COMMENT '应用密钥',
  `client_redirect_uri_host` varchar(256) DEFAULT NULL COMMENT '对应主机域名',
  `status` int(1) DEFAULT NULL COMMENT '状态。0:正常；1:冻结',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='应用client表';

BEGIN;
INSERT INTO `sys_oauth_client` VALUES ('joe_monitoring', '监测服务（web端）', 'admin123', '','0', '2018-08-30 19:42:32', '2018-08-30 20:24:08');
COMMIT;

DROP TABLE IF EXISTS `sys_oauth_user_authorize`;
CREATE TABLE `sys_oauth_user_authorize` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `client_id` varchar(50) NOT NULL COMMENT '客户端id',
  `oauth_user_id` varchar(50) NOT NULL COMMENT '绑定账号的id，例如对应wx来说，就是openId',
  `user_id` int(11) NOT NULL COMMENT '对应user_id',
  `oauth_user_name` varchar(50) DEFAULT '' COMMENT '绑定账号的名称',
  UNIQUE KEY `unique_client_idAnduser_id` (`client_id`,`user_id`) USING BTREE,
  UNIQUE KEY `unique_client_idAndoauth_user_id` (`client_id`,`oauth_user_id`) USING BTREE,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='账号授权表'