package com.rbs.technicaltest.primenumber;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest()
class PrimeNumberServiceTests {

  @Autowired
  private PrimeNumberService primeNumberService;

  @Test
  void generatePrimesTest() {
    int initial = 11;
    Set expectedPrimes = new LinkedHashSet();
    Collections.addAll(expectedPrimes, 2, 3, 5, 7, 11);

    PrimeResultSet primeResultSet = primeNumberService.generatePrimes(initial);

    Set resultantPrimes = primeResultSet.getPrimes();
    assertEquals(initial, primeResultSet.getInitial());
    assertNotNull(resultantPrimes);
    assertEquals(expectedPrimes, resultantPrimes);
  }

  @Test
  void generatePrimesNoPrimesTest() {
    int initial = 1;
    Set expectedPrimes = new LinkedHashSet();

    PrimeResultSet primeResultSet = primeNumberService.generatePrimes(initial);

    Set resultantPrimes = primeResultSet.getPrimes();
    assertEquals(initial, primeResultSet.getInitial());
    assertNotNull(resultantPrimes);
    assertEquals(expectedPrimes, resultantPrimes);
  }

  @Test
  void generatePrimesCacheHitTest() {
    int initial = 11;
    Set expectedPrimes = new LinkedHashSet();
    Collections.addAll(expectedPrimes, 2, 3, 5, 7, 11);
    PrimeNumberService spy = spy(primeNumberService);

    PrimeResultSet primeResultSet = primeNumberService.generatePrimes(initial);

    Set resultantPrimes = primeResultSet.getPrimes();
    assertEquals(initial, primeResultSet.getInitial());
    assertNotNull(resultantPrimes);
    assertEquals(expectedPrimes, resultantPrimes);

    primeResultSet = spy.generatePrimes(initial);

    resultantPrimes = primeResultSet.getPrimes();
    assertEquals(initial, primeResultSet.getInitial());
    assertNotNull(resultantPrimes);
    assertEquals(expectedPrimes, resultantPrimes);
    verify(spy, times(0)).isNumberPrime(initial);
  }
}
