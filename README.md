# currency-converter 

### How to Run?

- Install maven -- https://maven.apache.org/install.html

- Open terminal || cmd, run 'mvn spring-boot:run' to start application. 

### How to do integration tests?

- Install maven -- https://maven.apache.org/install.html if it was not installed.

- Open terminal || cmd, run 'mvn test' to start application.

### Request & Response

- Request example: POST http://localhost:8080/converter/convert , body = {"target":"USD", "source":"TRY", "amount":"100"}

- Response example: body = {"amount": 23.0, "currency": "USD"}
