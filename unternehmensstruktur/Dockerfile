FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# 1. Nur pom.xml kopieren und Dependencies laden → wird gecacht!
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -q

# 2. Erst jetzt den Code kopieren
COPY src ./src
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
