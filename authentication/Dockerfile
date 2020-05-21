FROM openjdk:8-jdk-alpine
#COPY entrypoint.sh /entrypoint.sh
#RUN chmod +x /entrypoint.sh
COPY ./target/authentication-1.0-SNAPSHOT.jar ./
CMD ["java", "-jar", "authentication-1.0-SNAPSHOT.jar"]

