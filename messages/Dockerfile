FROM openjdk:8-jdk-alpine
#COPY entrypoint.sh /entrypoint.sh
#RUN chmod +x /entrypoint.sh
COPY ./target/messages-1.0-SNAPSHOT.jar ./
CMD ["java", "-jar", "messages-1.0-SNAPSHOT.jar"]

