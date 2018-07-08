ALTER TABLE `account`
	ALTER `username` DROP DEFAULT,
	ALTER `productname` DROP DEFAULT,
	ALTER `createtime` DROP DEFAULT;
ALTER TABLE `account`
	CHANGE COLUMN `seqid` `id` BIGINT(20) NOT NULL AUTO_INCREMENT FIRST,
	CHANGE COLUMN `remail` `email` VARCHAR(100) NULL DEFAULT NULL COMMENT 'email Address of the Account' AFTER `user_name`,
	CHANGE COLUMN `fpemail` `forget_password_email` VARCHAR(100) NULL DEFAULT NULL COMMENT 'forget password email' AFTER `email`,
	CHANGE COLUMN `productname` `product_name` VARCHAR(100) NOT NULL COMMENT 'product name' AFTER `phone`,
	CHANGE COLUMN `producturl` `product_url` VARCHAR(500) NULL DEFAULT NULL COMMENT 'product url' AFTER `product_name`,
	CHANGE COLUMN `joindate` `join_date` DATETIME NULL DEFAULT NULL COMMENT 'registration date' AFTER `product_url`,
	CHANGE COLUMN `createtime` `create_time` DATETIME NOT NULL COMMENT 'record creation time' AFTER `join_date`;
ALTER TABLE `account`
	DROP INDEX `AK_Key_2`,
	ADD UNIQUE INDEX `email_product_name_unique_key` (`email`, `product_name`);

ALTER TABLE `navigator`
	ALTER `createtime` DROP DEFAULT;
ALTER TABLE `navigator`
	CHANGE COLUMN `seqid` `id` BIGINT(20) NOT NULL AUTO_INCREMENT FIRST,
	CHANGE COLUMN `createtime` `create_time` DATETIME NOT NULL COMMENT 'record creation time' AFTER `title`;
ALTER TABLE `navigator`
	DROP INDEX `AK_Key_2`,
	ADD UNIQUE INDEX `url_unique_key` (`url`);

ALTER TABLE `user`
	ALTER `createtime` DROP DEFAULT;
ALTER TABLE `user`
	CHANGE COLUMN `seqId` `id` BIGINT(20) NOT NULL AUTO_INCREMENT FIRST,
	CHANGE COLUMN `lastlogintime` `last_login_time` DATETIME NULL DEFAULT NULL AFTER `password`,
	CHANGE COLUMN `createtime` `create_time` DATETIME NOT NULL AFTER `last_login_time`;