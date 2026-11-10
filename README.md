# nuAuthorizer — Base Setup

Setup inicial para o desafio do Autorizador em **Java 21**.

## Decisões de Arquitetura e Design
- **Imutabilidade Absoluta:** `Account` e `Transaction` modelados como `record`s do Java 21 com cópia defensiva (`List.copyOf`) no construtor compacto para blindar o histórico contra mutações externas.
- **Transparência Referencial:** Evolução funcional de saldo e histórico sem efeitos colaterais na instância original.
- **Stack Tecnológica:** Java 21, Maven, JUnit 5 e Jackson (`jackson-databind` + `jackson-datatype-jsr310`).

## Como Executar
1. Rodar testes unitários: `mvn test`
2. Executar o Main: `mvn exec:java`