# Use a base image with JDK 17 to build the application
FROM maven:3.8.3-openjdk-17 as builder

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper files
COPY .mvn .mvn

# Copy the project descriptor files
COPY pom.xml .
COPY src ./src

# Build the application, skipping the tests
RUN mvn clean package -DskipTests

# Use a base image with JDK 17 to run the application
FROM openjdk:17

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the builder image
COPY --from=builder /app/target/vehicles-0.0.1-SNAPSHOT.jar .

# Set the active profile for the Spring Boot application
ENV SPRING_PROFILES_ACTIVE docker

# Expose the port on which your application listens
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "vehicles-0.0.1-SNAPSHOT.jar"]