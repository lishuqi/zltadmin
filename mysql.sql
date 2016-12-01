/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.0.96-community-nt : Database - ljysystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ljysystem` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `ljysystem`;

/*Table structure for table `t_dictionary` */

DROP TABLE IF EXISTS `t_dictionary`;

CREATE TABLE `t_dictionary` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `name` varchar(128) NOT NULL COMMENT '名称',
  `tree_id` bigint(20) NOT NULL COMMENT '树节点id',
  `code` varchar(32) NOT NULL COMMENT '标识',
  `sort` varchar(32) default NULL COMMENT '排序',
  `created` datetime default NULL COMMENT '创建时间',
  `updated` datetime default NULL COMMENT '更新时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `t_dictionary` */

insert  into `t_dictionary`(`id`,`name`,`tree_id`,`code`,`sort`,`created`,`updated`) values (11,'是',81,'1','1','2016-10-18 17:15:50','2016-10-18 17:15:50'),(12,'否',81,'2','2','2016-10-18 17:15:50','2016-10-18 17:15:50'),(15,'是',83,'1','1','2016-10-18 17:15:50','2016-10-18 17:15:50'),(16,'否',83,'2','2','2016-10-18 17:15:50','2016-10-18 17:15:50'),(19,'男',82,'1','1','2016-10-18 17:15:50','2016-10-18 17:15:50'),(20,'女',82,'2','2','2016-10-18 17:15:56','2016-10-18 17:15:56');

/*Table structure for table `t_log` */

DROP TABLE IF EXISTS `t_log`;

CREATE TABLE `t_log` (
  `id` bigint(20) NOT NULL auto_increment,
  `add_date` datetime default NULL,
  `add_user` varchar(255) collate utf8_bin default NULL,
  `content` varchar(255) collate utf8_bin default NULL,
  `title` varchar(255) collate utf8_bin default NULL,
  `type` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5008 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_log` */

