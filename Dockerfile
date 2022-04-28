FROM openjdk:11
ADD target/IBMProducer.jar IBMProducer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/IBMProducer.jar"]