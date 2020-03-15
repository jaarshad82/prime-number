package com.rbs.technicaltest.primenumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PrimeNumberControllerTests {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @MockBean
  private PrimeNumberService primeNumberService;

  @BeforeEach
  void setup() {
    PrimeResultSet primeResultSet;
    primeResultSet = new PrimeResultSet();
    primeResultSet.setInitial(11);
    primeResultSet.addPrime(2);
    primeResultSet.addPrime(3);
    primeResultSet.addPrime(5);
    primeResultSet.addPrime(7);
    primeResultSet.addPrime(11);

    BDDMockito.given(primeNumberService.generatePrimes(11)).willReturn(primeResultSet);
  }

  @Test
  void getPrimeNumbersJsonTest() throws Exception {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<>(headers);

    ResponseEntity<String> response =
        restTemplate.exchange("http://localhost:" + port + "/primes/11", HttpMethod.GET, entity, String.class);

    String resultSet = response.getBody();
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(resultSet);
    assertEquals("{\"initial\":11,\"primes\":[2,3,5,7,11]}", resultSet);
  }

  @Test
  void getPrimeNumbersXmlTest() throws Exception {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_XML);
    HttpEntity<String> entity = new HttpEntity<>(headers);

    ResponseEntity<String> response =
        restTemplate.exchange("http://localhost:" + port + "/primes/11", HttpMethod.GET, entity, String.class);

    String resultSet = response.getBody();
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(resultSet);
    assertEquals("<PrimeResultSet>" +
        "<initial>11</initial>" +
        "<primes>" +
        "<primes>2</primes>" +
        "<primes>3</primes>" +
        "<primes>5</primes>" +
        "<primes>7</primes>" +
        "<primes>11</primes>" +
        "</primes>" +
        "</PrimeResultSet>", resultSet);
  }
}
