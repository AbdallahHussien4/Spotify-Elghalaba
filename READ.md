TO RUN CYPRESS

1-\$cd /your/project/path

2-\$npm install 

3-\$npx cypress open
-->choose any test or run all tests

4-\$npm run test 
-->to generate  auto reports
report for website
==>web/cypress/reports/mochareports/report.html

TO RUN APPIUM :

-IF YOU HAVE ALREDY CONFIGURATION TO RUN APPIUM

1-\$appium

2-Open eclipse

3-Import project in your workspace

4-Help --> install new software

5-Install testng version 7.0.0
https://dl.bintray.com/testng-team/testng-eclipse-release/7.0.0/

6-Right click on your project in project explorer

7-Build Path -->cofigure build bath

8-Java Build Path -->Order and Export

9-Select :JRE System library , Maven Dependencies ,TestNG

10-open src/test/java -->tests

12-Change DesiredCapabilities according to your mobile system in BaseClass.java

13-Choose any test and right click -->Run As Testng Test
