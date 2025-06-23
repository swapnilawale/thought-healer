# ✅ Use a base image that has both Java and Maven
FROM maven:3.9.6-eclipse-temurin-21

# Set working directory
WORKDIR /app

# Copy all project files
COPY . .

# Build the app
RUN mvn clean package

# Expose the port Render sets
ENV PORT=8080

# Start the Java app
CMD ["java", "-jar", "target/thought-healer-1.0-shaded.jar"]
