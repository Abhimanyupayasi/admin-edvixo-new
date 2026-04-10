# 🔹 Build stage
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .

# low memory build
RUN mvn clean package -DskipTests -Dmaven.compiler.fork=true -Dmaven.compiler.memoryInitialSize=128m -Dmaven.compiler.memoryMaximumSize=256m

# 🔹 Run stage
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
