FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/check_task-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
