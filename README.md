# --- Smart Pet Feeder ---
[![Java](https://img.shields.io/badge/Java-21-%23ED8B00?logo=openjdk)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-%236DB33F?logo=spring)](https://spring.io/)
[![MySQL](https://img.shields.io/badge/MySQL-8-%234479A1?logo=mysql)](https://www.mysql.com/)
[![RabbitMQ](https://img.shields.io/badge/RabbitMQ-3.8.6-%23FF6600?logo=rabbitmq&logoColor=white)
](https://www.rabbitmq.com/)


A distributed smart feeding system for pets, built using microservice architecture and asynchronous communication via RabbitMQ.

---

## 📌 --- Overview ---📌

`SmartPetFeeder` simulates a real-world system where a sensor detects a pet near a feeder and publishes an event. Another service listens for this event and triggers the release of food.

This project demonstrates:
- Microservices with Spring Boot
- Asynchronous communication using RabbitMQ
- Clear separation of responsibilities
- Practical application of event-driven design


---

## 🧰 --- Technologies Used ---🧰

| Technology         | Purpose                              |
|--------------------|--------------------------------------|
| Java 21            | Core language                        |
| Spring Boot 3.2    | Framework for microservices          |
| RabbitMQ           | Messaging broker                     |
| Docker Compose     | Local container orchestration        |
| MySQL              | Relational database                  |
| Spring AMQP        | AMQP integration for Spring          |
| Spring Data JPA    | Database abstraction layer           |
| Swagger (OpenAPI)  | Endpoints Documentation              |

---

## 🧩 --- Services ---🧩

### 📡 sensor-service

- Port: `8080`
- Responsibilities:
  - Simulate pet detection
  - Persist detection logs
  - Publish detection events via RabbitMQ

**Primary Entity: `PetDetection`**
- `id`: Long
- `petId`: Long
- `sensorLocation`: String
- `detectedAt`: LocalDateTime

**API Endpoints:**
| Method | Route         | Description                     |
|--------|---------------|---------------------------------|
| POST   | `/detections` | Simulates a pet detection event |
| GET    | `/detections` | Lists all stored detections     |

---
### 🥣 feeder-service

- Port: `8081`
- Responsibilities:
  - Consume detection events
  - Simulate food dispensing

**Listens to queue:** `pet-feeder-queue`  
**Exchange:** `pet.events.exchange`  
**Routing Key:** `pet.detected`

---

## 🐇--- Messaging with RabbitMQ ---🐇

Message broker configuration:

| Component     | Value                  |
|----------------|------------------------|
| Exchange       | `pet-events-exchange`  |
| Exchange type  | `direct`               |
| Routing Key    | `pet-feeder-routing-key`         |
| Queue          | `pet-feeder-queue`     |

---