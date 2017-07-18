# RandomBeerService
A rest based service with spring, simple JPA and MySQL 5+ database. The GUI shows random beer onec user user on Show Another Beer button. 

### Table of content
  - Tools used
  - Database scripts
  - Database user
  - Running application using STS
  - Running application from command line

### Tools used
  - MySQL +
  - Spring
  - JPA
  
### Database scripts
To create database and populate with sample data execute following sql scripts
  - src/main/resources/CreateTableScript.sql
  - src/main/resources/SampleData.sql

### Database user
To connect to database, the application uses MySQL user with following credentials (which can be changed in src/main/resources/application.properties)
  - user name: admin
  - password: admin

### Staring application using Spring Tool Suits (STS)
Import project in STS and start main class: com.distrilledsch.randombeer.RandomBeerServiceApplication

### Staring application using command line mvn tool
Since we have used the spring-boot-starter-parent POM we have a useful run goal that we can use to start the application. Type following command from the root project directory to start the application:
> mvn spring-boot:run
