FROM openjdk:11-jdk-slim AS build

WORKDIR /app
COPY . /app
RUN ./gradlew build

FROM openjdk:11-jre-slim

COPY --from=build /app/build/libs/*.jar /app/app.jar

EXPOSE 4280
CMD ["java", "-jar", "/app/app.jar"]


