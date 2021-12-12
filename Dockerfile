FROM tomcat:9-jdk11-adoptopenjdk-hotspot
WORKDIR /usr/local/tomcat/webapps/
# https://cwiki.apache.org/confluence/display/tomcat/HowTo#HowTo-HowdoImakemywebapplicationbetheTomcatdefaultapplication?
ADD target/daw-dsw-java.war ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "jpda", "run"]