# wholesale

### To Run
`mvn spring-boot:run -Dspring-boot.run.profiles=local`

### Account API
`http://localhost:8080/api/accounts`

### AccountTransaction API
`http://localhost:8080/api/transactions/{accountNumber}`

### Run tests
`mvn -Dtest=AccountControllerTest test`
`mvn -Dtest=AccountTrabsactionControllerTest test`
