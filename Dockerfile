FROM openjdk:jdk-alpine

COPY ./target/lambda-block-app-0.0.1-SNAPSHOT.jar /app/lambda-block-app-0.0.1-SNAPSHOT.jar

EXPOSE 9900

CMD ["java", "-jar", "/app/lambda-block-app-0.0.1-SNAPSHOT.jar"]
