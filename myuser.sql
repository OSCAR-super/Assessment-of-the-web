/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - myuser
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`myuser` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `myuser`;

/*Table structure for table `kaohe` */

DROP TABLE IF EXISTS `kaohe`;

CREATE TABLE `kaohe` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `neiron` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `kaohe` */

insert  into `kaohe`(`id`,`name`,`time`,`neiron`) values (0,'考核1','20200202','cifan342423243'),(1,'1','1','1'),(3,'12','12','123123123\r\n2131231\r\n131323\r\n1312313');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sid` int(11) NOT NULL,
  `sname` varchar(50) DEFAULT NULL,
  `teacher` int(11) DEFAULT NULL,
  `gai` varchar(30) DEFAULT NULL,
  `stime` varchar(30) DEFAULT NULL,
  `kaohename` int(30) DEFAULT NULL,
  `file` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `kao` (`kaohename`),
  KEY `xiugai` (`teacher`),
  CONSTRAINT `kao` FOREIGN KEY (`kaohename`) REFERENCES `kaohe` (`id`),
  CONSTRAINT `xiugai` FOREIGN KEY (`teacher`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`sid`,`sname`,`teacher`,`gai`,`stime`,`kaohename`,`file`) values (1,'1',2,'通过','2020-02-15 18:41:16 下午',0,''),(111,'111',3,'通过','2020-02-15 21:13:21 下午',1,''),(132,'123',0,'通过','2020-02-15 18:46:14 下午',0,'1.rar');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`username`,`password`) values (0,'李雨田23343','lyt','123'),(1,'123','lyt1','123'),(2,'1234','lyt2','123'),(3,'12345','lyt3','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
