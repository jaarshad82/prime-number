package com.rbs.technicaltest.primenumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PrimeNumberController {

  @Autowired
  private PrimeNumberService primeNumberService;

  @RequestMapping(
      value = "/primes/{initial}",
      method = RequestMethod.GET,
      headers = "Content-Type=application/json",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PrimeResultSet> findPrimesJson(
      @PathVariable int initial,
      @RequestParam Optional<Integer> alg) {
    return new ResponseEntity<>(primeNumberService.generatePrimes(initial, alg.orElse(1)), HttpStatus.OK);
  }

  @RequestMapping(
      value = "/primes/{initial}",
      method = RequestMethod.GET,
      headers = "Content-Type=application/xml",
      produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<PrimeResultSet> findPrimesXml(
      @PathVariable int initial,
      @RequestParam Optional<Integer> alg) {
    return new ResponseEntity<>(primeNumberService.generatePrimes(initial, alg.orElse(1)), HttpStatus.OK);
  }
}
