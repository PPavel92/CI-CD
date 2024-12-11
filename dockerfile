FROM openjdk:11-jdk-slim AS build

WORKDIR /app
COPY . /app
RUN ./gradlew build  # или ./gradlew assemble, если у вас такой скрипт для сборки

FROM openjdk:11-jre-slim

COPY --from=build /app/build/libs/*.jar /app/app.jar

EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]


