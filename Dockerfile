FROM openjdk:17
EXPOSE 8080
ADD target/springboot-employee-tutorial.jar springboot-employee-tutorial.jar
ENTRYPOINT ["java","-jar","/springboot-employee-tutorial.jar"]