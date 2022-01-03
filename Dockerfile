FROM openjdk:8-jdk-alpine
EXPOSE 4003
VOLUME /main-app
ADD /target/mongo-test-client-0.1.0.jar mongo-test-client-0.1.0.jar
ENTRYPOINT ["java","-jar","mongo-test-client-0.1.0.jar"]