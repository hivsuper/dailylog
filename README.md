#dailylogv2
*Q: How to run the project?*
+A: 1) Run command `mvn clean install` on dailylog-parent  
2) Run command `mvn clean tomcat7:run` on dailylog-web  
3) Visit in web browser: http://127.0.0.1:8080/dailylog/login  

*Q: How to generate mapper.xml and mapper classes?*
+A: Run command `mvn mybatis-generator:generate` on dailylog-common  

*Q: What is the api overview?*
+A: http://127.0.0.1:8080/dailylog/swagger-ui.html  