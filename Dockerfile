FROM openjdk:17-ea-22-jdk-oracle
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]