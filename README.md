dailylogv2
==========

split dailylog into several modules

1. Run in Eclipse(Kepler) with cammand: clean tomcat7:run-war -Dmaven.tomcat.port=8080
2. Visit in web browser: http://127.0.0.1:8080/dailylog/login
3. Since it must be run after packaging war is finished, javascript/css/jsp amend will never be reloaded unless being redeployed.
4. Double click on dailylog-web module->Build Path->JavaScript->Include Path->Source->Excluded->Edit, add ext-all.js into `Exclusion patterns` to avoid build this file every time when build automatically.