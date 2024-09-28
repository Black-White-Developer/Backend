# Build
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

COPY . .

RUN ./gradlew bootJar

# Runtime
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]