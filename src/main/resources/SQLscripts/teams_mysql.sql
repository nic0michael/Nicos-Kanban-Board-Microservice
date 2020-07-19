DROP TABLE IF EXISTS teams;

CREATE TABLE teams(
id INT PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(300) UNIQUE, 
description VARCHAR(500), 
is_active CHAR(3),
created_at datetime);


INSERT INTO teams(name, is_active,created_at) VALUES('Front-end developers','Y','2020-06-17T16:17:59.304');
INSERT INTO teams(name, is_active,created_at) VALUES('Back-end developers','Y','2020-06-17T16:17:59.304');


