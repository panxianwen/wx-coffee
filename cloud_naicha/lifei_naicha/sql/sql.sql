/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.24 : Database - lifei_naicha
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lifei_naicha` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `lifei_naicha`;

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `goods_category_name` varchar(10) NOT NULL COMMENT '必要的冗余字段: 商品种类',
  `name` varchar(30) NOT NULL,
  `display_order` int(10) NOT NULL DEFAULT '0' COMMENT '显示次序',
  `default_price` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '默认价格',
  `is_sell` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否在卖',
  `image` varchar(300) DEFAULT NULL COMMENT '商品图片',
  `description` varchar(100) DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`id`,`goods_category_name`,`name`,`display_order`,`default_price`,`is_sell`,`image`,`description`) values (18,'下单必看','支付测试',0,1,1,'goodsImage-18.jpg?random=628','测试支付'),(19,'新鲜果茶','百香双重奏',1,1400,1,'goodsImage-19.jpg',''),(20,'新鲜果茶','杨枝甘露',2,1400,1,'goodsImage-20.jpg',''),(21,'新鲜果茶','芝士葡萄',3,1900,1,'goodsImage-21.jpg',''),(22,'新鲜果茶','蜂蜜柚子茶',4,1300,1,'goodsImage-22.jpg',''),(23,'新鲜果茶','茉香柠檬茶',5,1200,1,'goodsImage-23.jpg',''),(24,'新鲜果茶','霸气橙子',6,1700,1,'goodsImage-24.jpg',''),(25,'风味奶茶','润土烤奶',1,1300,1,NULL,''),(26,'风味奶茶','芋圆烤奶',2,1300,1,NULL,''),(27,'风味奶茶','芋圆血糯米',3,1100,1,NULL,''),(28,'风味奶茶','招牌奶茶',4,1000,1,NULL,''),(29,'风味奶茶','布丁奶茶',5,1100,1,NULL,''),(30,'风味奶茶','椰果奶茶',6,900,1,NULL,''),(31,'风味奶茶','珍珠奶茶',7,900,1,NULL,''),(32,'可可抹茶','芝士抹茶',1,1000,1,NULL,''),(33,'可可抹茶','芝士可可',5,1500,1,NULL,''),(34,'可可抹茶','醇奶抹茶',10,1300,1,NULL,''),(35,'可可抹茶','超满足抹茶',15,1700,1,NULL,''),(36,'可可抹茶','阿华田抹茶拿铁',25,1900,1,NULL,''),(37,'可可抹茶','阿华田可可拿铁',30,1900,1,NULL,''),(38,'牛乳茶','芋泥啵啵奶绿',1,1600,1,NULL,''),(39,'牛乳茶','奶芙牛乳茶',10,1600,1,NULL,''),(40,'牛乳茶','布丁芋奶露',30,1100,1,NULL,''),(41,'牛乳茶','芋泥青稞牛奶',40,1700,1,NULL,''),(42,'纯享鲜茶','芝士茉莉',10,1300,1,NULL,''),(43,'纯享鲜茶','锦上乌龙',20,1100,1,NULL,''),(44,'纯享鲜茶','芝士乌龙',30,1200,1,NULL,''),(45,'现磨咖啡','焦糖玛奇朵',10,2300,1,NULL,''),(46,'现磨咖啡','拿铁咖啡',20,1900,1,NULL,''),(47,'现磨咖啡','摩卡咖啡',30,2300,1,NULL,''),(48,'现磨咖啡','卡布奇诺',40,2100,1,NULL,''),(49,'现磨咖啡','美式咖啡',60,1700,1,NULL,''),(50,'小吃熟食','鸡柳',10,400,1,NULL,''),(51,'小吃熟食','骨肉相连',20,400,1,NULL,''),(52,'小吃熟食','鸡米花',40,1100,1,NULL,''),(53,'小吃熟食','洋葱卷',30,1100,1,NULL,''),(54,'小吃熟食','大薯条',50,1100,1,NULL,''),(55,'小吃熟食','单人套餐',70,1700,1,NULL,''),(56,'小吃熟食','双人套餐',80,3300,1,NULL,'');

/*Table structure for table `goods_category` */

DROP TABLE IF EXISTS `goods_category`;

CREATE TABLE `goods_category` (
  `name` varchar(10) NOT NULL,
  `display_order` tinyint(1) DEFAULT '1' COMMENT '显示顺序',
  `show_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否显示',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类别';

