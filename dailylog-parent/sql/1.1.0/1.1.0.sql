DROP TABLE `navigator`;
DROP TABLE `account`;
DROP TABLE `user`;

CREATE TABLE IF NOT EXISTS `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT 'user logon name',
  `email` varchar(100) DEFAULT NULL COMMENT 'email Address of the Account',
  `forget_password_email` varchar(100) DEFAULT NULL COMMENT 'forget password email',
  `phone` varchar(15) DEFAULT NULL COMMENT 'phone number',
  `product_name` varchar(100) NOT NULL COMMENT 'product name',
  `product_url` varchar(500) DEFAULT NULL COMMENT 'product url',
  `join_date` datetime DEFAULT NULL COMMENT 'registration date',
  `is_active` TINYINT(4) NOT NULL,
  `create_time` datetime NOT NULL COMMENT 'record creation time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_product_name_unique_key` (`email`,`product_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_unique_key` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;