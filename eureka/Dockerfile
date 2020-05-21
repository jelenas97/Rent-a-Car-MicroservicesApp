FROM openjdk:8-jdk-alpine
#COPY entrypoint.sh /entrypoint.sh
COPY  ./target/eureka-1.0-SNAPSHOT.jar ./
#eureka-1.0.0.jar eureka.jar
#RUN chmod +x /entrypoint.sh
CMD ["java", "-jar", "eureka-1.0-SNAPSHOT.jar"]