/*Data for the table `goods_category` */

insert  into `goods_category`(`name`,`display_order`,`show_status`) values ('下单必看',0,1),('可可抹茶',3,1),('小吃熟食',7,1),('新鲜果茶',1,1),('牛乳茶',4,1),('现磨咖啡',6,1),('纯享鲜茶',5,1),('风味奶茶',2,1);

/*Table structure for table `goods_property` */

DROP TABLE IF EXISTS `goods_property`;

CREATE TABLE `goods_property` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` int(10) NOT NULL,
  `category` enum('大小','加料','温度','甜度','口味') NOT NULL COMMENT '内置的属性类型',
  `property_option` varchar(10) DEFAULT NULL COMMENT '可选项，eg: 常温',
  `is_default` tinyint(1) DEFAULT '0' COMMENT '是否作为默认选择',
  `rebase_price` int(10) DEFAULT NULL COMMENT '重置基础价格,只有选择大小属性时需要',
  `extra_price` int(10) NOT NULL DEFAULT '0' COMMENT '额外价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='商品属性，甜度，温度等';

/*Data for the table `goods_property` */

insert  into `goods_property`(`id`,`goods_id`,`category`,`property_option`,`is_default`,`rebase_price`,`extra_price`) values (29,19,'大小','大杯',1,1400,0),(30,19,'大小','中杯',0,1200,0),(31,20,'大小','大杯',1,1400,0),(32,21,'大小','大杯',1,1900,0),(33,22,'大小','大杯',1,1300,0),(34,23,'大小','大杯',1,1200,0),(35,24,'大小','大杯',1,1700,0),(36,19,'温度','常温',1,NULL,0),(37,19,'温度','加冰',0,NULL,0),(38,32,'大小','大杯',1,1000,0);

/*Table structure for table `order_info` */

DROP TABLE IF EXISTS `order_info`;

CREATE TABLE `order_info` (
  `order_no` varchar(30) NOT NULL COMMENT '订单号',
  `wx_openid` varchar(50) NOT NULL,
  `order_status` enum('未付款','制作中','请取餐','配送中','已送达','已完成','已取消','退款中','已退款') NOT NULL COMMENT '订单状态',
  `wx_pay_transaction_id` varchar(32) DEFAULT NULL COMMENT '微信支付系统生成的订单号',
  `take_type` enum('到店自取','外卖配送') NOT NULL COMMENT '取餐方式',
  `address_detail` varchar(100) NOT NULL COMMENT '收货地址',
  `goods_preview` varchar(300) NOT NULL DEFAULT '' COMMENT '商品信息eg: 奶茶*2',
  `goods_total_num` int(11) DEFAULT '0' COMMENT '商品总数',
  `total_price` int(10) unsigned DEFAULT NULL,
  `pay_price` int(10) unsigned DEFAULT NULL COMMENT '支付金额',
  `verify_num` int(11) DEFAULT '0' COMMENT '取单号，一般取手机尾号',
  `extra_info` varchar(100) DEFAULT NULL COMMENT '用户备注、订单取消原因、或其他额外信息',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `pay_time` timestamp NULL DEFAULT NULL COMMENT '支付时间',
  `finish_time` timestamp NULL DEFAULT NULL COMMENT '订单完成时间',
  `user_phone` varchar(11) DEFAULT NULL COMMENT '用户联系电话',
  `receiver` varchar(10) DEFAULT NULL COMMENT '取餐人',
  PRIMARY KEY (`order_no`),
  KEY `createTime` (`create_time`),
  KEY `wx_openid` (`wx_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单';

/*Data for the table `order_info` */

