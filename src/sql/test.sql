CREATE DATABASE `commute`;
USE `commute`;
CREATE TABLE `user` (
                        `id` int unsigned NOT NULL AUTO_INCREMENT,
                        `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                        `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                        `address` varchar(100) DEFAULT NULL,
                        `phoneNumber` varchar(30) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `commute`.`timetable` (
                        `timetable_Id` int unsigned NOT NULL AUTO_INCREMENT,
                        `fk_user_id` int unsigned NOT NULL,
                        `datetime`  varchar(128),
                        `things` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
                        PRIMARY KEY (`timetable_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into commute.user (username, password, address, phoneNumber) VALUES ('admin', '123456', '-33.935990, 151.176171', '123456');
insert into commute.user (username, password, address, phoneNumber) VALUES ('test', '123456', '-33.922571, 151.165576', '123456');
insert into commute.user (username, password, address, phoneNumber) VALUES ('abc', '123456', '-33.859444, 151.205306', '123456');
insert into commute.user (username, password, address, phoneNumber) VALUES ('abc', '123456', '-33.921013, 151.160759', '123456');
insert into commute.user (username, password, address, phoneNumber) VALUES ('abc', '123456', '-33.923607, 151.235594', '123456');
insert into commute.user (username, password, address, phoneNumber) VALUES ('abc', '123456', '-33.979038, 151.251376', '123456');
insert into commute.user (username, password, address, phoneNumber) VALUES ('abc', '123456', '-33.917603, 151.169208', '123456');
insert into commute.user (username, password, address, phoneNumber) VALUES ('abc', '123456', '-33.917357, 151.212151', '123456');
insert into commute.user (username, password, address, phoneNumber) VALUES ('abc', '123456', '-33.917357, 151.212151', '123456');
insert into commute.user (username, password, address, phoneNumber) VALUES ('abc', '123456', '-33.916096, 151.211763', '123456');
insert into commute.user (username, password, address, phoneNumber) VALUES ('abc', '123456', '-33.916610, 151.167985', '123456');


