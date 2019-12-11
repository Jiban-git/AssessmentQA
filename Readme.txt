Pre-Requisites:

1)java 1.8 and maven 3.5 should be installed on execution system
2)JAVA_HOME,MAVEN_HOME should be declared in environment variable-system variables
3)directory of java-bin and maven-bin should be declared in systemvariable->path
4)chrome version 78 should be available.

Execution steps:
1)download the project from git UI https://github.com/Jiban-git/AssessmentQA.git
 or from command line
 >Create a folder , where you want to download the project
 >in command line go to that directory
  Clone the project from git repo: https://github.com/Jiban-git/AssessmentQA.git

  git clone https://github.com/Jiban-git/AssessmentQA.git
2)Once the project is cloned in command line navigate to that project location ,where pom.xml is available.
3)Run mvn test ,your build will be triggered.
4)Find the report under target/cucumber-reports/report.html