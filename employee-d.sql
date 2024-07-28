CREATE DATABASE IF NOT EXISTS `employee_db`;
USE `employee_db`;

DROP TABLE IF EXISTS `employee_db`;

CREATE TABLE `employee` (
	`id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `employee` VALUES
	(1,'Leticia','Ferreira','leticia2024f@medinastr.com'),
    (2,'Pedro','Reis','pedro2024r@medinastr.com'),
    (3,'Lucas','Santos','lucas2024s@medinastr.com');