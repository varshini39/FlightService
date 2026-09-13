# FlightService

Spring Boot microservice that owns flight data for the [Flight Booking system](https://github.com/varshini39/flightbooking). Provides CRUD REST APIs for flights and is called by [BookingService](https://github.com/varshini39/BookingService) to fetch flight details for a booking.

## Tech stack

Spring Boot · Spring Data JPA · MySQL · [EntityService](https://github.com/varshini39/EntityService) (shared `Flight` entity)

## API

Base path: `/api/flights` (server runs with `context-path=/api`)

| Method | Endpoint | Description |
|---|---|---|
| GET | `/flights` | List all flights |
| GET | `/flights/{flightId}` | Get a flight by ID |
| POST | `/flights` | Add a flight |
| PUT | `/flights` | Update a flight |
| DELETE | `/flights/{flightId}` | Delete a flight |

**Flight fields:** `flight_id`, `airline_name`, `from`, `to`, `start_time`, `end_time`, `rate`, `total_seats`, `available_seats`

## Running locally

Requires `entity-service` installed to your local Maven repo first (see [EntityService](https://github.com/varshini39/EntityService)):

```bash
mvn spring-boot:run
```

Configure the datasource in `src/main/resources/application.properties` (defaults to `jdbc:mysql://mysqldb:3307/flight_booking`).

## Running with Docker

```bash
docker-compose up --build
```

Starts a MySQL container (`flight_booking` db, exposed on host port 3308) and the service on host port **8082**.

To run alongside UserService and BookingService with a single shared database, use [BookingService/docker-compose.yml](https://github.com/varshini39/BookingService/blob/main/docker-compose.yml) instead.

## Kubernetes

Deployment/service manifests: `flight-service-deployment.yaml`, `flight-service-service.yaml`. See [UserService/kubernetes-commands.txt](https://github.com/varshini39/UserService/blob/main/kubernetes-commands.txt) for the full `kubectl`/Minikube workflow used across all three services.

## Part of

[flightbooking](https://github.com/varshini39/flightbooking) (project overview) · [EntityService](https://github.com/varshini39/EntityService) · [UserService](https://github.com/varshini39/UserService) · [BookingService](https://github.com/varshini39/BookingService)