insert  into `t_log`(`id`,`add_date`,`add_user`,`content`,`title`,`type`) values (4895,'2016-10-19 17:31:19',NULL,NULL,'shiro登陆后台',0),(4896,'2016-10-19 17:31:21',NULL,NULL,'shiro登陆后台',0),(4897,'2016-10-19 17:31:23',NULL,NULL,'shiro登陆后台',0),(4898,'2016-10-19 17:31:24',NULL,NULL,'shiro登陆后台',0),(4899,'2016-10-19 17:31:24',NULL,NULL,'shiro登陆后台',0),(4900,'2016-10-19 17:31:25',NULL,NULL,'shiro登陆后台',0),(4901,'2016-10-19 17:31:26',NULL,NULL,'shiro登陆后台',0),(4902,'2016-10-19 17:31:58',NULL,NULL,'shiro登陆后台',0),(4903,'2016-10-19 17:32:02',NULL,NULL,'shiro登陆后台',0),(4904,'2016-10-19 17:34:53',NULL,NULL,'shiro登陆后台',0),(4905,'2016-10-19 17:34:55',NULL,NULL,'shiro登陆后台',0),(4906,'2016-10-19 17:34:56',NULL,NULL,'shiro登陆后台',0),(4907,'2016-10-19 17:34:57',NULL,NULL,'shiro登陆后台',0),(4908,'2016-10-19 17:34:58',NULL,NULL,'shiro登陆后台',0),(4909,'2016-10-19 17:36:07',NULL,NULL,'shiro登陆后台',0),(4910,'2016-10-19 17:36:10',NULL,NULL,'shiro登陆后台',0),(4911,'2016-10-19 17:36:12',NULL,NULL,'shiro登陆后台',0),(4912,'2016-10-19 17:36:17',NULL,NULL,'shiro登陆后台',0),(4913,'2016-10-19 17:36:19',NULL,NULL,'shiro登陆后台',0),(4914,'2016-10-19 17:36:20',NULL,NULL,'shiro登陆后台',0),(4915,'2016-10-19 17:36:55','超级管理员',NULL,'訪問首頁',0),(4916,'2016-10-19 17:37:37','超级管理员',NULL,'訪問首頁',0),(4917,'2016-10-19 17:37:45','超级管理员',NULL,'访问用戶首页',0),(4918,'2016-10-19 17:37:46','超级管理员',NULL,'根据树id填充select',0),(4919,'2016-10-19 17:37:46','超级管理员',NULL,'根据树id填充select',0),(4920,'2016-10-19 17:37:46','超级管理员',NULL,'分页查询用戶列表',0),(4921,'2016-10-19 17:38:05',NULL,NULL,'shiro登陆后台',0),(4922,'2016-10-19 17:38:05',NULL,NULL,'shiro登陆后台',0),(4923,'2016-10-19 17:38:16','超级管理员',NULL,'訪問首頁',0),(4924,'2016-10-19 17:38:19','超级管理员',NULL,'访问用戶首页',0),(4925,'2016-10-19 17:38:19','超级管理员',NULL,'根据树id填充select',0),(4926,'2016-10-19 17:38:19','超级管理员',NULL,'根据树id填充select',0),(4927,'2016-10-19 17:38:19','超级管理员',NULL,'分页查询用戶列表',0),(4928,'2016-10-19 17:38:26','超级管理员',NULL,'访问角色首页',0),(4929,'2016-10-19 17:38:26','超级管理员',NULL,'分页查询角色列表',0),(4930,'2016-10-19 17:38:26','超级管理员',NULL,'根据树id填充select',0),(4931,'2016-10-19 17:40:40',NULL,NULL,'shiro登陆后台',0),(4932,'2016-10-19 17:40:42','超级管理员',NULL,'訪問首頁',0),(4933,'2016-10-19 17:40:46','超级管理员',NULL,'访问用戶首页',0),(4934,'2016-10-19 17:40:46','超级管理员',NULL,'根据树id填充select',0),(4935,'2016-10-19 17:40:46','超级管理员',NULL,'分页查询用戶列表',0),(4936,'2016-10-19 17:40:46','超级管理员',NULL,'根据树id填充select',0),(4937,'2016-10-19 17:40:47','超级管理员',NULL,'分页查询用戶列表',0),(4938,'2016-10-19 17:40:50','超级管理员',NULL,'分页查询用戶列表',0),(4939,'2016-10-19 17:40:50','超级管理员',NULL,'分页查询用戶列表',0),(4940,'2016-10-19 17:43:23',NULL,NULL,'shiro登陆后台',0),(4941,'2016-10-19 17:43:24','超级管理员',NULL,'訪問首頁',0),(4942,'2016-10-19 17:44:24','超级管理员',NULL,'访问用戶首页',0),(4943,'2016-10-19 17:44:25','超级管理员',NULL,'根据树id填充select',0),(4944,'2016-10-19 17:44:25','超级管理员',NULL,'根据树id填充select',0),(4945,'2016-10-19 17:44:25','超级管理员',NULL,'分页查询用戶列表',0),(4946,'2016-10-19 17:48:39',NULL,NULL,'shiro登陆后台',0),(4947,'2016-10-19 17:49:04','超级管理员',NULL,'訪問首頁',0),(4948,'2016-10-19 17:49:07','超级管理员',NULL,'访问用戶首页',0),(4949,'2016-10-19 17:49:07','超级管理员',NULL,'根据树id填充select',0),(4950,'2016-10-19 17:49:07','超级管理员',NULL,'根据树id填充select',0),(4951,'2016-10-19 17:49:07','超级管理员',NULL,'分页查询用戶列表',0),(4952,'2016-10-19 17:49:36',NULL,NULL,'shiro登陆后台',0),(4953,'2016-10-19 17:51:31',NULL,NULL,'shiro登陆后台',0),(4954,'2016-10-19 18:00:23',NULL,NULL,'shiro登陆后台',0),(4955,'2016-10-19 18:07:04','李树琪',NULL,'shiro登陆后台',0),(4956,'2016-10-19 18:07:11','李树琪',NULL,'shiro登陆后台',0),(4957,'2016-10-19 18:07:15','李树琪',NULL,'shiro登陆后台',0),(4958,'2016-10-19 18:07:45',NULL,NULL,'shiro登陆后台',0),(4959,'2016-10-19 18:07:47','超级管理员',NULL,'訪問首頁',0),(4960,'2016-10-19 18:07:49','超级管理员',NULL,'访问用戶首页',0),(4961,'2016-10-19 18:07:49','超级管理员',NULL,'根据树id填充select',0),(4962,'2016-10-19 18:07:49','超级管理员',NULL,'根据树id填充select',0),(4963,'2016-10-19 18:07:49','超级管理员',NULL,'分页查询用戶列表',0),(4964,'2016-10-19 18:07:50','超级管理员',NULL,'访问角色首页',0),(4965,'2016-10-19 18:07:50','超级管理员',NULL,'分页查询角色列表',0),(4966,'2016-10-19 18:07:50','超级管理员',NULL,'根据树id填充select',0),(4967,'2016-10-19 18:07:51','超级管理员',NULL,'訪問权限资源首頁',0),(4968,'2016-10-19 18:07:51','超级管理员',NULL,'获取数据字典tree列表',0),(4969,'2016-10-19 18:07:51','超级管理员',NULL,'分页查询数据权限资源',0),(4970,'2016-10-19 18:07:51','超级管理员',NULL,'根据树id填充select',0),(4971,'2016-10-19 18:07:52','超级管理员',NULL,'訪問字典首頁',0),(4972,'2016-10-19 18:07:53','超级管理员',NULL,'获取数据字典tree列表',0),(4973,'2016-10-19 18:07:53','超级管理员',NULL,'分页查询数据字典数据',0),(4974,'2016-10-19 18:07:54','超级管理员',NULL,'访问系统日志首页',0),(4975,'2016-10-19 18:07:54','超级管理员',NULL,'查詢日志列表',0),(4976,'2016-10-19 18:07:55','超级管理员',NULL,'访问异常日志首页',0),(4977,'2016-10-19 18:07:55','超级管理员',NULL,'查詢日志列表',0),(4978,'2016-10-19 18:07:57','超级管理员',NULL,'訪問首頁',0),(4979,'2016-10-19 18:07:59','超级管理员',NULL,'访问用戶首页',0),(4980,'2016-10-19 18:07:59','超级管理员',NULL,'根据树id填充select',0),(4981,'2016-10-19 18:07:59','超级管理员',NULL,'根据树id填充select',0),(4982,'2016-10-19 18:07:59','超级管理员',NULL,'分页查询用戶列表',0),(4983,'2016-10-19 18:08:09','超级管理员',NULL,'获取角色树',0),(4984,'2016-10-19 18:08:09','超级管理员',NULL,'用户授权信息回显',0),(4985,'2016-10-19 18:12:58',NULL,NULL,'shiro登陆后台',0),(4986,'2016-10-19 18:13:03','超级管理员',NULL,'訪問首頁',0),(4987,'2016-10-19 18:13:16','超级管理员',NULL,'访问系统日志首页',0),(4988,'2016-10-19 18:13:17','超级管理员',NULL,'查詢日志列表',0),(4989,'2016-10-19 18:15:22','超级管理员',NULL,'訪問首頁',0),(4990,'2016-10-19 18:16:33','超级管理员',NULL,'訪問首頁',0),(4991,'2016-10-19 18:16:38','超级管理员',NULL,'訪問首頁',0),(4992,'2016-10-19 18:16:40','超级管理员',NULL,'訪問首頁',0),(4993,'2016-10-19 18:16:41','超级管理员',NULL,'訪問首頁',0),(4994,'2016-10-19 18:17:07','超级管理员',NULL,'訪問首頁',0),(4995,'2016-10-19 18:17:17','超级管理员',NULL,'訪問首頁',0),(4996,'2016-10-19 18:17:56','超级管理员',NULL,'訪問首頁',0),(4997,'2016-10-19 18:18:37','超级管理员',NULL,'訪問首頁',0),(4998,'2016-10-19 18:18:45','超级管理员',NULL,'訪問首頁',0),(4999,'2016-10-19 18:18:54','超级管理员',NULL,'访问用戶首页',0),(5000,'2016-10-19 18:18:54','超级管理员',NULL,'根据树id填充select',0),(5001,'2016-10-19 18:18:54','超级管理员',NULL,'根据树id填充select',0),(5002,'2016-10-19 18:18:55','超级管理员',NULL,'分页查询用戶列表',0),(5003,'2016-10-19 18:19:02','超级管理员',NULL,'访问用戶首页',0),(5004,'2016-10-19 18:19:03','超级管理员',NULL,'分页查询用戶列表',0),(5005,'2016-10-19 18:25:19','超级管理员',NULL,'訪問首頁',0),(5006,'2016-10-19 18:25:24','超级管理员',NULL,'访问用戶首页',0),(5007,'2016-10-19 18:25:24','超级管理员',NULL,'分页查询用戶列表',0);

