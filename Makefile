# Makefile for the config-teste project

# Build the application
build:
	./mvnw clean install -DskipTests

# Run tests
test:
	./mvnw test

# Run the application
run:
	./mvnw spring-boot:run

# Build the Docker image and start the containers
docker-up: build
	docker-compose up --build -d

# Stop and remove the containers
docker-down:
	docker-compose down
