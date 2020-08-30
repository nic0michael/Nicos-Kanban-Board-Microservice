# Kanban Board Spring Boot Microservice

# Developer Notes

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

