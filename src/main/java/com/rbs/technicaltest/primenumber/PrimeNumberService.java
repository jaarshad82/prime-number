package com.rbs.technicaltest.primenumber;

import org.springframework.stereotype.Component;

@Component
class PrimeNumberService {

  PrimeResultSet generatePrimes(int initial) {
    return generatePrimes(initial, 1);
  }

  PrimeResultSet generatePrimes(int initial, Integer alg) {
    PrimeNumberGeneratorFactory primeNumberGeneratorFactory = new PrimeNumberGeneratorFactory();
    PrimeNumberGenerator primeNumberGenerator = primeNumberGeneratorFactory.getPrimeNumberGenerator(alg);
    return primeNumberGenerator.generate(initial);
  }
}
