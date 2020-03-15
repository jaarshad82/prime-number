package com.rbs.technicaltest.primenumber;

public class PrimeNumberGeneratorFactory {

  PrimeNumberGenerator getPrimeNumberGenerator(Integer alg) {
    PrimeNumberGenerator primeNumberGenerator;
    switch (alg) {
      case 1:
        primeNumberGenerator =  new SimplePrimeNumberGenerator();
        break;
      case 2:
        primeNumberGenerator =  new EratosthenesSievePrimeNumberGenerator();
        break;
      default:
        primeNumberGenerator =  new SimplePrimeNumberGenerator();
    }
    return primeNumberGenerator;
  }
}
