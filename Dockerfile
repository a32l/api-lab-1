FROM maven:3.5.2-jdk-8-alpine
COPY /target/antonapi-1.0.jar antonapi.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/antonapi.jar"]