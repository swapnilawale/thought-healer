# Use official Java image
FROM openjdk:21-jdk

# Set working directory
WORKDIR /app

# Copy everything
COPY . .

# Install Maven and build the project
RUN apt-get update && apt-get install -y maven && mvn clean package

# Read port from environment
ENV PORT=8080

# Run the app
CMD ["java", "-cp", "target/thought-healer-1.0.jar", "com.thoughthealer.App"]
