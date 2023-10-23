# Use a base image that includes Java
FROM eclipse-temurin:17

# Set the working directory
WORKDIR /app/flight-service

# Copy the JAR file into the container
COPY target/flight-service-1.jar flight-service.jar

# Command to run your application
ENTRYPOINT ["java", "-jar", "flight-service.jar"]
