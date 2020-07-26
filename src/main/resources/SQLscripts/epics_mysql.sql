-- SHOW CREATE TABLE `epic`;   
DROP TABLE IF EXISTS epic;
CREATE TABLE `epic` (
  `epic_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `customer_reference` varchar(255) DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`epic_id`),
  UNIQUE KEY `UK_5o8yf45ofj85s5alalaeuvi1j` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;  


INSERT INTO epic(name, customer_id, is_active,date_created) VALUES('Create new billing Service',1,'Y','2020-06-17T16:17:59.304');
INSERT INTO epic(name, customer_id, is_active,date_created) VALUES('Update Accounting System',2,'Y','2020-06-17T16:17:59.304');
INSERT INTO epic(name, customer_id, is_active,date_created) VALUES('Replace Billing System',3,'Y','2020-06-17T16:17:59.304');
INSERT INTO epic(name, customer_id, is_active,date_created) VALUES('Make gadget for James Bond',4,'Y','2020-06-17T16:17:59.304');


