CREATE
    DATABASE kanban_board;

USE
    kanban_board;

-- SHOW CREATE TABLE `audit`;
DROP TABLE IF EXISTS audit;
CREATE TABLE `audit`
(
    `audit_id`       bigint(20) NOT NULL AUTO_INCREMENT,
    `date_created`   datetime     DEFAULT NULL,
    `employee_id`    bigint(20)   DEFAULT NULL,
    `operation_type` varchar(255) DEFAULT NULL,
    `request`        varchar(255) DEFAULT NULL,
    PRIMARY KEY (`audit_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8;

-- SHOW CREATE TABLE `contact`;  
DROP TABLE IF EXISTS contact;
CREATE TABLE `contact`
(
    `contact_id`   bigint(20) NOT NULL AUTO_INCREMENT,
    `fullname`     varchar(255) DEFAULT NULL,
    `details`      varchar(255) DEFAULT NULL,
    `customer_id`  bigint(20)   DEFAULT NULL,
    `telephone`    varchar(255) DEFAULT NULL,
    `cellphone`    varchar(255) DEFAULT NULL,
    `email`        varchar(255) DEFAULT NULL,
    `is_active`    varchar(255) DEFAULT NULL,
    `date_created` datetime     DEFAULT NULL,
    PRIMARY KEY (`contact_id`),
    UNIQUE KEY `UK_kh2lig5t1x5hqpb18oemy4j3j` (`fullname`)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8;

-- SHOW CREATE TABLE `customer`;  
DROP TABLE IF EXISTS customer;
CREATE TABLE `customer`
(
    `customer_id`  bigint(20) NOT NULL AUTO_INCREMENT,
    `name`         varchar(255) DEFAULT NULL,
    `short_name`   varchar(255) DEFAULT NULL,
    `telephone`    varchar(255) DEFAULT NULL,
    `cellphone`    varchar(255) DEFAULT NULL,
    `date_created` datetime     DEFAULT NULL,
    `details`      varchar(255) DEFAULT NULL,
    `email`        varchar(255) DEFAULT NULL,
    `is_active`    varchar(255) DEFAULT NULL,
    PRIMARY KEY (`customer_id`),
    UNIQUE KEY `UK_crkjmjk1oj8gb6j6t5kt7gcxm` (`name`),
    UNIQUE KEY `UK_h4mk0gialp39cjyc4m7kknt61` (`short_name`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8;

-- SHOW CREATE TABLE `employee`;  
DROP TABLE IF EXISTS employee;
CREATE TABLE `employee`
(
    `employee_id`     bigint(20) NOT NULL AUTO_INCREMENT,
    `fullname`        varchar(255) DEFAULT NULL,
    `id_number`       varchar(255) DEFAULT NULL,
    `telephone`       varchar(255) DEFAULT NULL,
    `cellphone`       varchar(255) DEFAULT NULL,
    `date_created`    datetime     DEFAULT NULL,
    `details`         varchar(255) DEFAULT NULL,
    `email`           varchar(255) DEFAULT NULL,
    `skills_category` varchar(255) DEFAULT NULL,
    `authority`       varchar(255) DEFAULT NULL,
    `password`        varchar(255) DEFAULT NULL,
    `user_id`         varchar(255) DEFAULT NULL,
    `enabled`         int(1)       DEFAULT NULL,
    PRIMARY KEY (`employee_id`),
    UNIQUE KEY `UK_6djefmjx26crewgafuih51sad` (`fullname`),
    UNIQUE KEY `UK_6tpj1vwpvfk1jljoylys4ixyp` (`id_number`),
    UNIQUE KEY `UK_mpps3d3r9pdvyjx3iqixi96fi` (`user_id`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 51
  DEFAULT CHARSET = utf8;

-- SHOW CREATE TABLE `employee_team`;
CREATE TABLE `employee_team`
(
    `employee_team_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `employee_id`      bigint(20) DEFAULT NULL,
    `team_id`          bigint(20) DEFAULT NULL,
    PRIMARY KEY (`employee_team_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8;

-- SHOW CREATE TABLE `employee_user_story`;
DROP TABLE IF EXISTS employee_user_story;
CREATE TABLE `employee_user_story`
(
    `employee_id`   bigint(20) NOT NULL,
    `user_story_id` bigint(20) NOT NULL,
    KEY `FKkexd21s49v2bf1xux0re92mq1` (`user_story_id`),
    KEY `FKn6vtqimtcorrhdbepgjhkg7a8` (`employee_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8;


-- SHOW CREATE TABLE `epic`;   
DROP TABLE IF EXISTS epic;
CREATE TABLE `epic`
(
    `epic_id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `name`               varchar(255) DEFAULT NULL,
    `description`        varchar(255) DEFAULT NULL,
    `customer_id`        bigint(20)   DEFAULT NULL,
    `customer_reference` varchar(255) DEFAULT NULL,
    `date_created`       datetime     DEFAULT NULL,
    `due_date`           datetime     DEFAULT NULL,
    `is_active`          varchar(255) DEFAULT NULL,
    PRIMARY KEY (`epic_id`),
    UNIQUE KEY `UK_5o8yf45ofj85s5alalaeuvi1j` (`name`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = utf8;

-- SHOW CREATE TABLE `status_value`;   
DROP TABLE IF EXISTS `status_value`;
CREATE TABLE `status_value`
(
    `status_value_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `display_value`   varchar(255) DEFAULT NULL,
    `description`     varchar(255) DEFAULT NULL,
    `sort_order`      int(11)      DEFAULT NULL,
    PRIMARY KEY (`status_value_id`),
    UNIQUE KEY `UK_8ea8j0j4d04asye727ncmcngm` (`display_value`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = utf8;


-- SHOW CREATE TABLE `subtask`; 
DROP TABLE IF EXISTS subtask;
CREATE TABLE `subtask`
(
    `subtask_id`   bigint(20) NOT NULL AUTO_INCREMENT,
    `name`         varchar(255) DEFAULT NULL,
    `description`  varchar(255) DEFAULT NULL,
    `story_points` int(11)      DEFAULT NULL,
    `tasks_id`     bigint(20)   DEFAULT NULL,
    `assigned_to`  bigint(20)   DEFAULT NULL,
    `date_created` datetime     DEFAULT NULL,
    `due_date`     datetime     DEFAULT NULL,
    `is_active`    varchar(255) DEFAULT NULL,
    PRIMARY KEY (`subtask_id`),
    UNIQUE KEY `UK_kfi15xibqo0g7a3rybrbrkr6q` (`name`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8;


-- SHOW CREATE TABLE `task`; 
DROP TABLE IF EXISTS task;
CREATE TABLE `task`
(
    `task_id`       bigint(20) NOT NULL AUTO_INCREMENT,
    `name`          varchar(255) DEFAULT NULL,
    `description`   varchar(255) DEFAULT NULL,
    `is_active`     varchar(255) DEFAULT NULL,
    `stage`         varchar(255) DEFAULT NULL,
    `date_created`  datetime     DEFAULT NULL,
    `due_date`      datetime     DEFAULT NULL,
    `end_date`      datetime     DEFAULT NULL,
    `start_date`    datetime     DEFAULT NULL,
    `story_points`  int(11)      DEFAULT NULL,
    `assigned_to`   bigint(20)   DEFAULT NULL,
    `user_story_id` bigint(20)   DEFAULT NULL,
    PRIMARY KEY (`task_id`),
    UNIQUE KEY `UK_lerptdo9d67pejjpbfau899tm` (`name`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8;


-- SHOW CREATE TABLE `team`;   
DROP TABLE IF EXISTS team;
CREATE TABLE `team`
(
    `team_id`      bigint(20) NOT NULL AUTO_INCREMENT,
    `description`  varchar(255) DEFAULT NULL,
    `name`         varchar(255) DEFAULT NULL,
    `date_created` datetime     DEFAULT NULL,
    `is_active`    varchar(255) DEFAULT NULL,
    PRIMARY KEY (`team_id`),
    UNIQUE KEY `UK_g2l9qqsoeuynt4r5ofdt1x2td` (`name`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8;


-- SHOW CREATE TABLE `user_story`;
DROP TABLE IF EXISTS user_story;

CREATE TABLE `user_story`
(
    `user_story_id`      bigint(20) NOT NULL AUTO_INCREMENT,
    `name`               varchar(255) DEFAULT NULL,
    `description`        varchar(255) DEFAULT NULL,
    `stage`              varchar(255) DEFAULT NULL,
    `customer_reference` varchar(255) DEFAULT NULL,
    `due_date`           datetime     DEFAULT NULL,
    `date_created`       datetime     DEFAULT NULL,
    `is_active`          varchar(255) DEFAULT NULL,
    `end_date`           datetime     DEFAULT NULL,
    `start_date`         datetime     DEFAULT NULL,
    `assigned_to`        bigint(20)   DEFAULT NULL,
    `epic_id`            bigint(20)   DEFAULT NULL,
    PRIMARY KEY (`user_story_id`),
    UNIQUE KEY `UK_5w32xyy51n1h2yesbawuntbo5` (`name`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8;



alter table employee_user_story
    add constraint FKkexd21s49v2bf1xux0re92mq1 foreign key (user_story_id) references user_story (user_story_id);
alter table employee_user_story
    add constraint FKn6vtqimtcorrhdbepgjhkg7a8 foreign key (employee_id) references employee (employee_id);





