/*
SQLyog Community v11.51 (64 bit)
MySQL - 5.6.17 : Database - dbexamen
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `direcciones` */

CREATE TABLE `direcciones` (
  `id` bigint(20) NOT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `codigoPostal` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `permisos` */

CREATE TABLE `permisos` (
  `id` bigint(20) NOT NULL,
  `estatus` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `usuarios` */

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `direccion_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_direccion` (`direccion_id`),
  CONSTRAINT `fk_direccion` FOREIGN KEY (`direccion_id`) REFERENCES `direcciones` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `usuarios_permisos` */

CREATE TABLE `usuarios_permisos` (
  `usuarios_id` bigint(20) DEFAULT NULL,
  `permisos_id` bigint(20) DEFAULT NULL,
  KEY `fk_usuarios` (`usuarios_id`),
  KEY `fk_permisos` (`permisos_id`),
  CONSTRAINT `fk_usuarios` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `fk_permisos` FOREIGN KEY (`permisos_id`) REFERENCES `permisos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
