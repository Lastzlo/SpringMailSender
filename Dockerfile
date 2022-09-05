FROM openjdk:17
ADD target/springMailSender-0.0.1-SNAPSHOT.jar springMailSender-0.0.1-SNAPSHOT.jar
EXPOSE 8028
ENTRYPOINT ["java","-jar","springMailSender-0.0.1-SNAPSHOT.jar"]
