DROP TABLE IF EXISTS subtasks;

CREATE TABLE subtasks(
id INT PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(300), 
description VARCHAR(500), 
status VARCHAR(20), 
assigned_to INT,
tasks_id INT, 
story_points INT,
due_date datetime,
is_active CHAR(3),
created_at datetime);


INSERT INTO subtasks(name, is_active,tasks_id,created_at) VALUES('Front-end development','Y',1,'2020-06-17T16:17:59.304');
INSERT INTO subtasks(name, is_active,tasks_id,created_at) VALUES('Front-end development','Y',2,'2020-06-17T16:17:59.304');
INSERT INTO subtasks(name, is_active,tasks_id,created_at) VALUES('Back-end development','Y',3,'2020-06-17T16:17:59.304');
INSERT INTO subtasks(name, is_active,tasks_id,created_at) VALUES('Front-end development','Y',4,'2020-06-17T16:17:59.304');


