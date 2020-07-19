DROP TABLE IF EXISTS employees;

CREATE TABLE employees(
id INT PRIMARY KEY AUTO_INCREMENT, 
fullname VARCHAR(300) UNIQUE, 
title VARCHAR(10), 
user_is VARCHAR(20) UNIQUE, 
password VARCHAR(20), 
skill_category VARCHAR(50), 
teams_id INT, 
telephone VARCHAR(12),
cellphone VARCHAR(12),
email VARCHAR(100),
employee_type CHAR(1),
is_active CHAR(3),
created_at datetime);


INSERT INTO employees(fullname, is_active,teams_id,created_at) VALUES('Koos vd Merwe','Y',1,'2020-06-17T16:17:59.304');
INSERT INTO employees(fullname, is_active,teams_id,created_at) VALUES('Piet Pompies','Y',2,'2020-06-17T16:17:59.304');


