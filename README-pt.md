
# --- Smart Pet Feeder (Alimentador Inteligente para Animais de Estimação) ---  
[![Java](https://img.shields.io/badge/Java-21-%23ED8B00?logo=openjdk)](https://openjdk.org/)  
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-%236DB33F?logo=spring)](https://spring.io/)  
[![MySQL](https://img.shields.io/badge/MySQL-8-%234479A1?logo=mysql)](https://www.mysql.com/)  
[![RabbitMQ](https://img.shields.io/badge/RabbitMQ-3.8.6-%23FF6600?logo=rabbitmq&logoColor=white)](https://www.rabbitmq.com/)  
![Docker](https://img.shields.io/badge/Docker-✓-lightblue)  

Um sistema distribuído de alimentação inteligente para pets, construído com arquitetura de microsserviços e comunicação assíncrona via RabbitMQ.  

---  

## 📌 --- Visão Geral --- 📌  

O `SmartPetFeeder` simula um sistema real onde um sensor detecta um pet próximo ao alimentador e publica um evento. Outro serviço escuta esse evento e aciona a liberação de ração.  

Este projeto demonstra:  
- Microsserviços com Spring Boot  
- Comunicação assíncrona usando RabbitMQ  
- Separação clara de responsabilidades  
- Aplicação prática de design orientado a eventos  

---  

## 🧰 --- Tecnologias Utilizadas --- 🧰  

| Tecnologia        | Finalidade                          |  
|-------------------|-------------------------------------|  
| Java 21           | Linguagem principal                 |  
| Spring Boot 3.2   | Framework para microsserviços       |  
| RabbitMQ          | Broker de mensagens                 |  
| Docker Compose    | Orquestração de containers local    |  
| MySQL             | Banco de dados relacional           |  
| Spring AMQP       | Integração AMQP para Spring         |  
| Spring Data JPA   | Camada de abstração do banco        |  
| Swagger (OpenAPI) | Documentação de endpoints           |  

---  

## 🧩 --- Serviços --- 🧩  

### 📡 **sensor-service**  

- Porta: `8080`  
- Responsabilidades:  
  - Simular detecção de pets  
  - Armazenar logs de detecção  
  - Publicar eventos de detecção via RabbitMQ  

**Entidade Principal: `PetDetection`**  
- `id`: Long  
- `petId`: Long  
- `sensorLocation`: String  
- `detectedAt`: LocalDateTime  

**Endpoints da API:**  
| Método | Rota           | Descrição                          |  
|--------|----------------|------------------------------------|  
| POST   | `/detections`  | Simula um evento de detecção de pet |  
| GET    | `/detections`  | Lista todas as detecções armazenadas |  

---  

### 🥣 **feeder-service**  

- Porta: `8081`  
- Responsabilidades:  
  - Consumir eventos de detecção  
  - Simular a liberação de ração  

**Escuta a fila:** `pet-feeder-queue`  
**Exchange:** `pet.events.exchange`  
**Chave de Roteamento:** `pet.detected`  

---  

## 🐇 --- Mensageria com RabbitMQ --- 🐇  

Configuração do broker de mensagens:  

| Componente       | Valor                     |  
|------------------|---------------------------|  
| Exchange         | `pet-events-exchange`     |  
| Tipo de Exchange | `direct`                  |  
| Chave de Roteamento | `pet-feeder-routing-key`  |  
| Fila             | `pet-feeder-queue`        |  

---