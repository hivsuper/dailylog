# dailylogv2
*How to run the project?*
1) Run command `mvn clean install` on dailylog-parent  
2) Run `org.lxp.dailylog.Bootstrap` in dailylog-web  

*How to generate mapper.xml and mapper classes?*
+ Run command `mvn install` on dailylog-common  
+ Run command `mvn mybatis-generator:generate` on dailylog-common  

*What is the api overview?*
+ http://127.0.0.1:8080/dailylog/swagger-ui.html  