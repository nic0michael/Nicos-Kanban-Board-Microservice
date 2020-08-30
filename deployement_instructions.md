# Kanban Board Spring Boot Microservice

# Deployment Instructions

## Release Version 1.0.1
This code is ready for usage

## Installation of Java JDK JRE 8
We intend to migrate our JDK to OpenJDK 11 and rebuild this project

## Database Support
MySQL ,MariaDB, and PerconaMySql are supported

## Installation of MySQL (Maria DB)  
Although the code was originally written for MYSQL it was decided to use MariaDB
There will be backward compatibility


### SQL Scripts provided
In the folder : **/src/main/resources/sql_scripts**
you will find these files : 

  * create_db_and_tables_4mysql.sql
  * insert_data_4mysql.sql

**The insert_data_4mysql.sql can save you time creating users **  
Please note the passwords are encrypted so dont set them in the query
You will need to edit and run the Insert Query at the bottom of this sql script 
to give your administrator user the needed logon credentials .




once you have locked in with that employees user Id and password create another Employee with a diferent userId and password and assign the Admin role then delete the previous userID

### To use the SQL scripts provided to generate the tables

| We recommend that you create a Shell script : **mysql-terminal**|
|----------------------------------------------------------------|
| run the following command in the terminal:                      |
| sudo nano /usr/bin/mysql-terminal                              |
|                                                                |
| place the following code into this shell script:                |
| #!/bin/bash                                                    |
| sudo mysql -u root -pPasswordForRootUserOfMySqlServer          |


 
Now every time you want open the MSQL terminal you you have a quicker way to get in
just open the bash terminal and run this command :
    **mysql-terminal**

## Launching the Microservice
### Download the JAR file :  
here: [https://github.com/nic0michael/KanbanBoardMicroservice/tree/master/Files](https://github.com/nic0michael/KanbanBoardMicroservice/tree/master/Files)

Copy to a folder named : kanban-board

Run the following command from a terminal in that folder:

**java -jar spring-boot-kanban-board_V1_0_1.jar**

You can run shell script start.sh
or batch file start.BAT

### Open Browser to this URL
[http://localhost:8080/](http://localhost:8080/)

