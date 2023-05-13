# Use a base image with Java 17 and Maven
FROM maven:3.8.4-openjdk-17 AS builder

# Set the working directory
WORKDIR /app

# Copy the Maven build files and pom.xml
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use a smaller base image for the final image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Set the command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
