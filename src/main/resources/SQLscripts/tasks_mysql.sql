DROP TABLE IF EXISTS tasks;

CREATE TABLE tasks(
id INT PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(300), 
description VARCHAR(500), 
status VARCHAR(20), 
assigned_to INT,
user_stories_id INT, 
story_points INT,
due_date datetime,
is_active CHAR(3),
created_at datetime);


INSERT INTO tasks(name, is_active,user_stories_id,created_at) VALUES('Create new billing Service','Y',1,'2020-06-17T16:17:59.304');
INSERT INTO tasks(name, is_active,user_stories_id,created_at) VALUES('Update Accounting System','Y',2,'2020-06-17T16:17:59.304');
INSERT INTO tasks(name, is_active,user_stories_id,created_at) VALUES('Replace Billing System','Y',3,'2020-06-17T16:17:59.304');
INSERT INTO tasks(name, is_active,user_stories_id,created_at) VALUES('James Bond','Y',4,'2020-06-17T16:17:59.304');

