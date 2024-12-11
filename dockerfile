FROM openjdk:11-jdk-slim as build

RUN apt-get update && apt-get install -y gradle

WORKDIR /app
COPY . /app

RUN gradle build --no-daemon

FROM openjdk:11-jre-slim

COPY --from=build /app/build/libs/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

