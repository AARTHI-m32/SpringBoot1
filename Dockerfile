# Use Maven to build the application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy only the necessary files first to leverage Docker caching
COPY demo/pom.xml demo/
WORKDIR /app/demo
RUN mvn dependency:go-offline

# Copy the entire project after dependencies are cached
COPY demo/ .

# Build the application (Skipping tests for faster builds)
RUN mvn clean package -DskipTests

# Use OpenJDK to run the application
FROM openjdk:17.0.1-jdk-slim

# Set the working directory for the final container
WORKDIR /app

# Copy the built JAR file from the Maven build stage
COPY --from=build /app/demo/target/demo-0.0.1-SNAPSHOT.jar demo.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "demo.jar"]

#https://springboot1-ovg8.onrender.com