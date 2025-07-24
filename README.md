# PaydayPlanner


# Architecture
Layered Architecture, where each layer has a clear responsibility

com.paydayplanner
├── controller    ← API endpoints (resource layer)
├── service       ← Business logic (app layer)
├── repository    ← Data access logic (data layer)
├── model         ← JPA entities (domain model)
├── dto           ← Data Transfer Objects (view model)


## Controller Layer
Handles HTTP requests/response
Talks to the service layer

## Service Layer
Contains business logic. Orchestrates between repository + other services
Handles validations, calculations, etc.

## Repository Layer (repository)
Talks directly to the database
Uses PanacheRepository or JPA EntityManager
Returns entities

##  Model Layer (model)
JPA entity classes (@Entity)
Maps directly to database tables


## DTO Layer (dto)
Represents the shape of incoming/outgoing data
Keeps your model/entity decoupled from the API
Used in controllers and services

