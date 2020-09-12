# Kanban Board Spring Boot Microservice

# Developer Notes

## Github Commits
Only commits with detailed descriptions will be approved when you do a pull request

use the command :

**git commit -m "Now put your detailed description here"**


## Github Pushes
In order to make a change you need to **create a feature branch from the develop Branch**

Make your changes in the feature Branch

And then **make a pull request **

Subject to our Architects approval after a review of your pull request it will be allowed

[Deployment Instructions](https://docs.github.com/en/packages/using-github-packages-with-your-projects-ecosystem/configuring-apache-maven-for-use-with-github-packages)

To package this application:
mvn deploy -Dregistry=https://maven.pkg.github.com/nic0michael -Dtoken=GH_TOKEN

## Programmers comments: 
Create file : schema.sql in /resources folder
Now add this to properties file
spring.jpa.hibernate.ddl-auto=none



# References
Charts : [https://www.chartjs.org/](https://www.chartjs.org/)

Security: [https://www.baeldung.com/spring-security-thymeleaf](https://www.baeldung.com/spring-security-thymeleaf)

Thymeleaf forms : [https://www.baeldung.com/thymeleaf-select-option](https://www.baeldung.com/thymeleaf-select-option)

SQL formatting : [http://www.dpriver.com/pp/sqlformat.htm](http://www.dpriver.com/pp/sqlformat.htm)

