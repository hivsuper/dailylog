# dailylog-backend

This project is built on Java 8 and apache maven 3.3.9

----------------------------------------------------
*How to run the project?*
1) Run command `mvn clean install` on dailylog-parent  
2) Run `org.lxp.dailylog.Bootstrap` in dailylog-web or command `mvn spring-boot:run` on dailylog-web  

*How to generate mapper.xml and mapper classes?*
+ Run command `mvn install` on dailylog-common  
+ Run command `mvn mybatis-generator:generate` on dailylog-common  

*What is the api overview?*
+ http://127.0.0.1:8080/dailylog/swagger-ui.html  