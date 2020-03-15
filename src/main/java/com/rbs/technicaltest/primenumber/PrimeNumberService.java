package com.rbs.technicaltest.primenumber;

import org.springframework.stereotype.Component;

@Component
class PrimeNumberService {

  PrimeResultSet generatePrimes(int initial) {
    PrimeResultSet primeResultSet = new PrimeResultSet();
    primeResultSet.setInitial(initial);

    for (int i = 2; i <= initial; i++) {
      if (isNumberPrime(i)) {
        System.out.println("adding prime: " + i);
        primeResultSet.addPrime(i);
      }
    }

    return primeResultSet;
  }

  private boolean isNumberPrime(int number) {
    boolean isPrime = true;

    for (int i = 2; i < number; i++) {
      if (number % i == 0) {
        isPrime = false;
        break;
      }
    }

    return isPrime;
  }
}
