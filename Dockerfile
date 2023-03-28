FROM eclipse-temurin:17-jdk-jammy
COPY ./target/quarkus-app /project
WORKDIR /project
CMD ["java","-jar","./quarkus-run.jar"]