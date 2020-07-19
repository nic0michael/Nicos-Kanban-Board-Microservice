USE kanban_board;				

-- SHOW CREATE TABLE `audit`;
CREATE TABLE `audit` (
  `audit_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `operation_type` varchar(255) DEFAULT NULL,
  `request` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`audit_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
     
-- SHOW CREATE TABLE `contact`;  
CREATE TABLE `contact` (
  `contact_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  `cellphone` varchar(255) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`contact_id`),
  UNIQUE KEY `UK_kh2lig5t1x5hqpb18oemy4j3j` (`fullname`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
 
-- SHOW CREATE TABLE `customer`;  
CREATE TABLE `customer` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cellphone` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `short_name` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `UK_crkjmjk1oj8gb6j6t5kt7gcxm` (`name`),
  UNIQUE KEY `UK_h4mk0gialp39cjyc4m7kknt61` (`short_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- SHOW CREATE TABLE `employee`;  
CREATE TABLE `employee` (
  `employee_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `id_number` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  `cellphone` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `is_enabled` bit(1) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `skills_category` varchar(255) DEFAULT NULL,
  `team_id` bigint(20) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `user_id` (`user_id`),
  UNIQUE KEY `UK_6tpj1vwpvfk1jljoylys4ixyp` (`id_number`),
  UNIQUE KEY `UK_6djefmjx26crewgafuih51sad` (`fullname`)
) ENGINE=MyISAM AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- SHOW CREATE TABLE `employee_user_story`;
CREATE TABLE `employee_user_story` (
  `employee_id` bigint(20) NOT NULL,
  `user_story_id` bigint(20) NOT NULL,
  KEY `FKkexd21s49v2bf1xux0re92mq1` (`user_story_id`),
  KEY `FKn6vtqimtcorrhdbepgjhkg7a8` (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- SHOW CREATE TABLE `epic`;   
CREATE TABLE `epic` (
  `epic_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL,
  `customer_reference` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`epic_id`),
  UNIQUE KEY `UK_5o8yf45ofj85s5alalaeuvi1j` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;   

-- SHOW CREATE TABLE `subtask`; 
CREATE TABLE `subtask` (
  `subtask_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `assigned_to` bigint(20) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `story_points` int(11) DEFAULT NULL,
  `tasks_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`subtask_id`),
  UNIQUE KEY `UK_kfi15xibqo0g7a3rybrbrkr6q` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- SHOW CREATE TABLE `task`; 
CREATE TABLE `task` (
  `task_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `assigned_to` bigint(20) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `stage` varchar(255) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `story_points` int(11) DEFAULT NULL,
  `user_story_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  UNIQUE KEY `UK_lerptdo9d67pejjpbfau899tm` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

     
-- SHOW CREATE TABLE `team`;   
CREATE TABLE `team` (
  `team_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`team_id`),
  UNIQUE KEY `UK_g2l9qqsoeuynt4r5ofdt1x2td` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


   
-- SHOW CREATE TABLE `user_story`;
CREATE TABLE `user_story` (
  `user_story_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `assigned_to` bigint(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `customer_reference` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `epic_id` bigint(20) DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `stage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_story_id`),
  UNIQUE KEY `UK_5w32xyy51n1h2yesbawuntbo5` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;



	

-- INSERT employee			
insert into employee ( fullname, email,id_number,enabled) values ( 'John Warton', 'warton@gmail.com','001', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Mike Lanister', 'lanister@gmail.com','002', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Steve Reeves', 'Reeves@gmail.com','003', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Ronald Connor', 'connor@gmail.com','004', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Jim Salvator', 'Sal@gmail.com','005', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Peter Henley', 'henley@gmail.com','006', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Richard Carson', 'carson@gmail.com','007', 1);	

insert into employee ( fullname, email,id_number,enabled,user_id,authority,password) values ( 'Tony Roggers', 'roggers@gmail.com','009', 1,'user','ROLE_USER','$2a$10$8D29dyYhGe2Z8VPT3BV84eL6JptlMWgoFAJObP9Gq9IYG6Gc1DXSa');	
insert into employee ( fullname, email,id_number,enabled,user_id,authority,password) values ( 'Honor Miles', 'miles@gmail.com','008', 1,'admin','ROLE_ADMIN','$2a$10$XhADpGqFMvF33YzPmdV7JOTVbvRl9KqN5Tgxx3jHyOcVVxfRqPIwi');	
insert into employee ( fullname, email,id_number,enabled,user_id,authority,password) values ( 'Nicholas Michael', 'nmichael@gmail.com','1956', 1,'klidi','ROLE_ADMIN','$2a$10$r4325krPku2wNegHS5zLY.4PWtbc4Xz7Zu4NfS2AWaiNVNONtrt.2');	

-- INSERT user_story 			
insert into user_story ( name, stage, description) values ( 'Large Production Deploy', 'NOTSTARTED', 'This requires all hands on deck for the final deployment of the software into production');
insert into user_story ( name, stage, description) values ( 'New Employee Budget',  'COMPLETED', 'Decide on a new employee bonus budget for the year and figureout who will be promoted');
insert into user_story ( name, stage, description) values ( 'Office Reconstruction', 'INPROGRESS', 'The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed');
insert into user_story ( name, stage, description) values ( 'Improve Intranet Security', 'INPROGRESS', 'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation');

alter table employee_user_story add constraint FKkexd21s49v2bf1xux0re92mq1 foreign key (user_story_id) references user_story (user_story_id);
alter table employee_user_story add constraint FKn6vtqimtcorrhdbepgjhkg7a8 foreign key (employee_id) references employee (employee_id);
