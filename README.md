# dailylogv2
*How to run the project?*
+ 1) Run command `mvn clean install` on dailylog-parent  
2) Run command `mvn clean tomcat7:run` on dailylog-web  
3) Visit in web browser: http://127.0.0.1:8080/dailylog/login  

*How to generate mapper.xml and mapper classes?*
+ Run command `mvn mybatis-generator:generate` on dailylog-common  

*What is the api overview?*
+ http://127.0.0.1:8080/dailylog/swagger-ui.html  