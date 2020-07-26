-- SHOW CREATE TABLE `customer`;  
DROP TABLE IF EXISTS customer;
CREATE TABLE `customer` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `short_name` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `cellphone` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `UK_crkjmjk1oj8gb6j6t5kt7gcxm` (`name`),
  UNIQUE KEY `UK_h4mk0gialp39cjyc4m7kknt61` (`short_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


INSERT INTO customer(name, short_name, details, is_active,date_created) VALUES('IBM LTD','IBM','US It Firm','Y','2020-06-17T16:17:59.304');
INSERT INTO customer(name, short_name, details, is_active,date_created) VALUES('ORACLE LTD','ORACLE','US It Firm','Y','2020-06-17T16:17:59.304');
INSERT INTO customer(name, short_name, details, is_active,date_created) VALUES('DELL LTD','DELL','US It Firm','Y','2020-06-17T16:17:59.304');
INSERT INTO customer(name, short_name, details, is_active,date_created) VALUES('ACME Laboratories','ACME','SA Firm','Y','2020-06-17T16:17:59.304');


