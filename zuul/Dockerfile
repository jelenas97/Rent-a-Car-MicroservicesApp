FROM openjdk:8-jdk-alpine
#COPY entrypoint.sh /entrypoint.sh
COPY pom.xml /tmp/pom.xml
COPY ./target/zuul-1.0-SNAPSHOT.jar ./
#zuul-1.0.0.jar zuul.jar
#RUN chmod +x /entrypoint.sh
CMD ["java", "-jar", "zuul-1.0-SNAPSHOT.jar"]

