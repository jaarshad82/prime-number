# prime-number
prime number generator

To run the app
 - mvnw spring-boot:run
 
To run the tests
 - mvnw clean test
  
Example REST calls
 - curl --header "Content-Type: application/json" http://localhost:8080/primes/29
 - curl --header "Content-Type: application/json" http://localhost:8080/primes/29?alg=1
 - curl --header "Content-Type: application/json" http://localhost:8080/primes/29?alg=1
 - curl --header "Content-Type: application/xml" http://localhost:8080/primes/29?alg=1
 - curl --header "Content-Type: application/xml" http://localhost:8080/primes/29?alg=2
 