-- SHOW CREATE TABLE `contact`;  
DROP TABLE IF EXISTS contact;
CREATE TABLE `contact` (
  `contact_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `cellphone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  PRIMARY KEY (`contact_id`),
  UNIQUE KEY `UK_kh2lig5t1x5hqpb18oemy4j3j` (`fullname`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO contact(fullname, customer_id, telephone, is_active,date_created) VALUES('Bill Gates',1,'+1-123-1234','Y','2020-06-17T16:17:59.304');
INSERT INTO contact(fullname, customer_id, telephone, is_active,date_created) VALUES('Joe Soap',2,'+271112124','Y','2020-06-17T16:17:59.304');
INSERT INTO contact(fullname, customer_id, telephone, is_active,date_created) VALUES('Jane Doe',3'+271112784','Y','2020-06-17T16:17:59.304');
INSERT INTO contact(fullname, customer_id, telephone, is_active,date_created) VALUES('James Bond',4,'+7-007-7000','Y','2020-06-17T16:17:59.304');


