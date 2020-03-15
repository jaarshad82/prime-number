package com.rbs.technicaltest.primenumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeNumberController {

  @Autowired
  private PrimeNumberService primeNumberService;

  @RequestMapping(
      value = "/primes/{initial}",
      method = RequestMethod.GET,
      headers = "Content-Type=application/json",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PrimeResultSet> findPrimesJson(@PathVariable int initial) {
    return new ResponseEntity<>(primeNumberService.generatePrimes(initial), HttpStatus.OK);
  }

  @RequestMapping(
      value = "/primes/{initial}",
      method = RequestMethod.GET,
      headers = "Content-Type=application/xml",
      produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<PrimeResultSet> findPrimesXml(@PathVariable int initial) {
    return new ResponseEntity<>(primeNumberService.generatePrimes(initial), HttpStatus.OK);
  }
}