insert  into `order_info`(`order_no`,`wx_openid`,`order_status`,`wx_pay_transaction_id`,`take_type`,`address_detail`,`goods_preview`,`goods_total_num`,`total_price`,`pay_price`,`verify_num`,`extra_info`,`create_time`,`pay_time`,`finish_time`,`user_phone`,`receiver`) values ('202104013446-1003','oxci95SnSaCpN5NAvv66T4XYDVR8','已完成',NULL,'到店自取','到店自取','支付测试*1',1,1,NULL,9046,'','2021-04-10 17:40:08',NULL,'2021-04-11 01:40:09','17058179046','ccc'),('202104024108-1001','oxci95SnSaCpN5NAvv66T4XYDVR8','已取消',NULL,'外卖配送','2区15舍309','1515*1,血糯米奶茶[加冰 中杯 少量糖 ]*1,茉莉奶绿[大杯 ]*2',4,4300,4300,9046,' 请放桌上 订单取消原因: [商家取消]','2021-04-10 18:41:51',NULL,NULL,'17058179046','ccc'),('202104044022-1002','oxci95SnSaCpN5NAvv66T4XYDVR8','已完成','4200000996202104061470491317','到店自取','2区15舍309','支付测试*1',1,1,1,9046,'','2021-04-10 18:45:02','2021-04-06 04:40:36','2021-04-11 04:44:17','17058179046','陈亚茹'),('202104110738-1002','oxci95Q5CY070GJ65PCxfoCSK6Hw','已完成','4200000985202104081793471026','到店自取','到店自取','支付测试*1',1,1,1,9792,'','2021-04-10 17:01:42','2021-04-08 11:07:54',NULL,'18781139792','赵子豪'),('202104130834-1001','oxci95QiFQ6V_p3Pr5frTig2eOT4','已完成','4200000995202104067715978712','外卖配送','2区17舍201','珍珠奶茶[热 中杯 正常 ]*2',2,1700,1700,7282,'','2021-04-10 17:01:42','2021-04-06 13:08:44','2021-04-06 13:14:17','18383507282','李飞'),('202104135116-1005','oxci95QiFQ6V_p3Pr5frTig2eOT4','已完成','4200000986202104064182052078','外卖配送','2区17舍201','血糯米奶茶[加冰 大杯 少量糖 ]*1',1,1400,1400,7282,'','2021-04-10 17:01:42','2021-04-06 13:51:23',NULL,'18383507282','李飞'),('202104161904-1003','oxci95U3KGSQkPVcymOhvP3z4jhY','已完成','4200000989202104088552924812','外卖配送','10舍408','黄金乌龙[大杯 ]*1,烤椰子蛋糕奶*1',2,1600,1600,4185,'','2021-04-10 17:01:42','2021-04-08 16:19:08',NULL,'17774644185','郑宇'),('202104163324-1006','oxci95SnSaCpN5NAvv66T4XYDVR8','已完成','4200000994202104069105436268','到店自取','到店自取','支付测试*1',1,1,1,9046,'','2021-04-10 17:01:42','2021-04-06 16:33:30',NULL,'17058179046','陈亚茹'),('202104181347-1011','oxci95X_jymzjREewaZeQOPjfglE','已完成','4200000997202104091193610806','外卖配送','3区宿舍23舍B307','茉莉奶绿[大杯 ]*1,奥利奥奶茶*1',2,2300,2300,2281,' 要温的','2021-04-10 17:01:42','2021-04-09 18:13:52',NULL,'17358982281','王'),('202104191406-1012','oxci95SnSaCpN5NAvv66T4XYDVR8','已完成','4200000944202104092359180547','到店自取','到店自取','支付测试*1',1,1,1,9046,'','2021-04-10 17:01:42','2021-04-09 19:14:11',NULL,'17058179046','ccc'),('202104214351-1004','oxci95caUkkqoOi51ELdySiL7cVI','已完成','4200000987202104081520940808','外卖配送','二区15舍211','热狗*1,珍珠奶茶[热 中杯 半糖 ]*1',2,1100,1100,5388,'','2021-04-10 17:01:42','2021-04-08 21:43:57',NULL,'18808175388','江一丰'),('202104222019-1005','oxci95SnSaCpN5NAvv66T4XYDVR8','已完成','4200000941202104084299755088','到店自取','到店自取','支付测试*1',1,1,1,9046,'','2021-04-10 17:01:42','2021-04-08 22:20:44',NULL,'17058179046','陈亚茹'),('202104222644-1006','oxci95Rtn3D8rP8Ol6jGYMjugXBM','已完成','4200000984202104083379264626','到店自取','到店自取','支付测试*1',1,1,1,382,'','2021-04-10 17:01:42','2021-04-08 22:26:58',NULL,'18383550382','芶浩翔'),('202104222711-1007','oxci95SnSaCpN5NAvv66T4XYDVR8','已完成','4200000982202104084885732279','到店自取','到店自取','支付测试*1',1,1,1,9046,'','2021-04-10 17:01:42','2021-04-08 22:27:17',NULL,'17058179046','ccc'),('202104234258-1002','oxci95SnSaCpN5NAvv66T4XYDVR8','已完成','4200000990202104056638826233','到店自取','2区15舍','支付测试*1',1,1,1,9046,'','2021-04-06 01:39:55','2021-04-05 23:46:16','2021-04-06 01:47:22','17058179046','陈亚茹'),('202104234554-1003','oxci95SnSaCpN5NAvv66T4XYDVR8','已完成','4200000990202104056638826933','到店自取','2区15舍','支付测试*1',1,1,1,9046,'','2021-04-06 01:39:56','2021-04-05 23:46:16','2021-04-06 01:47:39','17058179046','陈亚茹'),('202104234630-1004','oxci95SnSaCpN5NAvv66T4XYDVR8','已完成','4200000990202104056638826133','到店自取','2区15舍','支付测试*1',1,1,1,9046,'','2021-04-06 01:40:00','2021-04-05 23:46:16','2021-04-06 01:47:15','17058179046','陈亚茹');

