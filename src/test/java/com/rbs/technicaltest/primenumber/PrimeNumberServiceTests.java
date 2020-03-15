package com.rbs.technicaltest.primenumber;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest()
class PrimeNumberServiceTests {

  @Autowired
  private PrimeNumberService primeNumberService;

  @Test
  void generatePrimesTest() {
    Set expectedPrimes = new LinkedHashSet();
    Collections.addAll(expectedPrimes, 2, 3, 5, 7, 11);

    PrimeResultSet primeResultSet = primeNumberService.generatePrimes(11);

    Set resultantPrimes = primeResultSet.getPrimes();
    assertEquals(11, primeResultSet.getInitial());
    assertNotNull(resultantPrimes);
    assertEquals(expectedPrimes, resultantPrimes);
  }

  @Test
  void generatePrimesNoPrimesTest() {
    Set expectedPrimes = new LinkedHashSet();

    PrimeResultSet primeResultSet = primeNumberService.generatePrimes(1);

    Set resultantPrimes = primeResultSet.getPrimes();
    assertEquals(1, primeResultSet.getInitial());
    assertNotNull(resultantPrimes);
    assertEquals(expectedPrimes, resultantPrimes);
  }
}
