DROP TABLE IF EXISTS audit;

CREATE TABLE audit(
id INT PRIMARY KEY AUTO_INCREMENT,
operation_type VARCHAR(20) , 
details VARCHAR(300) , 
employee_id CHAR(1),
created_at datetime);


INSERT INTO audit(operation_type, details,employee_id,created_at) VALUES('created Employee','Piet Pompies',1,'2020-06-17T16:17:59.304');
INSERT INTO audit(operation_type, details,employee_id,created_at) VALUES('Created Team','Java Developers',2,'2020-06-17T16:17:59.304');


