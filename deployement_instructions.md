# Kanban Board Spring Boot Microservice

# Deployment Instructions

## Beta Version 1.0.0B
This code is ready for trial usage

## Instalation od Java JDK JRE 8
We intend to migrate our JDK to OpenJDK 11 and rebuild this project

## Database Support
MySQL ,MariaDB, and PerconaMySql are supported

## Instalation of MySQL (Maria DB)  
Although the code was origianally written for MYSQL it was decided to use MariaDB
There will be backward compatability


### SQL Scripts provided
In the folder : **/src/main/resources/sql_scripts**
you will find these files : 

  * create_db_and_tables_4mysql.sql
  * insert_data_4mysql.sql

**The insert_data_4mysql.sql can save you time creating users **  
Please note the passwords are encrypted so dont set them in the query
You will need to edit and run the Insert Query at the bottom of this sql script 
to give your administrator user the needed logon credentials .




once you have lokked in with that employees user Id and password create another Employee with a diferent userId and password and assign the Admin role then delete the previous userID

### To use the SQL scripts provided to generate the tables

| We recomend that you create a Shell script : **mysql-terminal**|
|----------------------------------------------------------------|
| run the folowing command in the terminal:                      |
| sudo nano /usr/bin/mysql-terminal                              |
|                                                                |
| place the folowing code into this shell script:                |
| #!/bin/bash                                                    |
| sudo mysql -u root -pPasswordForRootUserOfMySqlServer          |


 
Now evertime you want open the MSQL terminal you you have a quicker way to get in
just open the bash terminal and run this command :
    **mysql-terminal**

## Programmers comments: 
Create file : schema.sql in /resources folder
Now add this to properties file
spring.jpa.hibernate.ddl-auto=none