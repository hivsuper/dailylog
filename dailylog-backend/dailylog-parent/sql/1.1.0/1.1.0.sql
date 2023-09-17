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
  `is_active` tinyint(4) NOT NULL,
  `create_time` datetime NOT NULL COMMENT 'record creation time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_product_name_unique_key` (`email`,`product_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `account` (`id`, `username`, `email`, `forget_password_email`, `phone`, `product_name`, `product_url`, `join_date`, `is_active`, `create_time`) VALUES
	(1, '11', '11@11.com', '111@11.com', '11111', 'aaaa', 'http://11.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(2, '12', '12@11.com', '112@11.com', '11112', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(3, '13', '13@11.com', '113@11.com', '11113', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(4, '14', '14@11.com', '114@11.com', '11114', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(5, '15', '15@11.com', '115@11.com', '11115', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(6, '16', '16@11.com', '116@11.com', '11116', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(7, '17', '17@11.com', '117@11.com', '11117', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(8, '18', '18@11.com', '118@11.com', '11118', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(9, '19', '19@11.com', '119@11.com', '11119', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(10, '20', '20@11.com', '120@11.com', '11120', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(11, '21', '21@11.com', '121@11.com', '11121', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(12, '22', '22@11.com', '122@11.com', '11122', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(13, '23', '23@11.com', '123@11.com', '11123', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(14, '24', '24@11.com', '124@11.com', '11124', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(15, '25', '25@11.com', '125@11.com', '11125', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(16, '26', '26@11.com', '126@11.com', '11126', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(17, '27', '27@11.com', '127@11.com', '11127', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(18, '28', '28@11.com', '128@11.com', '11128', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(19, '29', '29@11.com', '129@11.com', '11129', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(20, '30', '30@11.com', '130@11.com', '11130', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(21, '31', '31@11.com', '131@11.com', '11131', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(22, '32', '32@11.com', '132@11.com', '11132', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00'),
	(23, '33', '33@11.com', '133@11.com', '11133', 'aaaa', 'http://12.com', '2018-05-14 00:00:00', 1, '2018-05-14 00:00:00');

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_unique_key` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`id`, `username`, `password`, `last_login_time`, `create_time`) VALUES
	(1, 'super@1.com', 'NzI3ZGZiZGMxYTRlZTI0OWYzZjA4YzI0N2E1NjY5ZDU7bGVl', '2018-07-09 22:35:54', '2018-05-14 00:00:00');
