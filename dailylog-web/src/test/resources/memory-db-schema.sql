CREATE TABLE IF NOT EXISTS `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT 'user logon name',
  `email` varchar(100) DEFAULT NULL COMMENT 'email Address of the Account',
  `forget_password_email` varchar(100) DEFAULT NULL COMMENT 'forget password email',
  `phone` varchar(15) DEFAULT NULL COMMENT 'phone number',
  `product_name` varchar(100) NOT NULL COMMENT 'product name',
  `product_url` varchar(500) DEFAULT NULL COMMENT 'product url',
  `join_date` datetime DEFAULT NULL COMMENT 'registration date',
  `create_time` datetime NOT NULL COMMENT 'record creation time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_product_name_unique_key` (`email`,`product_name`)
) ENGINE=InnoDB;;

CREATE TABLE IF NOT EXISTS `navigator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT 'site name',
  `url` varchar(100) NOT NULL COMMENT 'site link',
  `title` varchar(100) DEFAULT '' COMMENT 'site title used for a label',
  `create_time` datetime NOT NULL COMMENT 'record creation time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `url_unique_key` (`url`)
) ENGINE=InnoDB;;

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_unique_key` (`username`)
) ENGINE=InnoDB;;