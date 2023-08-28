<h1 align="center">Welcome to embracing-microservices-design 👋</h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-0.0.1--SNAPSHOT-blue.svg?cacheSeconds=2592000" />
  <a href="https://github.com/wkmaaj/embracing-microservices-design" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
  <a href="https://www.mit.edu/~amini/LICENSE.md" target="_blank">
    <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" />
  </a>
  <a href="https://twitter.com/wkmaaj" target="_blank">
    <img alt="Twitter: wkmaaj" src="https://img.shields.io/twitter/follow/wkmaaj.svg?style=social" />
  </a>
</p>

> An umbrella application of microservices ranging from APIs to UIs and everything in between.

# DEPRECATED

This repo is being deprecated in favor of more specific repositories, please see:
- [Embracing Microservices Design - Message Event Publisher](https://github.com/wkmaaj/emd-kafka-spring-publisher)
- [Embracing Microservices Design - MongoDB SOAP Service](https://github.com/wkmaaj/emd-mongo-spring-soap-provider)
- [Embracing Microservices Design - Typescript Logger](https://github.com/wkmaaj/emd-logger-typescript)
- [Embracing Microservices Design - REST to SOAP API](https://github.com/wkmaaj/emd-nestjs-rest-to-soap-api)

<!-- <h2 align="center">TODO 🏋🏻‍♀️</h2> -->

## TODO 🏋🏻‍♂️

A list of things to do and/or pursue:

- Microservices will include (list to grow):

  - microservices that read data from data sources (i.e. Mongo, Neo4j, PostgreSQL, MySQL)
  - microservices that write data to data sources (i.e. Mongo, neo4j, postgresql, mysql)

    - these microservices will also be responsible for publishing new WRITE events to Kafka

  - microservices that run batch jobs that convert data from one data model to another, i.e., a microservice that maps a Mongo document to a Neo4j node, a microservice that converts a PostgreSQL table to a Mongo document, and so on

    - these microservices will also be responsible for listening for new WRITE events published to Kafka
    - these microservices will subscribe to Kafka channels/streams and trigger a batch process in response to new WRITE events

  - microservices that translate communication messages, i.e., a microservice that converts REST messages in JSON format to SOAP messages in XML

- MicroUIs will be built that will be combined to form whole user interfaces resulting in improved resiliency as the entire UI will not crash due to a feature (i.e. microUI) encountering issues

## TECHNOLOGIES

### Java

- Spring Boot
- Spring Batch
- Spring Data
- Maven
- Gradle

### JavaScript

- Nest.js
- Next.js
- Qwik
- React
- SolidJS
- Pino

### Databases

#### SQL

- PostgreSQL
- MySQL
- Oracle (possibly)

#### NoSQL

- Mongo
- Neo4j
- Cassandra (possibly)

### Containers

- Docker

### Communication

- SOAP over HTTP(S)
- REST over HTTP(S)
- GraphQL

## Links

### 🏠 [Homepage](https://github.com/wkmaaj/embracing-microservices-design)

### ✨ [Demo](https://github.com/wkmaaj/embracing-microservices-design)

## Install

```sh
run script
```

## Usage

```sh
execute script
```

## Run tests

```sh
test script
```

## Author

👤 **wkmaaj**

- Website: wkmaaj.com
- Twitter: [@wkmaaj](https://twitter.com/wkmaaj)
- Github: [@wkmaaj](https://github.com/wkmaaj)
- LinkedIn: [@wkmaaj](https://linkedin.com/in/wkmaaj)

## 🤝 Contributing

Contributions, issues and feature requests are welcome!<br />Feel free to check [issues page](wkmaaj). You can also take a look at the [contributing guide](wkmaaj).

## Show your support

Give a ⭐️ if this project helped you!

<a href="https://www.patreon.com/wkmaaj">
  <img src="https://c5.patreon.com/external/logo/become_a_patron_button@2x.png" width="160">
</a>

## 📝 License

Copyright © 2023 [wkmaaj](https://github.com/wkmaaj).<br />
This project is [MIT](https://www.mit.edu/~amini/LICENSE.md) licensed.

---

_This README was generated with ❤️ by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_
