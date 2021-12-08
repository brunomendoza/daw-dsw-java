FROM tomcat:9-jdk11-adoptopenjdk-hotspot
WORKDIR /usr/local/tomcat/webapps/
ADD target/daw-dsw-java.war daw-dsw-java.war
EXPOSE 8080
CMD ["catalina.sh", "run"]