/*Table structure for table `order_refund` */

DROP TABLE IF EXISTS `order_refund`;

CREATE TABLE `order_refund` (
  `refund_no` varchar(20) NOT NULL,
  `wx_refund_id` varchar(40) NOT NULL COMMENT '微信支付退款号',
  `wx_pay_transaction_id` varchar(40) NOT NULL COMMENT '微信支付订单号',
  `order_no` varchar(30) NOT NULL COMMENT '商户订单号',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `success_time` date DEFAULT NULL COMMENT '成功退款时间',
  `status` enum('SUCCESS','CLOSED','PROCESSING','ABNORMAL') NOT NULL COMMENT '退款状态: 成功，关闭，处理中，异常',
  `refund_fee` int(11) NOT NULL COMMENT '退款金额',
  `order_pay_price` int(11) NOT NULL COMMENT '订单交易金额',
  PRIMARY KEY (`refund_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单退款信息';

/*Data for the table `order_refund` */

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`description`) values (1,'超级管理员','全部权限'),(2,'后台管理员','管理应用'),(3,'游客模式','允许所有查看权限，拦截一切修改操作');

/*Table structure for table `sys_role_permission` */

DROP TABLE IF EXISTS `sys_role_permission`;

CREATE TABLE `sys_role_permission` (
  `role_id` int(10) NOT NULL,
  `permission` varchar(30) NOT NULL COMMENT '权限 eg:system:user:add',
  PRIMARY KEY (`role_id`,`permission`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色的权限(可以不止一个)';

/*Data for the table `sys_role_permission` */

insert  into `sys_role_permission`(`role_id`,`permission`) values (1,'*'),(2,'system:goods:add'),(2,'system:goods:delete'),(2,'system:goods:list'),(2,'system:goods:update'),(2,'system:goodsCategory:add'),(2,'system:goodsCategory:delete'),(2,'system:goodsCategory:list'),(2,'system:goodsCategory:update'),(2,'system:order:list'),(2,'system:order:update'),(2,'system:user:add'),(2,'system:user:delete'),(2,'system:user:list'),(2,'system:user:update'),(3,'system:goods:list'),(3,'system:goodsCategory:list'),(3,'system:order:list'),(3,'system:role:list'),(3,'system:sysUser:list'),(3,'system:timingTask:list'),(3,'system:user:list');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role_id` int(10) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '1' COMMENT '1表示账号可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`,`role_id`,`status`) values (1,'system','4QrcOUm6Wau+VuBX8g+IPg==',1,1),(2,'admin','4QrcOUm6Wau+VuBX8g+IPg==',2,1),(5,'guest','4QrcOUm6Wau+VuBX8g+IPg==',3,0),(6,'chenyaru','4QrcOUm6Wau+VuBX8g+IPg==',1,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `wx_openid` varchar(50) NOT NULL COMMENT '微信的openid',
  `name` varchar(10) NOT NULL DEFAULT '' COMMENT '姓名',
  `phone` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `address` varchar(30) NOT NULL DEFAULT '' COMMENT '地址信息',
  `sex` tinyint(1) DEFAULT '1' COMMENT '性别',
  `wx_avatar` varchar(300) DEFAULT NULL COMMENT '微信头像',
  `status` tinyint(1) DEFAULT '1' COMMENT '账号冻结状态',
  PRIMARY KEY (`wx_openid`),
  UNIQUE KEY `openid` (`wx_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`wx_openid`,`name`,`phone`,`address`,`sex`,`wx_avatar`,`status`) values ('oxci95aRpRxiKhcxnaX3GbFtmd8U','王锋光','13688216857','研究生公寓29栋一单元二楼6号',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/icHULujibfDhpOVePcXsABibh6yOOByp95EAMEGTaBicibyCJNpVF5IiaYzicpTAqZW8H8xCM1z02icTWMqXY56I5cgyYQ/132',1),('oxci95bCtJWiwHvhupH91WCYgkLw','','','',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/zxcw4auibrXYibBpDic5N1LdPaJTmnzT15icAiaic8LJoFY2fQTmw1ase2NgUwZIV93WxGCWru2uyVRm2XGkVHUibh10Q/132',1),('oxci95bF-BCcWosF6P3DrzyeAgIk','','','',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/0zrT8sRxhzsysgjlkBgVFp1SW3Cpz7icicxAdwianCMBUYs5atNKjX04eDicxTefzKfQCgVPNhibTayD5uWicTmy1K8A/132',1),('oxci95byW5erJRygqj19tylgBXeE','','','',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/LyXoVuH1CSbobRaabng37NZIFMw8Y78QbYTA4kFV5JXSicxJLmZXW8vI9uV9Gpk99Ns7CKp4mjEu6f6H6VW3WkA/132',1),('oxci95caUkkqoOi51ELdySiL7cVI','江一丰','18808175388','二区15舍211',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/gjING398wXa4rNEyPv3icQeEERia8pTn8iaiaAowm66gNic4BVYL9nlaKHQX91j3IFOUjJEQyKexkCIcxJre6I5ia59A/132',1),('oxci95diR8PFRUrzBX19weF4qSsY','范','13849876533','2区12舍',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/L7ibWSo1vrhzoia7MewSkM4MbzkHmdO6iaX18yGIjwaOpIeaUbZ3Z9wibYkshnlto5mvlVSWMreD2cFxs02eJZjIWg/132',1),('oxci95epe-y3Dc9_fFAr2PdOXuA8','','','',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/HicGWCcU4ZdU7YjYFklaewX8bWKVEE26PbicuicqgOFr9ahNaKjG4jz76BbCGCoFSv7oAXOWJ5gT53gLmPPyQgFKQ/132',1),('oxci95e_DIxfA0H0-_StOCWI56g4','辣椒酱','18516312132','2区11舍null',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erD0TQia7DSK7oHDpz1vKfshUlKhKsVz4X4e0Of2wguz5pkiakHgLxze6pxR4qQ4VPusDHuibEowicVXQ/132',1),('oxci95flbZ63x06tql0umb69Vzrc','','','',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/lGmpt34icnSg0iaYw8iab8AE8FTBsyar1CVh94sKKo80ftEjkDb9QFcybFF3TI2hXzjlmtAdkSNUIhV6mYzpkCobg/132',1),('oxci95fLmR0IbiUzXgUvGDH7lDHM','','','',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/7X0W86Sd2ia3Ft6ISoiclGmQWALjD8ibxwtbHrLIH48gUZglBR3hnMY738b7vMPRrswfwmuREMq9LTpYpYVqdGciag/132',1),('oxci95Q5CY070GJ65PCxfoCSK6Hw','赵子豪','18781139792','2区15舍308',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/K0eBHCBtLicJKhnf6DlIiaINtAlvsRenRSAq3ibSYh5sgQtgjsYmKAV8sHsbgKtsWRxcFFFQatRBXQ6j8AyetfQfQ/132',1),('oxci95QiFQ6V_p3Pr5frTig2eOT4','李飞','18383507282','2区17舍201',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/lGxjJS2DQw9QbLsLUKZUZ9ia78Hto8lkxdZJLyHhu9XbMepPAQsGdGrdgdzCz4T1usSSicibcyM4gia7a0VWW6cFXA/132',1),('oxci95RDa4v6LvbX08c2FyNlltwA','','','',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/hUQ6EWP6TyBBn4rV1MQz1xgDQxobk0bckkiaz6P91Oh9PyeicJN7oVTLzT0W23GUMfkkuBG3k7Hpia9oDtX3VXEkw/132',1),('oxci95RgfMKbIyGfVoO3cf3lRSX4','','','',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEJrdmhYR7l81AhgDfjickqtXPwbuVHyB1N7my6TTATR4rXfdqp20nYHp21H7icL42wwMd3uoRibTs4fg/132',1),('oxci95RMAD8kB048m12-IAnw1-6U','','','',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIpxjKKSfkprEb07zqumvCK4sykVejg2Zc7tPwM36qkrA6Iyiar1Bpk4KiaHUuTP7iamdVZO25ibGxZuA/132',1),('oxci95Rtn3D8rP8Ol6jGYMjugXBM','芶浩翔','18383550382','2区15舍309',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/9sOqZ3H77jY97hicAGkfaPDUibWvctuAjvybibqjSI9cTN1BoBsV3GsqumVFDo6JWInEyemfBKCuk4gIqicUJF0icog/132',1),('oxci95SnSaCpN5NAvv66T4XYDVR8','陈亚如','17058179046','2区10舍309',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132',1),('oxci95TavexRTRjWMVZPCZE2L62k','','','',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/vibkEE9ia1hFsVQRDxibWVQOcczGqpiabaFiaSVq5X0EhVjiaZRj6icA5rhQniaicCz0cKWSSEIRCtLGQyyZu3xIkGkI57g/132',1),('oxci95U3KGSQkPVcymOhvP3z4jhY','郑宇','17774644185','10舍408',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK1dGeaynXG4bjqBrpurXToxfRXicRTNa2nnhBPNKxVNlN5ATpiby5YYZV1NotmcMTtf6iavBicptBBuQ/132',1),('oxci95UTD-dmXisdAHlT-armQcfY','','','',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLyeNEWbJUqfRrPkOKstkz5YCRA6nVCMHlcvt6Df7EZibeK0D7kFBPNqpBlQFhBejeBG6mI2rPMH0w/132',1),('oxci95VMHgDtic2OzLC1sjviwBkA','','','',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/Qz0icbxA0r2rMCg40z47M4CxVpc2Cunbw2NFicv6vDGicjGldicVjmve0yPMbB7NskSrhuo1iaCBTZxoWZGu5DAnf9A/132',1),('oxci95VTjFiRQx24ohY_nYd23cKk','贾月月','18383552728','3区19舍',2,'https://thirdwx.qlogo.cn/mmopen/vi_32/ErmnFHFNhDP9FPEVmt0FpHQCRiaGsfh2RO5ZYPI0aICJFzA1tibSqVSHlyTTficfNib5yqXGicV5g6kPAR0wJKexFyQ/132',1),('oxci95WkGdwKgAS281gZP9pO1_cU','','','',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/ibz29q9Fpwf2iagiaaYA9NvfvZTMaqO3W6Md5KXJ8q6ne7tHxy6FH2VkGzYiclwcQiaVtm15fibdmYt8mB79ISd6BhnA/132',1),('oxci95X-iHGz3GPUmKZZJqBByYWk','','','',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/Zlxl7thPQLd9LNYszD8icLChuxz1Zwr0TUaGPw8X805Rxgo4g4gWMLNkIo6CbNyrF8fh45meSic7QpuF2RzwyJUw/132',1),('oxci95XWaWg4CgsXUvKyTlhPABP0','任丽','17390484055','3区19舍A504',2,'https://thirdwx.qlogo.cn/mmopen/vi_32/z7tEbRbmB8Iltdd2twND8JKlNBpNZx94HcCibpIXLtTCTAVhwf55vrHoqtNO4jSJrqa3v9GaOcN5VV7KwYicXEicA/132',1),('oxci95X_jymzjREewaZeQOPjfglE','王','17358982281','3区宿舍23舍B307',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJQ8AP2ZQCmzJSyOPUdkAkIhJ18lQFHImvME0lP13EoU67DBKsNHA9H2fpc4EnvLhJmgkff8ejrAQ/132',1),('ozcla5GmGBHYom7Om7wR7pHUX3RU','新用户fsfs','17058179047','',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/5X8cBQWXx4kRx9JciaicibSV1iabKzqqOBGd5iaHYH41JUYHGicO5lIicdqtic878pzuaZI0Mb9LibUE5vRjs3k6T30Tlxw/132',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
