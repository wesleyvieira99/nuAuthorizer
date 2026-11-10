# nuAuthorizer — Base Setup

Initial setup for the Authorizer challenge in **Java 17**.

## Architecture & Design Decisions
- **Absolute Immutability:** `Account` and `Transaction` modeled as Java 17 `record`s with defensive copying (`List.copyOf`) in the compact constructor to safeguard the history against external mutations.
- **Referential Transparency:** Functional evolution of balance and history without side effects on the original instance.
- **Tech Stack:** Java 17, Maven, JUnit 5, and Jackson (`jackson-databind` + `jackson-datatype-jsr310`).

## How to Run
1. Run unit tests: `mvn test`
2. Execute Main: `mvn exec:java`