/*Table structure for table `t_permission` */

DROP TABLE IF EXISTS `t_permission`;

CREATE TABLE `t_permission` (
  `tree_id` bigint(20) NOT NULL COMMENT '树节点id',
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `name` varchar(128) NOT NULL COMMENT '资源名称',
  `type` varchar(32) NOT NULL COMMENT '资源类型：menu,button,',
  `url` varchar(128) default NULL COMMENT '访问url地址',
  `percode` varchar(128) default NULL COMMENT '权限代码字符串',
  `parent_id` bigint(20) default NULL COMMENT '父结点id',
  `parent_ids` varchar(128) default NULL COMMENT '父结点id列表串',
  `sort` int(20) default NULL COMMENT '排序号',
  `available` int(1) default NULL COMMENT '是否可用,1：可用，0不可用',
  `created` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `t_permission` */

insert  into `t_permission`(`tree_id`,`id`,`name`,`type`,`url`,`percode`,`parent_id`,`parent_ids`,`sort`,`available`,`created`) values (201,1,'用户主菜单','menu','Manage/User/index.do','manage:menu:user:index',NULL,NULL,1,1,'2016-10-11 22:03:47'),(202,2,'用户添加','button','Manage/User/add.do','manage:buttom:user:add',NULL,NULL,1,1,'2016-10-11 22:03:48'),(202,3,'用户编辑','button','Manage/User/edit.do','manage:buttom:user:edit',NULL,NULL,2,1,'2016-10-11 22:03:49'),(202,4,'用户删除','button','Manage/User/delete.do','manage:button:user:delete',NULL,NULL,3,1,'2016-10-11 22:03:50'),(202,5,'用户授权','button','Manage/User/authenrization.do','manage:buttom:user:authenrization',NULL,NULL,4,1,'2016-10-11 22:03:51'),(301,6,'角色主菜单','menu','Manage/Role/index.do','manage:menu:role:index',NULL,NULL,1,1,'2016-10-11 22:03:52'),(302,7,'角色添加','button','Manage/Role/add.do','manage:buttom:role:add',NULL,NULL,1,1,'2016-10-11 22:03:53'),(302,8,'角色编辑','button','Manage/Role/edit.do','manage:button:role:edit',NULL,NULL,2,1,'2016-10-11 22:03:54'),(302,9,'角色删除','button','Manage/Role/delete.do','manage:button:role:delete',NULL,NULL,3,1,'2016-10-11 22:03:55'),(302,10,'角色授权','button','Manage/Role/authenrization.do','manage:button:role:authenrization',NULL,NULL,4,1,'2016-10-11 22:03:56'),(601,11,'资源主菜单','menu','Manage/Permission/index.do','manage:button:permission:index',NULL,NULL,1,1,'2016-10-11 22:03:57'),(602,13,'资源添加','button','Manage/Permission/add.do','manage:button:permission:add',NULL,NULL,1,1,'2016-10-11 22:03:58'),(602,14,'资源编辑','button','Manage/Permission/edit.do','manage:button:permission:edit',NULL,NULL,2,1,'2016-10-11 22:03:59'),(602,15,'资源删除','button','Manage/Permission/delete.do','manage:button:permission:delete',NULL,NULL,3,1,'2016-10-11 22:04:01'),(701,16,'数据字典主菜单','menu','Manage/Dictionary/index.do','manage:menu:dictionary:index',NULL,NULL,1,1,'2016-10-11 22:04:02'),(702,17,'字典值添加','button','Manage/Dictionary/add.do','manage:button:dictionary:add',NULL,NULL,1,1,'2016-10-11 22:04:03'),(702,18,'字典值编辑','button','Manage/Dictionary/edit.do','manage:button:dictionary:edit',NULL,NULL,2,1,'2016-10-11 22:04:04'),(702,19,'字典值删除','button','Manage/Dictionary/delete.do','manage:button:dictionary:delete',NULL,NULL,3,1,'2016-10-11 22:04:05');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` bigint(32) NOT NULL auto_increment,
  `name` varchar(64) NOT NULL COMMENT '角色名称',
  `tree_id` bigint(32) default NULL COMMENT '所属treeid',
  `available` int(1) default NULL COMMENT '是否keyong，1：yes，0no',
  `percode` varchar(10) default NULL COMMENT '角色标识',
  `created` datetime default NULL COMMENT '创建时间',
  `updated` datetime default NULL COMMENT '更新时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`name`,`tree_id`,`available`,`percode`,`created`,`updated`) values (14,'研发',2,1,'yf','2016-10-13 22:57:00','2016-10-13 22:57:00'),(15,'超级管理员',2,1,'cg','2016-10-13 22:57:07','2016-10-13 22:57:07'),(16,'测试',2,1,'cs','2016-10-13 22:57:12','2016-10-13 22:57:12'),(17,'司机',1,1,'sj','2016-10-13 23:47:03','2016-10-13 23:47:03'),(18,'乘客',1,1,'ck','2016-10-13 23:47:09','2016-10-13 23:47:09'),(19,'管理员',2,1,'admin','2016-10-19 10:03:11','2016-10-19 10:03:11');

/*Table structure for table `t_role_permission` */

DROP TABLE IF EXISTS `t_role_permission`;

CREATE TABLE `t_role_permission` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `permission_id` bigint(20) NOT NULL COMMENT '权限id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `t_role_permission` */

insert  into `t_role_permission`(`id`,`role_id`,`permission_id`) values (29,14,1),(30,14,3),(31,14,4),(32,14,5),(33,14,11),(34,14,14);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `user_code` varchar(32) NOT NULL COMMENT '账号',
  `ip` varchar(32) default NULL COMMENT '本次登陆ip地址',
  `phone` varchar(11) default NULL COMMENT '电话号码',
  `tree_id` bigint(20) NOT NULL COMMENT '树节点id',
  `id_card` varchar(32) default NULL COMMENT '身份证号码',
  `email` varchar(32) default NULL COMMENT '电子邮箱',
  `user_name` varchar(64) NOT NULL COMMENT '姓名',
  `gender` int(1) default NULL COMMENT '性别',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `now_login_date` timestamp NULL default NULL COMMENT '本次登陆时间',
  `last_login_date` timestamp NULL default NULL COMMENT '上次登陆时间',
  `locked` int(1) default NULL COMMENT '账号是否锁定，1：锁定，0未锁定',
  `created` datetime default NULL COMMENT '创建时间',
  `updated` datetime default NULL COMMENT '更新时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`user_code`,`ip`,`phone`,`tree_id`,`id_card`,`email`,`user_name`,`gender`,`password`,`now_login_date`,`last_login_date`,`locked`,`created`,`updated`) values (7,'lsq',NULL,'18435162285',201,'140227199210304719','237442461@qq.com','李树琪',1,'96e79218965eb72c92a549dd5a330112',NULL,NULL,1,'2016-10-13 23:39:42','2016-10-13 23:39:42'),(8,'ADMIN',NULL,NULL,201,NULL,NULL,'超级管理员',NULL,'96e79218965eb72c92a549dd5a330112',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`id`,`user_id`,`role_id`) values (19,7,15),(20,7,16),(24,8,14),(25,8,19);

/*Table structure for table `t_ztree_node` */

DROP TABLE IF EXISTS `t_ztree_node`;

CREATE TABLE `t_ztree_node` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '省份ID',
  `name` varchar(255) default NULL COMMENT '省份名称',
  `type` int(1) default NULL COMMENT '树所属类型',
  `p_id` bigint(20) NOT NULL COMMENT '省份ID',
  `icon` varchar(255) default NULL COMMENT '省份名称',
  `icon_close` varchar(255) default NULL COMMENT '省份名称',
  `icon_open` varchar(255) default NULL COMMENT '省份名称',
  `open` tinyint(1) default '0' COMMENT '默认是否打开',
  `is_parent` tinyint(1) default '0' COMMENT 'sfweifujiedian',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=703 DEFAULT CHARSET=utf8;

/*Data for the table `t_ztree_node` */

insert  into `t_ztree_node`(`id`,`name`,`type`,`p_id`,`icon`,`icon_close`,`icon_open`,`open`,`is_parent`) values (1,'基础数据',1,0,NULL,NULL,NULL,0,0),(2,'用户模块',2,0,NULL,NULL,NULL,0,1),(3,'角色管理',2,0,NULL,NULL,NULL,0,1),(4,'角色模块',1,0,NULL,NULL,NULL,0,1),(5,'状态',1,4,NULL,NULL,NULL,0,0),(6,'资源管理',2,0,NULL,NULL,NULL,0,1),(7,'数据字典',2,0,NULL,NULL,NULL,0,1),(81,'是否可用',1,1,NULL,NULL,NULL,0,0),(82,'性别',1,1,NULL,NULL,NULL,0,0),(83,'是否锁定',1,1,NULL,NULL,NULL,0,0),(201,'菜单',2,2,NULL,NULL,NULL,0,0),(202,'按钮',2,2,NULL,NULL,NULL,0,0),(301,'菜单',2,3,NULL,NULL,NULL,0,0),(302,'按钮',2,3,NULL,NULL,NULL,0,0),(601,'菜单',2,6,NULL,NULL,NULL,0,0),(602,'按钮',2,6,NULL,NULL,NULL,0,0),(701,'菜单',2,7,NULL,NULL,NULL,0,0),(702,'按钮',2,7,NULL,NULL,NULL,0,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
