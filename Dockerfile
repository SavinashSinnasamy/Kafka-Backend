# Use a base image with JDK and Maven to build the application
FROM maven:3-openjdk-17 AS builder

# Set the working directory in the container
WORKDIR C:/app

# Copy the Maven project file and download the dependencies
COPY . .
RUN mvn -B dependency:go-offline
# Copy the application source code
# COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use a lightweight base image with JRE to run the application
FROM openjdk:17.0.1-jdk-slim

# Set the working directory in the container
WORKDIR C:/Kafka-Backend

# Copy the built JAR file from the builder stage
COPY --from=builder C:/app/target/Kafka-Backend-0.0.1-SNAPSHOT.jar ./Kafka-Backend.jar

EXPOSE 9092

CMD ["java","-Xms512m","-Xmx1024m","-jar","Kafka-Backend.jar"]

# Specify the command to run your application
#CMD ["java", "-jar", "app.jar"]