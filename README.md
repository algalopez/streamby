# streamby

## Summary

streamby

Streamby is a sample project to practice and discuss about software architecture, try out new libraries, play with tools
that I haven't used yet and learn on a project with enough complexity to rise some problems.

The topic of this project is a marketplace for life events to provide real time information to users.

## Goals

The main goal of the project is learning. Here are some of the topics that the project will cover:

- Hexagonal architecture, CQRS, DDD and event driven architecture
- Archunit tests
- Github CI/CD
- TBD

## Description

streamby is composed of 3 different projects in one repository

- backoffice_app: Manages all information regarding events and packages
- provider_app: Provides life information to consumers
- consumer_app: Retrieves life information from the providers

Example:

- [backoffice]: An admin creates an event like for example, a football match
- [backoffice]: An admin creates a package that the consumer can use to buy event information
- [provider_app]: A provider creates a coverage for an event. For example they provide real time text describing what is
  happening in the football match
- [consumer_app]: A consumer buys a package and gets some credit for subscriptions
- [consumer_app]: A consumer uses a package to subscribe to the event coverage from a provider
- [consumer_app]: A consumer receives the information from a provider
- [backoffice_app]: An admin checks statistic about the system

### Repository structure

The repository has the following folders:

- database: Liquibase migration files
- documentation: Documentation of the project and any information that I might want to share to discuss with friends
- environment:
    - Docker file to run an environment with any tool needed like a database, grafana, sonarqube, rabbitMQ, etc.
    - Environment variables used by the service organized per environment (dev, test, prod)
- src: Source code of the project

### Project structure

Each one of the projects source code is divided in submodules first and by layers second. These layer are:

- api: Contains the primary adapters such as rest controllers, cli, grpc, etc and all other related logic needed to call
  the application
- application: Contains all the application logic
- domain: Contains all the business logic including aggregates, read models, ports, events, exceptions, business
  services, etc
- infrastructure: Contains the secondary adapters such as repository implementations, clients, publishers, and all other
  related logic needed to return data to the application

## How to

Start environment

````bash
docker compose -f .\environment\docker-compose.yml up &
````

Build project

````bash
.\gradlew clean build
````

Run sonarqube

````bash
.\gradlew sonar -D sonar.login=<token>
````

Open swagger

````http://localhost:8080/q/swagger-ui````