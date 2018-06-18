create database dew_training_db;
use dew_training_db;

CREATE TABLE `application_properties` (
  `application_property_id` int(11) NOT NULL AUTO_INCREMENT,
  `property_name` varchar(45) NOT NULL,
  `property_value` varchar(500) NOT NULL,
  `created_on` datetime NOT NULL,
  `created_by` varchar(30) NOT NULL,
  `modified_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`application_property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `users` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `gender` tinyint(1) NOT NULL,
  `DOB` date NOT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `is_active` bit(1) NOT NULL DEFAULT b'1',
  `address` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `country` varchar(50) NOT NULL,
  `pincode` varchar(6) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `user_type` int(11) DEFAULT NULL,
  `created_on` datetime NOT NULL,
  `created_by` varchar(30) NOT NULL,
  `modified_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
