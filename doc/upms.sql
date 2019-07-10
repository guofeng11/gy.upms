﻿CREATE TABLE `user_account` (
	`id` INT NOT NULL AUTO_INCREMENT COMMENT '自增主键',
	`username` VARCHAR (50) NOT NULL COMMENT '用户名',
	`nickname` VARCHAR (10) NULL,
	`password` VARCHAR (32) NOT NULL COMMENT '密码',
	`status` INT NOT NULL COMMENT '用户状态',
	`email` VARCHAR (64) NULL COMMENT '邮箱',
	`phone` VARCHAR (18) NULL COMMENT '手机',
	`usertype` VARCHAR (1) NOT NULL COMMENT 'S-系统，B-b端客户，C-c端客户',
	`comeform` INT NOT NULL COMMENT '用户来源',
	`userlevel` INT NOT NULL COMMENT '用户级别',
	`org_id` INT NULL,
	`jobtitle_id` INT NULL,
	`createtime` datetime NOT NULL,
	`createrid` INT NULL COMMENT '创建人编号',
	`creater` VARCHAR (50) NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `user_info` (
	`user_id` INT NOT NULL COMMENT '用户编号',
	`real_name` VARCHAR (50) NOT NULL,
	`sex` INT NULL COMMENT '性别：0-女，1-男,2-保密',
	`birthday` datetime NULL,
	`idcard_type` INT NULL COMMENT '证件号类型',
	`idcard` VARCHAR (32) NULL,
	`phone` VARCHAR (18) NULL,
	`telephone` VARCHAR (18) NULL,
	`country_code` VARCHAR (12) NULL,
	`country_name` VARCHAR (50) NULL,
	`province_code` VARCHAR (12) NULL,
	`province_name` VARCHAR (50) NULL,
	`city_code` VARCHAR (12) NULL,
	`city_name` VARCHAR (50) NULL,
	`area_code` VARCHAR (12) NULL,
	`area_name` VARCHAR (50) NULL,
	`address` VARCHAR (100) NULL,
	`zip_code` VARCHAR (10) NULL,
	`createrid` INT NULL,
	`creater` VARCHAR (50) NULL,
	`create_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`user_id`)
);

CREATE TABLE `server_log` (
	`id` CHAR (36) NOT NULL,
	`user_id` INT NOT NULL,
	`gate_way` VARCHAR (100) NULL COMMENT '服务IP或服务器名',
	`address` VARCHAR (16) NULL COMMENT '访问地址',
	`remote_addr` VARCHAR (100) NULL COMMENT '访问来源地址',
	`state_time` datetime NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `address` (
	`code` VARCHAR (12) NOT NULL,
	`name_cn` VARCHAR (50) NULL,
	`name_en` VARCHAR (50) NULL,
	`parent_code` VARCHAR (12) NULL,
	`level` INT NULL COMMENT '级别：0是第一级',
	`abbreviation_cn` VARCHAR (50) NULL,
	`abbreviation_en` VARCHAR (50) NULL,
	`createrid` INT NULL,
	`creater` VARCHAR (50) NULL,
	`create_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`code`)
);

CREATE TABLE `organization` (
	`org_id` INT NOT NULL,
	`org_code` VARCHAR (16) NULL COMMENT '组织代码',
	`org_name_cn` VARCHAR (100) NULL,
	`org_name_en` VARCHAR (200) NULL,
	`abbr_name_cn` VARCHAR (10) NULL,
	`org_type` VARCHAR (2) NULL DEFAULT 'O' COMMENT 'D-部门，O-公司',
	`abbr_name_en` VARCHAR (10) NULL,
	`level` INT NULL,
	`parent_id` INT NULL,
	`remark` text NULL,
	`createid` INT NULL,
	`creater` VARCHAR (50) NULL,
	`create_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`org_id`)
);

CREATE TABLE `job_title` (
	`id` INT NOT NULL,
	`job_title` VARCHAR (50) NULL,
	`job_title_en` VARCHAR (50) NULL,
	`level` INT NULL DEFAULT 1,
	`remark` VARCHAR (255) NULL,
	`create_id` INT NULL,
	`creater` VARCHAR (50) NULL,
	`create_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
);

CREATE TABLE `permission` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`app_id` INT NOT NULL,
	`perm_key` VARCHAR (50) NOT NULL,
	`perm_name_cn` VARCHAR (10) NOT NULL,
	`perm_name_en` VARCHAR (10) NOT NULL,
	`status` INT NULL DEFAULT 1,
	`sort_order` INT NOT NULL DEFAULT 1 COMMENT '排序',
	`level` INT NOT NULL,
	`parent_id` INT NOT NULL DEFAULT 0,
	`remark` VARCHAR (200) NULL,
	`creater_id` INT NULL,
	`creater` VARCHAR (50) NULL,
	`create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
);

CREATE TABLE `role` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`role_name` VARCHAR (10) NOT NULL,
	`role_name_en` VARCHAR (10) NOT NULL,
	`sort_order` INT NOT NULL DEFAULT 1,
	`status` INT NOT NULL,
	`remark` VARCHAR (200) NULL,
	`creater_id` INT NOT NULL,
	`creater` LONGTEXT NOT NULL,
	`create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
);

CREATE TABLE `role_perm` (
	`role_id` INT NOT NULL,
	`perm_id` INT NOT NULL
);

CREATE TABLE `user_role` (
	`user_id` INT NULL,
	`role_id` INT NULL
);

CREATE TABLE `application` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`app_name` VARCHAR (50) NOT NULL,
	`app_name_en` VARCHAR (100) NULL,
	`app_token` VARCHAR (64) NOT NULL,
	`status` INT NOT NULL COMMENT '0-删除，1-正常，2-禁用',
	`remark` VARCHAR (200) NULL,
	`creater_id` INT NOT NULL,
	`creater` VARCHAR (50) NOT NULL,
	`create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
);

CREATE TABLE `user_login` (
	`user_id` INT NOT NULL,
	`token` CHAR (36) NOT NULL,
	`login_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
	`exp_dur` INT NOT NULL COMMENT '过期时长，单位秒 ',
	PRIMARY KEY (`user_id`)
);

CREATE TABLE `app_authorized` (
	`id` CHAR (36) NOT NULL,
	`app_id` INT NULL,
	`auth_app_id` INT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `user_info` ADD CONSTRAINT `fk_user_info_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_account` (`id`);

ALTER TABLE `role_perm` ADD CONSTRAINT `fk_role_perm_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

ALTER TABLE `role_perm` ADD CONSTRAINT `fk_role_perm_perm_id` FOREIGN KEY (`perm_id`) REFERENCES `permission` (`id`);

ALTER TABLE `user_role` ADD CONSTRAINT `fk_user_role_user_account_id` FOREIGN KEY (`user_id`) REFERENCES `user_account` (`id`);

ALTER TABLE `user_role` ADD CONSTRAINT `fk_user_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

ALTER TABLE `permission` ADD CONSTRAINT `fk_perm_id_perm_sys_id` FOREIGN KEY (`app_id`) REFERENCES `application` (`id`);

ALTER TABLE `user_account` ADD CONSTRAINT `fk_user_account_user_login_1` FOREIGN KEY (`id`) REFERENCES `user_login` (`user_id`);

ALTER TABLE `application` ADD CONSTRAINT `fk_application_app_authorized_1` FOREIGN KEY (`id`) REFERENCES `app_authorized` (`app_id`);

ALTER TABLE `application` ADD CONSTRAINT `fk_application_app_authorized_2` FOREIGN KEY (`id`) REFERENCES `app_authorized` (`auth_app_id`);