# Smart Parking Management System

A microservices-based Smart Parking Management System built with Java, Spring Boot, and Maven. The system manages users, vehicles, parking slots, and payments, and uses Eureka for service discovery.

## Features

- **User Service**: Register, update, delete, and retrieve users.
- **Vehicle Service**: Register, update, delete, and retrieve vehicles.
- **Parking Service**: Book, update, delete, and retrieve parking slots.
- **Payment Service**: Validate, update, delete, and retrieve payments.
- **Eureka Server**: Service discovery for all microservices.

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- Eureka Server (Netflix OSS)
- Maven
- RESTful APIs

## Architecture

- Each service runs on a different port.
- Eureka Server for service registration and discovery.
- Communication via REST APIs.

## Getting Started

### Prerequisites

- Java 17+
- Maven
- Git

### Clone the Repository
### Build and Run

1. **Start Eureka Server**  
   Navigate to the Eureka server module and run:
2. Eureka will be available at [http://localhost:8761](http://localhost:8761).

2. **Start Each Microservice**  
   For each service (`user-service`, `vehicle-service`, `parking-service`, `payment-service`), run:
   Each service will register with Eureka.

### Eureka Server Screenshot

![Eureka Server Dashboard](eureka-dashboard.png)


All endpoints are documented in the included Postman collection.

- [Smart Parking System Postman Collection](Smart-Parking-System.postman_collection.json)





### Import Postman Collection

1. Open Postman.
2. Import the file: `Smart-Parking-System.postman_collection.json`
3. Use the requests to test all available APIs.



## Project Structure

- `user-service/`
- `vehicle-service/`
- `parking-service/`
- `payment-service/`
- `eureka-server/`
- `Smart-Parking-System.postman_collection.json`
- `Readme.md`

## License

This project is licensed under the MIT License.

---

