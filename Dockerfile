FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/Timesheet-1.0.jar Timesheet-1.0.jar
ENTRYPOINT ["java","-jar","/timesheet_devops-1.0.jar"]