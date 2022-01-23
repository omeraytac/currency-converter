# currency-converter 

### How to Run?

- Clone the repository.

- Install maven -- https://maven.apache.org/install.html

- Open terminal || cmd, go into the project directory, run 'mvn spring-boot:run' to start the application. 

### How to do integration tests?

- Clone the repository, if was not cloned.

- Install maven -- https://maven.apache.org/install.html if it was not installed.

- Open terminal || cmd, go into the project directory, run 'mvn test' to test the application.

### Request & Response

- Request example: POST http://localhost:8080/converter/convert , body = {"target":"USD", "source":"TRY", "amount":"100"}

- Response example: body = {"amount": 23.0, "currency": "USD"}
