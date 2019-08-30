-- 初始化授权中心服务 
INSERT INTO `application`(`app_name`,`app_name_en`,`app_token`,`ipv4`,`status`,`remark`,`creater_id`,`creater`,`create_time`)
VALUES('授权中心服务','upms-service',uuid(),'127.0.0.1',1,'授权服务为基础服务，所有服务应向授权中心服务注册',1,'admin',now());
-- 创建默认用户 密码 123456
INSERT INTO `upms`.`user_account`(`username`,`nickname`,`password`,`status`,`email`,`phone`,`usertype`,`comeform`,`userlevel`,`org_id`,`jobtitle_id`,`createtime`,`creater_id`,`creater`)
VALUES('admin','admin','a66abb5684c45962d887564f08346e8d',1,'admin@dnjexpress.com','13100000000','C', '1', '1', '1', '1', '2019-07-10 16:30:44', '0', '');

