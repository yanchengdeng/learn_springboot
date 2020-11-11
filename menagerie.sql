-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.28 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 menagerie 的数据库结构
CREATE DATABASE IF NOT EXISTS `menagerie` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `menagerie`;

-- 导出  表 menagerie.customer 结构
CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  menagerie.customer 的数据：~13 rows (大约)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `first_name`, `last_name`) VALUES
	(3, 'Jack', 'Bauer'),
	(4, 'Chloe', 'O\'Brian'),
	(5, 'Kim', 'Bauer'),
	(6, 'David', 'Palmer'),
	(7, 'Michelle', 'Dessler'),
	(8, 'Jack', 'Bauer'),
	(9, 'Chloe', 'O\'Brian'),
	(10, 'Kim', 'Bauer'),
	(11, 'David', 'Palmer'),
	(12, 'Michelle', 'Dessler'),
	(13, 'Jack', 'Bauer'),
	(14, 'Chloe', 'O\'Brian'),
	(15, 'Kim', 'Bauer'),
	(16, 'David', 'Palmer');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- 导出  表 menagerie.event 结构
CREATE TABLE IF NOT EXISTS `event` (
  `name` varchar(20) DEFAULT NULL,
  `age` date DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  menagerie.event 的数据：~10 rows (大约)
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` (`name`, `age`, `type`, `remark`) VALUES
	('Fluffy', '1995-05-15', 'litter', '4 kittens, 3 female, 1 male'),
	('Buffy', '1993-06-23', 'litter', '5 puppies, 2 female, 3 male'),
	('Buffy', '1994-06-19', 'litter', '3 puppies, 3 female'),
	('Chirpy', '1999-03-21', 'vet', 'needed beak straightened'),
	('Slim', '1997-08-03', 'vet', 'broken rib'),
	('Bowser', '1991-10-12', 'kennel', NULL),
	('Fang', '1991-10-12', 'kennel', NULL),
	('Fang', '1998-08-28', 'birthday', 'Gave him a new chew toy'),
	('Claws', '1998-03-17', 'birthday', 'Gave him a new flea collar'),
	('Whistler', '1998-12-09', 'birthday', 'First birthday');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;

-- 导出  表 menagerie.goods 结构
CREATE TABLE IF NOT EXISTS `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goods_name` varchar(50) NOT NULL DEFAULT '0' COMMENT '商品名称',
  `goods_info` varchar(50) NOT NULL DEFAULT '' COMMENT '商品价格',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='商品信息表\r\n';

-- 正在导出表  menagerie.goods 的数据：~9 rows (大约)
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` (`id`, `goods_name`, `goods_info`) VALUES
	(1, 'iphone8s', '这是一台ios'),
	(2, 'huaweip40', '这是一台华为'),
	(3, 'iphone7s', '这是一台ios iohone7s'),
	(4, 'xiaomi10', '这是一台小米10'),
	(5, 'xiaomi10C', '这是一台小米10V'),
	(6, 'meizu', '这是一台魅族6s'),
	(6, 'meizu', '这是一台魅族6s'),
	(8, 'meizu8', '这是一台魅族8s');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;

-- 导出  表 menagerie.hibernate_sequence 结构
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  menagerie.hibernate_sequence 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(18);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- 导出  表 menagerie.lego_set 结构
CREATE TABLE IF NOT EXISTS `lego_set` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  menagerie.lego_set 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `lego_set` DISABLE KEYS */;
/*!40000 ALTER TABLE `lego_set` ENABLE KEYS */;

-- 导出  表 menagerie.manual 结构
CREATE TABLE IF NOT EXISTS `manual` (
  `id` int(11) NOT NULL,
  `lego_set` int(11) DEFAULT NULL,
  `author` char(100) DEFAULT NULL,
  `text` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  menagerie.manual 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `manual` DISABLE KEYS */;
/*!40000 ALTER TABLE `manual` ENABLE KEYS */;

-- 导出  表 menagerie.model 结构
CREATE TABLE IF NOT EXISTS `model` (
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `lego_set` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  menagerie.model 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
/*!40000 ALTER TABLE `model` ENABLE KEYS */;

-- 导出  表 menagerie.person 结构
CREATE TABLE IF NOT EXISTS `person` (
  `id` varchar(32) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 正在导出表  menagerie.person 的数据：1 rows
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`id`, `age`, `name`) VALUES
	('1', 13, 'person1');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

-- 导出  表 menagerie.pet 结构
CREATE TABLE IF NOT EXISTS `pet` (
  `name` varchar(20) DEFAULT NULL,
  `owner` varchar(20) DEFAULT NULL,
  `species` varchar(20) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `death` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  menagerie.pet 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `pet` DISABLE KEYS */;
INSERT INTO `pet` (`name`, `owner`, `species`, `sex`, `birth`, `death`) VALUES
	('puffball', 'Diane_new', 'hamster', 'f', '2009-03-30', '2020-03-24'),
	('Cluaws', 'Lucy', 'dog', 'f', '1999-09-21', '2020-03-21'),
	('Fluffy', 'Lucy', 'bird', 'f', '2019-02-19', '2019-11-14'),
	('parakeet', 'nimo', 'bird', 'm', '2014-05-11', '2023-10-21'),
	('Bear', 'nimo', 'animal', 'm', '2015-09-12', '2020-10-22');
/*!40000 ALTER TABLE `pet` ENABLE KEYS */;

-- 导出  表 menagerie.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  menagerie.user 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `email`, `name`, `age`) VALUES
	(1, 'dycjavee@163.com', 'lisa', NULL),
	(2, 'javaee.edu@hotmail.com', 'nimo', NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
